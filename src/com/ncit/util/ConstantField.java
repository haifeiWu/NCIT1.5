package com.ncit.util;

/**
 * 工具类 静态字段
 * ClassName: ConstantField 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月24日
 */
public interface ConstantField {
	//中心
	public static char BEIJING = 'B';
	public static char TIANJIN = 'T';
	public static char WUXI = 'W';
	public static char CHANGCHUN = 'C';
	public static char XIAN = 'X';
	
	//当地基准
	public static float BJ_LOCAL = 1700;
	public static float TJ_LOCAL = 1260;
	public static float WX_LOCAL = 1260;
	public static float CC_LOCAL = 1000;
	public static float XA_LOCAL = 1000;
	
	//连携基准
	public static float BORROW =300; 
	
}
