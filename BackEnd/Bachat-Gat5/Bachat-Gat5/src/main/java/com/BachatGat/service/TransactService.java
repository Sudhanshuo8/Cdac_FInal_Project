package com.BachatGat.service;

import java.util.List;

import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.Transact;



public interface TransactService {
	
	
	//public void addTransaction(Transact transact, Long memberId);
		
	public List<GroupMember> getAll();
	void updateTransaction(GroupMember transact, Long memberId);
	void removeTransaction(Long id);
	GroupMember getTransaction(Long id);
}
