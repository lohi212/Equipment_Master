package com.inkathon.equipmentmaster.serviceimpl;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.EquipmentMasterDao;
import com.inkathon.equipmentmaster.daos.EquipmentStageDao;
import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;
import com.inkathon.equipmentmaster.service.EquipmentStageService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class EquipmentStageServiceImpl implements EquipmentStageService {

	private final Logger logger = LoggerFactory.getLogger(EquipmentStageServiceImpl.class);

	@Autowired
	private EquipmentStageDao equipmentStageDao;
	
	
	
	@Override
	public ResponseDto saveEquipmentStage(EquipmentStageDto dto) {
		ResponseDto responseMessage=new ResponseDto();
		try{
			String eid=equipmentStageDao.saveEquipmentStage(dto);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			responseMessage.setData(eid);


		}catch(Exception e){
			System.err.println("Error-EquipmentStageServiceImpl.saveEquipmentStage():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentStageServiceImpl.saveEquipmentStage():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;
	}



	@Override
	public ResponseDto getEquipmentStageList(Integer pageNumber, Integer pageSize) {
		Integer startIndex = (pageNumber - 1) * pageSize;
		ResponseDto responseMessage = new ResponseDto();
		responseMessage.setPageNo(pageNumber);
		responseMessage.setPageSize(pageSize);

		try {
			List<Object> equipmentStageDtoList = equipmentStageDao.getEquipmentStageList(startIndex, pageSize);
			//to get toatl no of records
			if(!ServicesUtil.isEmpty(equipmentStageDtoList)){

			Long count=equipmentStageDao.getEquipmentStageListMaxCount();
			responseMessage.setDataList(equipmentStageDtoList);
			
			responseMessage.setTotalCount(count);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);


			}

		} catch (Exception e) {
			System.err.println("Error-EquipmentStageServiceImpl.getEquipmentStageList():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentStageServiceImpl.getEquipmentStageList():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}

	@Override
	public ResponseDto viewEquipmentStageListNotInMaster(Integer pageNumber, Integer pageSize) {
		Integer startIndex = (pageNumber - 1) * pageSize;
		ResponseDto responseMessage = new ResponseDto();
		responseMessage.setPageNo(pageNumber);
		responseMessage.setPageSize(pageSize);
																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														
		try {
			List<Object> equipmentStageDtoList = equipmentStageDao.viewEquipmentStageListNotInMaster(startIndex, pageSize);
			//to get toatl no of records
			if(!ServicesUtil.isEmpty(equipmentStageDtoList)){
			Long count=equipmentStageDao.viewEquipmentStageListMaxCount();
			responseMessage.setDataList(equipmentStageDtoList);
			responseMessage.setTotalCount(count);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else
			{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}

		} catch (Exception e) {
			System.err.println("Error-EquipmentStageServiceImpl.viewEquipmentStageListNotInMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentStageServiceImpl.viewEquipmentStageListNotInMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}

	@Override
	public ResponseDto viewEquipmentMasterList(Integer pageNumber, Integer pageSize) {
		Integer startIndex = (pageNumber - 1) * pageSize;
		ResponseDto responseMessage = new ResponseDto();
		responseMessage.setPageNo(pageNumber);
		responseMessage.setPageSize(pageSize);

		try {
			List<Object> equipmentMasterDtoList = equipmentStageDao.viewEquipmentMasterList(startIndex, pageSize);
			//to get toatl no of records
			if(!ServicesUtil.isEmpty(equipmentMasterDtoList)){
			Long count=equipmentStageDao.viewEquipmentMasterListMaxCount();
			responseMessage.setDataList(equipmentMasterDtoList);
			responseMessage.setTotalCount(count);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else
			{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}


		} catch (Exception e) {
			System.err.println("Error-EquipmentStageServiceImpl.viewEquipmentMasterList():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentStageServiceImpl.viewEquipmentMasterList():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}

	public ResponseDto filterEquipmentStage(EquipmentStageDto dto,Integer pageNumber, Integer pageSize) {
		ResponseDto responseMessage = new ResponseDto();
		responseMessage.setPageNo(pageNumber);
		responseMessage.setPageSize(pageSize);
		Integer startIndex = (pageNumber - 1) * pageSize;
		try {
			List<Object> equipmentStageDtoList = equipmentStageDao.filterEquipmentStage(dto,startIndex, pageSize);
			//to get toatl no of records
			if(!ServicesUtil.isEmpty(equipmentStageDtoList)){

			Long count=equipmentStageDao.filterEquipmentStageMaxCount(dto);
			
			responseMessage.setTotalCount(count);
			responseMessage.setDataList(equipmentStageDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}

		} catch (Exception e) {
			System.err.println("Error-EquipmentStageServiceImpl.getEquipmentStageList():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentStageServiceImpl.filterEquipmentStage():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	
	}

}
