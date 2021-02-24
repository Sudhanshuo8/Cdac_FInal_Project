package com.BachatGat.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "prodId")
public class Product{
	@Id
	@Column(name = "prod_id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long prodId=(long) 0;
	@Column(name = "prod_name")
	private String prodName;
	
	@Column(name = "prod_quantity")
	private String prodQuantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gat_id", nullable = false)
	private BachatGat gat;

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(String prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
