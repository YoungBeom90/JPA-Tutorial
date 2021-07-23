package jpa.jpashop.sale;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.jpashop.member.Member;


public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}
