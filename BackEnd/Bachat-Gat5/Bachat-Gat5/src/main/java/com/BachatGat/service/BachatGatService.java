package com.BachatGat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.BachatGat;
import com.BachatGat.dto.GroupLeader;


public interface BachatGatService {
	public void addGat(BachatGat gat, Long leadId);
	void updateGat(BachatGat gat);
	void deleGat(Long id);
}
