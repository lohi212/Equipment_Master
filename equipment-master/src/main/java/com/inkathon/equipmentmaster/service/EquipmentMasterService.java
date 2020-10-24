package com.inkathon.equipmentmaster.service;


import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.dos.EquipmentStageDo;
import com.inkathon.equipmentmaster.dtos.EquipmentMasterDto;
import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;

public interface EquipmentMasterService {


	public ResponseDto saveEquipmentMaster(EquipmentStageDto dto);
	public ResponseDto getEquipmentMasterList(Integer pageNumber, Integer pageSize);
	//public ResponseDto viewEquipmentMasterList(Integer pageNumber, Integer pageSize);
	public ResponseDto filterEquipmentMaster(EquipmentMasterDto dto,Integer pageNumber, Integer pageSize);



}