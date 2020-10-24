
package com.inkathon.equipmentmaster.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.LocationStageDao;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;
import com.inkathon.equipmentmaster.service.LocationStageService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class LocationStageServiceImpl implements LocationStageService {

	private final Logger logger = LoggerFactory.getLogger(LocationStageServiceImpl.class);

	@Autowired
	private LocationStageDao locationStageDao;

	@Override
	public ResponseDto saveLocationStage(LocationStageDtoList dtolist) {
		ResponseDto responseMessage = new ResponseDto();
		try {
			String eid = dtolist.getEquipmentId();
			for (LocationStageDto dto : dtolist.getLocationslist()) {
				dto.setEquipmentId(eid);
				locationStageDao.saveLocationStage(dto);
			}
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);

		} catch (Exception e) {
			System.err.println("Error-LocationStageServiceImpl.saveLocationStage():-" + e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg
					+ "-LocationStageServiceImpl.saveLocationStage():-" + e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}

		@Override
	public ResponseDto getLocationStageById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> locationStageDtoList = locationStageDao.getLocationStage(equipmentId);
			if(!ServicesUtil.isEmpty(locationStageDtoList)){

			responseMessage.setDataList(locationStageDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}
				

		} catch (Exception e) {
			System.err.println("Error-LocationStageServiceImpl.getLocationStageById():-" + e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg
					+ "-LocationStageServiceImpl.getLocationStageById():-" + e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}

	@Override
	public ResponseDto viewLocationStageById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> locationStageDtoList = locationStageDao.viewLocationStage(equipmentId);
			if(!ServicesUtil.isEmpty(locationStageDtoList)){

			responseMessage.setDataList(locationStageDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);


			}

		} catch (Exception e) {
			System.err.println("Error-LocationStageServiceImpl.viewLocationStageById():-" + e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg
					+ "-LocationStageServiceImpl.viewLocationStageById():-" + e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}
	@Override
	public ResponseDto viewLocationMaster(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> locationMasterDtoList = locationStageDao.viewLocationMaster(equipmentId);
			if(!ServicesUtil.isEmpty(locationMasterDtoList)){

			responseMessage.setDataList(locationMasterDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);


			}

		} catch (Exception e) {
			System.err.println("Error-LocationStageServiceImpl.viewLocationMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-LocationStageServiceImpl.viewLocationMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}


}
