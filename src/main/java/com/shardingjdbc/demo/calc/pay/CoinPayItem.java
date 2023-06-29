package com.shardingjdbc.demo.calc.pay;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/2 8:38 下午
 */
@Setter
@Getter
public class CoinPayItem extends AbstractPayItem {

    public CoinPayItem(BigDecimal money) {
        super(money, PayType.COIN, PayGroup.VIRTUAL_PROPERTY);
    }

    /**
     * 来源
     */
    private String source;


}
