package com.gankki.demo.portal.rules.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gankki.demo.portal.rules.model.Role;

public interface RoleMapper {

	//根据用户查找，相应的角色
	public List<Role> getRoleByUser(@Param(value="userId")String userId);

}
