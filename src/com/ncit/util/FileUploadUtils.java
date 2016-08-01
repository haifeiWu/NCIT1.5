package com.ncit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

public class FileUploadUtils {
	/**
	 * 
	 * @param @param file
	 * @return   
	 * @throws
	 * @author wuhaifei
	 * @date 2016年7月28日
	 */
	public static String createSendFieldJson(File file){
		 try {
	        	InputStream is = new FileInputStream(file);
	            StringBuffer buffer = new StringBuffer();
	            Workbook workbook = new HSSFWorkbook(is);
	            HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);//第一页sheet
	            //创建存放数据的数组
	            String[] keysField = {"employeeId","employeeName","departmentId","departmentName","financeId","projectName",
	            		"fundSend","applyDuration","note","applyDate","fundSendDate"};
	            String[] keys = new String[sheet.getRow(0).getPhysicalNumberOfCells()];
	            String[] values = new String[sheet.getRow(0).getPhysicalNumberOfCells()];
	            int number = 0;
	            buffer.append("[");            
	            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {//Excel的行数
	                HSSFRow row = sheet.getRow(i);
	                for(int j=0;j<row.getPhysicalNumberOfCells();j++){//返回当前行的单元格的个数
	                   if(i==0){//第0行数据是表头
//	                	   keys[j] = row.getCell(j).getStringCellValue();//将表头放到数组中
	                	   //处理项目计提数据
//	                	   if(row.getCell(j).getStringCellValue().equals("项目编码")
//	                			   |row.getCell(j).getStringCellValue().equals("贷方金额")){
//							keys[j] = row.getCell(j).getStringCellValue();
//							values[j] = String.valueOf(j);
//	                	   }
	                	   //处理报销数据导入
//	                	   if(row.getCell(j).getStringCellValue().equals("年")
//	                			   |row.getCell(j).getStringCellValue().equals("月")
//	                			   |row.getCell(j).getStringCellValue().equals("凭证号")
//	                			   |row.getCell(j).getStringCellValue().equals("项目编码")
//	                			   |row.getCell(j).getStringCellValue().equals("摘要")
//	                			   |row.getCell(j).getStringCellValue().equals("借方金额")){
//							keys[j] = row.getCell(j).getStringCellValue();
//							values[j] = String.valueOf(j);
//	                	   }
	                	   keys[j] = keysField[j];//row.getCell(j).getStringCellValue();
	                	   values[j] = String.valueOf(j);
	                   } else{
	                	   for(int m=row.getPhysicalNumberOfCells()-1; m>0; m--){
	                		   if(values[m] != null){
	                			   number = m;
	                			   break;
	                		   }
	                	   }
	                	   if(keys[j] != null&values[j] != null/*&getCellValue(row.getCell(j))!=null*/){
		                	   if(j==0){
		                           buffer.append("{\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j]))) + "\"" + ",");
		                       }else if(j==number){
		                    	   buffer.append("\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j])))+"\"}");
		                       }else{
		                    	   buffer.append("\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j]))) + "\"" + ",");
		                       }
	                	   }
	                   }
	                }
	                if(sheet.getPhysicalNumberOfRows()-1!=i && i!=0){
	                    buffer.append(",");
	                }
	                buffer.append("\r");
	            }
	            buffer.append("]");
	            return buffer.toString();
	        } catch (Exception e) {
	            System.out.println("出现异常");
	            throw new RuntimeException(e);
	        }
	}
	
	public static String createFieldJson(File file){
		 try {
	        	InputStream is = new FileInputStream(file);
	            StringBuffer buffer = new StringBuffer();
	            Workbook workbook = new HSSFWorkbook(is);
	            HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);//第一页sheet
	            //创建存放数据的数组
	            String[] keysField = {"noaId","financeId","projectName","pmId","departmentId","departmentName",
	            		"memberPersonMonth","BPPersonMonth","workPersonMonth","quitPersonMonth","applyDuration",
	            		"applyId","note","applyDate","approveDate"};
	            String[] keys = new String[sheet.getRow(0).getPhysicalNumberOfCells()];
	            String[] values = new String[sheet.getRow(0).getPhysicalNumberOfCells()];
	            int number = 0;
	            buffer.append("[");            
	            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {//Excel的行数
	                HSSFRow row = sheet.getRow(i);
	                for(int j=0;j<row.getPhysicalNumberOfCells();j++){//返回当前行的单元格的个数
	                   if(i==0){//第0行数据是表头
//	                	   keys[j] = row.getCell(j).getStringCellValue();//将表头放到数组中
	                	   //处理项目计提数据
//	                	   if(row.getCell(j).getStringCellValue().equals("项目编码")
//	                			   |row.getCell(j).getStringCellValue().equals("贷方金额")){
//							keys[j] = row.getCell(j).getStringCellValue();
//							values[j] = String.valueOf(j);
//	                	   }
	                	   //处理报销数据导入
//	                	   if(row.getCell(j).getStringCellValue().equals("年")
//	                			   |row.getCell(j).getStringCellValue().equals("月")
//	                			   |row.getCell(j).getStringCellValue().equals("凭证号")
//	                			   |row.getCell(j).getStringCellValue().equals("项目编码")
//	                			   |row.getCell(j).getStringCellValue().equals("摘要")
//	                			   |row.getCell(j).getStringCellValue().equals("借方金额")){
//							keys[j] = row.getCell(j).getStringCellValue();
//							values[j] = String.valueOf(j);
//	                	   }
	                	   keys[j] = keysField[j];//row.getCell(j).getStringCellValue();
	                	   values[j] = String.valueOf(j);
	                   } else{
	                	   for(int m=row.getPhysicalNumberOfCells()-1; m>0; m--){
	                		   if(values[m] != null){
	                			   number = m;
	                			   break;
	                		   }
	                	   }
	                	   if(keys[j] != null&values[j] != null/*&getCellValue(row.getCell(j))!=null*/){
		                	   if(j==0){
		                           buffer.append("{\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j]))) + "\"" + ",");
		                       }else if(j==number){
		                    	   buffer.append("\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j])))+"\"}");
		                       }else{
		                    	   buffer.append("\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j]))) + "\"" + ",");
		                       }
	                	   }
	                   }
	                }
	                if(sheet.getPhysicalNumberOfRows()-1!=i && i!=0){
	                    buffer.append(",");
	                }
	                buffer.append("\r");
	            }
	            buffer.append("]");
	            return buffer.toString();
	        } catch (Exception e) {
	            System.out.println("出现异常");
	            throw new RuntimeException(e);
	        }
	}
	
	/**
     * @description: 根据excel文件生成对应的json字符串
     * @return
     * @throws FileNotFoundException
     */
    public static String createJson(File file) {
        try {
        	InputStream is = new FileInputStream(file);
            StringBuffer buffer = new StringBuffer();
            Workbook workbook = new HSSFWorkbook(is);
            HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(0);//第一页sheet
            //创建存放数据的数组
            String[] keys = new String[sheet.getRow(0).getPhysicalNumberOfCells()];
            String[] values = new String[sheet.getRow(0).getPhysicalNumberOfCells()];
            int number = 0;
            buffer.append("[");            
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {//Excel的行数
                HSSFRow row = sheet.getRow(i);
                for(int j=0;j<row.getPhysicalNumberOfCells();j++){//返回当前行的单元格的个数
                   if(i==0){//第0行数据是表头
//                	   keys[j] = row.getCell(j).getStringCellValue();//将表头放到数组中
                	   //处理项目计提数据
//                	   if(row.getCell(j).getStringCellValue().equals("项目编码")
//                			   |row.getCell(j).getStringCellValue().equals("贷方金额")){
//						keys[j] = row.getCell(j).getStringCellValue();
//						values[j] = String.valueOf(j);
//                	   }
                	   //处理报销数据导入
//                	   if(row.getCell(j).getStringCellValue().equals("年")
//                			   |row.getCell(j).getStringCellValue().equals("月")
//                			   |row.getCell(j).getStringCellValue().equals("凭证号")
//                			   |row.getCell(j).getStringCellValue().equals("项目编码")
//                			   |row.getCell(j).getStringCellValue().equals("摘要")
//                			   |row.getCell(j).getStringCellValue().equals("借方金额")){
//						keys[j] = row.getCell(j).getStringCellValue();
//						values[j] = String.valueOf(j);
//                	   }
                	   keys[j] = row.getCell(j).getStringCellValue();
                	   values[j] = String.valueOf(j);
                   } else{
                	   for(int m=row.getPhysicalNumberOfCells()-1; m>0; m--){
                		   if(values[m] != null){
                			   number = m;
                			   break;
                		   }
                	   }
                	   if(keys[j] != null&values[j] != null/*&getCellValue(row.getCell(j))!=null*/){
	                	   if(j==0){
	                           buffer.append("{\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j]))) + "\"" + ",");
	                       }else if(j==number){
	                    	   buffer.append("\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j])))+"\"}");
	                       }else{
	                    	   buffer.append("\"" + keys[j] + "\"" + ":" + "\"" +  getCellValue(row.getCell(Integer.parseInt(values[j]))) + "\"" + ",");
	                       }
                	   }
                   }
                }
                if(sheet.getPhysicalNumberOfRows()-1!=i && i!=0){
                    buffer.append(",");
                }
                buffer.append("\r");
            }
            buffer.append("]");
            return buffer.toString();
        } catch (Exception e) {
            System.out.println("出现异常");
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取当前单元格内容
     * */  
    /**
     * 
     * @param cell
     * @return cell的内容   
     * @throws none
     * @author wuhaifei
     * @date 2016年7月25日
     */
    private static String getCellValue(Cell cell){  
        String value = "";  
        if(cell!=null){  
            switch (cell.getCellType()) {  
            case Cell.CELL_TYPE_NUMERIC:  
                if(HSSFDateUtil.isCellDateFormatted(cell)){ //日期类型  
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());  
                    value = sdf.format(date);  
                }else{  
                    Integer data = (int) cell.getNumericCellValue();  
                    value = data.toString();  
                }  
                break;  
            case Cell.CELL_TYPE_STRING:  
                value = cell.getStringCellValue();  
                break;  
            case Cell.CELL_TYPE_BOOLEAN:  
                Boolean data = cell.getBooleanCellValue();  
                value = data.toString();   
                break;  
            case Cell.CELL_TYPE_ERROR:  
                System.out.println("单元格内容出现错误");  
                break;  
            case Cell.CELL_TYPE_FORMULA:  
                value = String.valueOf(cell.getNumericCellValue());    
                if (value.equals("NaN")) {// 如果获取的数据值非法,就将其装换为对应的字符串  
                    value = cell.getStringCellValue().toString();    
                }             
                break;            
            case Cell.CELL_TYPE_BLANK:  
            	value = null;
                System.out.println("单元格内容 为空值 "+value);  
                break;            
            default :  
                value = cell.getStringCellValue().toString();  
                break;  
            }  
        }  
        return value;  
    }  
}
