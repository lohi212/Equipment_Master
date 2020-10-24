
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

import com.inkathon.equipmentmaster.dtos.EquipmentMasterDto;
import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;
import com.inkathon.equipmentmaster.service.EquipmentMasterService;
import com.inkathon.equipmentmaster.config.ResponseDto;


@RestController
@RequestMapping(value="/equipmentMaster")
public class EquipmentMasterController {
	@GetMapping("/get")
	public String get1(){
		return "Get hello";
	}
	@GetMapping("/get2")
	public String get2(){
		return "Hello World";
	}
	
	@Autowired
	EquipmentMasterService equipmentMasterService;
	
	//create or update master
	@PostMapping(value="/saveEquipmentMaster",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseDto saveEquipmentMaster(@RequestBody EquipmentStageDto dto){
		return equipmentMasterService.saveEquipmentMaster(dto);
	}
	
	//read all records in master irrespective of flag
	@GetMapping(value = "/getAllEquipmentMaster/{pageNumber}/{pageSize}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto getEquipmentMasterList(@PathVariable Integer pageNumber,@PathVariable Integer pageSize) {
		return equipmentMasterService.getEquipmentMasterList(pageNumber,pageSize);

	}
	//read all records in master with respective of flag (written in stagecontroller)
	
    //filter in master
	@PostMapping(value="/filterEquipmentMaster/{pageNumber}/{pageSize}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseDto filterEquipmentMaster(@RequestBody EquipmentMasterDto equipmentMasterDto,@PathVariable Integer pageNumber,@PathVariable Integer pageSize) {
		return equipmentMasterService.filterEquipmentMaster(equipmentMasterDto,pageNumber,pageSize);

	}

	
}

