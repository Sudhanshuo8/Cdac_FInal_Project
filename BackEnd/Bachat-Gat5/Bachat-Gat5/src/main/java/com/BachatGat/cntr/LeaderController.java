package com.BachatGat.cntr;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.repo.LeaderRepo;
import com.BachatGat.service.LeaderService;

@RestController
@CrossOrigin(origins = "*")
public class LeaderController {
	
	@Autowired
	private LeaderService leadServ;
	

	@PostMapping(value = "add_leader")
	public String leaderAdd(@Valid @RequestBody GroupLeader leader) {
		leadServ.addLeader(leader);
		return "success";
	}
	
	@DeleteMapping(value ="remove_leader/{id}")
	public String leaderRemove(@PathVariable Long id)
	{
		leadServ.deleLeader(id);
		return "success";
		
	}
	
	@PutMapping(value = "update_leader/{leaderId}")
	public String leaderUpdate(@RequestBody GroupLeader leader , @PathVariable Long leaderId) {
		leadServ.updateLeader(leader , leaderId);
		return "success";
	}
	
	@PutMapping(value = "leader_comment/{leaderId}")
	public String leaderComment(@RequestBody GroupLeader leader , @PathVariable Long leaderId) {
		leadServ.commentLeader(leader , leaderId);
		return "success";
	}
	
	@PostMapping(value = "forget_password")
	public ResponseEntity<String> leaderPassword(@RequestBody GroupLeader leader) {
		leadServ.forgotPass(leader);
		return new ResponseEntity<>("Success",HttpStatus.OK);
	}
	
	@GetMapping(value = "leader_list")
	public List<GroupLeader> leaderList(){
		return leadServ.getAll();
	}

	
	

}
