package org.mon.mybaits.demo.mapper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mon.mybaits.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

//    @BeforeEach
//    void setUp() {
//        System.out.println("beforeEach...");
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.out.println("afterEach...");
//    }

    @Test
    void selectAll() {
        userInfoMapper.selectAll().forEach(x -> System.out.println(x));
//        System.out.println("selectAll...");
    }

    @Test
    void selectUserById() {
        System.out.println(userInfoMapper.selectUserById(1));
    }

    @Test
    void selectUserByAgeAndGender() {
        System.out.println(userInfoMapper.selectUserByAgeAndGender(1, 18));
    }

    @Test
    void selectUserByAgeAndGender_ex() {
        System.out.println(userInfoMapper.selectUserByAgeAndGender_ex(1,18));
    }

    @Test
    void insertUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("java");
        userInfo.setAge(20);
        userInfo.setPassword("12345");
        userInfo.setGender(1);
        Integer integer = userInfoMapper.insertUser(userInfo);
    }

    @Test
    void insertUserByParam() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("java-2");
        userInfo.setAge(22);
        userInfo.setPassword("12345-2");
        userInfo.setGender(1);
        Integer integer = userInfoMapper.insertUserByParam(userInfo);
        System.out.println("执行结果"+integer+",id:"+userInfo.getId());
    }

    @Test
    void deleteUser() {
        Integer delete = userInfoMapper.delete(8);
        System.out.println(delete);
    }

    @Test
    void update() {
        System.out.println(userInfoMapper.update(7, "root"));
    }

    @Test
    void selectAll2() {
        System.out.println(userInfoMapper.selectAll2());
    }

    @Test
    void selectUserById1() {
//        可以防止SQL注入（数据库攻击手段）
        System.out.println(userInfoMapper.selectUserById1("' or 1= '1"));
    }

//    @Test
//    void testUpdate() {
//        UserInfo userInfo=new UserInfo();
//        userInfo.setId(7);
//        userInfo.setPassword("testByObject");
//        System.out.println(userInfoMapper.update(userInfo));
//    }

//    @Test
//    void selectAll2() {
////        数据库返回内容与我接受的参数个数不匹配
//        System.out.println(userInfoMapper.selectAll2());
//    }
//    @Test
//    void selectAll2() {
//        System.out.println("selectAll2...");
//    }
}