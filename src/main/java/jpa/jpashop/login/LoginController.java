package jpa.jpashop.login;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpa.jpashop.member.Member;
import jpa.jpashop.member.MemberRepository;
import jpa.jpashop.util.MemberUtil;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private MemberRepository memberRepository;
	
	@PostMapping("/newLogin")
	public String newLogin(@RequestParam Map<String, String> memberInfo, HttpSession session) {
		String memberId = memberInfo.get("memberId");
		String pwd = memberInfo.get("password");
		pwd = MemberUtil.getHashSHA256(pwd);
		Optional<Member> selcMember = memberRepository.findByMemberId(memberId);
		Member member = selcMember.get();
		
		if(member == null) {
			return "fail_id";
		}
		
		String selcMemberPwd =  member.getPassword();
		logger.info("요청 비밀번호 = " + pwd);
		logger.info("데이터베이스 비밀번호 = " + selcMemberPwd);
		if(!pwd.equals(selcMemberPwd)) {
			return "fail_pwd";
		}
		session.setAttribute("loginInfo", member);
		session.setMaxInactiveInterval(60*5);
		
		return "success";
	}
	
	/*
	 * @GetMapping("/loginCheck") public String loginCheck(HttpServletRequest
	 * request, HttpSession session) throws Exception{ String check = null;
	 * if(session==null) { session = request.getSession(); } Member member =
	 * (Member) session.getAttribute("loginInfo");
	 * 
	 * if(member != null) { check = "true"; } logger.info("세션확인 완료."); return check;
	 * }
	 */
}
