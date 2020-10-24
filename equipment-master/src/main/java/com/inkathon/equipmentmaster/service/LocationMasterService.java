package com.inkathon.equipmentmaster.service;

import com.inkathon.equipmentmaster.config.ResponseDto;

import com.inkathon.equipmentmaster.dtos.LocationMasterDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;

public interface LocationMasterService {



	public ResponseDto saveLocationMaster(LocationStageDtoList dtolist);
	public ResponseDto getLocationMasterById(String equipmentId);




}
