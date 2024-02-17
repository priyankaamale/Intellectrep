package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;
import com.example.demo.servicei.Employeeservicei;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Employeecontroller {
	@Autowired
	private Employeeservicei ei;
	
	
	@PostMapping(value = "/savedata" ,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity savedata(@RequestPart(value = "adharCard") MultipartFile adharCard,
			@RequestPart(value = "panCard") MultipartFile panCard,
			@RequestPart(value = "photo") MultipartFile photo,
			@RequestPart(value = "marksheet") MultipartFile marksheet) throws IOException
	{
		Employee emp=new Employee();
		emp.setAdharCard(adharCard.getBytes());
		emp.setPanCard(panCard.getBytes());
		emp.setPhoto(photo.getBytes());
		emp.setMarksheet(marksheet.getBytes());
	
	ei.savedata(emp);
	return  new ResponseEntity (HttpStatus.CREATED);
	
	
		
	}
	@DeleteMapping("/deletedata/{id}")
	public void deletedata(@PathVariable int id)
	{
		ei.deletedata(id);
	}

}
