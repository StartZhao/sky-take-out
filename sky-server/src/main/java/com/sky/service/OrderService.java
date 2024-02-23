package com.sky.service;

import com.sky.dto.OrdersDTO;
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
}
