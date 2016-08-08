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
public class ProjectCountAction extends BaseAction implements ServletRequestAware{
	
	
	//解析上传的excel文件并核对项目计提信息，看是否正确，
	//最后将数据返回前台，注意项目计提不足的警告应该用颜色标示
	public String analyzeCountCheack(){
		List<ProjectCount> countList = new ArrayList<ProjectCount>();
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user == null){
			return "error";
		}else{
			String str = FileUploadUtils.createProjectCountFieldJson(getUploadfile());
			countList = JSON.parseArray(str, ProjectCount.class);
	        System.out.println("json数据："+str);
	        return "analyzeCountCheack";
		}
	}
}
