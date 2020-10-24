package com.inkathon.equipmentmaster.daos;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;

import com.inkathon.equipmentmaster.dos.EquipmentStageDo;
import com.inkathon.equipmentmaster.dos.EquipmentStagePK;
import com.inkathon.equipmentmaster.dos.GeneralDataStageDo;
import com.inkathon.equipmentmaster.dos.LocationStageDo;
import com.inkathon.equipmentmaster.dos.OrganisationStageDo;
import com.inkathon.equipmentmaster.dos.OrganisationStagePK;
import com.inkathon.equipmentmaster.dtos.GeneralDataStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDto;
import com.inkathon.equipmentmaster.dtos.OrganisationStageDtoList;
import com.inkathon.equipmentmaster.util.ServicesUtil;
@Repository
public class OrganisationStageDao extends BaseDao{
	
	private OrganisationStageDo importDto(OrganisationStageDto dto) {
		OrganisationStageDo organisationStageDo = null;
		if (dto != null) {
			organisationStageDo = new OrganisationStageDo();
			OrganisationStagePK pk = new OrganisationStagePK();
			pk.setEquipmentId(dto.getEquipmentId());
			pk.setVersion(dto.getVersion());
			pk.setCompanyCode(dto.getCompanyCode());
			organisationStageDo.setId(pk);
			organisationStageDo.setBusinessArea(dto.getBusinessArea());
			organisationStageDo.setAsset(dto.getAsset());
			organisationStageDo.setCostCentre(dto.getCostCentre());
			organisationStageDo.setMaintenancePlanningPlant(dto.getMaintenancePlanningPlant());
			organisationStageDo.setPlannerGroup(dto.getPlannerGroup());
			organisationStageDo.setMainWorkCtr(dto.getMainWorkCtr());
			organisationStageDo.setCatalogProfile(dto.getCatalogProfile());
			organisationStageDo.setCurrencyKey(dto.getCurrencyKey());
			organisationStageDo.setManufacturerSerialNo(dto.getManufacturerSerialNo());
			organisationStageDo.setPlantAssociated(dto.getPlantAssociated());
		}
		return organisationStageDo;
	}

	private OrganisationStageDto exportDto(OrganisationStageDo entity) {
		OrganisationStageDto organisationStageDto = null;
		if (entity != null) {
			organisationStageDto = new OrganisationStageDto();
			organisationStageDto.setEquipmentId(entity.getId().getEquipmentId());
			organisationStageDto.setVersion(entity.getId().getVersion());
			organisationStageDto.setCompanyCode(entity.getId().getCompanyCode());
			organisationStageDto.setBusinessArea(entity.getBusinessArea());
			organisationStageDto.setAsset(entity.getAsset());
			organisationStageDto.setCostCentre(entity.getCostCentre());
			organisationStageDto.setMaintenancePlanningPlant(entity.getMaintenancePlanningPlant());
			organisationStageDto.setPlannerGroup(entity.getPlannerGroup());
			organisationStageDto.setMainWorkCtr(entity.getMainWorkCtr());
			organisationStageDto.setCatalogProfile(entity.getCatalogProfile());
			organisationStageDto.setCurrencyKey(entity.getCurrencyKey());
			organisationStageDto.setManufacturerSerialNo(entity.getManufacturerSerialNo());
			organisationStageDto.setPlantAssociated(entity.getPlantAssociated());
		}
		return organisationStageDto;

	}

	public List<Object> getOrganisationStage(String equipmentId) {
		List<Object> reqList = new ArrayList<>();

		try{
		String q = "select distinct l.id.companyCode from OrganisationStageDo l where l.id.equipmentId='" + equipmentId
				+ "'";
		Query<String> qu = getSession().createQuery(q, String.class);
		List<String> orgList = qu.list();

		for (String str : orgList) {
			
			String queryStr = "select s from OrganisationStageDo s where s.id.equipmentId='" + equipmentId +"' ";
			queryStr+= " and s.id.companyCode='" + str + "' and  s.id.version = ";
			queryStr+= "(select max(r.id.version) from OrganisationStageDo r where";
			queryStr+= " r.id.equipmentId=s.id.equipmentId and r.id.companyCode = s.id.companyCode)  order by s.id.companyCode desc ";


		/*	String queryStr = "select s from OrganisationStageDo s where s.id.equipmentId='" + equipmentId
					+ "' and s.id.companyCode='" + str + "'";
			queryStr += "  order by s.id.version desc ";
			
			*/
			
			Query<OrganisationStageDo> query = getSession().createQuery(queryStr, OrganisationStageDo.class);
			List<OrganisationStageDo> resultList = query.getResultList();
			for (OrganisationStageDo osdo : resultList) {
				OrganisationStageDto osdto = exportDto(osdo);
				reqList.add(osdto);
			}
		}
		}catch (Exception e) {
			System.err.println("Error-OrganisationStageDao.getOrganisationStage:" + e.getMessage());
		}
		//dtoList.setOrganisationslist(reqList);
		return reqList;

	}

