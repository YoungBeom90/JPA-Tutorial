package jpa.jpashop.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jpa.jpashop.member.Member;

public class SessionUtil {
	
	
	public static Member getLoginInfo(HttpServletRequest request, HttpSession session) {
		if(session == null) {
			session = request.getSession();
		}
		if(session == null) {
			return null;
		}
		
		Member loginInfo = (Member)session.getAttribute("loginInfo");
		
		return loginInfo;
	}
}
