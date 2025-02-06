package org.mon.mybaits.Confession_Wal.controller;

import org.mon.mybaits.Confession_Wal.model.MessageInfo;
import org.mon.mybaits.Confession_Wal.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    private List<MessageInfo> messageInfos =new ArrayList<>();

    @Autowired
    private MessageService messageService;

    @RequestMapping("/getList")
    public List<MessageInfo> getList(){
        return messageService.queryMessage();
    }
    @RequestMapping("/publish")
    public boolean publish(MessageInfo messageInfo){
        System.out.println(messageInfo.toString());
        if(StringUtils.hasLength(messageInfo.getFrom())
                &&StringUtils.hasLength(messageInfo.getTo())
                &&StringUtils.hasLength(messageInfo.getMessage())){
//            messageInfos.add(messageInfo);
            messageService.insertMessage(messageInfo);
            return true;
        }
        return false;
    }
}
