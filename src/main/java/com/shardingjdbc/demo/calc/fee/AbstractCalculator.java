package com.shardingjdbc.demo.calc.fee;

import cn.hutool.core.util.NumberUtil;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.shardingjdbc.demo.calc.pay.PayItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author gim 抽象计算器
 */
public abstract class AbstractCalculator<O> implements FeeCalculate<O> {

    private final FeeCalculate<O> feeCalculate;

    private final Unique unique;

    protected AbstractCalculator(FeeCalculate feeCalculate, Unique unique) {
        this.feeCalculate = feeCalculate;
        this.unique = unique;
    }

    @Override
    public Unique getUnique() {
        return unique;
    }

    /**
     * 当前抵扣
     *
     * @return
     */
    protected abstract Map<FeeItemType, BigDecimal> currentPayItem(Map<FeeItemType, BigDecimal> left,
                                                                   O o);

    /**
     * 当前抵扣的明细
     *
     * @return
     */
    protected abstract Map<FeeItemType, List<PayItem>> payItemList();

    @Override
    public Map<FeeItemType, List<PayItem>> payItemList(List<FeeItem<O>> list) {
        Map<FeeItemType, List<PayItem>> map;
        if (Objects.nonNull(feeCalculate)) {
            map = feeCalculate.payItemList(list);
        } else {
            map = Maps.newHashMap();
        }
        Map<FeeItemType, List<PayItem>> currentList = payItemList();
        if (Objects.nonNull(currentList) && !currentList.isEmpty()) {
            currentList.entrySet().stream().forEach(entry -> {
                List<PayItem> tempList = map.getOrDefault(entry.getKey(), Lists.newArrayList());
                tempList.addAll(entry.getValue());
                map.put(entry.getKey(), tempList);
            });
        }
        return map;
    }

    @Override
    public Map<FeeItemType, BigDecimal> calculateWaitPay(List<FeeItem<O>> list) {
        //如果没有上层包装，那么直接返回订单的实际金额减去当前抵扣的金额
        if (Iterables.isEmpty(list)) {
            throw new RuntimeException(FeeEnum.FEE_ITEM_EMPTY.getName());
        }
        Map<FeeItemType, BigDecimal> leftMap = Maps.newHashMap();
        if (Objects.isNull(feeCalculate)) {
            for (FeeItem item : list) {
                leftMap.put(item.getFeeItemType(), item.getFeeItemOriginMoney());
            }
            Map<FeeItemType, BigDecimal> currentDeduct = currentPayItem(leftMap,
                    list.get(0).getOrderInfo());
            currentDeduct.entrySet().stream().forEach(entry -> {
                leftMap.put(entry.getKey(), NumberUtil.sub(leftMap.get(entry.getKey()), entry.getValue()));
            });
            return leftMap;
        } else {
            Map<FeeItemType, BigDecimal> left = feeCalculate.calculateWaitPay(list);
            //如果有任何一个
            Optional<BigDecimal> greaterThanZero = left.entrySet().stream().map(e -> e.getValue())
                    .collect(Collectors.toList()).stream()
                    .filter(s -> NumberUtil.isGreater(s, BigDecimal.ZERO)).findFirst();
            if (!greaterThanZero.isPresent()) {
                return left;
            }
            Map<FeeItemType, BigDecimal> current = currentPayItem(left, list.get(0).getOrderInfo());
            Map<FeeItemType, BigDecimal> temp = Maps.newHashMap();
            for (FeeItem item : list) {
                //如果当前有抵扣
                if (Objects.nonNull(current.get(item.getFeeItemType()))) {
                    if (NumberUtil.isGreater(current.get(item.getFeeItemType()),
                            left.get(item.getFeeItemType()))) {
                        throw new RuntimeException(FeeEnum.AMOUNT_GREATER_ERROR.getName());
                    }
                    temp.put(item.getFeeItemType(),
                            NumberUtil.sub(left.get(item.getFeeItemType()), current.get(item.getFeeItemType())));
                } else {
                    //如果当前没有抵扣，直接返回剩余金额
                    temp.put(item.getFeeItemType(), left.get(item.getFeeItemType()));
                }
            }
            return temp;
        }
    }
}
