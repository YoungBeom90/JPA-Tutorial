package jpa.jpashop.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductQueryRepository extends JpaRepository<Product, Long>{
	
	@Query(value="from Product where prdtname like CONCAT('%',:searchName,'%') "
			+ "order by prdtname desc")
	public List<Product> searchProduct(@Param("searchName")String param);
}
