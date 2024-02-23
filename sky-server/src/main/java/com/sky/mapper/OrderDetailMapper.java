package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    /**
     * 通过OrdersId查询订单详情信息
     * @param ordersId
     * @return
     */
    @Select("select * from order_detail where order_id = #{ordersId}")
    List<OrderDetail> getByOrdersId(Long ordersId);
}
