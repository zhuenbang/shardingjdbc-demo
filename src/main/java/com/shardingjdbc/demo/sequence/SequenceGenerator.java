package com.shardingjdbc.demo.sequence;

import com.shardingjdbc.demo.constant.DbAndTableEnum;

/**
 * @ClassName: SequenceGenerator
 * @Description: 序列生成器接口
 * @author: Ryan zhu
 * @date: 2022/12/9 14:37
 */
public interface SequenceGenerator {
    /**
     * 查redis方式 key前缀（形如：tableName_dbIndex_tbIndex_）
     *
     * @param targetEnum
     * @param dbIndex
     * @param tbIndex
     * @return
     */
    String getNextVal(DbAndTableEnum targetEnum, int dbIndex, int tbIndex);
}
