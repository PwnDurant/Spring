package org.mon.mybaits.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.mon.mybaits.demo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoXmlMapper {


    List<UserInfo> selectAll();
}
