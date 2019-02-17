package com.doc.DockerDemo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doc.DockerDemo.Entity.User;
import com.doc.DockerDemo.model.ResponseModel;

@RestController
public class DockerController {
	
	@RequestMapping(value="/name",method=RequestMethod.GET)
	public String getMyName() {
		
		return "Hello Pramodya Thushan";
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String getTestMethod() {
		return "Test Method";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateTestMethod() {
		return "get method";
	}
	
	@RequestMapping(value="/user-info",method=RequestMethod.POST)
	public ResponseEntity<?> afterMethod(@RequestBody User reqUser){
		
		User user = new User();
		user.setName(reqUser.getName());
		user.setAddress(reqUser.getAddress());
		user.setMail(reqUser.getMail());
		user.setBirthday(reqUser.getBirthday());
		user.setSex(reqUser.getSex());
		
		if(user.getName()!=null) {
			return new ResponseEntity<Object>(new ResponseModel(200,"User info", user),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(new ResponseModel(400,"User name is null.Please Check your user name", null),HttpStatus.BAD_REQUEST);
		}
		
		
		
	}

}
