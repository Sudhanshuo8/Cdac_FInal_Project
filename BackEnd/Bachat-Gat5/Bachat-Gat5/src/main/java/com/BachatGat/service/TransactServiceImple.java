package com.BachatGat.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;

import com.BachatGat.dto.BachatGat;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.Transact;
import com.BachatGat.repo.TransactRepository;


@Service
public class TransactServiceImple implements TransactService {
	
	@Autowired
	private TransactRepository transactRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Boolean addTransaction(GroupMember trans , Long memberId) {
		String query="insert into transaction values(?,?,?,?)";
		
		
        return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {

                ps.setLong(1,memberId);
                ps.setLong(2,trans.getAcc_bal());
                ps.setLong(3,trans.getLoan());

                return ps.execute();

            }
        });
		
	}

	@Override
	public void removeTransaction(Long id) {
		transactRepository.deleteById( id);
		
	}

	@Override
	public GroupMember getTransaction(Long id) {
		Optional<GroupMember> opt=transactRepository.findById(id);
		
		return opt.get();
	}

	@Override
	public void updateTransaction(GroupMember transact , Long memberId) {
		String sql = "update group_member set acc_bal = ?,loan = ? where member_id = ?";
		
		jdbcTemplate.update(sql,transact.getAcc_bal() , transact.getLoan() , memberId);
	}

	@Override
	public List<GroupMember> getAll() {
		Iterable<GroupMember> itr=transactRepository.findAll();
		Iterator<GroupMember> it=itr.iterator();
		List<GroupMember> li=new ArrayList<GroupMember>();
		while(it.hasNext()) {
			li.add(it.next());
		}
		return li;
	}

}
