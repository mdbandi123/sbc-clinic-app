package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.List;

import org.acumen.training.codes.model.Staff;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


@Repository
public class StaffDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	public boolean insertStaff(Staff staff){
		try {
			em.persist(staff);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public boolean updateStaff(Integer id, Staff newStaffDetails) {
		try {
			Staff staff = em.find(Staff.class, id);
			
			staff.setName(newStaffDetails.getName());
			staff.setIcNo(newStaffDetails.getIcNo());
			staff.setGender(newStaffDetails.getGender());
			staff.setAddress(newStaffDetails.getAddress());
			staff.setContactNo(newStaffDetails.getContactNo());
			staff.setPosition(newStaffDetails.getPosition());
			staff.setProfileImage(newStaffDetails.getProfileImage());
			
			em.merge(staff);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Transactional
	public List<Staff> getAllStaff() {
		List<Staff> records = new ArrayList<>();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Staff> sql = cb.createQuery(Staff.class);
		Root<Staff> root = sql.from(Staff.class);
		
		sql.select(root);
		
		TypedQuery<Staff> query = em.createQuery(sql);
		records = query.getResultList();
		
		return records;
	}
}
