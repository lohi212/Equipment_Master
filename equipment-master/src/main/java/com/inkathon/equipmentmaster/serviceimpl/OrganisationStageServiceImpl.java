

package com.inkathon.equipmentmaster.serviceimpl;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.OrganisationStageDao;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;
import com.inkathon.equipmentmaster.service.OrganisationStageService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class OrganisationStageServiceImpl implements OrganisationStageService {
	
	private final Logger logger = LoggerFactory.getLogger(OrganisationStageServiceImpl.class);

	@Autowired
	private OrganisationStageDao organisationStageDao;
	@Override
	public ResponseDto getOrganisationStageById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> organisationStageDtoList = organisationStageDao.getOrganisationStage(equipmentId);
			if(!ServicesUtil.isEmpty(organisationStageDtoList)){
			responseMessage.setDataList(organisationStageDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}


		} catch (Exception e) {
			System.err.println("Error-OrganisationStageServiceImpl.getOrganisationStageById():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-OrganisationStageServiceImpl.getOrganisationStageById():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}
	@Override
	public ResponseDto saveOrganisationStage(OrganisationStageDtoList dtolist) {
		ResponseDto responseMessage=new ResponseDto();
		try{
			
			String eid = dtolist.getEquipmentId();

			for(OrganisationStageDto dto: dtolist.getOrganisationslist())
			{
				dto.setEquipmentId(eid);
				organisationStageDao.saveOrganisationStage(dto);
			}

			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);


		}catch(Exception e){
			System.err.println("Error-OrganisationStageServiceImpl.saveOrganisationStage():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-OrganisationStageServiceImpl.saveOrganisationStage():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}	


	
	@Override
	public ResponseDto viewOrganisationStageById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> organisationStageDtoList = organisationStageDao.viewOrganisationStage(equipmentId);
			if(!ServicesUtil.isEmpty(organisationStageDtoList)){
			responseMessage.setDataList(organisationStageDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}


		} catch (Exception e) {
			System.err.println("Error-OrganisationStageServiceImpl.viewOrganisationStageById():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-OrganisationStageServiceImpl.viewOrganisationStageById():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}

	@Override
	public ResponseDto viewOrganisationMaster(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> organisationMasterDtoList = organisationStageDao.viewOrganisationMaster(equipmentId);
			if(!ServicesUtil.isEmpty(organisationMasterDtoList)){
			responseMessage.setDataList(organisationMasterDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}


		} catch (Exception e) {
			System.err.println("Error-OrganisationStageServiceImpl.viewOrganisationMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-OrganisationStageServiceImpl.viewOrganisationMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}


}
