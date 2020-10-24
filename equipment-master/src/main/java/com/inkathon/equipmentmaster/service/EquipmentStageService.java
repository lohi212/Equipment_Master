package com.inkathon.equipmentmaster.service;

import java.util.List;


import com.inkathon.equipmentmaster.config.ResponseDto;

import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;

public interface EquipmentStageService {

	ResponseDto saveEquipmentStage(EquipmentStageDto dto);

	public ResponseDto getEquipmentStageList(Integer pageNumber, Integer pageSize);
	
	public ResponseDto viewEquipmentStageListNotInMaster(Integer pageNumber, Integer pageSize);

	public ResponseDto viewEquipmentMasterList(Integer pageNumber, Integer pageSize);

	public ResponseDto filterEquipmentStage(EquipmentStageDto dto,Integer pageNumber, Integer pageSize);

}
