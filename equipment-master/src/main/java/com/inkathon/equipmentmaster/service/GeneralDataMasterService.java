package com.inkathon.equipmentmaster.service;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.dtos.GeneralDataMasterDto;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;

public interface GeneralDataMasterService {


	public ResponseDto saveGeneralDataMaster(GeneralDataStageDto dto);
	public ResponseDto getGeneralDataMasterById(String equipmentId);




}
