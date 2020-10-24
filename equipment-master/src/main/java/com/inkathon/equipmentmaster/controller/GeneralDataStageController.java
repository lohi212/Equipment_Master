
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

import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.service.GeneralDataStageService;
import com.inkathon.equipmentmaster.config.ResponseDto;


@RestController
@RequestMapping(value="/generalDataStage")
public class GeneralDataStageController {
	@GetMapping("/get")
	public String get1(){
		return "Get hello";
	}
	@GetMapping("/get2")
	public String get2(){
		return "Hello World";
	}
	
	@Autowired
	GeneralDataStageService generalDataStageService;
	
	   //create or update in stage
	@PostMapping(value="/save",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto saveGeneralDataStage(@RequestBody GeneralDataStageDto dto){
		return generalDataStageService.saveGeneralDataStage(dto);
	}

	//get  record in stage
	@GetMapping(value="/getGeneralDataStage/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getGeneralDataStage(@PathVariable String  equipmentId) {
		return generalDataStageService.getGeneralDataStageById(equipmentId);


	}

	//get record in stage which is not in master
	@GetMapping(value="/viewGeneralDataStage/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto viewGeneralDataStage(@PathVariable String  equipmentId) {
		return generalDataStageService.viewGeneralDataStageById(equipmentId);


	}
	
	//read  record in master with respective of flag as true 
	 @GetMapping(value="/viewGeneralDataMaster/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	 
		public ResponseDto viewGeneralDataMaster(@PathVariable String  equipmentId) {
			return generalDataStageService.viewGeneralDataMaster(equipmentId);


		}


}
