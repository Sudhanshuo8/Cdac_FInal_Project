package com.BachatGat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.Product;
import com.BachatGat.dto.GroupLeader;


public interface ProductService {
	void addProduct(Product product, Long gatId);

	List<Product> findAll(Long gatId);
}
