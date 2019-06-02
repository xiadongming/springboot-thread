package Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Encoder;

public class DownLoadUtils {
	
	/**
	 * 判断浏览器类型，4，及其编码类型
	 * */
//	public static String getName(String agent, String filename) throws UnsupportedEncodingException {
//        if (agent.contains("MSIE")) {
//            // IE浏览器
//            filename = URLEncoder.encode(filename, "utf-8");
//            filename = filename.replace("+", " ");
//        } else if (agent.contains("Firefox")) {
//            // 火狐浏览器
//            BASE64Encoder base64Encoder = new BASE64Encoder();
//            String string = Base64.getEncoder().toString();
//            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
//        } else {
//            // 其它浏览器
//            filename = URLEncoder.encode(filename, "utf-8");
//        }
//        return filename;
//    }
}
