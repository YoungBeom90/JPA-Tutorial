package jpa.jpashop.sale;

import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jpa.jpashop.member.MemberRepository;
import jpa.jpashop.product.ProductRepository;

@RestController
@RequestMapping("/sale")
public class SaleController {
	@Autowired SaleRepository saleRepository;
	
	@Autowired MemberRepository memberRepository;
	
	@Autowired ProductRepository ProductRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/insertSale")
	public String insertSale(Sale newSale) {
		logger.info("판매고객정보: " + newSale.getMemberId());
		logger.info("판매등록일: " + newSale.getSaleDate());
		saleRepository.save(newSale);
		return "0";
	}
	
	@GetMapping("/selectSaleList")
	public Page<Sale> selectSaleList() {
		Page<Sale> slist;
		slist = saleRepository.findAll(PageRequest.of(0, 5, Sort.by(Direction.DESC, "saleId")));
		
		return slist;
	}
	
	@GetMapping("/selectSalePage")
	public Page<Sale> selectSalePage(@RequestParam(name="page", defaultValue="1",required=true) int page) {
		Page<Sale> slist;
		slist = saleRepository.findAll(PageRequest.of(page-1, 5, Sort.by(Direction.DESC, "saleId")));
		return slist;
	}
	
	@GetMapping("/selectMemberSaleList")
	public Page<Sale> selectMemberSaleList(@RequestParam(name="member", required=true) String member) {
		Page<Sale> slist = null;
		
		return slist;
	}
		
}
