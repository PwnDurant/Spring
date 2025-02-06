package org.mon.mybaits.Confession_Wal.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mon.mybaits.Confession_Wal.model.MessageInfo;

import java.util.List;

@Mapper
public interface MessageInfoMapper {

    @Select("select * from message_info where delete_flag=0")
    List<MessageInfo> queryMessage();

    @Insert("insert into message_info (`from`,`to`,`message`) values (#{from},#{to},#{message})")
    Integer insertMessage(MessageInfo messageInfo);
}
