package org.mon.mybaits.Confession_Wal.mapper;

import org.junit.jupiter.api.Test;
import org.mon.mybaits.Confession_Wal.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MessageInfoMapperTest {

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    @Test
    void queryMessage() {
        System.out.println(messageInfoMapper.queryMessage());
    }

    @Test
    void insertMessage() {
        MessageInfo messageInfo=new MessageInfo();
        messageInfo.setFrom("zhangsan");
        messageInfo.setTo("lisi");
        messageInfo.setMessage("帮我签到");
        System.out.println(messageInfoMapper.insertMessage(messageInfo));

    }
}