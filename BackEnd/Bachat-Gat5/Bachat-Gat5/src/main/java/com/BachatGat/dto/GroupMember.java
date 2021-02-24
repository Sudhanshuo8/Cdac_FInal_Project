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
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Group_Member")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "memberId")
public class GroupMember{
	@Id
	@Column(name = "member_id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId=(long) 0;
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_pass")
	private String memberPass;
	
	@Column(name = "member_DOB")
	private String memberDOB;
	
	@Column(name = "member_Gender")
	private String memberGender;
	
	@Email
	@Column(name = "member_mail")
	private String memberEmail;
	
	@Column(name = "member_number")
	private String memberContactNumber;
	
	@Column(name = "roleDB",columnDefinition = "varchar(25) default 'member'")
	private String role;
	
	@Column(columnDefinition = "int default 1000")
	private Long acc_bal=(long) 1000;
	
	@Column(columnDefinition = "int default 0")
	private Long loan=(long) 0;
	

	
	
	/*@OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
	@JoinColumn(name = "mem_id")
	private Transact trans*/;
	
    public Long getAcc_bal() {
		return acc_bal;
	}





	public void setAcc_bal(Long acc_bal) {
		this.acc_bal = acc_bal;
	}





	public Long getLoan() {
		return loan;
	}





	public void setLoan(Long loan) {
		this.loan = loan;
	}





	public String getMemberPass() {
		return memberPass;
	}





	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}





	public String getRole() {
		return role;
	}





	public void setRole(String role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gat_id", nullable = false)
	private BachatGat gat;
	

	public GroupMember() {
		super();
		// TODO Auto-generated constructor stub
	}

	



	public GroupMember(Long memberId, String memberName, String memberDOB, String memberGender, String memberEmail,
			String memberContactNumber, BachatGat gat) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberDOB = memberDOB;
		this.memberGender = memberGender;
		this.memberEmail = memberEmail;
		this.memberContactNumber = memberContactNumber;
		this.gat = gat;
	}





	public Long getMemberId() {
		return memberId;
	}



	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}



	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberDOB() {
		return memberDOB;
	}

	public void setMemberDOB(String memberDOB) {
		this.memberDOB = memberDOB;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberContactNumber() {
		return memberContactNumber;
	}

	public void setMemberContactNumber(String memberContactNumber) {
		this.memberContactNumber = memberContactNumber;
	}

	public BachatGat getGat() {
		return gat;
	}

	public void setGat(BachatGat gat) {
		this.gat = gat;
	}


	
		
	
}
