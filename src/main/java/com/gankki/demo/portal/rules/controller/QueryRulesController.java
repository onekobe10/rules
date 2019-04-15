package com.gankki.demo.portal.rules.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gankki.demo.portal.rules.model.PortalRules;
import com.gankki.demo.portal.rules.model.PortalRulesExample;
import com.gankki.demo.portal.rules.model.PortalRulesExample.Criteria;
import com.gankki.demo.portal.rules.service.IRulesService;
import com.gankki.demo.portal.rules.util.PageUtils;
import com.gankki.demo.portal.rules.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 查询规章制度Controller
 *
 * @author liuhao
 * <p>
 * 2017年7月12日
 */
@Controller
@RequestMapping("query")
public class QueryRulesController {

    @Autowired
    private IRulesService rulesService;
    @Resource
    private HashMap<String, String> productType;

    /**
     * 模糊查询规则制度
     *
     * @param pageNum
     * @param productTypeKey 产品类型的key
     * @param rules
     * @param model
     * @return
     */
    @RequestMapping(value = "main")
    public String queryMain(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            PortalRules rules, Model model) {
        try {
            // 创建查询对象
            PortalRulesExample example = new PortalRulesExample();
            // 创建查询标准
            Criteria criteria = example.createCriteria();
            // 将主题、产品类型、新建时间、新建人员作为查询条件
            if (!StringUtils.isEmpty(rules.getTheme())) {
                criteria.andThemeLike("%" + rules.getTheme() + "%");
            }
            if (!StringUtils.isEmpty(rules.getProductType())) {
                criteria.andProductTypeEqualTo(rules.getProductType());
            }
            if (!StringUtils.isEmpty(rules.getBuildPerson())) {
                criteria.andBuildPersonEqualTo(rules.getBuildPerson());
            }
            if (!StringUtils.isEmpty(rules.getBuildDate())) {
                criteria.andBuildDateEqualTo(rules.getBuildDate());
            }
            // 分页操作
            PageHelper.startPage(pageNum, 8);
            List<PortalRules> list = this.rulesService
                    .queryRulesByExample(example);
            PageInfo<PortalRules> page = new PageInfo<PortalRules>(list);
            model.addAttribute("rules", rules);
            model.addAttribute("pageNum", pageNum);
            model.addAttribute("page", page);
            model.addAttribute("index_nums",
                    PageUtils.listPageNums(page.getPageNum(), page.getPages()));
            // 将产品类型以及查询结果传递回页面
            model.addAttribute("productType", this.productType);
            model.addAttribute("queryRulesList", list);

            return "rulesManager/queryRules";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "查询操作中出现错误!");
            model.addAttribute("path", "rules/query/main");
            return "common/error";
        }
    }

    /**
     * 规章制度详情
     *
     * @param rulesId 主键Id
     * @param model
     * @return
     */
    @RequestMapping(value = "details", method = RequestMethod.GET)
    public String rulesDetails(String rulesId, Model model) {
        try {
            PortalRules rule = this.rulesService.queryRulesById(rulesId);
            // 将查询结果与产品类型等带回页面
            model.addAttribute("productType1", this.productType);
            model.addAttribute("rule", rule);

            return "rulesManager/rulesDetails";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "详情展示操作出现错误!");
            model.addAttribute("path", "rules/query/main");
            return "common/error";
        }
    }
}
