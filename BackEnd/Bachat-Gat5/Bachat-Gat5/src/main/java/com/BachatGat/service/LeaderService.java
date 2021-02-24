package com.BachatGat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BachatGat.dto.GroupMember;

import com.BachatGat.dto.GroupLeader;


public interface LeaderService {
	public void addLeader(GroupLeader leader);
	void updateLeader(GroupLeader leader, Long leaderId);
	void deleLeader(Long id);
	List<GroupLeader> getAll();
	public void forgotPass(GroupLeader leader);
	public void commentLeader(GroupLeader leader, Long leaderId);
}
