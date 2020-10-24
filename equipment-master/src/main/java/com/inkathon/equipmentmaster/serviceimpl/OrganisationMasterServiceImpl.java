

package com.inkathon.equipmentmaster.serviceimpl;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.OrganisationMasterDao;
import com.inkathon.equipmentmaster.dtos.GeneralDataMasterDto;
import com.inkathon.equipmentmaster.dtos.OrganisationMasterDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;
import com.inkathon.equipmentmaster.service.OrganisationMasterService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class OrganisationMasterServiceImpl implements OrganisationMasterService {
	
	private final Logger logger = LoggerFactory.getLogger(OrganisationMasterServiceImpl.class);

	@Autowired
	private OrganisationMasterDao organisationMasterDao;
	
	

	@Override
	public ResponseDto saveOrganisationMaster(OrganisationStageDtoList dtolist) {
		ResponseDto responseMessage=new ResponseDto();
		try{
			String eid = dtolist.getEquipmentId();

			for(OrganisationStageDto dto: dtolist.getOrganisationslist())
			{
				dto.setEquipmentId(eid);
				organisationMasterDao.saveOrganisationMaster(dto);
			}

			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);


		}catch(Exception e){
			System.err.println("Error-OrganisationMasterServiceImpl.saveOrganisationMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-OrganisationMasterServiceImpl.saveOrganisationMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;
	}	

	@Override
	public ResponseDto getOrganisationMasterById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> organisationMasterDtoList = organisationMasterDao.getOrganisationMaster(equipmentId);
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
			System.err.println("Error-OrganisationMasterServiceImpl.getOrganisationMasterById():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-OrganisationMasterServiceImpl.getOrganisationMasterById():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}

	
}
