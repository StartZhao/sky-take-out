package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {


    /**
     * 批量插入菜品味道
     * @param flavors
     */
    @AutoFill(OperationType.INSERT)
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据dishId删除菜品口味
     * @param dishId
     */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * 根据dishId查询菜品口味
     * @param dishId
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);

    /**
     * 根据dishId集合删除菜品口味
     * @param dishIds
     */
    void deleteByDishIds(List<Long> dishIds);
}