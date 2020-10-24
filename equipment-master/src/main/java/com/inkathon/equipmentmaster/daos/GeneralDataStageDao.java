package com.inkathon.equipmentmaster.daos;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;
import com.inkathon.equipmentmaster.dos.EquipmentIdDo;
import com.inkathon.equipmentmaster.dos.EquipmentStageDo;
import com.inkathon.equipmentmaster.dos.EquipmentStagePK;
import com.inkathon.equipmentmaster.dos.GeneralDataStageDo;
import com.inkathon.equipmentmaster.dos.OrganisationStageDo;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.util.ServicesUtil;
@Repository
public class GeneralDataStageDao extends BaseDao{
	
	private GeneralDataStageDo importDto(GeneralDataStageDto dto) {
		GeneralDataStageDo generalDataStageDo = null;
		if (dto != null) {
			generalDataStageDo = new GeneralDataStageDo();
			EquipmentStagePK pk = new EquipmentStagePK();
			pk.setEquipmentId(dto.getEquipmentId());
			pk.setVersion(dto.getVersion());
			generalDataStageDo.setId(pk);
			generalDataStageDo.setClassType(dto.getClassType());
			generalDataStageDo.setObjectType(dto.getObjectType());
			generalDataStageDo.setWeight(dto.getWeight());
			generalDataStageDo.setSize(dto.getSize());
			generalDataStageDo.setAcquisitionValue(dto.getAcquisitionValue());
			generalDataStageDo.setAcquisitionDate(dto.getAcquisitionDate());
			generalDataStageDo.setManufacturer(dto.getManufacturer());
			generalDataStageDo.setManufacturerCountry(dto.getManufacturerCountry());
			generalDataStageDo.setModelNo(dto.getModelNo());
			generalDataStageDo.setManufacturerPartNo(dto.getManufacturerPartNo());
			generalDataStageDo.setConstr_yymm(dto.getConstr_yymm());

		}
		return generalDataStageDo;
	}

	private GeneralDataStageDto exportDto(GeneralDataStageDo entity) {
		GeneralDataStageDto generalDataStageDto = null;
		if (entity != null) {
			generalDataStageDto = new GeneralDataStageDto();
			generalDataStageDto.setEquipmentId(entity.getId().getEquipmentId());
			generalDataStageDto.setVersion(entity.getId().getVersion());
			generalDataStageDto.setClassType(entity.getClassType());
			generalDataStageDto.setObjectType(entity.getObjectType());
			generalDataStageDto.setWeight(entity.getWeight());
			generalDataStageDto.setSize(entity.getSize());
			generalDataStageDto.setAcquisitionValue(entity.getAcquisitionValue());
			generalDataStageDto.setAcquisitionDate(entity.getAcquisitionDate());
			generalDataStageDto.setManufacturer(entity.getManufacturer());
			generalDataStageDto.setManufacturerCountry(entity.getManufacturerCountry());
			generalDataStageDto.setModelNo(entity.getModelNo());
			generalDataStageDto.setManufacturerPartNo(entity.getManufacturerPartNo());
			generalDataStageDto.setConstr_yymm(entity.getConstr_yymm());


		}
		return generalDataStageDto;

	}

	public void saveGeneralDataStage(GeneralDataStageDto dto) {
		try {
			Integer latestVersion = 0;
			latestVersion = getmaxVersionId(dto.getEquipmentId());
			dto.setVersion(latestVersion + 1);
			System.err.println("dto:" + dto);
			GeneralDataStageDo generalDataStageDo = importDto(dto);
			System.err.println("do:" + generalDataStageDo);
			 getSession().save(generalDataStageDo);
		} catch (Exception e) {
			System.err.println("Error-GeneralDataStageDao.saveEquipmentMaster:" + e.getMessage());
		}

}

	public GeneralDataStageDto getGeneralDataStage(String equipmentId) {
		GeneralDataStageDo generalDataStageDo=null;
		try{
			String queryStr = "select s from GeneralDataStageDo s where s.id.equipmentId='" + equipmentId + "'";
			queryStr += "  order by s.id.version desc ";
			Query<GeneralDataStageDo> query = getSession().createQuery(queryStr, GeneralDataStageDo.class);
			List<GeneralDataStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList))
			 generalDataStageDo=resultList.get(0);
		}catch (Exception e) {
			System.err.println("Error-GeneralDataStageDao.getGeneralDataStage:" + e.getMessage());
		}

				return exportDto(generalDataStageDo);
				
	}

	public Integer getmaxVersionId(String equipmentId) {
		try {
			String queryStr = "select s from GeneralDataStageDo s where s.id.equipmentId='" + equipmentId + "'";
			queryStr += "  order by s.id.version desc ";

			Query<GeneralDataStageDo> query = getSession().createQuery(queryStr, GeneralDataStageDo.class);
			List<GeneralDataStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList))
				return resultList.get(0).getId().getVersion();
			else
				return 0;

		} catch (Exception e) {
			System.err.println("Logger-GeneralDataStageDao.getmaxVersionId():" + e.getMessage());
			return 0;
		}
	}
	public GeneralDataStageDto viewGeneralDataStage(String equipmentId) {
		GeneralDataStageDo generalDataStageDo=null;
		try{
		String queryStr = "select s from GeneralDataStageDo s where s.id.equipmentId='" + equipmentId + "'";
		queryStr += "and s.id.equipmentId not in (select m.equipmentId from GeneralDataMasterDo m) order by s.id.version desc ";
		Query<GeneralDataStageDo> query = getSession().createQuery(queryStr, GeneralDataStageDo.class);
		List<GeneralDataStageDo> resultList = query.getResultList();
		if (!ServicesUtil.isEmpty(resultList))
		 generalDataStageDo=resultList.get(0);
		}catch (Exception e) {
			System.err.println("Error-GeneralDataStageDao.viewGeneralDataStage:" + e.getMessage());
		}

			return exportDto(generalDataStageDo);
			
}
	public GeneralDataStageDto viewGeneralDataMaster(String equipmentId) {
		GeneralDataStageDo generalDataStageDo=null;
		try{
	      String queryStr = "select s from GeneralDataStageDo s where s.id.version="
					+ "(select max(r.id.version) from GeneralDataStageDo r where"
					+ " r.id.equipmentId=s.id.equipmentId)  and s.id.equipmentId in "
					+ " (select m.equipmentId from EquipmentMasterDo m where m.updatePending=true and s.id.equipmentId='"+equipmentId+"')";

			Query<GeneralDataStageDo> query = getSession().createQuery(queryStr, GeneralDataStageDo.class);
			List<GeneralDataStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList))
			 generalDataStageDo=resultList.get(0);
		}catch (Exception e) {
			System.err.println("Error-GeneralDataStageDao.viewGeneralDataMaster:" + e.getMessage());
		}
				return exportDto(generalDataStageDo);
				
	}
}
	
	


