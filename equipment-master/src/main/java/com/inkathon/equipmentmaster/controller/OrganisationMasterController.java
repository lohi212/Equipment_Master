
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

import com.inkathon.equipmentmaster.dtos.OrganisationMasterDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;
import com.inkathon.equipmentmaster.service.OrganisationMasterService;
import com.inkathon.equipmentmaster.config.ResponseDto;


@RestController
@RequestMapping(value="/organisationMaster")
public class OrganisationMasterController {
	@GetMapping("/get")
	public String get1(){
		return "Get hello";
	}
	@GetMapping("/get2")
	public String get2(){
		return "Hello World";
	}
	
	@Autowired
	OrganisationMasterService organisationMasterService;
	
	
	@PostMapping(value="/saveOrganisationMaster",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto saveOrganisationMaster(@RequestBody OrganisationStageDtoList dtolist){
		return organisationMasterService.saveOrganisationMaster(dtolist);
	}
	
	
	//read all records in master irrespective of flag
	@GetMapping(value="/getOrganisationMaster/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getOrganisationMaster(@PathVariable String  equipmentId) {
		return organisationMasterService.getOrganisationMasterById(equipmentId);


	}

	//read all records in master with respective of flag (written in stagecontroller)
	
	
}
