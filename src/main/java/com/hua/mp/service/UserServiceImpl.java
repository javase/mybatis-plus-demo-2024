package com.hua.mp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hua.mp.dao.entity.User;
import com.hua.mp.dao.mapper.UserMapper;
import com.hua.mp.service.i.IUserService;

import org.springframework.stereotype.Service;

/**
 * created at 2024-01-15 16:38
 * @author lerry
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
