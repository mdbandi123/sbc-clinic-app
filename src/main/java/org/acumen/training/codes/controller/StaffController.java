package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.model.Staff;
import org.acumen.training.codes.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
@CrossOrigin
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping("insert")
	public boolean insertStaff(@RequestBody Staff staff){
		return staffService.insertStaff(staff);
	}
	
	@PatchMapping("/update/{id}")
	public boolean updateStaff(@PathVariable Integer id, @RequestBody Staff staff) {
		return staffService.updateStaff(id, staff);
	}
	
	@GetMapping("/details/list/all")
	public List<Staff> getAllStaff(){
		return staffService.getAllStaff();
	}
}
