package org.mon.mybaits.demo.mapper;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.mon.mybaits.demo.model.UserInfo;

import java.util.List;

//交给Spring去管理，用Mapper注解
@Mapper
public interface UserInfoMapper {
//    查询所有的用户信息
//    @Results(id="BaseMap",value={
//            @Result(column="delete_flag",property = "deleteFlag"),
//            @Result(column="create_time",property = "createTime"),
//            @Result(column="update_time",property = "updateTime"),
//    })  //可以直接通过配置文件进行自动转换
    @Select("select id,username,password,age,gender,phone,delete_flag,create_time,update_time from user_info")
    List<UserInfo> selectAll();

//    @ResultMap("BaseMap")
    @Select("select id,username,password,age,gender,phone,delete_flag,create_time,update_time from user_info")
    UserInfo selectAll2();

//    @Select("select * from user_info where id=4")
//    UserInfo selectUserById();

//    一个参数是可以随便写，但是多个参数就不可以随便写了
//    进行复用
//    @ResultMap("BaseMap")
//    用#{},代表的是预编译sql（用？作为占位符）
//    可以用来防止sql注入
    @Select("select * from user_info where username= '${name}' and password= '${password}'")
    List<UserInfo> selectUserById(String name,String password);

//    用${},代表的是即使sql,直接进行参数替换，如果是字符串的话，需要加上引号
    @Select("select * from user_info where username= '${name}'")
    List<UserInfo> selectUserById1(String name);


//    非唯一主键查询，返回结果建议使用List
//    使用@Param注解可以直接将传入参数的名字与sql参数的名字进行绑定（参数重命名），但是如果改为参数的名词就不可以运行，会报错
    @Select("select * from user_info where age= #{age1} and gender= #{gender}")
    List<UserInfo> selectUserByAgeAndGender(Integer gender,@Param("age1") Integer age);

//    也可以直接使用mybatis默认的参数名字来进行绑定,可以正确执行，但是不推荐
    @Select("select * from user_info where age= #{param2} and gender= #{param1}")
    List<UserInfo> selectUserByAgeAndGender_ex(Integer gender,Integer age);

//    传递对象

//    这样传会报错，它会到UserInfo中寻找userInfo这个属性，所以它已经给我们封装了一层，直接去拿对应的属性就行了
//    @Insert("insert into user_info (username,password,age,gender) values (#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender})")
//    Integer insertUser(UserInfo userInfo);

    @Insert("insert into user_info (username,password,age,gender) values (#{username},#{password},#{age},#{gender})")
    Integer insertUser(UserInfo userInfo);

//    使用绑定参数来进行传递参数
//    拿到自增Id
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user_info (username,password,age,gender) values (#{userInfo.username},#{userInfo.password},#{userInfo.age},#{userInfo.gender})")
    Integer insertUserByParam(@Param("userInfo") UserInfo userInfo);



//     删除数据,返回的结果就是影响的行数，所以需要Integer类型来进行接收
    @Delete("delete from user_info where id = #{id}")
    Integer delete(Integer id);

//    修改数据
    @Update("update user_info set password= #{password} where id = #{id}")
    Integer update(Integer id,String password);

//    在同一个类中，方法名称必须是不相同的
//    @Update("update user_info set password= #{password} where id = #{id}")
//    Integer update(UserInfo userInfo);

//    查询

//    排序功能
//    使用#{}如果参入参数是String类型的话，就会自动添加引号，排序只能使用${}
//    但是这样也会存在SQL注入的问题，只要这样使用就一定会存在SQL注入
//    解决方法：使用枚举的方式，前端传入的时候被限制，或者进行参数校验
    @Select("select * from user_info order by id ${order}")
    List<UserInfo> selectUserByOrder(String order);

//    like查询
//    这样也会存在SQL注入问题，可以使用SQL函数（拼接）来解决问题
    @Select("select * from uesr_info where username like '%${name}%'")
    List<UserInfo> selectUserByLike(String name);

    @Select("select * from user_info where username like concat('%',#{name},'%')")
    List<UserInfo> selectUserByLike_ex(String name);


//    这是注解的方式来进行动态SQL，非常繁琐，所以还是要用XML
//    @Insert("<script>"+
//            "insert into user_info" +
//            "        <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">" +
//            "            <if test=\"username!=null\">username,</if>" +
//            "            <if test=\"password!=null\">password,</if>" +
//            "            <if test=\"age!=null\">age,</if>" +
//            "            <if test=\"gender!=null\">gender</if>" +
//            "        </trim>" +
//            "\n" +
//            "        values" +
//            "        <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">" +
//            "            <if test=\"username!=null\">#{username},</if>" +
//            "            <if test=\"password!=null\">#{password},</if>" +
//            "            <if test=\"age!=null\">#{age},</if>" +
//            "            <if test=\"gender!=null\">#{gender}</if>" +
//            "        </trim>"+
//            "</script>")
//    Integer insertUserByCondition(UserInfo userInfo;
}
