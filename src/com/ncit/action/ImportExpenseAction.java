package com.ncit.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.ncit.base.BaseAction;
import com.ncit.entity.BounsStats;
import com.ncit.entity.BounsUse;
import com.ncit.entity.User;
import com.ncit.util.FileUploadUtils;

/**
 * 导入项目报销数据
 * 更新项目相关的数据，不项目经费
 * @author wuhaifei
 * @date 2016/08/3
 */
@Controller
@Scope("prototype")
public class ImportExpenseAction extends BaseAction<BounsUse>{
	
	
	//解析excel文件并核对经费是否超标
	public String analyzeAndCheack(){
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<BounsUse> list = new ArrayList<BounsUse>();//用来接收前台的数据，并将其封装成list
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(this.getUploadfile() == null|user == null){
			return "error";
		}else{
			//清除map
			map.clear();
			//清除之前的session
			request.getSession().removeAttribute("user");
			//重新添加session
			request.getSession().setAttribute("user", user);
			
			String str = FileUploadUtils.createUseFieldJson(getUploadfile());
	        System.out.println("json数据："+str);
	        
			list = JSON.parseArray(str, BounsUse.class);
				
			
			for(int i=0; i<list.size();i++){
				//判断三次才清除干净,不知道员因何在
				if(list.get(i).getEvidenceId().equals("null")){
					list.remove(i);
				}
				if(list.get(i).getEvidenceId().equals("null")){
					list.remove(i);
				}
				if(list.get(i).getEvidenceId().equals("null")){
					list.remove(i);
				}
			}
			List<BounsUse> updateList = bounsUseService.findAll();
//			List<BounsStats> statsList = bounsStatsService.findAll(); 
			for(int j=0;j<list.size();j++){
				System.out.println(list.get(j).toString());
			}
			/**
			 * 未考虑边缘情况
			 */
			for(int i=0;i<updateList.size();i++){
				for(int j=0;j<list.size();j++){
					if(updateList.get(i).getFinanceId().equals(list.get(j).getFinanceId())){
						
						if(list.get(j).getExpenseMoney()>updateList.get(i).getFundUseUp()){
							updateList.get(i).setAlert("项目经费支出超标");
						}else{
							updateList.get(i).setAlert(null);
							updateList.get(i).setExpenseReason(list.get(j).getExpenseReason());
							updateList.get(i).setExpenseMoney(list.get(j).getExpenseMoney());
							updateList.get(i).setExpenseDate(list.get(j).getExpenseDate());
						}
					}
				}
			}
			
//			bounsUseService.updateBounsUseInfor(updateList);
//			bounsStatsService.updateBunstatsInfor(statsList);
			
			request.getSession().setAttribute("updateList", updateList);//暂时的这么写
			
			for(int i=0;i<updateList.size(); i++){
				System.out.println(updateList.toString());
			}
			return "analyzeAndCheack";
		}
	}
	
	/**
	 * 用于保存数据
	 * @return
	 */
	public String saveData(){
		List<BounsStats> statsList = bounsStatsService.findAll();
		List<BounsUse> updateList = (List<BounsUse>) request.getSession().getAttribute("updateList");
		User user = (User) request.getSession().getAttribute("user");
		//清除session
		request.getSession().removeAttribute("updateList");
		
		if(user == null|updateList==null){
			return "error";
		}else{
			//保存,更新数据
			bounsUseService.updateBounsUseInfor(updateList);
			bounsStatsService.updateBunstatsInfor(statsList);
			return "saveData";
		}
		
	}
	/**
	 * 取消
	 * @return
	 */
	public String cancel(){
		//清除session
		request.getSession().removeAttribute("updateList");
		return "cancel";
	}
}
