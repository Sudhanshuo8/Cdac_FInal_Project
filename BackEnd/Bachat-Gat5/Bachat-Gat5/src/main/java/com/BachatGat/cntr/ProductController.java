package com.BachatGat.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.Product;
import com.BachatGat.repo.LeaderRepo;
import com.BachatGat.service.LeaderService;
import com.BachatGat.service.MemberService;
import com.BachatGat.service.ProductService;
@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	private ProductService prodServ;
	

	

	
	@PostMapping(value = "add_product/{gatId}")
	public String leaderAdd(@RequestBody Product product , @PathVariable Long gatId) {
		prodServ.addProduct(product , gatId);
		return "success";
	}
	


	@GetMapping(value = "product_list/{gatId}")
	public List<Product> memberList(@PathVariable Long gatId){
		return prodServ.findAll(gatId);
	}
	


	
	

}
