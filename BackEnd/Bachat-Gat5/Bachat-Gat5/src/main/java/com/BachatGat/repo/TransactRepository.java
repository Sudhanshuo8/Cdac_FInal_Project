package com.BachatGat.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.Transact;


@Repository
public interface TransactRepository extends CrudRepository<GroupMember, Long>{

}
