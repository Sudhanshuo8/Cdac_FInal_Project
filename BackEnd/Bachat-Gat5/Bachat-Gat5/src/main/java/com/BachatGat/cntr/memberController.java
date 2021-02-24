package com.BachatGat.cntr;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.repo.LeaderRepo;
import com.BachatGat.service.LeaderService;
import com.BachatGat.service.MemberService;
@RestController
@CrossOrigin(origins = "*")
public class memberController {
	
	@Autowired
	private MemberService membeServ;
	

	

	
	@PostMapping(value = "add_member/{gatId}")
	public String leaderAdd(@Valid @RequestBody GroupMember member , @PathVariable Long gatId) {
		membeServ.addMember(member , gatId);
		return "success";
	}
	
	@DeleteMapping(value ="remove_member/{id}")
	public String memberRemove(@PathVariable Long id)
	{
		membeServ.delMember(id);
		return "success";
		
	}
	
	@PutMapping(value = "update_member")
	public String memberUpdate(@RequestBody GroupMember member) {
		membeServ.modifyMember(member);
		return "success";
	}
	

	@GetMapping(value = "member_list/{gatId}")
	public List<GroupMember> memberList(@PathVariable Long gatId){
		return membeServ.findAll(gatId);
	}
	
	@GetMapping(value = "member_list")
	public List<GroupMember> memberList(){
		return membeServ.findAll();
	}
	
	@GetMapping(value = "members")
	public List<GroupMember> membersList(){
		return membeServ.Allmembers();
	}
	


	
	

}
