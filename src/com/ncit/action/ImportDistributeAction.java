package com.ncit.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.ncit.base.BaseAction;
import com.ncit.entity.BounsApprove;
import com.ncit.entity.BounsSend;
import com.ncit.entity.BounsStats;
import com.ncit.entity.User;
import com.ncit.util.FileUploadUtils;
import com.ncit.util.MySessionContext;

/**
 * 导入分配数据的相关操作
 * ClassName: ImportDistributeAction 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月25日
 */
@Controller
@Scope("prototype")
public class ImportDistributeAction extends BaseAction<BounsSend> {
	
	
	private File uploadfile;
	private String center;
	private String uploadfileContentType;
	private String uploadfileFileName;
	private String financeID;
	private String data;
	
	
	//导入分配数据，解析导入的excel文件,并存到数据库
	public String analyzeAndSaveData(){
		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		System.out.println("------------------------->ImportAction----->analyzeAndSaveData");
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<BounsSend> list = new ArrayList<BounsSend>();
		//自定义的session
		MySessionContext myc= MySessionContext.getInstance();
		HttpSession session = myc.getSession(this.getUsersession());
		
		User user = (User) session.getAttribute("user");
		//清除之前的session
		request.getSession().removeAttribute("user");
		//重新添加session
		request.getSession().setAttribute("user", user);
		
		
		if(user == null){
			map.clear();
			map.put("success", "loginError");
			result = JSON.toJSONString(map);
		}else{
			if(user.getUserAccount().equals(this.userAccount)){
				map.clear();
				//解析excel文件成json数据
				String str = FileUploadUtils.createSendFieldJson(uploadfile);
				//将json数据转化成list
				System.out.println("json数据："+str);
				list = JSON.parseArray(str, BounsSend.class);
				//查询到所有的申请数据
//				List<BounsApprove> approvreList = bounsApproveService.findAll();
				//更新奖金管理表
//				List<BounsStats> statsList = bounsStatsService.insertBounsValue(approvreList);
				bounsSendService.insertBounsSendValue(list);
				//导入奖金管理表，更新奖金统计表
//				bounsStatsService.updateBounsValue(list);
		        map.put("success", request.getSession().getId());
		        result = JSON.toJSONString(map);
		        }else{
		        	map.clear();
		        	map.put("seccuss", "loginError");
					result = JSON.toJSONString(map);
		        }
		}
		return SUCCESS;
	}
	//选择中心
	public String whichCenter(){
		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		System.out.println("------------------------->ImportAction----->whichCenter");
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		//自定义的session
		MySessionContext myc= MySessionContext.getInstance();
		HttpSession session = myc.getSession(this.getUsersession());
		
		User user = (User) session.getAttribute("user");
		
		String str = "[{\"" + "centerName" + "\"" + ":" + "\"" +"无锡开发中心" +"\"}"
		+ ","+"{\"" + "centerName" + "\"" + ":" + "\"" + "长春开发中心" +"\"}"+
				","+"{\"" + "centerName" + "\"" + ":" +"\"" + "天津开发中心" +"\"}"+ 
		","+"{\"" + "centerName" + "\"" + ":"  + "\"" + "西安开发中心" +"\"}"+
				","+"{\"" + "centerName" + "\"" + ":"+"\"" + "北京开发中心"+"\"}]";
		
		//清除之前的session
		request.getSession().removeAttribute("user");
		//重新添加session
		request.getSession().setAttribute("user", user);
		if(user == null){
			map.clear();
			map.put("success", "loginError");
			result = JSON.toJSONString(map);
		}else{
			if(user.getUserAccount().equals(this.userAccount)){
				map.put("success", request.getSession().getId());
				map.put("data", str);
				result = JSON.toJSONString(map);
			}else{
	        	map.clear();
	        	map.put("seccuss", "loginError");
				result = JSON.toJSONString(map);
	        }
		}
		return SUCCESS;
	}
	//根据中心，返回项目id
	public String selectProjectId(){
		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		System.out.println("------------------------->ImportAction----->selectProjectId");
		Map<Object, Object> map = new HashMap<Object, Object>();
		//自定义的session
		MySessionContext myc= MySessionContext.getInstance();
		HttpSession session = myc.getSession(this.getUsersession());
		
		User user = (User) session.getAttribute("user");
		//清除之前的session
		request.getSession().removeAttribute("user");
		//重新添加session
		request.getSession().setAttribute("user", user);
		
		if(user == null){
			map.clear();
			map.put("success", "loginError");
			result = JSON.toJSONString(map);
		}else{
			if(user.getUserAccount().equals(this.userAccount)){
				map.clear();
				List<BounsSend> list = bounsSendService.findProjectFinanceId(this.getCenter());
//				bounsSendService.findEmployeeByFinanceId();
				
				System.out.println("查询到的list:"+list);
				System.out.println("所属中心："+this.getCenter());
				
				map.put("success", request.getSession().getId());
//				result = JSON.toJSONString(map);
				map.put("data", list);
				result = JSON.toJSONString(map);
				
			}else{
	        	map.clear();
	        	map.put("seccuss", "loginError");
				result = JSON.toJSONString(map);
	        }
		}
		return SUCCESS;
	}
	
	
	//根据中心，项目id，导入项目体制信息
	public String projectStruct(){
		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		System.out.println("------------------------->ImportAction----->projectStruct");
		Map<Object, Object> map = new HashMap<Object, Object>();
		//自定义的session
		MySessionContext myc= MySessionContext.getInstance();
		HttpSession session = myc.getSession(this.getUsersession());
		
		User user = (User) session.getAttribute("user");
		//清除之前的session
		request.getSession().removeAttribute("user");
		//重新添加session
		request.getSession().setAttribute("user", user);
//		System.out.println("用户："+this.getUserAccount());
//		System.out.println("session:"+this.getUsersession());
//		System.out.println("中心："+this.getCenter());
//		System.out.println("财务ID："+this);
		
		if(user == null){
			map.clear();
			map.put("success", "loginError");
			result = JSON.toJSONString(map);
		}else{
			if(user.getUserAccount().equals(this.userAccount)){
				map.clear();
				List<BounsSend> list = bounsSendService.findEmployeeByFinanceId(this.getFinanceID());//bounsSendService.findEmployeeByFinanceId(this.getFinanceID());
				System.out.println("查询数据库得到的："+list);
				map.put("success", request.getSession().getId());
				map.put("data", list);
				result = JSON.toJSONString(map);
			}else{
	        	map.clear();
	        	map.put("seccuss", "loginError");
				result = JSON.toJSONString(map);
	        }
		}			
		return SUCCESS;
	}
	
