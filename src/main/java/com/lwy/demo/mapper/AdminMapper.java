package com.lwy.demo.mapper;


import com.lwy.demo.bean.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resources;
import java.lang.reflect.Array;
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
    /**
     * 获取所有用户信息，根据消费排序
     */
    @Select("select * from user ORDER BY  grossmoney desc")
    List<User> alluserinf();
    /**
     * 查询一共有多少个用户
     */
    @Select("select count(*) from user")
    int countuser();
    /**
     * 查找所有的管理员，按照职位排序
     */
    @Select("select * from admin ORDER BY  position ")
      List<Admin> alladmininf();
    /**
     * 查询一共有多少个管理员
     */
    @Select("select count(*) from admin")
    int countadmin();
    /**
     * 统计传递进来的性别衣服的个数
     *
     */
    @Select("select count(*) from clothes where type = #{type}")
    int counttype(String type);
    /**
     * 向赎救苦添加衣服信息
     */
    @Insert("insert into clothes(type,brand,info,money,num,src) values (#{type},#{brand},#{info},#{money},#{num},#{src})")
    void insertclothes (AddClothes clothes);
    /**
     * 根据id删除数据库里的信息
     */
    @Delete("delete from clothes where id = #{id}")
    void deleteclothes(int id);
    /**
     * 根据id返回图片文件的路径
     */
    @Select("select src from clothes where id =#{id}")
    String findsrc(int id);

    /**
     * 条件查询衣服  默认是全部查询
     * @param clothes
     * @return
     */
    List<Clothes> typeselectclothes(AdminClothes clothes);
    /**
     * 查询条件查询时数据的数量
     */
     int counttypeselectclothes(AdminClothes clothes);
    /**
     * 改变用户存活状态
     */
    @Update("update user set alive = #{alive} where username = #{username}")
    void changealive(String username,int alive);
    /**
     * 根据用户信息条件查询 空则查询所有的值
     */
    List<User> typeselectuser(AdminUser user);
    /**
     * 统计条件查询用户时的数量
     */
    int counttypeselectuser(AdminUser user);
    /**
     * 查找所有用户名
     */
    @Select("select username from user ORDER BY  grossmoney desc")
    String [] alluserinfusername();
    /**
     * 查找所有的钱
     */
    @Select("select grossmoney from user ORDER BY  grossmoney desc")
    String [] alluserinfgrossmoney();
    /**
     * 查找所有购物车历史信息
     */
    @Select("select * from carthistory order by carthistoryid desc")
    List<CartHistory> selectallcarthistory();
    /**
     * 写入管理员登陆时间
     */
    @Insert("insert into admintime(username) values (#{username})")
    void addadmintime(String username);
    /**
     * 查询管理员登陆时间总数
     */
    @Select("select count(*) from admintime")
    int countadmintime();
    /**
     * 查询所有管理员登陆时间的信息
     */
    @Select("select * from admintime")
    List<Admintime> selectadmintime();

}