	public Integer getmaxVersionId(String equipmentId,String companyCode) {
		try {
			String queryStr = "select s from OrganisationStageDo s where s.id.equipmentId='" + equipmentId + "' and s.id.companyCode='"+companyCode+"'";
			queryStr += "  order by s.id.version desc ";
			Query<OrganisationStageDo> query = getSession().createQuery(queryStr, OrganisationStageDo.class);
			List<OrganisationStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList))
				return resultList.get(0).getId().getVersion();
			else
				return 0;

		} catch (Exception e) {
			System.err.println("Logger-OrganisationStageDo.getmaxVersionId():" + e.getMessage());
			return 0;
		}
	}

	
	public void saveOrganisationStage(OrganisationStageDto dto) {
		try {
			Integer latestVersion = 0;
			latestVersion = getmaxVersionId(dto.getEquipmentId(),dto.getCompanyCode());
			dto.setVersion(latestVersion + 1);
			System.err.println("dto:" + dto);
			OrganisationStageDo organisationStageDo = importDto(dto);
			System.err.println("do:" + organisationStageDo);
			 getSession().save(organisationStageDo);
		} catch (Exception e) {
			System.err.println("Error-OrganisationStageDao.saveOrganisationStage:" + e.getMessage());
		}

}

	public List<Object> viewOrganisationStage(String equipmentId) {
		List<Object> reqList = new ArrayList<>();

		try{
		String q = "select distinct l.id.companyCode from OrganisationStageDo l where l.id.equipmentId='" + equipmentId
				+ "'";
		Query<String> qu = getSession().createQuery(q, String.class);
		List<String> orgList = qu.list();

		for (String str : orgList) {
			
			String queryStr = "select s from OrganisationStageDo s where s.id.equipmentId='" + equipmentId +"' ";
			queryStr+= " and s.id.companyCode='" + str + "' and  s.id.version = ";
			queryStr+= "(select max(r.id.version) from OrganisationStageDo r where";
			queryStr+= " r.id.equipmentId=s.id.equipmentId and r.id.companyCode = s.id.companyCode) ";
			queryStr+= " and s.id.equipmentId not in (select m.id.equipmentId from OrganisationMasterDo m) order by s.id.companyCode desc ";



		    /*  String queryStr = "select s from OrganisationStageDo s where s.id.equipmentId='" + equipmentId
					+ "' and s.id.companyCode='" + str + "'";
			queryStr += " and s.id.equipmentId not in (select m.id.equipmentId from OrganisationMasterDo m) order by s.id.version desc ";
			*/
			
			Query<OrganisationStageDo> query = getSession().createQuery(queryStr, OrganisationStageDo.class);
			List<OrganisationStageDo> resultList = query.getResultList();
			for (OrganisationStageDo osdo : resultList) {
				OrganisationStageDto osdto = exportDto(osdo);
				reqList.add(osdto);
			}

		}
		}catch (Exception e) {
			System.err.println("Error-OrganisationStageDao.viewOrganisationStage:" + e.getMessage());
		}

		//dtoList.setOrganisationslist(reqList);
		return reqList;

	}

	public List<Object> viewOrganisationMaster(String equipmentId) {
		List<Object> reqList = new ArrayList<>();
        try{
		String q = "select distinct l.id.companyCode from OrganisationMasterDo l where l.id.equipmentId='" + equipmentId
				+ "'";
		Query<String> qu = getSession().createQuery(q, String.class);
		List<String> orgList = qu.list();

		for (String str : orgList) {
			
			String queryStr = "select s from OrganisationStageDo s where s.id.equipmentId='" + equipmentId +"' ";
			queryStr+= " and s.id.companyCode='" + str + "' and  s.id.version = ";
			queryStr+= "(select max(r.id.version) from OrganisationStageDo r where";
			queryStr+= " r.id.equipmentId=s.id.equipmentId and r.id.companyCode = s.id.companyCode) ";
			queryStr+= " and s.id.equipmentId in (select m.equipmentId from EquipmentMasterDo m where m.updatePending=true and m.equipmentId='"+equipmentId+"') order by s.id.companyCode desc ";

					
		Query<OrganisationStageDo> query = getSession().createQuery(queryStr, OrganisationStageDo.class);
			List<OrganisationStageDo> resultList = query.getResultList();
			for (OrganisationStageDo omdo : resultList) {
				OrganisationStageDto omdto = exportDto(omdo);
				reqList.add(omdto);
			}

		}
		}catch (Exception e) {
			System.err.println("Error-OrganisationStageDao.viewOrganisationMaster:" + e.getMessage());
		}

		//dtoList.setOrganisationslist(reqList);
		return reqList;

	}


}



