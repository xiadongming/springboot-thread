package com.poi.excel;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.example.demo.pojo.Student;

public class CreateSimpleExcelToDisk {

     	 @SuppressWarnings("deprecation")  
	    public static void main(String[] args) throws Exception {
		// 第一步，创建一个webbook，对应一个Excel文件    
	        HSSFWorkbook wb = new HSSFWorkbook();  
	     // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet    
	        HSSFSheet sheet = wb.createSheet("学生表一"); 
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short   
	        HSSFCellStyle headStyle = wb.createCellStyle();   
	        HSSFFont f  = wb.createFont();        
	        f.setFontHeightInPoints((short) 15);// 字号     
	        f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗     
	        headStyle.setFont(f);   
	        headStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式    
	        headStyle.setBorderBottom((short) 1);  
	        headStyle.setBorderRight((short) 1);  
	        headStyle.setFillBackgroundColor((short) 20);  
	        HSSFRow row = sheet.createRow((int) 0);               //----将sheet的表头(学号，姓名)，设置为row=0行
	        
	        // 第四步，创建单元格，并设置值表头 设置表头居中    
	        HSSFCellStyle style = wb.createCellStyle();    
	        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式    
	        style.setBorderBottom((short) 1);  
	        style.setBorderRight((short) 1);  
	        String[] header = new String[]{"学号","姓名","年龄","生日"};    
	        HSSFCell cell = null;  
	        for(int i=0;i<header.length;i++){  
	            cell = row.createCell((short) i);   
	            cell.setCellValue(header[i]);    
	            cell.setCellStyle(headStyle);   
	            sheet.setColumnWidth(i, 5000);  
	        } 
	        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，    
	        List<Student> list = CreateSimpleExcelToDisk.getStudent();      
	        for (int i = 0; i < list.size(); i++)    
	        {    
	            row = sheet.createRow((int) i + 1);    
	            Student stu = (Student) list.get(i);    
	            // 第四步，创建单元格，并设置值    
	            cell = row.createCell((short) 0);  
	            cell.setCellValue(stu.getId());  
	            cell.setCellStyle(style);  
	            cell = row.createCell((short) 1);  
	            cell.setCellValue(stu.getName());  
	            cell.setCellStyle(style);  
	            cell = row.createCell((short) 2);  
	            cell.setCellValue(stu.getAge());  
	            cell.setCellStyle(style);  
	            cell = row.createCell((short) 3);    
	            cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu.getBirth()));    
	            cell.setCellStyle(style);  
	        }    
	        // 第六步，将文件存到指定位置    
	        try    
	        {    
	            FileOutputStream fout = new FileOutputStream("D:/students.xls");    
	            wb.write(fout);    
	            fout.close();    
	            System.out.println("输出成功！");  
	        }    
	        catch (Exception e)    
	        {    
	            e.printStackTrace();    
	        }    
	    }    
	        
		private static List<Student> getStudent() throws Exception {    
	        List<Student> list = new ArrayList<Student>();    
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");    
	    
	        Student user1 = new Student(1, "张三", 16, df.parse("1997-03-12"));    
	        Student user2 = new Student(2, "李四", 17, df.parse("1996-08-12"));    
	        Student user3 = new Student(3, "王五", 26, df.parse("1985-11-12"));    
	        list.add(user1);    
	        list.add(user2);    
	        list.add(user3);    
	    
	        return list;    
	    }    
		
}
