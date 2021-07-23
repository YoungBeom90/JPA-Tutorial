package jpa.jpashop.sale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import io.swagger.v3.oas.annotations.media.Schema;
import jpa.jpashop.member.Member;
import jpa.jpashop.product.Product;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Sale {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="SALE_ID_GEN")
	@SequenceGenerator(name="SALE_ID_GEN", sequenceName="SALE_ID_SEQ", allocationSize = 1)
	@Schema(description="판매ID")
	private Long saleId;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	@Schema(description="구매고객ID")
	private Member memberId;
	
	@ManyToOne
	@JoinColumn(name="prdtId")
	@Schema(description="구매상품ID")
	private Product prdtId;
	
	@Schema(description="구매수량")
	@Column(nullable = false)
	private int salePrdtCtn;
	
	@Schema(description="판매일시")
	@Column(nullable = false)
	private String saleDate;
	
	@Builder
	public Sale(Long saleId, Member memberId, Product prdtId, int salePrdtCtn, String saleDate) {
		this.saleId = saleId;
		this.memberId = memberId;
		this.prdtId = prdtId;
		this.salePrdtCtn = salePrdtCtn;
		this.saleDate = saleDate;
	}
	
}
