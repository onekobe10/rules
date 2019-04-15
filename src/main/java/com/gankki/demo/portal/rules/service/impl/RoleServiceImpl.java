package com.gankki.demo.portal.rules.service.impl;

import java.util.List;

import com.gankki.demo.portal.rules.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gankki.demo.portal.rules.model.Role;
import com.gankki.demo.portal.rules.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public String getRoleTypeByUser(String userId) {
        List<Role> roles = roleMapper.getRoleByUser(userId);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < roles.size(); i++) {
            sb.append(roles.get(i).getRoleType());
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

}
