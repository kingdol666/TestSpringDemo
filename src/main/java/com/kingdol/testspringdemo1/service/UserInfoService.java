package com.kingdol.testspringdemo1.service;

import com.kingdol.testspringdemo1.entity.UserInfo;
import com.kingdol.testspringdemo1.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    public UserInfo findUserInfoById(Long userId){
        return userInfoRepository.findById(userId).get();
    }

    public Boolean saveUserInfo(UserInfo userInfo){
        userInfoRepository.save(userInfo);
        return true;
    }

    public Boolean deleteUserInfo(Long userId){
        userInfoRepository.deleteByUserId(userId);
        return true;
    }

    public Boolean updateUserInfo(UserInfo userInfo){
        Long userId = userInfo.getUserId();
        String email = userInfo.getEmail();
        Integer age = userInfo.getAge();
        userInfoRepository.updateEmailAndAgeByUserId(email, age, userId);
        return true;
    }
}
