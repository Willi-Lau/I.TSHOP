package com.lwy.demo.mapper;


import com.lwy.demo.bean.Clothes;
import com.lwy.demo.bean.Clothes_Admin;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;
import java.util.List;

/**
 * 管理员部分
 */
@Repository
public interface AdminMapper {
    /**
     * 根据用户名查询密码
     */

    @Select("select password from admin where username = #{username}")
    String selectadmin(String username);

    /**
     * 分页实现查找所有库存服装
     */
    @Select("select * from clothes")
    List<Clothes> selectallclothespage();
    /**
     * 查询一共有多少条数据
     */
    @Select("select count(*) from clothes")
    int countclothes();
    /**
     * 根据指定id 查询
     */
    @Select("select id,type,brand,info,money,num from clothes where id = #{id}")
    Clothes_Admin selectbyid(String id);
    /**
     * 修改衣服信息
     */
    @Update("update clothes set type = #{type},brand = #{brand} ,info =#{info},money = #{money},num = #{num} where id = #{id}")
    void modifyclothes(Clothes_Admin admin);

}
