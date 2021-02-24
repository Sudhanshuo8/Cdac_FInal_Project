package com.BachatGat.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.BachatGat.dto.GroupLeader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class LeaderRepo {
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
	private LeaderRepoInterface leaderRep;
    
	public void saveLeader(GroupLeader leader) {
		leaderRep.save(leader);
	}
    
	public void modifyLeader(GroupLeader leader, Long leaderId) {
		String sql = "update group_leader set leader_flag = true where leader_id = ?";
		
		jdbcTemplate.update(sql,leaderId);
		
	}
	
	public void deleteLeader(Long id) {
		leaderRep.deleteById(id);
		
	}

	public void UpdatePass(GroupLeader leader) {
String sql = "update group_leader set leader_pass = ? where leader_mail = ?";
		
		jdbcTemplate.update(sql,leader.getLeaderPassword(),leader.getLeaderEmail());
		
	}

	public void CommentLead(GroupLeader leader, Long leaderId) {
		String sql = "update group_leader set leader_comment = 'rejected' where leader_id = ?";
		
		jdbcTemplate.update(sql,leaderId);
		
	}


}
