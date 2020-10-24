
package com.inkathon.equipmentmaster.controller;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;
import com.inkathon.equipmentmaster.service.LocationStageService;
import com.inkathon.equipmentmaster.config.ResponseDto;


@RestController
@RequestMapping(value="/locationStage")
public class LocationStageController {
	@GetMapping("/get")
	public String get1(){
		return "Get hello";
	}
	@GetMapping("/get2")
	public String get2(){
		return "Hello World";
	}
	
	@Autowired
	LocationStageService locationStageService;
	
	//get all records in stage
	@GetMapping(value="/getLocationStage/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getLocationStage(@PathVariable String  equipmentId) {
		return locationStageService.getLocationStageById(equipmentId);


	}

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto saveLocationStage(@RequestBody LocationStageDtoList dto){
		return locationStageService.saveLocationStage(dto);
	}
	
	
	//get records in stage which are not in master
	@GetMapping(value="/viewLocationStage/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto viewLocationStage(@PathVariable String  equipmentId) {
		return locationStageService.viewLocationStageById(equipmentId);


	}
	
	
	//read all records in master with respective of flag as true 
	@GetMapping(value="/viewLocationMaster/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto viewLocationMaster(@PathVariable String  equipmentId) {
		return locationStageService.viewLocationMaster(equipmentId);


	}


}
