package org.mon.mybaits.demo.mapper;

import org.junit.jupiter.api.Test;
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
}