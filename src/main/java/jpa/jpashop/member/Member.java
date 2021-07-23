package jpa.jpashop.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Entity // 테이블
@Data
public class Member {
	
	public Member() {}
	
	// @Id 는 PK 설정, @SequenceGenerator는 시퀀스, @GeneratedValue 는 default 값이라고 볼 수 있다.
	@Id 
//	@SequenceGenerator(name="MEMBER_ID_GENERATOR", sequenceName="MEMBER_ID_SEQ", allocationSize = 1)
//	@GeneratedValue(strategy= GenerationType.IDENTITY, generator="MEMBER_ID_GENERATOR")
	@Schema(description ="유저ID")
	@Column(nullable = false)
	private String memberId;
	
	@Schema(description ="유저명")
	@Column(nullable = false)
	private String memberName;
	
	@Schema(description="유저PW")
	@Column(nullable = false)
	private String password;
	
	@Schema(description="유저주소")
	@Column(nullable = false)
	private String address;
	
	@Schema(description="유저등록일자")
	@Column(nullable = false)
	private String signInDate;
	
	
}
