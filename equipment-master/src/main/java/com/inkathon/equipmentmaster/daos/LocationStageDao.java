package com.inkathon.equipmentmaster.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.inkathon.equipmentmaster.dos.EquipmentStageDo;
import com.inkathon.equipmentmaster.dos.EquipmentStagePK;
import com.inkathon.equipmentmaster.dos.LocationStageDo;
import com.inkathon.equipmentmaster.dos.LocationStagePK;
import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDto;
import com.inkathon.equipmentmaster.dtos.LocationStageDtoList;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Repository
public class LocationStageDao extends BaseDao {

	private LocationStageDo importDto(LocationStageDto dto) {
		LocationStageDo locationStageDo = null;
		if (dto != null) {
			locationStageDo = new LocationStageDo();
			LocationStagePK pk = new LocationStagePK();
			pk.setEquipmentId(dto.getEquipmentId());
			pk.setVersion(dto.getVersion());
			pk.setLocationId(dto.getLocationId());
			locationStageDo.setId(pk);
			locationStageDo.setManufacturePlant(dto.getManufacturePlant());
			locationStageDo.setAbcIndicator(dto.getAbcIndicator());
			locationStageDo.setSortField(dto.getSortField());
			locationStageDo.setName(dto.getName());
			locationStageDo.setStreet(dto.getStreet());
			locationStageDo.setTelephone(dto.getTelephone());
			locationStageDo.setFax(dto.getFax());
		}
		return locationStageDo;
	}

	private LocationStageDto exportDto(LocationStageDo entity) {
		LocationStageDto locationStageDto = null;
		if (entity != null) {
			locationStageDto = new LocationStageDto();
			locationStageDto.setEquipmentId(entity.getId().getEquipmentId());
			locationStageDto.setVersion(entity.getId().getVersion());
			locationStageDto.setLocationId(entity.getId().getLocationId());
			locationStageDto.setManufacturePlant(entity.getManufacturePlant());
			locationStageDto.setAbcIndicator(entity.getAbcIndicator());
			locationStageDto.setSortField(entity.getSortField());
			locationStageDto.setName(entity.getName());
			locationStageDto.setStreet(entity.getStreet());
			locationStageDto.setTelephone(entity.getTelephone());
			locationStageDto.setFax(entity.getFax());
		}
		return locationStageDto;

	}

	public void saveLocationStage(LocationStageDto dto) {
		try {
			Integer latestVersion = 0;
			latestVersion = getmaxVersionId(dto.getEquipmentId(), dto.getLocationId());
			dto.setVersion(latestVersion + 1);
			System.err.println("dto:" + dto);
			LocationStageDo locationStageDo = importDto(dto);
			System.err.println("do:" + locationStageDo);

			getSession().save(locationStageDo);

		} catch (Exception e) {
			System.err.println("Error-LocationStageDao.saveLocationStage:" + e.getMessage());
		}

	}

	public List<Object> getLocationStage(String equipmentId) {
		// List<LocationStageDto> dtoList = new ArrayList<>();
		LocationStageDtoList dtoList = new LocationStageDtoList();
		List<Object> reqList = new ArrayList<>();
		try {

			String q = "select distinct l.id.locationId from LocationStageDo l where l.id.equipmentId='" + equipmentId
					+ "'";
			Query<String> qu = getSession().createQuery(q, String.class);
			List<String> locList = qu.list();

			for (String str : locList) {

				String queryStr = "select s from LocationStageDo s where s.id.equipmentId='" + equipmentId + "' ";
				queryStr += " and s.id.locationId='" + str + "' and  s.id.version = ";
				queryStr += "(select max(r.id.version) from LocationStageDo r where";
				queryStr += " r.id.equipmentId=s.id.equipmentId and r.id.locationId = s.id.locationId)  order by s.id.locationId desc ";
				Query<LocationStageDo> query = getSession().createQuery(queryStr, LocationStageDo.class);
				List<LocationStageDo> resultList = query.getResultList();
				for (LocationStageDo lsdo : resultList) {
					LocationStageDto lsdto = exportDto(lsdo);
					reqList.add(lsdto);
				}

			}
		} catch (Exception e) {
			System.err.println("Error-LocationStageDao.getLocationStage:" + e.getMessage());
		}
		// dtoList.setLocationslist(reqList);
		return reqList;

	}

