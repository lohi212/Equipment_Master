
package com.inkathon.equipmentmaster.serviceimpl;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.inkathon.equipmentmaster.config.ResponseDto;
import com.inkathon.equipmentmaster.daos.GeneralDataMasterDao;
import com.inkathon.equipmentmaster.dtos.GeneralDataMasterDto;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.service.GeneralDataMasterService;
import com.inkathon.equipmentmaster.util.HttpStatusCodes;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Service
@Transactional
public class GeneralDataMasterServiceImpl implements GeneralDataMasterService {
	
	private final Logger logger = LoggerFactory.getLogger(GeneralDataMasterServiceImpl.class);

	@Autowired
	private GeneralDataMasterDao generalDataMasterDao;
	
	@Override
	public ResponseDto saveGeneralDataMaster(GeneralDataStageDto dto) {
		ResponseDto responseMessage=new ResponseDto();
		try{
			generalDataMasterDao.saveGeneralDataMaster(dto);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);

		}catch(Exception e){
			System.err.println("Error-GeneralDataMasterServiceImpl.saveGeneralDataMaster():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-GeneralDataMasterServiceImpl.saveGeneralDataMaster():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;
	}	
	@Override
	public ResponseDto getGeneralDataMasterById(String equipmentId) {
		ResponseDto responseMessage = new ResponseDto();

		try {
			GeneralDataMasterDto generalDataMasterDto = generalDataMasterDao.getGeneralDataMaster(equipmentId);
			if(!ServicesUtil.isEmpty(generalDataMasterDto)){
			responseMessage.setData(generalDataMasterDto);
			responseMessage.setMessage(HttpStatusCodes.successMsg);
			responseMessage.setStatusCode(HttpStatusCodes.successCode);
			responseMessage.setStatus(HttpStatusCodes.trueStatus);
			}else{
				responseMessage.setMessage(HttpStatusCodes.notFoundMsg);
				responseMessage.setStatusCode(HttpStatusCodes.notFoundCode);
				responseMessage.setStatus(HttpStatusCodes.falseStatus);

			}

		} catch (Exception e) {
			System.err.println("Error-GeneralDataMasterServiceImpl.getGeneralDataMasterById():-"+e.getMessage());
			responseMessage.setMessage(HttpStatusCodes.internalServerErrorMsg+"-GeneralDataMasterServiceImpl.getGeneralDataMasterById():-"+e.getMessage());
			responseMessage.setStatusCode(HttpStatusCodes.internalServerErrorCode);
			responseMessage.setStatus(HttpStatusCodes.falseStatus);
		}
		return responseMessage;


	}


	
}
