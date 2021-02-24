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
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Group_Leader")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "leaderId")
public class GroupLeader {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "leader_id" , nullable = false)
	private Long leaderId;
	
	@Column(name = "leader_name")
	private String leaderName;
	
	@Column(name = "leader_pass")
	private String leaderPassword;
	
	@Column(name = "leader_mail")
	@Email
	private String leaderEmail;
	
	@Column(name = "leader_number")
	private String leaderContactNumber;
	
	@Column(name = "roleDB", nullable = false)
	private String role = "leader";
	
	@Column(name = "leader_flag", nullable = false)
	private Long Leaderflag = (long) 0;
	
	
	
   


	public Long getLeaderflag() {
		return Leaderflag;
	}




	public void setLeaderflag(Long leaderflag) {
		Leaderflag = leaderflag;
	}

	@OneToOne(mappedBy = "leader", fetch = FetchType.LAZY)
	@JoinColumn(name = "gat_id")
	private BachatGat gat;

		public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}


	
	public GroupLeader() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public GroupLeader(Long leaderId, String leaderName, String leaderPassword, String leaderEmail,
			String leaderContactNumber, List<GroupMember> members, BachatGat gat) {
		super();
		this.leaderId = leaderId;
		this.leaderName = leaderName;
		this.leaderPassword = leaderPassword;
		this.leaderEmail = leaderEmail;
		this.leaderContactNumber = leaderContactNumber;
		this.gat = gat;
	}


	public BachatGat getGat() {
		return gat;
	}




	public void setGat(BachatGat gat) {
		this.gat = gat;
	}




	public Long getLeaderId() {
		return leaderId;
	}



	public void setLeaderId(Long leaderId) {
		this.leaderId = leaderId;
	}



	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	
	public String getLeaderPassword() {
		return leaderPassword;
	}

	public void setLeaderPassword(String leaderPassword) {
		this.leaderPassword = leaderPassword;
	}

	public String getLeaderEmail() {
		return leaderEmail;
	}

	public void setLeaderEmail(String leaderEmail) {
		this.leaderEmail = leaderEmail;
	}


	public String getLeaderContactNumber() {
		return leaderContactNumber;
	}

	public void setLeaderContactNumber(String leaderContactNumber) {
		this.leaderContactNumber = leaderContactNumber;
	}

	/*public List<GroupMember> getMembers() {
		//return members;
	}

	public void setMembers(List<GroupMember> members) {
		//this.members = members;
	}*/

	
}
