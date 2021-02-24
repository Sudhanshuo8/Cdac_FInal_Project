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

import com.BachatGat.dto.GroupMember;
import com.BachatGat.dto.Transact;
import com.BachatGat.service.TransactService;
import com.BachatGat.service.TransactServiceImple;


@CrossOrigin(origins="*")

@RestController
public class TransactController {

	@Autowired
	private TransactService tranService;
	
	@Autowired
	private TransactServiceImple tranServiceImple;
	
	
		
		@GetMapping(value="trans_list")
		public List<GroupMember> transactList(){
			return tranService.getAll();
		}
		
		@DeleteMapping(value="trans_del/{id}")
		public String transDelete(@PathVariable Long id) {
			tranService.removeTransaction(id);
			return "Transaction deleted successfully";
		}
		
		@GetMapping(value="trans_get/{id}")
		public GroupMember getTransact(@PathVariable Long id) {
			return tranService.getTransaction(id);
		}
		
		@PutMapping(value="trans_update/{memberId}")
		public String transUpdate(@RequestBody GroupMember transact , @PathVariable Long memberId) {
			tranService.updateTransaction(transact,memberId);
			return "Transaction updated successfully";
		}
		
		
		
}
