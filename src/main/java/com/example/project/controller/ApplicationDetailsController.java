package com.example.project.controller;


import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.project.services.ApplicationDetailsService;
import com.example.project.models.Application_details;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ApplicationDetailsController {
	
	@Autowired
	ApplicationDetailsService appSer;
	
	
	@GetMapping("/appDetails")
	public Optional<Application_details> getAppDet(@RequestParam(value="id" , required= true) int id){
		return appSer.getAppDetails(id);
	}
	
	@PutMapping("/appDetails")
	public String puttAppDet(@RequestBody Application_details appDet, @RequestParam(value="id" ,required= true) int id) {
		return appSer.putAppDetails(appDet, id);
	}
	
	@PostMapping("/appDetails")
	public int postAppDet(@RequestBody Application_details appDet) {
		return appSer.postAppDetails(appDet);
	}
	
	@DeleteMapping("/appDetails")
	public String deleteAppDet(@RequestParam(value="id", required = true) int id) {
		return appSer.deleteAppDetails(id);
	}
	
	  @PostMapping("/uploadFile")
		public int uploadFile(@RequestParam("file") MultipartFile multipartFile,@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("postalAddress") String postalAddress,@RequestParam("collegeName") String collegeName,@RequestParam("state") String state,@RequestParam("className") String className, @RequestParam("studentId") int studentId) throws IOException{
		  return appSer.uploadFile(multipartFile, firstName,lastName,postalAddress,collegeName,state,className,studentId );
		  
		  
	  }
}
