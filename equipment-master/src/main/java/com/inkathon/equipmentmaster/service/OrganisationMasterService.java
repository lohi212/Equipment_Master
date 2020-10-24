package com.inkathon.equipmentmaster.service;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.dtos.OrganisationMasterDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;

public interface OrganisationMasterService {


	public ResponseDto saveOrganisationMaster(OrganisationStageDtoList dtolist);
	public ResponseDto getOrganisationMasterById(String equipmentId);



}
