package com.inkathon.equipmentmaster.daos;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;

import com.inkathon.equipmentmaster.dos.LocationMasterDo;
import com.inkathon.equipmentmaster.dos.OrganisationMasterDo;
import com.inkathon.equipmentmaster.dos.OrganisationMasterPK;
import com.inkathon.equipmentmaster.dos.OrganisationStageDo;
import com.inkathon.equipmentmaster.dtos.LocationMasterDto;
import com.inkathon.equipmentmaster.dtos.OrganisationMasterDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;
@Repository
public class OrganisationMasterDao extends BaseDao{
	
	private OrganisationMasterDo importMasterDto(OrganisationStageDto dto) {
		OrganisationMasterDo organisationMasterDo = null;
		if (dto != null) {
			organisationMasterDo = new OrganisationMasterDo();
			OrganisationMasterPK pk = new OrganisationMasterPK();
			pk.setEquipmentId(dto.getEquipmentId());
			pk.setCompanyCode(dto.getCompanyCode());
			organisationMasterDo.setId(pk);
			organisationMasterDo.setBusinessArea(dto.getBusinessArea());
			organisationMasterDo.setAsset(dto.getAsset());
			organisationMasterDo.setCostCentre(dto.getCostCentre());
			organisationMasterDo.setMaintenancePlanningPlant(dto.getMaintenancePlanningPlant());
			organisationMasterDo.setPlannerGroup(dto.getPlannerGroup());
			organisationMasterDo.setMainWorkCtr(dto.getMainWorkCtr());
			organisationMasterDo.setCatalogProfile(dto.getCatalogProfile());
			organisationMasterDo.setCurrencyKey(dto.getCurrencyKey());
			organisationMasterDo.setManufacturerSerialNo(dto.getManufacturerSerialNo());
			organisationMasterDo.setPlantAssociated(dto.getPlantAssociated());
		}
		return organisationMasterDo;
	}

	private OrganisationMasterDto exportMasterDto(OrganisationMasterDo entity) {
		OrganisationMasterDto organisationMasterDto = null;
		if (entity != null) {
			organisationMasterDto = new OrganisationMasterDto();
			organisationMasterDto.setEquipmentId(entity.getId().getEquipmentId());
			organisationMasterDto.setCompanyCode(entity.getId().getCompanyCode());
			organisationMasterDto.setBusinessArea(entity.getBusinessArea());
			organisationMasterDto.setAsset(entity.getAsset());
			organisationMasterDto.setCostCentre(entity.getCostCentre());
			organisationMasterDto.setMaintenancePlanningPlant(entity.getMaintenancePlanningPlant());
			organisationMasterDto.setPlannerGroup(entity.getPlannerGroup());
			organisationMasterDto.setMainWorkCtr(entity.getMainWorkCtr());
			organisationMasterDto.setCatalogProfile(entity.getCatalogProfile());
			organisationMasterDto.setCurrencyKey(entity.getCurrencyKey());
			organisationMasterDto.setManufacturerSerialNo(entity.getManufacturerSerialNo());
			organisationMasterDto.setPlantAssociated(entity.getPlantAssociated());
		}
		return organisationMasterDto;

	}
	public void saveOrganisationMaster(OrganisationStageDto dto) {
		try {
			getSession().saveOrUpdate(importMasterDto(dto));
		} catch (Exception e) {
			System.err.println("Error-OrganisationMasterDao.saveOrganisationMaster:" + e.getMessage());
		}

	}

	
	public List<Object> getOrganisationMaster(String equipmentId) {
		List<Object> reqList = new ArrayList<>();
		try{

		String q = "select distinct l.id.companyCode from OrganisationMasterDo l where l.id.equipmentId='" + equipmentId
				+ "'";
		Query<String> qu = getSession().createQuery(q, String.class);
		List<String> orgList = qu.list();

		for (String str : orgList) {

			String queryStr = "select s from OrganisationMasterDo s where s.id.equipmentId='" + equipmentId
					+ "' and s.id.companyCode='" + str + "' order by s.id.companyCode desc";
			Query<OrganisationMasterDo> query = getSession().createQuery(queryStr, OrganisationMasterDo.class);
			List<OrganisationMasterDo> resultList = query.getResultList();
			for (OrganisationMasterDo omdo : resultList) {
				OrganisationMasterDto omdto = exportMasterDto(omdo);
				reqList.add(omdto);
			}
		}
		} catch (Exception e) {
			System.err.println("Error-OrganisationMasterDao.getOrganisationMaster:" + e.getMessage());
		}
		//dtoList.setOrganisationslist(reqList);
		return reqList;

	}


}



