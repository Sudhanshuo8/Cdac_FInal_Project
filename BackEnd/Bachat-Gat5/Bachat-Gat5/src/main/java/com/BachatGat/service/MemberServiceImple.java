package com.BachatGat.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.repo.LeaderRepo;
import com.BachatGat.repo.MemberRepo;
import com.BachatGat.repo.MemberRepoInterface;
@Service
public class MemberServiceImple implements MemberService {
	
	@Autowired
	private MemberRepo memerRep;
	
	@Autowired
	private MemberRepoInterface memerRepItf;



	@Override
	public void addMember(GroupMember member, Long gatId) {
		// TODO Auto-generated method stub
		memerRep.saveMember(member, gatId);
		
	}

	@Override
	public void modifyMember(GroupMember member) {
		memerRepItf.save(member);
		
	}

	@Override
	public void delMember(Long id) {
		memerRepItf.deleteById(id);
		
	}

	@Override
	public List<GroupMember> findAll(Long gatId) {
		
		return memerRep.findAll(gatId);
	}

	@Override
	public List<GroupMember> findAll() {
		Iterable<GroupMember> itr = memerRepItf.findAll();
		Iterator<GroupMember> it = itr.iterator();
		List<GroupMember> li = new ArrayList<GroupMember>();
		while(it.hasNext()) {
			li.add(it.next()); 
		}
		return li;
	}

	@Override
	public List<GroupMember> Allmembers() {
		// TODO Auto-generated method stub
		return memerRep.memberAll();
	}


	



}
