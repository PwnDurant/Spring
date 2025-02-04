package org.mon.mybaits.demo.mapper;

import org.junit.jupiter.api.Test;
import org.mon.mybaits.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoXmlMapperTest {

    @Autowired
    private UserInfoXmlMapper userInfoXmlMapper;

    @Test
    void selectAll() {
        userInfoXmlMapper.selectAll().forEach(x-> System.out.println(x));
    }

    @Test
    void insertUser() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("java");
        userInfo.setAge(20);
        userInfo.setPassword("12345");
        userInfo.setGender(1);
        Integer integer = userInfoXmlMapper.insertUser(userInfo);
        System.out.println(integer+",id:"+userInfo.getId());
    }

    @Test
    void insertUser2() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("java");
        userInfo.setAge(20);
        userInfo.setPassword("12345");
        userInfo.setGender(1);
        Integer integer = userInfoXmlMapper.insertUser2(userInfo);
    }

    @Test
    void updateUser() {
        System.out.println(userInfoXmlMapper.updateUser(7, "root_test"));
    }

    @Test
    void updateUser2() {
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("aslhgfla");
        userInfo.setId(5);
        userInfoXmlMapper.updateUser2(userInfo);
    }

    @Test
    void deleteUser() {
        System.out.println(userInfoXmlMapper.deleteUser(10));
    }
}