package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.ShoppingCart;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.mapper.ShoppingCartMapper;
import com.sky.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: ShoppingCartServiceImpl
 * Package: com.sky.service.impl
 * Description:
 *
 * @Author StartZhao
 * @Create 2024/2/23 13:23
 * @Version 1.0
 */
@Service
@Slf4j
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;

    /**
     * 添加购物车
     * 每个用户只能管理自己的购物车
     * @param shoppingCartDTO
     */
    @Override
    @Transactional
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        //获取购物车对象
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
        // 获得用户唯一标识
        shoppingCart.setUserId(BaseContext.getCurrentId());
        //如果购物车表已经有了菜品或套餐则将其数量加一
        //条件查询得到购物车集合
        List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);
        if (list != null && list.size() > 0) {
            shoppingCart = list.get(0);
            shoppingCart.setNumber(shoppingCart.getNumber() + 1);
            //更新购物车信息
            shoppingCartMapper.update(shoppingCart);
            return;
        }
        //反之将购物车信息存入数据库中
        shoppingCart.setCreateTime(LocalDateTime.now());
        shoppingCart.setNumber(1);
        //判断添加到购物车的数据是菜品还是套餐
        if (shoppingCart.getDishId() != null) {
            Dish dish = dishMapper.getById(shoppingCart.getDishId());
            shoppingCart.setName(dish.getName());
            shoppingCart.setAmount(dish.getPrice());
            shoppingCart.setImage(dish.getImage());
        } else {
            //套餐
            Setmeal setmeal = setmealMapper.getById(shoppingCart.getSetmealId());
            shoppingCart.setName(setmeal.getName());
            shoppingCart.setAmount(setmeal.getPrice());
            shoppingCart.setImage(setmeal.getImage());

        }
        //插入购物车信息
        shoppingCartMapper.insert(shoppingCart);



    }

    /**
     * 展示购物车信息
     * @return
     */
    @Override
    public List<ShoppingCart> showShoppingCart() {
        Long userId = BaseContext.getCurrentId();
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .userId(userId)
                .build();
        return shoppingCartMapper.list(shoppingCart);

    }

    /**
     * 清空购物车
     */
    @Override
    public void cleanShoppingCart() {
        Long userId = BaseContext.getCurrentId();
        shoppingCartMapper.deleteByUserId(userId);
    }

    /**
     * 删除购物车中一个商品
     * 购物车没有信息执行不了该方法，由于前端设计原因
     * 由于为了程序的健壮性，应加入检验集合是否非空判断
     * @param shoppingCartDTO
     */
    @Override
    @Transactional
    public void subShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        //获取购物车对象
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartDTO, shoppingCart);
        // 获得用户唯一标识
        shoppingCart.setUserId(BaseContext.getCurrentId());
        //number是否等于1
        List<ShoppingCart> list = shoppingCartMapper.list(shoppingCart);
        if (list != null && list.size() > 0) {
            shoppingCart = list.get(0);
            if (shoppingCart.getNumber() == 1) {
                //条件删除购物车信息
                shoppingCartMapper.delete(shoppingCart);
                return;
            }
            shoppingCart.setNumber(shoppingCart.getNumber() - 1);
            shoppingCartMapper.update(shoppingCart);
        }
    }
}
