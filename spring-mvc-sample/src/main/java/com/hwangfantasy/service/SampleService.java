package com.hwangfantasy.service;

import com.hwangfantasy.bean.User;
import com.hwangfantasy.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/12 <br/>
 * @方法描述: TODO ADD FUNCTION. <br/>
 */
@Service
public class SampleService {
    @Autowired
    private UserMapper userMapper;

    public void addUser(User user){
        userMapper.insert(user);
    }
}
