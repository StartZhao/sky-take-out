package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: OrderDetailMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author StartZhao
 * @Create 2024/2/23 18:10
 * @Version 1.0
 */
@Mapper
public interface OrderDetailMapper {

    /**
     * 批量插入订单详情表
     * @param orderDetailList
     */
    void insertBatch(List<OrderDetail> orderDetailList);
}
