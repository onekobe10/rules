package com.gankki.demo.portal.rules.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gankki.demo.phone.model.PhoneInformObject;
import com.gankki.demo.portal.rules.model.PortalRules;
import com.gankki.demo.portal.rules.model.PortalRulesExample;
import com.gankki.demo.portal.rules.service.IRulesService;
import com.gankki.demo.portal.rules.util.ExportExcelFile;
import com.gankki.demo.portal.rules.util.StringUtils;

/**
 * 规章制度表相关文件Controller
 * 
 * @author liuhao
 * 
 * 2017年7月18日
 */
@Controller
@RequestMapping("file")
public class FileRulesController {

	@Autowired
	private IRulesService rulesService;

	/**
	 * 规章制度附件下载
	 * 
	 * @param req
	 * @param res
	 * @param rulesId
	 * 
	 */
	@RequestMapping("download")
	public void downloadRule(HttpServletRequest req, HttpServletResponse res,
			String rulesId) {
		InputStream is = null;
		OutputStream os = null;
		try {
			ServletContext sc = req.getSession().getServletContext();
			// 根据id将对象的文件名查询并判断
			PortalRules rules = this.rulesService.queryRulesById(rulesId);
			String fileName = rules.getRules();
			if (!StringUtils.isEmpty(fileName)) {
				String path = sc.getRealPath("/fileManager");
				File file = new File(path);
				if (!file.exists()) {
					file.mkdirs();
				}
				is = new FileInputStream(new File(file, fileName));
				// Http的Head要求编码格式必须为iso8859-1
				String newFileName = new String(fileName.getBytes(),
						"iso8859-1");
				res.setHeader("Content-Disposition", "attachment;filename="
						+ newFileName);
				os = res.getOutputStream();
				// 将is流数据copy给os
				IOUtils.copy(is, os);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null && os != null) {
					// 最后将流关闭
					is.close();
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将所有的规章制度数据导出到Excel表中
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "export", method = RequestMethod.GET)
	public void exportRules(HttpServletRequest req, HttpServletResponse res) {
		try {
			// 创建查询对象
			PortalRulesExample example = new PortalRulesExample();
			List<PortalRules> list = this.rulesService.queryAllRules(example);
			List<PhoneInformObject> list2 = new ArrayList<PhoneInformObject>();
			// 创建导出对象并调用导出Excel文件方法
			ExportExcelFile export = new ExportExcelFile();
			export.exportExcelFile(list2, req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
