package org.mon.mybaits.demo.service;


import org.mon.mybaits.demo.mapper.UserInfoMapper;
import org.mon.mybaits.demo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> selectUserList() {
        return userInfoMapper.selectAll();
    }

    public UserInfo selectUserByNameAndPassword(String userName,String password) {
        List<UserInfo> userInfos = userInfoMapper.selectUserById(userName, password);
        if(userInfos.size()>0){
            return userInfos.get(0);
        }
        return null;
    }
}
