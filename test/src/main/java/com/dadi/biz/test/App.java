package com.dadi.biz.test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import sun.misc.BASE64Decoder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
 
//         Connection conn=DBUtil.getConnection();
//         String sql="" + 
//                 "select * from t_comm_BinaryData";
//         String sql2="SELECT a.UserID,c.BinaryData FROM [Forp].[dbo].[t_res_Employee] a,[Forp].[dbo].[t_res_Employee_Photo] b,[Forp].[dbo].[t_comm_BinaryData] c where a.UserId = b.Number and b.DocID = c.DocID";
//         PreparedStatement psmt = conn.prepareStatement(sql2);
//         
//         //执行SQL语句
//         ResultSet rs = psmt.executeQuery();
//         while(rs.next()){
////            System.out.println("docid="+rs.getInt("UserId")+","+rs.getString("BinaryData"));
////            GenerateImage(rs.getString("BinaryData"), rs.getInt("UserId"));
////            break;
//            GenerateImage(rs.getString("BinaryData"), rs.getInt("UserID"));
//         }
    	
    	String a="media/dweb/cg/photo/4028001167ab79fb0167ab8281920016/4028001167ab79fb0167ab8284c2002f\744d7e5e90d149088ba5d0442cfbac29_1544780293642.jpg";
    	
    	String[] b=a.split("\\\\");
//    	b=a.replaceAll("\\/", "//");
    	System.out.println(b.length);
//    	System.out.println("ret="+b);
    	
    	String str = StringEscapeUtils.unescapeHtml4("&lt;p&gt;【产品名称】艾酷维多种维生素锌软糖&lt;/p&gt;");
		System.out.println(str);
		String str2 = StringEscapeUtils.escapeHtml4("<p>【产品名称】艾酷维多种维生素锌软糖</p>");
		System.out.println(str2);
    }
  //base64字符串转化成图片  
    public static boolean GenerateImage(String imgStr,int id)  
    
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            String imgFilePath = "D:\\tupian3\\"+id+".jpg";//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
            return false;  
        }  
    }  
}
