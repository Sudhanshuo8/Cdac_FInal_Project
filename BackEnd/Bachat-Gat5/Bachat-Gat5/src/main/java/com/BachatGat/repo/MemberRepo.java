package com.BachatGat.repo;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.BachatGat.dto.BachatGat;
import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberRepo {
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
	private MemberRepoInterface memberRep;
    
	public Boolean saveMember(GroupMember member , Long gatId) {
		String query="insert into group_member(member_id,member_number,member_dob,member_name,member_gender,member_mail,gat_id) values(?,?,?,?,?,?,?)";
		
		BachatGat gat = new BachatGat();
		
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setLong(1,member.getMemberId());
                ps.setString(2,member.getMemberContactNumber());
                ps.setString(3,member.getMemberDOB());
                ps.setString(4,member.getMemberName());
                ps.setString(5,member.getMemberGender());
                ps.setString(6,member.getMemberEmail());
                ps.setLong(7,gatId);

                return ps.execute();

            }
        });
		
	}
	
  
	  public List<GroupMember> findAll(Long gatId) {
			
			
			String query="select * from group_member where gat_id= ?"; 
						
	      return   jdbcTemplate.execute(query,new PreparedStatementCallback<List<GroupMember>>()
	      {
	        	
	        	
	            @Override
	            public List<GroupMember> doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {

	            	ps.setLong(1,gatId);
	               
	            	ArrayList<GroupMember> al = new  ArrayList<GroupMember>();

	            	
	            	ResultSet rs = ps.executeQuery();
	            	while(rs.next())
	    			{
	            		GroupMember exp = new GroupMember();	    				
	    				exp.setMemberId(rs.getLong("member_id"));
	    				exp.setMemberContactNumber(rs.getString("member_number"));
	    				exp.setMemberDOB(rs.getString("member_dob"));
	    				exp.setMemberEmail(rs.getString("member_mail"));
	    				exp.setMemberGender(rs.getString("member_gender"));
	    				exp.setMemberName(rs.getString("member_name"));
	    				exp.setRole(rs.getString("roledb"));
	    				
	    				al.add(exp);
	    			}
	            	return al;
	            }
	        });
			
		
//return members;
	
}

	public List<GroupMember> memberAll() {
		String query="select * from group_member"; 
		
	      return   jdbcTemplate.execute(query,new PreparedStatementCallback<List<GroupMember>>()
	      {
	        	
	        	
	            @Override
	            public List<GroupMember> doInPreparedStatement(PreparedStatement ps)
	                    throws SQLException, DataAccessException {
	               
	            	ArrayList<GroupMember> al = new  ArrayList<GroupMember>();

	            	
	            	ResultSet rs = ps.executeQuery();
	            	while(rs.next())
	    			{
	            		GroupMember exp = new GroupMember();
	            		BachatGat gat = new BachatGat();
	    				exp.setMemberId(rs.getLong("member_id"));
	    				exp.setMemberContactNumber(rs.getString("member_number"));
	    				exp.setMemberDOB(rs.getString("member_dob"));
	    				exp.setMemberEmail(rs.getString("member_mail"));
	    				exp.setMemberGender(rs.getString("member_gender"));
	    				exp.setMemberName(rs.getString("member_name"));
	    				exp.setRole(rs.getString("roledb"));
	    				
	    				al.add(exp);
	    			}
	            	return al;
	            }
	        });
	}
	
}



