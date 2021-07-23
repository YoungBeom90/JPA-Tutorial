package jpa.jpashop.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jpa.jpashop.member.Member;
import jpa.jpashop.util.SessionUtil;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Aspect
@Component
public class MemberLoginCheckAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("@annotation(jpa.jpashop.aop.MemberLoginCheck)")
	public void memberLoginCheck() throws Exception {
		log.debug("AOP - Member Login Check Started");
		Member member = null;
		HttpSession session = null;
		HttpServletRequest request = null;
		HttpServletResponse response = null;

		response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
		request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest()
				.getSession();

		member = SessionUtil.getLoginInfo(request, session);

		if (member == null) {
			session.removeAttribute("loginInfo");
			logger.info("세션 종료. 로그인 페이지 이동.");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('세션이 만료되었습니다.'); location.href='/loginPage';</script>");
			writer.close();

//			response.sendRedirect(request.getContextPath() + "/loginPage");
		}
		logger.info("세션확인 완료.");
	}

}
