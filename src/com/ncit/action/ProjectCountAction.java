package com.ncit.action;

import java.io.File;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
public class ProjectCountAction extends ActionSupport{
	
	private File uploadfile;
	private String uploadfileContentType;
	private String uploadfileFileName;
	
	//解析上传的excel文件并核对项目计提信息，看是否正确，
	//最后将数据返回前台，注意项目计提不足的警告应该用颜色标示
	public String analyzeCountCheack(){
		
		return SUCCESS;
	}
	
	
	
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	
}
