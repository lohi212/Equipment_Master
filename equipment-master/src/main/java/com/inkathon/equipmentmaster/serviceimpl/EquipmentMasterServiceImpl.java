
package com.inkathon.equipmentmaster.serviceimpl;

import java.util.List;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.EquipmentMasterDao;
import com.inkathon.equipmentmaster.dos.EquipmentStageDo;
import com.inkathon.equipmentmaster.dtos.EquipmentMasterDto;
import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;
import com.inkathon.equipmentmaster.service.EquipmentMasterService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class EquipmentMasterServiceImpl implements EquipmentMasterService {
	
	private final Logger logger = LoggerFactory.getLogger(EquipmentMasterServiceImpl.class);

	@Autowired
	private EquipmentMasterDao equipmentMasterDao;
	
	public ResponseDto saveEquipmentMaster(EquipmentStageDto dto){
		ResponseDto responseMessage=new ResponseDto();
		try{
			String s = equipmentMasterDao.saveEquipmentMaster(dto);
			if(ServicesUtil.isEmpty(s)){
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage("Service not excecuted because of new update in stage");
				responseMessage.setStatusCode(HttpStatusCodes.newUpdateCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}

		}catch(Exception e){
			System.err.println("Error-EquipmentMasterServiceImpl.saveEquipmentMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentMasterServiceImpl.saveEquipmentMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}

	
/*	public ResponseDto saveEquipmentMaster(EquipmentStageDto dto){
		ResponseDto responseMessage=new ResponseDto();
		try{
			equipmentMasterDao.saveEquipmentMaster(dto);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);

		}catch(Exception e){
			System.err.println("Error-EquipmentMasterServiceImpl.saveEquipmentMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentMasterServiceImpl.saveEquipmentMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}
*/
	
	@Override
	public ResponseDto getEquipmentMasterList(Integer pageNumber, Integer pageSize) {
		Integer startIndex = (pageNumber - 1) * pageSize;
		ResponseDto responseMessage = new ResponseDto();
		responseMessage.setPageNo(pageNumber);
		responseMessage.setPageSize(pageSize);

		try {
			List<Object> equipmentMasterDtoList = equipmentMasterDao.getEquipmentMasterList(startIndex, pageSize);
			//to get toatl no of records
			if(!ServicesUtil.isEmpty(equipmentMasterDtoList)){
			Long count=equipmentMasterDao.getEquipmentMasterListMaxCount();
			responseMessage.setDataList(equipmentMasterDtoList);
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
			System.err.println("Error-EquipmentMasterServiceImpl.getEquipmentMasterList():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentMasterServiceImpl.getEquipmentMasterList():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	}
	public ResponseDto filterEquipmentMaster(EquipmentMasterDto dto,Integer pageNumber, Integer pageSize) {
		ResponseDto responseMessage = new ResponseDto();
		responseMessage.setPageNo(pageNumber);
		responseMessage.setPageSize(pageSize);
		Integer startIndex = (pageNumber - 1) * pageSize;
		try {
			List<Object> equipmentMasterDtoList = equipmentMasterDao.filterEquipmentMaster(dto,startIndex, pageSize);
			//to get toatl no of records
			if(!ServicesUtil.isEmpty(equipmentMasterDtoList)){

			Long count=equipmentMasterDao.filterEquipmentMasterMaxCount(dto);
			
			responseMessage.setTotalCount(count);
			responseMessage.setDataList(equipmentMasterDtoList);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}

		} catch (Exception e) {
			System.err.println("Error-EquipmentMasterServiceImpl.getEquipmentMasterList():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-EquipmentMasterServiceImpl.filterEquipmentMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;

	
	}


	

}

