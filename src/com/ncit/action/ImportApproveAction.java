package com.ncit.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.ncit.base.BaseAction;
import com.ncit.entity.BounsApprove;
import com.ncit.entity.BounsStats;
import com.ncit.entity.BounsUse;
import com.ncit.entity.ProjectBounsExtend;
import com.ncit.entity.User;
import com.ncit.util.FileUploadUtils;
import com.ncit.util.ImportDataHandler;
import com.ncit.util.MySessionContext;
import com.ncit.util.SimplePropertyFilter;

@Controller
@Scope("prototype")
public class ImportApproveAction extends BaseAction<BounsApprove> {
	
	private String data;
	
	//将上传的Excel解析成json数据，并计算细则总则之后返回
	public String approve() throws IOException{
//		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<BounsApprove> list = new ArrayList<BounsApprove>();//用来接收前台的数据，并将其封装成list
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(this.getUploadfile() == null|user == null){
			map.clear();
			map.put("success", "user");
			result = JSON.toJSONString(map);
		}else{
			//清除map
			map.clear();
			//清除之前的session
			request.getSession().removeAttribute("user");
			//重新添加session
			request.getSession().setAttribute("user", user);
			
			String str = FileUploadUtils.createFieldJson(getUploadfile());
	        System.out.println("json数据："+str);
			list = JSON.parseArray(str, BounsApprove.class);
			//处理细则
			list = ImportDataHandler.detailHandler(list);
			//处理总则
			list = ImportDataHandler.generalHandler(list);
			result = JSON.toJSONString(list);
			//重新获取sessionId返回
	        map.put("success", user);
	        map.put("data",result);
	        System.out.println("返回的result:"+result);
	        result = JSON.toJSONString(map);
		}
		return SUCCESS;
	}
	
	
	public String singleApprove(){
		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		
		System.out.println("------------------------->ImportAction----->singleApprove");
		List<BounsApprove> list = new ArrayList<BounsApprove>();//用来接收前台的数据，并将其封装成list
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		User user = (User)request.getSession().getAttribute("user");
		
		System.out.println("当前登录的用户："+user);
		System.out.println("数据："+this.data);
		
		if(user == null){
			map.clear();
			map.put("success", "loginError");
			result = JSON.toJSONString(map);
		}else{
			map.clear();
			String str = this.getData();
			//生成list
			list = JSON.parseArray(str, BounsApprove.class);
			System.out.println("财务Id："+list.get(0).getFinanceId());
			//处理细则
			list = ImportDataHandler.detailHandler(list);
			//处理总则
			list = ImportDataHandler.generalHandler(list);
			//清除之前的session
			request.getSession().removeAttribute("user");
			//重新添加session
			request.getSession().setAttribute("user", user);
			
			result = JSON.toJSONString(list);
			//重新获取sessionId返回
	        map.put("success", request.getSession().getId());
	        map.put("data",result);
	        System.out.println("返回的result:"+result);
	        result = JSON.toJSONString(map);
	       }
		return SUCCESS;
	}
	
	//当用户点击确定保存的     保存到数据库
	public String approveSaveData(){
		response.addHeader("Access-Control-Allow-Origin", "*");//公网访问
		
		System.out.println("------------------------->ImportAction------>approveSaveData");
		
		List<BounsApprove> list = new ArrayList<BounsApprove>();//用来接收前台的数据，并将其封装成list
		//用于更新项目报销的项目列表
		List<BounsUse> useList = new ArrayList<BounsUse>();
		//用户更新项目奖金的项目列表
		List<ProjectBounsExtend> extendList = new ArrayList<ProjectBounsExtend>();
		//用户更新项目奖金统计列表
		List<BounsStats> statsList = new ArrayList<BounsStats>();
		
		Map<Object, Object> map = new HashMap<Object, Object>();//用来返回格式化json
		
		String str = this.getData();
		//获取当前的登录对象
		User user = (User) request.getSession().getAttribute("user");
		//打印接收到的json
		System.out.println("json字符串："+str);
		if(this.getData() == null|user == null){
			map.clear();
			map.put("success", "user");
			result = JSON.toJSONString(map);
		}else{
			map.clear();
			
			//清除之前的session
			request.getSession().removeAttribute("user");
			//重新添加session
			request.getSession().setAttribute("user", user);
			list = JSON.parseArray(str, BounsApprove.class);
			
			System.out.println("返回数据的条数："+list.size());
			
			for(int i=0;i<list.size();i++){
				System.out.println("财务Id："+list.get(i).getFinanceId());
				useList.add(new BounsUse());
				extendList.add(new ProjectBounsExtend());
				statsList.add(new BounsStats());
			}
			//保存到数据库,申请数据
			bounsApproveService.insertNoaApproveData(list);
			//初始化数据
			for(int i=0;i<list.size();i++){
				//初初始化报销数据
				useList.get(i).setFinanceId(list.get(i).getFinanceId());
				useList.get(i).setProjectName(list.get(i).getProjectName());
				useList.get(i).setFundRecommend(list.get(i).getRecommendFund());//项目推荐经费
				useList.get(i).setFundUseUp(list.get(i).getFundUp());//设置项目经费上限
				//初始化项目奖金数据
				extendList.get(i).setFinanceId(list.get(i).getFinanceId());
				extendList.get(i).setProjectName(list.get(i).getProjectName());
				extendList.get(i).setFundSendTotal(list.get(i).getPmBouns()*(1-list.get(i).getRecommendRatio()));
				extendList.get(i).setFundSendDown(list.get(i).getPmBouns()*0.9);//项目奖金发放下限
				//项目统计数据
				statsList.get(i).setFinanceId(list.get(i).getFinanceId());
				statsList.get(i).setProjectName(list.get(i).getProjectName());
				statsList.get(i).setBounsTotal(list.get(i).getPmBouns());//设置项目奖金总额
				statsList.get(i).setBounsSendTotal(0);
				statsList.get(i).setBounsUseTotal(0);//报销额
				statsList.get(i).setBounsUsedTotal(statsList.get(i).getBounsSendTotal()+statsList.get(i).getBounsUseTotal());
				statsList.get(i).setBalance(statsList.get(i).getBounsTotal()-statsList.get(i).getBounsUsedTotal());
			}
			
			bounsUseService.initBounsUseValue(useList);//更新数据库
			bounsStatsService.initBounsStatsValue(statsList);
			projectBounsExtendService.initBounsExtendValue(extendList);
			
			result = JSON.toJSONString(list);
			//重新获取sessionId返回
	        map.put("success", user);
	        map.put("data",result);
	        System.out.println("返回的result:"+result);
	        result = JSON.toJSONString(map);
		}
		return SUCCESS;
	}
	
	//取消数据导入
	public String cancel(){
		System.out.println("取消数据导入");
		return "cancel";
	}
	
	//设置比例
	public String ratioSet(){
		System.out.println("设置比例");
		return "ratioset";
	}
	
	//批量导入项目分配信息
	public String distribution(){
		
		return "";
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

}




