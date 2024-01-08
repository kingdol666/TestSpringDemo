package com.kingdol.testspringdemo1.repository;

import com.kingdol.testspringdemo1.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    @Transactional
    @Modifying
    @Query("delete from UserInfo u where u.userId = ?1")
    int deleteByUserId(Long userId);
    @Transactional
    @Modifying
    @Query("update UserInfo u set u.email = ?1, u.age = ?2 where u.userId = ?3")
    int updateEmailAndAgeByUserId(String email, Integer age, Long userId);
    @Query("SELECT u FROM UserInfo u WHERE u.userId = :userId")
    UserInfo findByUserId(Long userId);

    // 保存用户信息
}
