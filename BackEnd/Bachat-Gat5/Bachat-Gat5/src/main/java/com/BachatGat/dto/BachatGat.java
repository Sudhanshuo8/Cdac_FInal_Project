package com.BachatGat.dto;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Bachat_gat")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "gatId")
public class BachatGat {
	@Id
	@Column(name = "gat_id" , nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gatId=(long) 0;
	
	@Column(name = "bachagat_name")
	private String bachatgatName;
	
	@Column(name = "member_count")
	private Long memberCount;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "leader_id")
	private GroupLeader leader;
	
	  /* @OneToMany(
	            fetch = FetchType.LAZY,
	            mappedBy = "gat")
	private List<GroupMember> members;*/
	   
	   @OneToMany(
	            fetch = FetchType.LAZY,
	            mappedBy = "gat")
	private List<Product> products;
	
	public BachatGat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BachatGat(Long gatId, String bachatgatName, Long memberCount, GroupLeader leader,
			List<GroupMember> members) {
		super();
		this.gatId = gatId;
		this.bachatgatName = bachatgatName;
		this.memberCount = memberCount;
		this.leader = leader;
		//this.members = members;
	}

	public Long getGatId() {
		return gatId;
	}

	public void setGatId(Long gatId) {
		this.gatId = gatId;
	}

	public String getBachatgatName() {
		return bachatgatName;
	}

	public void setBachatgatName(String bachatgatName) {
		this.bachatgatName = bachatgatName;
	}

	public Long getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Long memberCount) {
		this.memberCount = memberCount;
	}

	public GroupLeader getLeader() {
		return leader;
	}

	public void setLeader(GroupLeader leader) {
		this.leader = leader;
	}

	/*public List<GroupMember> getMembers() {
		return members;
	}

	public void setMembers(List<GroupMember> members) {
		this.members = members;
	}*/
	
	
}
