package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * ClassName: UserMapper
 * Package: com.sky.mapper
 * Description:
 *
 * @Author StartZhao
 * @Create 2024/2/22 14:29
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * 通过openid获取用户
     * @param openid
     * @return
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 插入数据且返回主键值
     * @param user
     */
    void insert(User user);

    /**
     * 通过id获取用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{userId}")
    User getById(Long userId);

    /**
     * 根据集合返回用户数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);
}
