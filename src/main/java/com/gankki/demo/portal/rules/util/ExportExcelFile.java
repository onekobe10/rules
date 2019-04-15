package com.gankki.demo.portal.rules.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.gankki.demo.phone.model.PhoneInformObject;


/**
 * 利用poi生成Excel文件
 *
 * @author liuhao
 * <p>
 * 2017年7月18日
 */
public class ExportExcelFile {
    public void exportExcelFile(List<PhoneInformObject> list, HttpServletRequest req, HttpServletResponse res) {
        OutputStream os = null;
        try {
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = workbook.createSheet("Sheet1");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = workbook.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
            sheet.setColumnWidth(0, 3766);
            sheet.setColumnWidth(1, 3766);
            sheet.setColumnWidth(2, 3766);
            sheet.setColumnWidth(3, 3766);
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
            font.setColor((short) 160);
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
            font2.setColor((short) 160);
            font2.setFontName("宋体");
            // 把字体应用到当前的样式
            style2.setFont(font2);

            HSSFCell cell = row.createCell(0);
            cell.setCellValue("姓名");
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue("电话");
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue("部门");
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue("职位");
            cell.setCellStyle(style);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    row = sheet.createRow((int) i + 1);
                    PhoneInformObject pio = list.get(i);
                    // 第四步，创建单元格，并设置值
                    //第一列
                    cell = row.createCell(0);
                    cell.setCellValue(pio.getName());
                    cell.setCellStyle(style2);
                    //第二列
                    cell = row.createCell(1);
                    cell.setCellValue(pio.getPhone());
                    cell.setCellStyle(style2);
                    //第三列
                    cell = row.createCell(2);
                    cell.setCellValue(pio.getDepartment());
                    cell.setCellStyle(style2);
                    //第四列
                    cell = row.createCell(3);
                    cell.setCellValue(pio.getPosition());
                    cell.setCellStyle(style2);
                }
            }
            // 第六步，将文件输出，一般输出路径由用户决定
            String newFileName = null;
            String fileName = "电话通知对象导出_" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xls";
            //编码文件名
            String header = req.getHeader("User-Agent").toUpperCase();
            if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
                newFileName = URLEncoder.encode(fileName, "utf-8");
                newFileName = newFileName.replace("+", "%20");    //IE下载文件名空格变+号问题
            } else {
                newFileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
            }
            res.setHeader("Content-Disposition", "attachment;filename=" + newFileName);
            os = res.getOutputStream();
            workbook.write(os);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
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
