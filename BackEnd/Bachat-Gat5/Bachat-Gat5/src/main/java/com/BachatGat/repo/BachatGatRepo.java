package com.BachatGat.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.BachatGat.dto.BachatGat;
import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class BachatGatRepo {
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    
   
	public Boolean saveGat(BachatGat gat , Long id) {
		String query="insert into bachat_gat(gat_id,bachagat_name,member_count,leader_id) values(?,?,?,?)";
		
		GroupLeader leader = new GroupLeader();
		
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setLong(1,gat.getGatId());
                ps.setString(2,gat.getBachatgatName());
                ps.setLong(3,gat.getMemberCount());
                ps.setLong(4,id);

                return ps.execute();

            }
        });
		
	}
    
	/*public void modifyLeader(GroupLeader leader) {
		leaderRep.save(leader);
		
	}
	
	public void deleteLeader(Long id) {
		leaderRep.deleteById(id);
		
	}*/


}
