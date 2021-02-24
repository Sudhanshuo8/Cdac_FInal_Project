package com.BachatGat.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BachatGat.dto.BachatGat;
import com.BachatGat.dto.GroupLeader;
import com.BachatGat.dto.GroupMember;
import com.BachatGat.repo.LeaderRepo;
import com.BachatGat.service.BachatGatService;
import com.BachatGat.service.LeaderService;
import com.BachatGat.service.MemberService;
@RestController
@CrossOrigin(origins = "*")
public class BachatGatController {
	
	@Autowired
	private BachatGatService gatServ;
	

	

	
	@PostMapping(value = "add_gat/{leadId}")
	public String leaderAdd(@RequestBody BachatGat gat , @PathVariable Long leadId) {
		gatServ.addGat(gat,leadId);
		return "success"+gat.getGatId();
	}
	

	
	

}
