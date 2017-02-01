package com.ssmdemo.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ssmdemo.domain.Students;
import com.ssmdemo.service.IStudentsService;

//表示继承了SpringJUnit4ClassRunner类
@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:applicationContext.xml"})

public class StudentsTest {
	
	//日志
	private static Logger logger = Logger.getLogger(StudentsTest.class);
	@Autowired
	private IStudentsService studentsService;
	
	@Test
	public void testGetStudentById(){
		String id = "001";
		Students student = studentsService.getStudentById(id);
		//注意logger如何打印对象信息，是转化为json字符串进行展示
		logger.info(JSON.toJSONString(student));
	}
}
