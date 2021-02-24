package com.BachatGat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BachatGat.dto.GroupMember;

import com.BachatGat.dto.GroupLeader;


public interface MemberService {
	public void addMember(GroupMember member, Long gatId);
	public void delMember(Long id);
	public void modifyMember(GroupMember member);
	public List<GroupMember> findAll(Long gatId);
	//List<GroupMember> getAll();
	public List<GroupMember> findAll();
	public List<GroupMember> Allmembers();
}
