package com.browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class downloadDemo {

	/**
	 * 不推荐
	 * */
	@RequestMapping("/down")
	public void down(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "D:\\word_temp.docx";
		File file = new File(path);
		long size = file.length();

		String fileName = new String("000.doc".getBytes("UTF-8"), "iso-8859-1");
		response.reset();

		response.setHeader("Accept-Ranges", "bytes");
		response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", fileName));
		
	}
	   
	   /**
	    * 功能是ok的，但是没有应用场景
	    * */
	    @RequestMapping("/down2")
	    @ResponseBody
	    public void downloadDeviceLog(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        String logUrl = "https://**/word_temp.docx";
	        try {
	            String [] logUrlArray = logUrl.split("/");
	            String fileName = logUrlArray[logUrlArray.length-1];
	            URL url = new URL (logUrl);
	            URLConnection uc = url.openConnection();
	            response.setContentType("application/octet-stream");//设置文件类型
	            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
	            response.setHeader("Content-Length", String.valueOf(uc.getContentLength()));
	            ServletOutputStream out = response.getOutputStream();
	            IOUtils.copy(uc.getInputStream(), out);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   /**
	    * ok的
	    * */
	   @RequestMapping("/down3")
	   public void download(HttpServletResponse response) throws  IOException{
	        //获取服务器文件
	        File file = new File("D:\\word_temp.docx");
	 
	        InputStream ins = new FileInputStream(file);
	        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
	        response.setContentType("multipart/form-data");
	        /* 设置文件头：最后一个参数是设置下载文件名 */
	        response.setHeader("Content-Disposition", "attachment;filename="+file.getName());
	        try{
	            OutputStream os = response.getOutputStream();
	            byte[] b = new byte[1024];
	            int len;
	            while((len = ins.read(b)) > 0){
	                os.write(b,0,len);
	            }
	            os.flush();
	            os.close();
	            ins.close();
	        }catch (IOException ioe){
	           ioe.printStackTrace();
	        }
	    }
	   /**
	    * ok的
	    * */
	   @RequestMapping("/down4")
	   public void download4(HttpServletResponse response,HttpServletRequest request) throws  IOException{
	        //获取服务器文件
	        File file = new File("D:\\word_temp.docx");
	 
	        InputStream ins = new FileInputStream(file);
	        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
	        response.setContentType("multipart/form-data");
	        /* 设置文件头：最后一个参数是设置下载文件名 */
	        response.setHeader("Content-Disposition", "attachment;filename="+"abc.docx");
	       // String name = file.getName();//显示word_temp.docx
	        String userAgent = request.getHeader("user-agent").toLowerCase();  
	        try{
	            OutputStream os = response.getOutputStream();
	            IOUtils.copy(ins, os);
	           
	        }catch (IOException ioe){
	           ioe.printStackTrace();
	        }
	    }
	   
	   /**
	    * ok的
	    * */
	   @RequestMapping("/down5")
	   public void download5(HttpServletResponse response) throws  IOException{
	        //获取服务器文件
	        File file = new File("D:\\word_temp.docx");
	 
	        InputStream ins = new FileInputStream(file);
	        /* 设置文件ContentType类型，这样设置，会自动判断下载文件类型 */
	        response.setContentType("multipart/form-data");
	        /* 设置文件头：最后一个参数是设置下载文件名 */
	        response.setHeader("Content-Disposition", "attachment;filename="+file.getName());
	        try{
	            OutputStream os = response.getOutputStream();
	           FileCopyUtils.copy(ins, os);
	        }catch (IOException ioe){
	           ioe.printStackTrace();
	        }
	    }
	   
	   
}
