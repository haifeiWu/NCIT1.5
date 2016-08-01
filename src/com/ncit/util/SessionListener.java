package com.ncit.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 通过sessionid获取对象的监听器
 * ClassName: SessionListener 
 * @Description: TODO
 * @author wuhaifei
 * @date 2016年7月23日
 */
public class SessionListener implements HttpSessionListener {

	public static Map userMap = new HashMap();
    private MySessionContext myc=MySessionContext.getInstance();
	    
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		myc.AddSession(httpSessionEvent.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		HttpSession session = httpSessionEvent.getSession();
        myc.DelSession(session);
	}

}
