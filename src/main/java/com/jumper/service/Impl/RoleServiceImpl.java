package com.jumper.service.Impl;

import com.jumper.mapper.RoleMapper;
import com.jumper.pojo.Role;
import com.jumper.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role selectRoleByID(int roleID) {
        return roleMapper.selectRoleByID(roleID);
    }

}