	//导入分配数据，更新数据库，更新奖金合计表
	public String distributeData(){
		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		System.out.println("------------------------->ImportAction----->distributeData");
		Map<Object, Object> map = new HashMap<Object, Object>();
		//自定义的session
		MySessionContext myc= MySessionContext.getInstance();
		HttpSession session = myc.getSession(this.getUsersession());
		
		User user = (User) session.getAttribute("user");
		//清除之前的session
		request.getSession().removeAttribute("user");
		//重新添加session
		request.getSession().setAttribute("user", user);
		System.out.println("用户："+this.getUserAccount());
		System.out.println("session:"+this.getUsersession());
//		System.out.println("中心："+this.getCenter());
		System.out.println("财务ID："+this);
		System.out.println("data:"+this.getData());
		
		if(user == null){
			map.clear();
			map.put("success", "loginError");
			result = JSON.toJSONString(map);
		}else{
			if(user.getUserAccount().equals(this.userAccount)){
				map.clear();
				
				List<BounsSend> updateList = JSON.parseArray(this.getData(), BounsSend.class);
				
				
			}else{
	        	map.clear();
	        	map.put("seccuss", "loginError");
				result = JSON.toJSONString(map);
	        }
		}			
		return SUCCESS;
	}

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}
	public String getFinanceID() {
		return financeID;
	}
	public void setFinanceID(String financeID) {
		this.financeID = financeID;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
