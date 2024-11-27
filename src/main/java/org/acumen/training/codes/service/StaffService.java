package org.acumen.training.codes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.acumen.training.codes.dao.StaffDao;
import org.acumen.training.codes.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

	@Autowired
	private StaffDao staffDao;

	public boolean insertStaff(Staff staff) {
		staff.setRegistrationTime(LocalDateTime.now());
		return staffDao.insertStaff(staff);
	}

	public boolean updateStaff(Integer id, Staff staff) {
		return staffDao.updateStaff(id, staff);
	}

	public List<Staff> getAllStaff() {
		return staffDao.getAllStaff();
	}

	public List<Staff> getStaffById(Integer id) {
		return staffDao.getStaffById(id);
	}

	public List<Staff> getStaffByIcNo(String icno) {
		return staffDao.getStaffByIcNo(icno);
	}

	public List<Staff> getStaffByName(String name) {
		return staffDao.getStaffByName(name);
	}

}
