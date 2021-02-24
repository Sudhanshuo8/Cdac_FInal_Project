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
import com.BachatGat.repo.LeaderRepoInterface;
import com.BachatGat.repo.MemberRepoInterface;
@Service
public class LeaderServiceImple implements LeaderService {
	
	@Autowired
	private LeaderRepo leaderRep;
	
	@Autowired
	private LeaderRepoInterface leaderRepItf;

	@Override
	public void addLeader(GroupLeader leader) {
		leaderRep.saveLeader(leader);
	}


	@Override
	public void updateLeader(GroupLeader leader , Long leaderId) {
		leaderRep.modifyLeader(leader , leaderId);
	}


	@Override
	public void deleLeader(Long id) {
		leaderRep.deleteLeader(id);
		
	}
	
	@Override
	public List<GroupLeader> getAll() {
		Iterable<GroupLeader> itr = leaderRepItf.findAll();
		Iterator<GroupLeader> it = itr.iterator();
		List<GroupLeader> li = new ArrayList<GroupLeader>();
		while(it.hasNext()) {
			li.add(it.next()); 
		}
		return li;
	}


	@Override
	public void forgotPass(GroupLeader leader) {
		leaderRep.UpdatePass(leader);
		
	}


	@Override
	public void commentLeader(GroupLeader leader, Long leaderId) {
		leaderRep.CommentLead(leader,leaderId);
		
	}


}
