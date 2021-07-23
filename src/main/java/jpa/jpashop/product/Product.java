package jpa.jpashop.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="PRODUCT_ID_GEN")
	@SequenceGenerator(name="PRODUCT_ID_GEN", sequenceName="PRODUCT_ID_SEQ", allocationSize = 1)
	@Schema(description="상품ID")
	private Long prdtId;
	
	@Schema(description="상품명")
	@Column(nullable = false)
	private String prdtname;
	
	@Schema(description="상품가격")
	@Column(nullable = false)
	private String prdtPrice;
	
	@Schema(description="상품사이즈")
	
	private String prdtSize;
	
	@Schema(description="상품색상")
	private String prdtColor;
	
	@Builder
	public Product(Long prdtId, String prdtname, String prdtPrice, String prdtSize, String prdtColor) {
		this.prdtId = prdtId;
		this.prdtname = prdtname;
		this.prdtPrice = prdtPrice;
		this.prdtSize = prdtSize;
	}
}
