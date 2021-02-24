package com.BachatGat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BachatGat.dto.GroupLeader;

public interface BachatGatRepoInterface extends JpaRepository<GroupLeader, Long> {

}