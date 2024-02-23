package com.sky.service;

import com.sky.dto.OrdersDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersPaymentDTO;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

/**
 * ClassName: OrderService
 * Package: com.sky.service
 * Description:
 *
 * @Author StartZhao
 * @Create 2024/2/23 17:51
 * @Version 1.0
 */
public interface OrderService {


    /**
     * 用户下单
     * @param ordersDTO
     * @return
     */
    OrderSubmitVO submit(OrdersDTO ordersDTO);


    /**
     * 订单支付
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    /**
     * 历史订单查询
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    OrderVO orderDetail(Long id);

    /**
     * 取消订单
     * @param id
     */
    void cancel(Long id);

    /**
     * 再来一单
     * @param id
     */
    void repetition(Long id);
}
