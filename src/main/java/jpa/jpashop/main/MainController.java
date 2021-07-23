package jpa.jpashop.main;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jpa.jpashop.aop.MemberLoginCheck;

@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String index(HttpServletRequest req) throws Exception {
		
		String returnPage = "/loginPage";
		
		return returnPage;
	}
	
	@RequestMapping("/loginPage")
	public String loginPage() throws Exception {
		logger.info("로그인 페이지 입니다.");
		return "loginPage";
	}
	
	@RequestMapping("/main")
	@MemberLoginCheck
	public String main() throws Exception {
		logger.info("메인 페이지 입니다.");
		return "main";
	}
	
	@RequestMapping("/minfo")
	@MemberLoginCheck
	public String viewMemberInfo() throws Exception {
		return "/member/mInfo";
	}
	
	@RequestMapping("/viewSaleList")
	public String viewSaleList() throws Exception {
		return "/sale/saleList";
	}
	
}
