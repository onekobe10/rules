package com.gankki.demo.portal.rules.service.impl;

import java.util.List;
import java.util.Map;

import com.gankki.demo.portal.rules.mapper.PortalRulesMapper;
import com.gankki.demo.portal.rules.model.PortalRulesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gankki.demo.portal.rules.model.PortalRules;
import com.gankki.demo.portal.rules.model.User;
import com.gankki.demo.portal.rules.service.IRulesService;

/**
 * 规章制度业务层
 *
 * @author liuhao
 * <p>
 * 2017年7月12日
 */
@Service
public class RulesService implements IRulesService {

    @Autowired
    private PortalRulesMapper rulesMapper;

    public void insertRules(PortalRules rules) {
        this.rulesMapper.insert(rules);
    }

    public List<PortalRules> queryRulesByExample(PortalRulesExample example) {
        return this.rulesMapper.selectByExample(example);
    }

    public void deleteRulesById(String rulesID) {
        this.rulesMapper.deleteByPrimaryKey(rulesID);
    }

    public PortalRules queryRulesById(String rulesId) {
        return this.rulesMapper.selectByPrimaryKey(rulesId);
    }

    @Override
    public void updateByPrimaryKey(PortalRules rules) {
        this.rulesMapper.updateByPrimaryKey(rules);
    }

    @Override
    public List<PortalRules> queryAllRules(PortalRulesExample example) {
        return this.rulesMapper.selectByExample(example);
    }

    public List<PortalRules> selectRulesByList(List<String> list) {
        return this.rulesMapper.selectRulesByList(list);
    }

    public List<PortalRules> selectRulesByArray(String[] arrs) {
        return this.rulesMapper.selectRulesByArray(arrs);
    }

    public List<PortalRules> selectRulesByMap(Map<String, Object> map) {
        return this.rulesMapper.selectRulesByMap(map);
    }

    public List<PortalRules> selectAllRules() {
        return this.rulesMapper.selectAllRules();
    }

    public List<PortalRules> selectRulesByObject(PortalRules rules) {
        return this.rulesMapper.selectRulesByObject(rules);
    }

    public List<PortalRules> selectRulesByCreateDate(String date) {
        return this.rulesMapper.selectRulesByCreateDate(date);
    }

    public List<String> selectRulesByGroup(String date) {
        return this.rulesMapper.selectRulesByGroup(date);
    }

    public String selectTestUser(int testInt) {
        return this.rulesMapper.selectTestUser(testInt);
    }

    public void updateRulesByTest(String update) {
        this.rulesMapper.updateRulesByTest(update);
    }

    public void updateRuesByAge(int i) {
        this.rulesMapper.updateRuesByAge(i);
    }

    public void insertUserByTest(User user) {
        this.rulesMapper.insertUserByTest(user);
    }

    public List<User> selectUserByTest(User user) {
        return this.rulesMapper.selectUserByTest(user);
    }

}
