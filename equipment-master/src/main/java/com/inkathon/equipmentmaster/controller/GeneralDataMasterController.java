

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

import com.inkathon.equipmentmaster.dtos.GeneralDataMasterDto;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.service.GeneralDataMasterService;
import com.inkathon.equipmentmaster.config.ResponseDto;


@RestController
@RequestMapping(value="/generalDataMaster")
public class GeneralDataMasterController {
	@GetMapping("/get")
	public String get1(){
		return "Get hello";
	}
	@GetMapping("/get2")
	public String get2(){
		return "Hello World";
	}
	
	@Autowired
	GeneralDataMasterService generalDataMasterService;
	
	//create or update in master
	@PostMapping(value="/saveGeneralDataMaster",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto saveGeneralDataMaster(@RequestBody GeneralDataStageDto dto){
		return generalDataMasterService.saveGeneralDataMaster(dto);
	}
	
	//read  record in master irrespective of flag
	@GetMapping(value="/getGeneralDataMaster/{equipmentId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getGeneralDataMaster(@PathVariable String  equipmentId) {
		return generalDataMasterService.getGeneralDataMasterById(equipmentId);


	}
	//read  record in master with respective of flag (written in generalDataStageController)

		

}
