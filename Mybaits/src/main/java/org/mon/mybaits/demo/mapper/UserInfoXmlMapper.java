package org.mon.mybaits.demo.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mon.mybaits.demo.model.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoXmlMapper {

    List<UserInfo> selectAll();

    Integer insertUser(UserInfo userInfo);

    Integer insertUser2(@Param("userInfo") UserInfo userInfo);

    Integer updateUser(Integer id,String password);

    Integer updateUser2(UserInfo userInfo);

    Integer deleteUser(Integer id);

    Integer insertUserByCondition(UserInfo userInfo);

    List<UserInfo> selectUserByCondition(UserInfo userInfo);

    Integer updateByCondition(UserInfo userInfo);

    Integer batchDelete(List<Integer> ids);
}
