package com.ncit.util;

import java.util.List;

import com.ncit.entity.BounsApprove;

/**
 * 数据处理的工具类
 * 先细则，后总则
 * ClassName: ImportDataHandler 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月23日
 */
public class ImportDataHandler {
	/**
	 * 设置各中心的总则
	 * @param list
	 * @return list 
	 * @throws none
	 * @author wuhaifei
	 * @date 2016年7月23日
	 */
	public static List<BounsApprove> generalHandler(List<BounsApprove> list){//设置各中心的总则
		
		for(int i = 0; i < list.size(); i++) {//遍历列表
			
			list.get(i).setRatioUp(0.1);
			list.get(i).setRatioBounsDown(0.9);
			list.get(i).setRecommendRatio(0.08);
			//设置项目经费上限金额
			list.get(i).setFundUp(list.get(i).getBounsMemberWork()*list.get(i).getRatioUp());
			//设置项目奖金下限
			list.get(i).setBounsDown(list.get(i).getBounsMemberWork()*list.get(i).getRatioBounsDown());
			//设置项目经费推荐
			list.get(i).setRecommendFund(list.get(i).getRecommendRatio()*list.get(i).getBounsMemberWork());
		}
		return list;
	}
	/**
	 * 设定各个中心细则
	 * @param list
	 * @return list
	 * @throws none
	 * @author wuhaifei
	 * @date 2016年7月23日
	 */
	public static List<BounsApprove> detailHandler(List<BounsApprove> list){
		char belong;
		for(int i=0; i < list.size(); i++){
			belong = list.get(i).getFinanceId().charAt(1);
			switch (belong) {
			case ConstantField.BEIJING:
				//计算项目人月
				list.get(i).setProjectPersonMonth(list.get(i).getBPPersonMonth()+list.get(i).getMemberPersonMonth());
				//计算BP率
				list.get(i).setBPRate(list.get(i).getBPPersonMonth()/list.get(i).getProjectPersonMonth());
				
				//社员奖金
				list.get(i).setBonusMember(ConstantField.BJ_LOCAL*list.get(i).getMemberPersonMonth());
				//中心共通经费
				list.get(i).setCenterFund(ConstantField.BJ_LOCAL*list.get(i).getBPPersonMonth());
				//连携奖金
				list.get(i).setBounsWork(ConstantField.BORROW*list.get(i).getWorkPersonMonth());
				//社员+连携奖金
				list.get(i).setBounsMemberWork(list.get(i).getBounsWork()+list.get(i).getBonusMember());
				//离职奖金
				list.get(i).setBounsQuit(ConstantField.BJ_LOCAL*list.get(i).getQuitPersonMonth());
				
				//中心
				list.get(i).setCenterBouns(list.get(i).getBPPersonMonth()*ConstantField.BJ_LOCAL);
				//本部
				list.get(i).setBaseDepartDouns(0);
				//部门
				list.get(i).setDepartmentBouns(0);
				//PM
				list.get(i).setPmBouns(list.get(i).getMemberPersonMonth()*ConstantField.BJ_LOCAL
						+list.get(i).getWorkPersonMonth()+ConstantField.BORROW);
				
				//奖金总额
				list.get(i).setBounsTotal(list.get(i).getPmBouns()+list.get(i).getCenterBouns()
						+list.get(i).getDepartmentBouns()+list.get(i).getBaseDepartDouns());
				
				break;
			case ConstantField.TIANJIN:
				
				//计算项目人月
				list.get(i).setProjectPersonMonth(list.get(i).getBPPersonMonth()+list.get(i).getMemberPersonMonth());
				//计算BP率
				list.get(i).setBPRate(list.get(i).getBPPersonMonth()/list.get(i).getProjectPersonMonth());
				System.out.println(list.get(i).getBPRate());
				//社员奖金
				list.get(i).setBonusMember(ConstantField.TJ_LOCAL*list.get(i).getMemberPersonMonth());
				//中心共通经费
				list.get(i).setCenterFund(ConstantField.TJ_LOCAL*list.get(i).getBPPersonMonth());
				//连携奖金
				list.get(i).setBounsWork(ConstantField.BORROW*list.get(i).getWorkPersonMonth());
				//社员+连携奖金
				list.get(i).setBounsMemberWork(list.get(i).getBounsWork()+list.get(i).getBonusMember());
				//离职奖金
				list.get(i).setBounsQuit(ConstantField.TJ_LOCAL*list.get(i).getQuitPersonMonth());
				
				//中心
				list.get(i).setCenterBouns(list.get(i).getBPPersonMonth()*ConstantField.TJ_LOCAL);
				//本部
				list.get(i).setBaseDepartDouns(0);
				//部门
				list.get(i).setDepartmentBouns((list.get(i).getMemberPersonMonth()*ConstantField.TJ_LOCAL
						+list.get(i).getWorkPersonMonth()+ConstantField.BORROW)*0.65);
				//PM
				list.get(i).setPmBouns((list.get(i).getMemberPersonMonth()*ConstantField.TJ_LOCAL
						+list.get(i).getWorkPersonMonth()+ConstantField.BORROW)*0.35);
				
				//奖金总额
				list.get(i).setBounsTotal(list.get(i).getPmBouns()+list.get(i).getCenterBouns()
						+list.get(i).getDepartmentBouns()+list.get(i).getBaseDepartDouns());
				
				break;
			case ConstantField.WUXI:
				//计算项目人月
				list.get(i).setProjectPersonMonth(list.get(i).getBPPersonMonth()+list.get(i).getMemberPersonMonth());
				//计算BP率
				list.get(i).setBPRate(list.get(i).getBPPersonMonth()/list.get(i).getProjectPersonMonth());
				
				//社员奖金
				list.get(i).setBonusMember(ConstantField.WX_LOCAL*list.get(i).getMemberPersonMonth());
				//中心共通经费
				list.get(i).setCenterFund(ConstantField.WX_LOCAL*list.get(i).getBPPersonMonth());
				//连携奖金
				list.get(i).setBounsWork(ConstantField.BORROW*list.get(i).getWorkPersonMonth());
				//社员+连携奖金
				list.get(i).setBounsMemberWork(list.get(i).getBounsWork()+list.get(i).getBonusMember());
				//离职奖金
				list.get(i).setBounsQuit(ConstantField.WX_LOCAL*list.get(i).getQuitPersonMonth());
				
				//中心
				list.get(i).setCenterBouns(list.get(i).getBPPersonMonth()*
						ConstantField.WX_LOCAL*0.444+list.get(i).getQuitPersonMonth()*
						ConstantField.WX_LOCAL*0.5);
				//本部
				list.get(i).setBaseDepartDouns(list.get(i).getMemberPersonMonth()*ConstantField.WX_LOCAL*
						0.04+list.get(i).getBPPersonMonth()*ConstantField.WX_LOCAL*0.079+
						list.get(i).getQuitPersonMonth()*ConstantField.WX_LOCAL*0.5-
						list.get(i).getQuitPersonMonth()*ConstantField.WX_LOCAL*0.04);
				//部门
				list.get(i).setDepartmentBouns(list.get(i).getMemberPersonMonth()*ConstantField.WX_LOCAL*0.079
						+list.get(i).getBPPersonMonth()*ConstantField.WX_LOCAL*0.079
						+list.get(i).getWorkPersonMonth()*ConstantField.BORROW
						-list.get(i).getQuitPersonMonth()*ConstantField.WX_LOCAL*0.079);
				//PM
				list.get(i).setPmBouns(list.get(i).getMemberPersonMonth()*ConstantField.WX_LOCAL*0.881
						+list.get(i).getBPPersonMonth()*ConstantField.WX_LOCAL*0.398
						-list.get(i).getQuitPersonMonth()*ConstantField.WX_LOCAL*0.881);
				
				//奖金总额
				list.get(i).setBounsTotal(list.get(i).getPmBouns()+list.get(i).getCenterBouns()
						+list.get(i).getDepartmentBouns()+list.get(i).getBaseDepartDouns());
				break;
			case ConstantField.CHANGCHUN:
				
				//计算项目人月
				list.get(i).setProjectPersonMonth(list.get(i).getBPPersonMonth()+list.get(i).getMemberPersonMonth());
				//计算BP率
				list.get(i).setBPRate(list.get(i).getBPPersonMonth()/list.get(i).getProjectPersonMonth());
				
				//社员奖金
				list.get(i).setBonusMember(ConstantField.CC_LOCAL*list.get(i).getMemberPersonMonth());
				//中心共通经费
				list.get(i).setCenterFund(ConstantField.CC_LOCAL*list.get(i).getBPPersonMonth());
				//连携奖金
				list.get(i).setBounsWork(ConstantField.BORROW*list.get(i).getWorkPersonMonth());
				//社员+连携奖金
				list.get(i).setBounsMemberWork(list.get(i).getBounsWork()+list.get(i).getBonusMember());
				//离职奖金
				list.get(i).setBounsQuit(ConstantField.CC_LOCAL*list.get(i).getQuitPersonMonth());
				
				//中心
				list.get(i).setCenterBouns(list.get(i).getBPPersonMonth()*
						ConstantField.CC_LOCAL*0.5+list.get(i).getQuitPersonMonth()*
						ConstantField.CC_LOCAL*0.5);
				//本部
				list.get(i).setBaseDepartDouns(
						list.get(i).getMemberPersonMonth()*ConstantField.CC_LOCAL*0.05
						+list.get(i).getQuitPersonMonth()*ConstantField.CC_LOCAL*0.2
						-list.get(i).getQuitPersonMonth()*ConstantField.CC_LOCAL*0.05);
				//部门
				list.get(i).setDepartmentBouns(list.get(i).getMemberPersonMonth()*ConstantField.CC_LOCAL*0.079
						+list.get(i).getBPPersonMonth()*ConstantField.CC_LOCAL*0.1
						+list.get(i).getWorkPersonMonth()*ConstantField.BORROW
						-list.get(i).getQuitPersonMonth()*ConstantField.CC_LOCAL*0.08);
				//PM
				list.get(i).setPmBouns(list.get(i).getMemberPersonMonth()*ConstantField.CC_LOCAL*0.87
						+list.get(i).getBPPersonMonth()*ConstantField.CC_LOCAL*0.4
						+list.get(i).getQuitPersonMonth()*ConstantField.CC_LOCAL*0.3
						-list.get(i).getQuitPersonMonth()*ConstantField.CC_LOCAL*0.87);
				
				//奖金总额
				list.get(i).setBounsTotal(list.get(i).getPmBouns()+list.get(i).getCenterBouns()
						+list.get(i).getDepartmentBouns()+list.get(i).getBaseDepartDouns());
				
				break;
			case ConstantField.XIAN:
				//计算项目人月
				list.get(i).setProjectPersonMonth(list.get(i).getBPPersonMonth()+list.get(i).getMemberPersonMonth());
				//计算BP率
				list.get(i).setBPRate(list.get(i).getBPPersonMonth()/list.get(i).getProjectPersonMonth());
				
				//社员奖金
				list.get(i).setBonusMember(ConstantField.XA_LOCAL*list.get(i).getMemberPersonMonth());
				//中心共通经费
				list.get(i).setCenterFund(ConstantField.XA_LOCAL*list.get(i).getBPPersonMonth());
				//连携奖金
				list.get(i).setBounsWork(ConstantField.BORROW*list.get(i).getWorkPersonMonth());
				//社员+连携奖金
				list.get(i).setBounsMemberWork(list.get(i).getBounsWork()+list.get(i).getBonusMember());
				//离职奖金
				list.get(i).setBounsQuit(ConstantField.XA_LOCAL*list.get(i).getQuitPersonMonth());
				
				//中心
				list.get(i).setCenterBouns(list.get(i).getBPPersonMonth()*ConstantField.XA_LOCAL);
				//本部
				list.get(i).setBaseDepartDouns(0);
				//部门
				list.get(i).setDepartmentBouns((list.get(i).getMemberPersonMonth()*ConstantField.XA_LOCAL
						+list.get(i).getWorkPersonMonth()+ConstantField.BORROW)*0.6);
				//PM
				list.get(i).setPmBouns((list.get(i).getMemberPersonMonth()*ConstantField.XA_LOCAL
						+list.get(i).getWorkPersonMonth()+ConstantField.BORROW)*0.4);
				
				//奖金总额
				list.get(i).setBounsTotal(list.get(i).getPmBouns()+list.get(i).getCenterBouns()
						+list.get(i).getDepartmentBouns()+list.get(i).getBaseDepartDouns());
				break;
				
			default:
				break;
			}
		}
		
		return list;
	}
	/**
	 * 计算申请数据
	 * @param list
	 * @return list
	 * @throws none
	 * @author wuhaifei
	 * @date 2016年7月23日
	 */
	public static List<BounsApprove> approveHandler(List<BounsApprove> list){
		for(int i=0;i<list.size();i++){
//			list.get(i).setRatioUp(0.1);
//			list.get(i).setRatioBounsDown(0.9);
			list.get(i).setRecommendRatio(0.08);
		}
		
		return list;
	}
}
