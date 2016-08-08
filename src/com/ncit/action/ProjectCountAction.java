package com.ncit.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.ncit.base.BaseAction;
import com.ncit.entity.BounsApprove;
import com.ncit.entity.BounsUse;
import com.ncit.entity.ProjectCount;
import com.ncit.entity.User;
import com.ncit.util.FileUploadUtils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 项目项目计提核对（项目计提=项目奖金+报销额）
 * 功能：财务系统导出各个项目的项目奖金的计提数据，
 * 		导入本系统，核对各个项目奖金计提是否足够
 * 累计计提金额    应略大于   项目奖金总额（正式社员 + BP社员部分的项目奖金）
 * @author wuhaifei
 *
 * @date 2016年8月3日
 */

@Controller
@Scope("prototype")
public class ProjectCountAction extends BaseAction<ProjectCount> implements ServletRequestAware{
	
	
	//解析上传的excel文件并核对项目计提信息，看是否正确，
	//最后将数据返回前台，注意项目计提不足的警告应该用颜色标示
	public String analyzeCountCheack(){
		List<ProjectCount> countList = new ArrayList<ProjectCount>();
		
		User user = (User) request.getSession().getAttribute("user");
		int length=0;
		if(user == null){
			return "error";
		}else{
			
			List<BounsApprove> approvrList = bounsApproveService.findAll();
			String str = FileUploadUtils.createProjectCountFieldJson(getUploadfile());
			countList = JSON.parseArray(str, ProjectCount.class);
			
			//核对信息
			for(int i=0; i<countList.size(); i++){
				for(int j=0; j<approvrList.size(); j++){
					if(countList.get(i).getFinanceId().equals(approvrList.get(j).getFinanceId())){
						if(countList.get(i).getCountMoney()<approvrList.get(j).getCenterFund()){
							countList.get(i).setAlert("项目奖金计提额不足，不足金额为："+
									(approvrList.get(j).getCenterFund()-countList.get(i).getCountMoney()));
							countList.get(i).setAmountPaid(approvrList.get(j).getCenterFund());//设置支出金额
						}else{
							countList.get(i).setAmountPaid(approvrList.get(j).getCenterFund());//设置支出金额
						}
					}
				}
			}
			
			
			for(int i=0; i<countList.size(); i++){
				System.out.println(countList.get(i));
			}
			
			context.setAttribute("countList", countList);
			
//			for(int i=0; i<approvrList.size(); i++){
//				System.out.println(approvrList.get(i));
//			}
//	        System.out.println("json数据："+str);
	        return "analyzeCountCheack";
		}
	}
}
