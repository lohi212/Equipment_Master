package com.inkathon.equipmentmaster.daos;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;

import com.inkathon.equipmentmaster.dos.GeneralDataMasterDo;
import com.inkathon.equipmentmaster.dos.LocationMasterDo;
import com.inkathon.equipmentmaster.dos.LocationMasterPK;
import com.inkathon.equipmentmaster.dos.LocationStageDo;
import com.inkathon.equipmentmaster.dtos.GeneralDataMasterDto;
import com.inkathon.equipmentmaster.dtos.LocationMasterDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;
@Repository
public class LocationMasterDao extends BaseDao{
	
	private LocationMasterDo importMasterDto(LocationStageDto dto) {
		LocationMasterDo locationMasterDo = null;
		if (dto != null) {
			locationMasterDo = new LocationMasterDo();
			LocationMasterPK pk=new LocationMasterPK();
			pk.setLocationId(dto.getLocationId());
			pk.setEquipmentId(dto.getEquipmentId());
			locationMasterDo.setId(pk);
			locationMasterDo.setManufacturePlant(dto.getManufacturePlant());
			locationMasterDo.setAbcIndicator(dto.getAbcIndicator());
			locationMasterDo.setSortField(dto.getSortField());
			locationMasterDo.setName(dto.getName());
			locationMasterDo.setStreet(dto.getStreet());
			locationMasterDo.setTelephone(dto.getTelephone());
			locationMasterDo.setFax(dto.getFax());
		}
		return locationMasterDo;
	}

	private LocationMasterDto exportMasterDto(LocationMasterDo entity) {
		LocationMasterDto locationMasterDto = null;
		if (entity != null) {
			locationMasterDto = new LocationMasterDto();
			locationMasterDto.setEquipmentId(entity.getId().getEquipmentId());
			locationMasterDto.setLocationId(entity.getId().getLocationId());
			locationMasterDto.setManufacturePlant(entity.getManufacturePlant());
			locationMasterDto.setAbcIndicator(entity.getAbcIndicator());
			locationMasterDto.setSortField(entity.getSortField());
			locationMasterDto.setName(entity.getName());
			locationMasterDto.setStreet(entity.getStreet());
			locationMasterDto.setTelephone(entity.getTelephone());
			locationMasterDto.setFax(entity.getFax());
		}
		return locationMasterDto;

	}
	
	public void saveLocationMaster(LocationStageDto dto) {
		try {
			getSession().saveOrUpdate(importMasterDto(dto));
		} catch (Exception e) {
			System.err.println("Error-LocationMasterDao.saveLocationMaster:" + e.getMessage());
		}

	}
	
	public List<Object>  getLocationMaster(String equipmentId) {
		// List<LocationMasterDto> dtoList = new ArrayList<>();
		List<Object> reqList = new ArrayList<>();
		try{

		String q = "select distinct l.id.locationId from LocationMasterDo l where l.id.equipmentId='" + equipmentId
				+ "'";
		Query<String> qu = getSession().createQuery(q, String.class);
		List<String> locList = qu.list();

		for (String str : locList) {

			String queryStr = "select s from LocationMasterDo s where s.id.equipmentId='" + equipmentId
					+ "' and s.id.locationId='" + str + "'  order by s.id.locationId desc";
			Query<LocationMasterDo> query = getSession().createQuery(queryStr, LocationMasterDo.class);
			List<LocationMasterDo> resultList = query.getResultList();
			for (LocationMasterDo lmdo : resultList) {
				LocationMasterDto lmdto = exportMasterDto(lmdo);
				reqList.add(lmdto);
			}

		}
		}catch (Exception e) {
			System.err.println("Error-LocationMasterDao.getLocationMaster:" + e.getMessage());
		}
		//dtoList.setLocationslist(reqList);
		return reqList;

	}

	

}
