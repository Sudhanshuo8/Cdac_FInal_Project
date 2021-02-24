package com.BachatGat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.BachatGat.dto.GroupLeader;

public interface LeaderRepoInterface extends JpaRepository<GroupLeader, Long> {

}