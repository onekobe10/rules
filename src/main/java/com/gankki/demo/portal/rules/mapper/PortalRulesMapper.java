package com.gankki.demo.portal.rules.mapper;

import com.gankki.demo.portal.rules.model.PortalRules;
import com.gankki.demo.portal.rules.model.PortalRulesExample;
import com.gankki.demo.portal.rules.model.User;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 规章制度表Mapper对象
 * @author liuhao	
 *
 * 2017年7月18日
 */
public interface PortalRulesMapper {
    int countByExample(PortalRulesExample example);

    int deleteByExample(PortalRulesExample example);

    int deleteByPrimaryKey(String id);

    int insert(PortalRules record);

    int insertSelective(PortalRules record);

    List<PortalRules> selectByExample(PortalRulesExample example);

    PortalRules selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PortalRules record, @Param("example") PortalRulesExample example);

    int updateByExample(@Param("record") PortalRules record, @Param("example") PortalRulesExample example);

    int updateByPrimaryKeySelective(PortalRules record);

    int updateByPrimaryKey(PortalRules record);

	List<PortalRules> selectRulesByList(List<String> list);

	List<PortalRules> selectRulesByArray(String[] arrs);

	List<PortalRules> selectRulesByMap(Map<String, Object> map);

	List<PortalRules> selectAllRules();

	List<PortalRules> selectRulesByObject(PortalRules rules);

	List<PortalRules> selectRulesByCreateDate(String date);

	List<String> selectRulesByGroup(String date);

	String selectTestUser(int testInt);

	void updateRulesByTest(String update);

	void updateRuesByAge(int i);

	void insertUserByTest(User user);

	List<User> selectUserByTest(User user);
}