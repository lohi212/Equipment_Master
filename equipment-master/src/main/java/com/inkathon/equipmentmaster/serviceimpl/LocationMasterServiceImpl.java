
package com.inkathon.equipmentmaster.serviceimpl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.LocationMasterDao;
import com.inkathon.equipmentmaster.dtos.GeneralDataMasterDto;
import com.inkathon.equipmentmaster.dtos.LocationMasterDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;
import com.inkathon.equipmentmaster.service.LocationMasterService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class LocationMasterServiceImpl implements LocationMasterService {
	
	private final Logger logger = LoggerFactory.getLogger(LocationMasterServiceImpl.class);

	@Autowired
	private LocationMasterDao locationMasterDao;
	
	@Override
	public ResponseDto saveLocationMaster(LocationStageDtoList dtolist) {
		ResponseDto responseMessage=new ResponseDto();
		try{
			String eid = dtolist.getEquipmentId();

			for(LocationStageDto dto: dtolist.getLocationslist())
			{
				dto.setEquipmentId(eid);

				locationMasterDao.saveLocationMaster(dto);
			}
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);

		}catch(Exception e){
			System.err.println("Error-LocationMasterServiceImpl.saveLocationMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-LocationMasterServiceImpl.saveLocationMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}	
	@Override
	public ResponseDto getLocationMasterById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			List<Object> locationMasterDtoList = locationMasterDao.getLocationMaster(equipmentId);
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
			System.err.println("Error-LocationMasterServiceImpl.getLocationMasterById():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-LocationMasterServiceImpl.getLocationMasterById():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}


	

}
