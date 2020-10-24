
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

import com.inkathon.equipmentmaster.dtos.LocationMasterDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;
import com.inkathon.equipmentmaster.service.LocationMasterService;
import com.inkathon.equipmentmaster.config.ResponseDto;


@RestController
@RequestMapping(value="/locationMaster")
public class LocationMasterController {
	@GetMapping("/get")
	public String get1(){
		return "Get hello";
	}
	@GetMapping("/get2")
	public String get2(){
		return "Hello World";
	}
	
	@Autowired
	LocationMasterService locationMasterService;
	
	@PostMapping(value="/saveLocationMaster",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto saveLocationMaster(@RequestBody LocationStageDtoList dtolist){
		return locationMasterService.saveLocationMaster(dtolist);
	}

	//read  records in master irrespective of flag

	@GetMapping(value="/getLocationMaster/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getLocationMaster(@PathVariable String  equipmentId) {
		return locationMasterService.getLocationMasterById(equipmentId);


	}
	//read all records in master with respective of flag (written in stagecontroller)

	
}
