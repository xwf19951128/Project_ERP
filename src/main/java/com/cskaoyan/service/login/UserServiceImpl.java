package com.cskaoyan.service.login;

import com.cskaoyan.bean.login.SysUser;
import com.cskaoyan.bean.user.Role;
import com.cskaoyan.bean.user.User;
import com.cskaoyan.mapper.login.UserMapper;
import com.cskaoyan.service.login.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public SysUser queryUserByUsername(String username) {
        SysUser sysUser = userMapper.queryUserByUsername(username);
        return sysUser;
    }

    @Override
    public SysUser queryUserByUsernameAndPassword(SysUser user) {
        SysUser sysUser = userMapper.queryUserByUsernameAndPassword(user);
        return sysUser;
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public List<Role> getRoleData() {
        return userMapper.getRoleData();
    }

    @Override
    public User queryUserById(User user) {
        return userMapper.queryUserById(user.getId());
    }

    @Override
    public int updateAll(User user) {
        userMapper.updateRole(user);
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteBatch(String[] ids) {
        userMapper.deleteBatchRole(ids);
        return userMapper.deleteBatchUser(ids);
    }

    @Override
    public int insertUser(User user) {
        UUID uuid = UUID.randomUUID();
        userMapper.insertUserRole(user,uuid.toString());
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> searchUserByUserId(String term) {
        return userMapper.searchUserByUserId(term);
    }

    @Override
    public List<User> searchUserByUserName(String term) {
        return userMapper.searchUserByUserName(term);
    }

    @Override
    public List<User> searchUserByRoleName(String term) {
        return userMapper.searchUserByRoleName(term);
    }
}
