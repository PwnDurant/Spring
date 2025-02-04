package org.mon.mybaits;

import org.junit.jupiter.api.Test;
import org.mon.mybaits.demo.mapper.UserInfoMapper;
import org.mon.mybaits.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybaitsApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void contextLoads() {
        System.out.println(userInfoMapper.selectAll());
    }

}
