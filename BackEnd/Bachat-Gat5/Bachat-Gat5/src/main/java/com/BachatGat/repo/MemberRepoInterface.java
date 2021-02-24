package com.BachatGat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;

public interface MemberRepoInterface extends JpaRepository<GroupMember, Long> {

	
}