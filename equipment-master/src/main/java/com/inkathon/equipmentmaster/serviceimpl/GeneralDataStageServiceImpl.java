
package com.inkathon.equipmentmaster.serviceimpl;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.GeneralDataStageDao;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.service.GeneralDataStageService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class GeneralDataStageServiceImpl implements GeneralDataStageService {
	
	private final Logger logger = LoggerFactory.getLogger(GeneralDataStageServiceImpl.class);

	@Autowired
	private GeneralDataStageDao generalDataStageDao;
	



	@Override
	public ResponseDto getGeneralDataStageById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			GeneralDataStageDto generalDataStageDto = generalDataStageDao.getGeneralDataStage(equipmentId);
			if(!ServicesUtil.isEmpty(generalDataStageDto)){
			responseMessage.setData(generalDataStageDto);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}

		} catch (Exception e) {
			System.err.println("Error-GeneralDataStageServiceImpl.getGeneralDataStageById():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-GeneralDataStageServiceImpl.getGeneralDataStageById():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}

	@Override
	public ResponseDto viewGeneralDataStageById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			GeneralDataStageDto generalDataStageDto = generalDataStageDao.viewGeneralDataStage(equipmentId);
			if(!ServicesUtil.isEmpty(generalDataStageDto)){
			responseMessage.setData(generalDataStageDto);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);


			}

		} catch (Exception e) {
			System.err.println("Error-GeneralDataStageServiceImpl.viewGeneralDataStageById():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-GeneralDataStageServiceImpl.viewGeneralDataStageById():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}

	@Override
	public ResponseDto viewGeneralDataMaster(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			GeneralDataStageDto generalDataStageDto = generalDataStageDao.viewGeneralDataMaster(equipmentId);
			if(!ServicesUtil.isEmpty(generalDataStageDto)){
			responseMessage.setData(generalDataStageDto);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);


			}

		} catch (Exception e) {
			System.err.println("Error-GeneralDataMasterServiceImpl.viewGeneralDataMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-GeneralDataMasterServiceImpl.viewGeneralDataMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}


	@Override
	public ResponseDto saveGeneralDataStage(GeneralDataStageDto dto) {
		ResponseDto responseMessage=new ResponseDto();
		try{
			generalDataStageDao.saveGeneralDataStage(dto);
			
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);

		}catch(Exception e){
			System.err.println("Error-GeneralDataStageServiceImpl.saveGeneralDataStage():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-GeneralDataStageServiceImpl.saveGeneralDataStage():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}

	
	
}
