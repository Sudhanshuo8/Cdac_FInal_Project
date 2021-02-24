package com.BachatGat.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mem_id;
	private int acc_bal=1000;
	private int loan=0;
	
	/*@OneToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "member_id")
	private GroupMember member;*/
	
	
	/*public GroupMember getMember() {
		return member;
	}
	public void setMember(GroupMember member) {
		this.member = member;
	}*/
	public int getLoan() {
		return loan;
	}
	public void setLoan(int loan) {
		this.loan = loan;
	}
	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public int getAcc_bal() {
		return acc_bal;
	}
	public void setAcc_bal(int acc_bal) {
		this.acc_bal = acc_bal;
	}
	
	public Transact() {
		super();
		// TODO Auto-generated constructor stub
	}
}
