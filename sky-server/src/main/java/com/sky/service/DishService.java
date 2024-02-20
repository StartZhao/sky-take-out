package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * ClassName: DishService
 * Package: com.sky.service
 * Description:
 *
 * @Author StartZhao
 * @Create 2024/2/20 22:25
 * @Version 1.0
 */

public interface DishService {

    /**
     * 新增菜品
     * @param dishDTO
     */
    void saveWithFlavor(DishDTO dishDTO);
}
