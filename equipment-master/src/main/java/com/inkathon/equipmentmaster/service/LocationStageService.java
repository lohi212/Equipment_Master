
package com.inkathon.equipmentmaster.service;
import com.inkathon.equipmentmaster.config.ResponseDto;

import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;

public interface LocationStageService {

	public ResponseDto getLocationStageById(String equipmentId);

	ResponseDto saveLocationStage(LocationStageDtoList dto);
	
	public ResponseDto viewLocationStageById(String equipmentId);
		public ResponseDto viewLocationMaster(String equipmentId);


}
