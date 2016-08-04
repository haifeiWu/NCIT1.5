package com.ncit.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.ncit.base.BaseAction;
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
			
			String str = FileUploadUtils.createJson(getUploadfile());
	        System.out.println("json数据："+str);
//			list = JSON.parseArray(str, BounsUse.class);
			
//			result = JSON.toJSONString(list);
//			//重新获取sessionId返回
//	        map.put("success", user);
//	        map.put("data",result);
//	        System.out.println("返回的result:"+result);
//	        result = JSON.toJSONString(map);
		}
		return SUCCESS;
	}
}
