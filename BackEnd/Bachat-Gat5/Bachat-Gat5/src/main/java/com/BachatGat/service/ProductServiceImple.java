package com.BachatGat.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.Product;
import com.BachatGat.repo.LeaderRepo;
import com.BachatGat.repo.MemberRepo;
import com.BachatGat.repo.MemberRepoInterface;
import com.BachatGat.repo.ProductRepo;
@Service
public class ProductServiceImple implements ProductService {
	
	@Autowired
	private ProductRepo prodRep;
	

	@Override
	public void addProduct(Product product, Long gatId) {
		// TODO Auto-generated method stub
		prodRep.saveProduct(product, gatId);
		
	}

	@Override
	public List<Product> findAll(Long gatId) {
		
		return prodRep.findAll(gatId);
	}


}
