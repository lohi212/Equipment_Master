package com.inkathon.equipmentmaster.service;

import com.inkathon.equipmentmaster.config.ResponseDto;

import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;

public interface OrganisationStageService {


	public ResponseDto getOrganisationStageById(String equipmentId);

	public ResponseDto saveOrganisationStage(OrganisationStageDtoList dtolist);
	
	public ResponseDto viewOrganisationStageById(String equipmentId);
	public ResponseDto viewOrganisationMaster(String equipmentId);



}
