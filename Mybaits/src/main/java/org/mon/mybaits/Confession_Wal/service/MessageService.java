package org.mon.mybaits.Confession_Wal.service;


import org.mon.mybaits.Confession_Wal.mapper.MessageInfoMapper;
import org.mon.mybaits.Confession_Wal.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    public List<MessageInfo> queryMessage(){
        return messageInfoMapper.queryMessage();
    }

    public Integer insertMessage(MessageInfo messageInfo){
        return messageInfoMapper.insertMessage(messageInfo);
    }
}
