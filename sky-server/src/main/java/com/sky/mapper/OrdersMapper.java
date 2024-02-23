package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrderMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author StartZhao
 * @Create 2024/2/23 17:54
 * @Version 1.0
 */
@Mapper
public interface OrdersMapper {

    /**
     * 插入一条订单数据
     * sql语句要得到主键id的值
     * @param orders
     */
    void insert(Orders orders);
}
