package com.hwangfantasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwangfantasy.bean.User;
import com.hwangfantasy.bean.UserExample;
import com.hwangfantasy.dao.UserMapper;

import java.util.List;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/25 <br/>
 * @方法描述: SampleService. <br/>
 */
@Service
public class SampleService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public User getUserByName(String name){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<User> users = userMapper.selectByExample(userExample);
        if(users == null || users.size() == 0)
            return null;
        return users.get(0);
    }
}
