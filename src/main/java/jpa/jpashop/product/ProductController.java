package jpa.jpashop.product;

import java.util.ArrayList;
import java.util.List;
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

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductQueryRepository productQueryRepository;
	
	@GetMapping("/selectAll")
	public Page<Product> selectProductAll() {
		Page<Product> plist;
		plist = productRepository.findAll(PageRequest.of(0, 5, Sort.by(Direction.DESC, "prdtId")));
		
		return plist;
	}
	
	@GetMapping("/selectPrdtPage")
	public Page<Product> selectPrdtPage(/* @RequestParam Map<String,Object> param, */
			@RequestParam(name="perPage", defaultValue="5", required=true) int perPage,
			@RequestParam(name="page", defaultValue="1", required=true) int page) {
//		logger.info("" + param);
//		logger.info("page="+ param.get("page"));
//		logger.info("perPage="+ param.get("perPage"));
		Page<Product> plist;
		plist = productRepository.findAll(PageRequest.of(page-1, 5, Sort.by(Direction.DESC, "prdtId")));
		return plist;
	}
	
	@GetMapping("/searchProduct")
	public List<Product> searchProduct(@RequestParam(name="prdtname", required=true) String prdtname) {
		List<Product> plist = new ArrayList<Product>();
		plist = productQueryRepository.searchProduct(prdtname);
		logger.info(""+ plist);
		return plist;
	}
	
	@PostMapping("/insert")
	public String insertProduct(Product product) {
		productRepository.save(product);
		return "0";
	} 
	
	
}
