package com.gankki.demo.portal.rules.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.gankki.demo.portal.rules.model.PortalRules;
import com.gankki.demo.portal.rules.service.IRulesService;
import com.gankki.demo.portal.rules.service.RoleService;
import com.gankki.demo.portal.rules.util.StringUtils;
import com.gankki.demo.portal.rules.util.UUIDUtil;

/**
 * 规章制度管理Controller
 *
 * @author liuhao
 * <p>
 * 2017年7月12日
 */
@Controller
@RequestMapping("regulation")
public class RegulationRulesController {

    @Autowired
    private IRulesService rulesService;
    @Autowired
    private RoleService roleService;
    @Resource
    private HashMap<String, String> productType;

    /**
     * 主页面的跳转
     *
     * @param main
     * @return
     */
    @RequestMapping("{main}")
    public String mainPage(@PathVariable String main) {
        return "rulesManager/" + main;
    }

    /**
     * 返回添加规章制度页面并将配置文件中的产品类型信息返回给页面
     *
     * @param req
     * @param res
     * @param model
     * @return
     */
    @RequestMapping(value = "addPage", method = RequestMethod.GET)
    public String regulationAdd(HttpServletRequest req, Model model) {
        // 将产品类型带回页面
        model.addAttribute("productType", this.productType);
        String userId = (String) req.getSession().getAttribute("userId");
        if (!StringUtils.isEmpty(userId)) {
            model.addAttribute("userid", userId);
        }
        return "rulesManager/addRulesPage";
    }

    /**
     * 规章制度添加操作
     *
     * @param rules
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String InsertRules(HttpServletRequest request, PortalRules rules,
                              MultipartFile file, Model model) {
        try {
            // UUID生成规章制度的主键ID
            rules.setId(UUIDUtil.getUUID());
            // 将附件保存在硬盘上，文件名持久化到数据库中去
            ServletContext sc = request.getSession().getServletContext();
            String fileName = file.getOriginalFilename();
            // 判断是否上传文件
            if (!StringUtils.isEmpty(fileName)) {
                // 判断目录是否存在
                String path = sc.getRealPath("/fileManager");
                File file2 = new File(path);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file.transferTo(new File(file2, fileName));
                rules.setRules(fileName);
            } else {
                model.addAttribute("msg", "添加数据操作中出现错误！");
                model.addAttribute("path", "rules/query/main");
                return "common/error";
            }
            this.rulesService.insertRules(rules);
            // 插入成功之后3秒之后回到的页面
            model.addAttribute("returnpath", "rules/regulation/addPage");
            return "common/success";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "添加数据操作中出现错误！");
            model.addAttribute("path", "rules/query/main");
            return "common/error";
        }
    }

    /**
     * 通过主键Id删除某条数据
     *
     * @param ruelsId 主键Id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void deleteRulesById(HttpServletRequest req,
                                HttpServletResponse res, String rulesId, Model model) {
        try {
            // 产品类型带回页面
            model.addAttribute("productType", this.productType);
            this.rulesService.deleteRulesById(rulesId);
            // 如果删除成功则还返回查询页面
            res.sendRedirect(req.getContextPath() + "/rules/query/main");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改规整制度
     *
     * @param req
     * @param file
     * @param model
     * @param rule
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateRulesById(HttpServletRequest req, MultipartFile file,
                                  Model model, PortalRules rule) {
        try {
            ServletContext sc = req.getSession().getServletContext();
            String newFileName = file.getOriginalFilename();
            String oldPath = sc.getRealPath("/fileManager");
            File file2 = new File(oldPath);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            // 判断是否有新的附件替换上传
            if (!StringUtils.isEmpty(newFileName)) {
                // 判断原来是否已经有附件，如果有则删除
                if (!StringUtils.isEmpty(rule.getRules())) {
                    File file3 = new File(file2, rule.getRules());
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file.transferTo(new File(file2, file.getOriginalFilename()));
                    rule.setRules(newFileName);
                } else {
                    // 如果原来没有附件，则直接上传附件
                    file.transferTo(new File(file2, file.getOriginalFilename()));
                    rule.setRules(newFileName);
                }
            }
            // 将rule持久化到数据库
            this.rulesService.updateByPrimaryKey(rule);
            // 操作成功返回的页面
            model.addAttribute("returnpath", "rules/query/main");

            return "common/success";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "修改数据操作中出现错误！");
            model.addAttribute("path", "rules/query/main");
            return "common/error";
        }
    }

    @RequestMapping("roleTypeJudge")
    public void roleTypeJudge(HttpServletRequest req, HttpServletResponse res) {
        PrintWriter out = null;
        try {
            String roleType = this.roleService.getRoleTypeByUser((String) req
                    .getSession().getAttribute("userId"));
            Map<String, Object> map = new HashMap<String, Object>();
            if (!roleType.contains("Admin")) {
                map.put("msg", "没有管理员权限");
                map.put("flag", "true");
            } else {
                map.put("flag", "true");
            }
            // 设置页面为 不缓存
            res.setContentType("application/json");
            res.setHeader("Pragma", "No-cache");
            res.setHeader("Cache-Control", "no-cache");
            out = res.getWriter();
            out.print(JSON.toJSONString(map));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
