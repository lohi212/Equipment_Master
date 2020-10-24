package com.inkathon.equipmentmaster.service;

import com.inkathon.equipmentmaster.config.ResponseDto;


import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;

public interface GeneralDataStageService {

	public ResponseDto getGeneralDataStageById(String equipmentId);

	public ResponseDto saveGeneralDataStage(GeneralDataStageDto dto);
	
	public ResponseDto viewGeneralDataStageById(String equipmentId) ;
		public ResponseDto viewGeneralDataMaster(String equipmentId);

	


}