	public Integer getmaxVersionId(String equipmentId, String locationId) {
		try {
			String queryStr = "select s from LocationStageDo s where s.id.equipmentId='" + equipmentId
					+ "' and s.id.locationId='" + locationId + "'";
			queryStr += "  order by s.id.version desc ";
			Query<LocationStageDo> query = getSession().createQuery(queryStr, LocationStageDo.class);
			List<LocationStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList))
				return resultList.get(0).getId().getVersion();
			else
				return 0;

		} catch (Exception e) {
			System.err.println("Logger-LocationStageDao.getmaxVersionId():" + e.getMessage());
			return 0;
		}
	}

	public List<Object> viewLocationStage(String equipmentId) {

		List<Object> reqList = new ArrayList<>();

		try {
			String q = "select distinct l.id.locationId from LocationStageDo l where l.id.equipmentId='" + equipmentId
					+ "'";
			Query<String> qu = getSession().createQuery(q, String.class);
			List<String> locList = qu.list();
			for (String str : locList) {

				String queryStr = "select s from LocationStageDo s where s.id.equipmentId='" + equipmentId + "' ";
				queryStr += " and s.id.locationId='" + str + "' and  s.id.version = ";
				queryStr += "(select max(r.id.version) from LocationStageDo r where";
				queryStr += " r.id.equipmentId=s.id.equipmentId and r.id.locationId = s.id.locationId)";
				queryStr += " and s.id.equipmentId not in (select m.id.equipmentId from LocationMasterDo m )order by s.id.locationId desc ";

				Query<LocationStageDo> query = getSession().createQuery(queryStr, LocationStageDo.class);
				List<LocationStageDo> resultList = query.getResultList();
				for (LocationStageDo lsdo : resultList) {
					LocationStageDto lsdto = exportDto(lsdo);
					reqList.add(lsdto);
				}

			}
		} catch (Exception e) {
			System.err.println("Error-LocationStageDao.viewLocationStage:" + e.getMessage());
		}
		return reqList;

	}

	public List<Object> viewLocationMaster(String equipmentId) {
		try {
			List<Object> reqList = new ArrayList<>();

			String q = "select distinct l.id.locationId from LocationMasterDo l where l.id.equipmentId='" + equipmentId
					+ "'";
			Query<String> qu = getSession().createQuery(q, String.class);
			List<String> locList = qu.list();
			for (String str : locList) {

				String queryStr = "select s from LocationStageDo s where s.id.equipmentId='" + equipmentId + "' ";
				queryStr += " and s.id.locationId='" + str + "' and  s.id.version = ";
				queryStr += "(select max(r.id.version) from LocationStageDo r where";
				queryStr += " r.id.equipmentId=s.id.equipmentId and r.id.locationId = s.id.locationId)";
				queryStr += " and s.id.equipmentId in (select m.equipmentId from EquipmentMasterDo m where m.updatePending=true and m.equipmentId='"
						+ equipmentId + "') order by s.id.locationId desc ";

				Query<LocationStageDo> query = getSession().createQuery(queryStr, LocationStageDo.class);
				List<LocationStageDo> resultList = query.getResultList();
				for (LocationStageDo lmdo : resultList) {
					LocationStageDto lmdto = exportDto(lmdo);
					reqList.add(lmdto);
				}

			}
			return reqList;
		} catch (Exception e) {
			System.err.println("Logger-LocationStageDao.viewLocationMaster():" + e.getMessage());
			return null;
		}

	}

}
