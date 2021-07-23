package jpa.jpashop.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jpa.jpashop.util.MemberUtil;

@RestController
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MemberRepository memberRepository;

	@GetMapping("/member")
	public List<Member> selectMembers() {
		List<Member> mlist = new ArrayList<Member>();
		Iterable<Member> iterable = memberRepository.findAll(Sort.by(Direction.DESC, "memberId"));
		for (Member memberEntity : iterable) {
			logger.info("member : " + memberEntity);
			mlist.add(memberEntity);
		}
		return mlist;
	}

	@PostMapping("/member/insert")
	public String insertMembers(Member newMember) {
		String pwd = newMember.getPassword();
		String hexPwd = MemberUtil.getHashSHA256(pwd);
		newMember.setPassword(hexPwd);
		memberRepository.save(newMember);
		return "0";
	}

	@GetMapping("/member/info")
	public String selectMemberInfo(@RequestParam(name = "memberId") String memberId) throws JsonProcessingException {
		Optional<Member> optional = null;
		Member member = null;

		optional = memberRepository.findByMemberId(memberId);
		member = optional.get();
		logger.info("member=" + member.getMemberName());
		ObjectMapper jsonObj = new ObjectMapper();
		String jsonData = jsonObj.writeValueAsString(member);
		return jsonData;
	}
}
