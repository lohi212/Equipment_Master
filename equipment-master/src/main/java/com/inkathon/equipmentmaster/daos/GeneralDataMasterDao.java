package com.inkathon.equipmentmaster.daos;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;

import com.inkathon.equipmentmaster.dos.GeneralDataMasterDo;
import com.inkathon.equipmentmaster.dos.GeneralDataStageDo;
import com.inkathon.equipmentmaster.dtos.GeneralDataMasterDto;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.util.ServicesUtil;
@Repository
public class GeneralDataMasterDao extends BaseDao{
	
	private GeneralDataMasterDo importMasterDto(GeneralDataStageDto dto) {
		GeneralDataMasterDo generalDataMasterDo = null;
		if (dto != null) {
			generalDataMasterDo = new GeneralDataMasterDo();
			generalDataMasterDo.setEquipmentId(dto.getEquipmentId());
			generalDataMasterDo.setClassType(dto.getClassType());
			generalDataMasterDo.setObjectType(dto.getObjectType());
			generalDataMasterDo.setWeight(dto.getWeight());
			generalDataMasterDo.setSize(dto.getSize());
			generalDataMasterDo.setAcquisitionValue(dto.getAcquisitionValue());
			generalDataMasterDo.setAcquisitionDate(dto.getAcquisitionDate());
			generalDataMasterDo.setManufacturer(dto.getManufacturer());
			generalDataMasterDo.setManufacturerCountry(dto.getManufacturerCountry());
			generalDataMasterDo.setModelNo(dto.getModelNo());
			generalDataMasterDo.setManufacturerPartNo(dto.getManufacturerPartNo());
			generalDataMasterDo.setConstr_yymm(dto.getConstr_yymm());


		}
		return generalDataMasterDo;
	}

	private GeneralDataMasterDto exportMasterDto(GeneralDataMasterDo entity) {
		GeneralDataMasterDto generalDataMasterDto = null;
		if (entity != null) {
			generalDataMasterDto = new GeneralDataMasterDto();
			generalDataMasterDto.setEquipmentId(entity.getEquipmentId());
			generalDataMasterDto.setClassType(entity.getClassType());
			generalDataMasterDto.setObjectType(entity.getObjectType());
			generalDataMasterDto.setWeight(entity.getWeight());
			generalDataMasterDto.setSize(entity.getSize());
			generalDataMasterDto.setAcquisitionValue(entity.getAcquisitionValue());
			generalDataMasterDto.setAcquisitionDate(entity.getAcquisitionDate());
			generalDataMasterDto.setManufacturer(entity.getManufacturer());
			generalDataMasterDto.setManufacturerCountry(entity.getManufacturerCountry());
			generalDataMasterDto.setModelNo(entity.getModelNo());
			generalDataMasterDto.setManufacturerPartNo(entity.getManufacturerPartNo());
			generalDataMasterDto.setConstr_yymm(entity.getConstr_yymm());

		}
		return generalDataMasterDto;

	}
	public void saveGeneralDataMaster(GeneralDataStageDto dto) {
		try {
			getSession().saveOrUpdate(importMasterDto(dto));
		} catch (Exception e) {
			System.err.println("Error-GeneralDataMasterDao.saveGeneralDataMaster:" + e.getMessage());
		}

	}
	public GeneralDataMasterDto getGeneralDataMaster(String equipmentId) {
	
		GeneralDataMasterDo generalDataMasterDo=null;
		try
		{
		String queryStr = "select s from GeneralDataMasterDo s where s.id.equipmentId='" + equipmentId + "'";
		Query<GeneralDataMasterDo> query = getSession().createQuery(queryStr, GeneralDataMasterDo.class);
		List<GeneralDataMasterDo> resultList = query.getResultList();
		if (!ServicesUtil.isEmpty(resultList))
	     generalDataMasterDo=resultList.get(0);
		}catch (Exception e) {
			System.err.println("Error-GeneralDataMasterDao.getGeneralDataMaster:" + e.getMessage());
		}

		return exportMasterDto(generalDataMasterDo);
	
			
}

}


