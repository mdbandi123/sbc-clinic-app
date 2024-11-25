package org.acumen.training.codes.service;

import java.util.List;

import org.acumen.training.codes.dao.StaffDao;
import org.acumen.training.codes.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

	@Autowired 
	private StaffDao staffDao;
	
	public boolean insertStaff(Staff staff){
		return staffDao.insertStaff(staff);
	}
	

	public boolean updateStaff(Integer id, Staff staff) {
		return staffDao.updateStaff(id, staff);
	}
	
	public List<Staff> getAllStaff(){
		return staffDao.getAllStaff();
	}
	
	
}
