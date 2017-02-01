package com.ssmdemo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssmdemo.dao.StudentsMapper;
import com.ssmdemo.domain.Students;
import com.ssmdemo.service.IStudentsService;

@Service
public class StudentsServiceImpl implements IStudentsService {

	@Autowired
	private StudentsMapper studentsMapper;
	
	public Students getStudentById(String id) {
		// TODO Auto-generated method stub
		return studentsMapper.selectByPrimaryKey(id);
	}

}
