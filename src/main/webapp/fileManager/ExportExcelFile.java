package com.boco.eoms.portal.rules.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import sun.tools.tree.NewArrayExpression;

import com.boco.eoms.portal.rules.model.PortalRules;


/**
 * 利用poi生成Excel文件
 * @author liuhao	
 *
 * 2017年7月18日
 */
public class ExportExcelFile {
	public void exportExcelFile(List<PortalRules> list,HttpServletResponse res) {
		OutputStream os = null;
		try {
			// 第一步，创建一个webbook，对应一个Excel文件
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
			HSSFSheet sheet = workbook.createSheet("Sheet1");
			// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
			HSSFRow row = sheet.createRow((int) 0);
			// 第四步，创建单元格，并设置值表头 设置表头居中
			HSSFCellStyle style = workbook.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
			sheet.setColumnWidth(0, 3766);
			sheet.setColumnWidth(1, 3766);
			sheet.setColumnWidth(2, 3766);
			sheet.setColumnWidth(3, 3766);
			sheet.setColumnWidth(4, 3766);
			sheet.setColumnWidth(5, 3766);
			sheet.setColumnWidth(6, 3766);
			sheet.setColumnWidth(7, 3766);
			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.YELLOW.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			// 生成一个字体
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFColor.VIOLET.index);
			font.setFontHeightInPoints((short) 14);
			font.setColor((short)160);
			font.setFontName("宋体");
			//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			// 把字体应用到当前的样式
			style.setFont(font);
			// 生成并设置另一个样式
			HSSFCellStyle style2 = workbook.createCellStyle();
		      style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		      style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 生成另一个字体
			HSSFFont font2 = workbook.createFont();
			font2.setColor(HSSFColor.VIOLET.index);
			font2.setFontHeightInPoints((short) 12);
			font2.setColor((short)160);
			font2.setFontName("宋体");
			// 把字体应用到当前的样式
			style2.setFont(font2);

			HSSFCell cell = row.createCell((short) 0);
			cell.setCellValue("主题");
			cell.setCellStyle(style);

			cell = row.createCell((short) 1);
			cell.setCellValue("产品类型");
			cell.setCellStyle(style);

			cell = row.createCell((short) 2);
			cell.setCellValue("简介");
			cell.setCellStyle(style);

			cell = row.createCell((short) 3);
			cell.setCellValue("新建时间");
			cell.setCellStyle(style);
			
			cell = row.createCell((short) 4);
			cell.setCellValue("新建人员");
			cell.setCellStyle(style);
			
			cell = row.createCell((short) 5);
			cell.setCellValue("规章制度");
			cell.setCellStyle(style);
			
			cell = row.createCell((short) 6);
			cell.setCellValue("备注");
			cell.setCellStyle(style);
			
			// 第五步，写入实体数据 实际应用中这些数据从数据库得到，
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					row = sheet.createRow((int) i + 1);
					PortalRules rule = list.get(i);
					// 第四步，创建单元格，并设置值
					//添加主题信息到excel单元格中
					cell = row.createCell((short) 0);
					cell.setCellValue(rule.getTheme());
					//设置该单元格样式
					cell.setCellStyle(style2);
					
					//添加产品类型信息到excel单元格中
					cell = row.createCell((short) 1);
					cell.setCellValue(rule.getProductType());
					//设置该单元格样式
					cell.setCellStyle(style2);
					
					//添加简介信息到excel单元格中
					cell = row.createCell((short) 2);
					cell.setCellValue(rule.getIntroduce());
					//设置该单元格样式
					cell.setCellStyle(style2);
					
					//添加新建时间信息到excel单元格中
					cell = row.createCell((short) 3);
					cell.setCellValue(rule.getBuildDate()!= null ? 
							new SimpleDateFormat("yyyy-MM-dd").format(rule.getBuildDate()) : "");
					//设置该单元格样式
					cell.setCellStyle(style2);
					
					//添加新建人员信息到excel单元格中
					cell = row.createCell((short) 4);
					cell.setCellValue(rule.getBuildPerson());
					//设置该单元格样式
					cell.setCellStyle(style2);
					
					//添加技术规章制度附件名字信息到excel单元格中
					cell = row.createCell((short) 5);
					cell.setCellValue(rule.getRules());
					//设置该单元格样式
					cell.setCellStyle(style2);
					
					//添加强制保险时间到excel单元格中
					cell = row.createCell((short) 6);
					cell.setCellValue(rule.getRemarks());
					//设置该单元格样式
					cell.setCellStyle(style2);
				}
			}
			// 第六步，将文件输出，一般输出路径由用户决定
			String fileName = "规章制度数据_"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+".xls";
			String newFileName = new String(fileName.getBytes(),"iso8859-1");
			res.setHeader("Content-Disposition","attachment;filename="+newFileName);
			os = res.getOutputStream();
			workbook.write(os);
		}catch (Exception e) {
			e.printStackTrace();;
		}finally{
			if (os != null) {
				try {
					//最后关闭输出流
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
