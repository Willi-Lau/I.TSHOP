package com.lwy.demo.mapper;


import com.lwy.demo.bean.Cart;
import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_type;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClothesMapper {
    /**
     * 查询所有服装 根据性别种类 男 女 童装
     */
    @Select("select * from clothes where type = #{sex}")
    List<Clothes> select_allmen(String sex);
    /**
     * 查询所有衣服的品牌
     */
    @Select("select DISTINCT brand from clothes")
    List<String> select_allclothesbrand();

    /**
     * 查询价钱里的最大值
     */
    @Select("select max(money) from clothes")
    int select_maxmoney();
    /**
     * 根据传送过来的参数进行条件查询衣服
     *
     */
    List<Clothes> select_dreamclothes(Clothes_type clothes);
    /**
     * 购物车添加时减少库存的信息
     */
    @Update("update clothes set num = num - #{num} where id = #{id}")
    void updateclothes_whencartadd(Cart cart);

}
