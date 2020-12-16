package com.lwy.demo.mapper;


import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.Cart_Clothes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartMapper {
    /**
     *查询购物车中是否有要添加的货物的信息
     */
    @Select("select COUNT(*) from cart where username = #{username} and id = #{id}")
     int selecttocart(Cart cart);

    /**
     * 入宫没有添加到购物车
     * @param cart
     */

    @Insert("insert into cart (username,id,num) values(#{username},#{id},#{num})")
     void addtocart(Cart cart);
    /**
     * 如果有就是修改
     */
    @Update("update cart set num = num + #{num} where username = #{username} and id = #{id}")
    void updatetocart(Cart cart);
    /**
     * 修改仓库的数据
     */
    @Update("update clothes set num = num - #{num} where  id = #{id}")
    void updatetoclothes(Cart cart);
    /**
     * 查询现在购物车的货物
     *
     */
    List<Cart_Clothes> selectcartclothes(String name);
    /**
     * 支付
     */
     @Delete("delete from cart where username = #{name}")
    void paycartclothes (String name);
    /**
     * 查询指定用户的总消费
     */
    @Select("select grossmoney from user where username = #{name}")
    int selectgrossmoney(String name);
    /**
     * 修改指定用户总消费
     */
    @Update("update user set grossmoney = #{grossmoney} where username = #{name}")
    void updategrossmoney(String name,int grossmoney);

}
