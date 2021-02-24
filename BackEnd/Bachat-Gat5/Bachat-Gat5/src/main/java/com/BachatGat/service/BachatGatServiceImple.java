package com.BachatGat.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BachatGat.dto.BachatGat;
import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.repo.BachatGatRepo;
import com.BachatGat.repo.LeaderRepo;
import com.BachatGat.repo.MemberRepo;
@Service
public class BachatGatServiceImple implements BachatGatService {
	
	@Autowired
	private BachatGatRepo gatRep;


	@Override
	public void updateGat(BachatGat gat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleGat(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGat(BachatGat gat, Long leadId) {
		// TODO Auto-generated method stub
		gatRep.saveGat(gat, leadId);
		
	}

	



}
