
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

import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;
import com.inkathon.equipmentmaster.service.OrganisationStageService;
import com.inkathon.equipmentmaster.config.ResponseDto;


@RestController
@RequestMapping(value="/organisationStage")
public class OrganisationStageController {
	@GetMapping("/get")
	public String get1(){
		return "Get hello";
	}
	@GetMapping("/get2")
	public String get2(){
		return "Hello World";
	}
	
	@Autowired
	OrganisationStageService organisationStageService;
	
	//get all records in stage
	@GetMapping(value="/getOrganisationStage/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getGeneralDataStage(@PathVariable String  equipmentId) {
		return organisationStageService.getOrganisationStageById(equipmentId);


	}

	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto saveOrganisationStage(@RequestBody OrganisationStageDtoList dtolist){
		return organisationStageService.saveOrganisationStage(dtolist);
	}
	
	//get records in stage which are not in master
	@GetMapping(value="/viewOrganisationStage/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto viewGeneralDataStage(@PathVariable String  equipmentId) {
		return organisationStageService.viewOrganisationStageById(equipmentId);


	}
	
	//read all records in master with respective of flag as true
	@GetMapping(value="/viewOrganisationMaster/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto viewOrganisationMaster(@PathVariable String  equipmentId) {
		return organisationStageService.viewOrganisationMaster(equipmentId);


	}


}
