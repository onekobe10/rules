package com.gankki.demo.portal.rules.service;

import java.util.List;

import com.gankki.demo.portal.rules.model.PortalRules;
import com.gankki.demo.portal.rules.model.PortalRulesExample;

/**
 * @author liuhao
 * <p>
 * 2017年7月12日
 */
public interface IRulesService {

    public void insertRules(PortalRules rules);

    public List<PortalRules> queryRulesByExample(PortalRulesExample example);

    public void deleteRulesById(String ruelsId);

    public PortalRules queryRulesById(String rulesId);

    public void updateByPrimaryKey(PortalRules rules);

    public List<PortalRules> queryAllRules(PortalRulesExample example);

}
