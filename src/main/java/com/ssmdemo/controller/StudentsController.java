package com.ssmdemo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssmdemo.domain.Students;
import com.ssmdemo.service.IStudentsService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	
	private Logger log = Logger.getLogger(StudentsController.class);
	@Autowired
	private IStudentsService studentsService;
	
	//RESTful风格,注意注解@PathVariable的使用
	@RequestMapping("/{sid}")
	public String getStudentById(@PathVariable("sid") String sid,HttpServletRequest request,Model model){
		log.info("request studentid is" + sid);
		Students student = null;
		student = studentsService.getStudentById(sid);
		//Map<String,String> map = new HashMap<String,String>();
		//map.put("name", student.getName());
		//map.put("age", student.getAge());
		model.addAttribute("student",student);
		return "student_demo";
	}
	
	@RequestMapping(value="/upload")
	public String fileUpload(){
		return "fileupload_demo";
	}
	
	//@RequestParam参数绑定，将页面上传参数绑定方法接口参数
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile file){
		try{
			if(!file.isEmpty()){
				log.info("正在处理上传文件："+file.getName());
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File("d:\\temp\\uploadImgDemo",file.getName()));
				return "fileupload_success_demo";
			}
		}catch(Exception e){
			log.info(e.getMessage());
		}
		return "fileupload_success_demo";
	}
}
