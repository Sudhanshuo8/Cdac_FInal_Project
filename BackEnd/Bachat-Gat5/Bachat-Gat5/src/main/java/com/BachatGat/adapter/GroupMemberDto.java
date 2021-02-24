package com.BachatGat.adapter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.BachatGat.dto.BachatGat;

public class GroupMemberDto {
	@Id
	@Column(name = "member_id")
	private Long memberId;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_DOB")
	private String memberDOB;
	
	@Column(name = "member_Gender")
	private String memberGender;
	
	@Column(name = "member_mail")
	private String memberEmail;
	
	@Column(name = "member_number")
	private String memberContactNumber;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gat_id", nullable = false)
	private BachatGat gat;
	

}
