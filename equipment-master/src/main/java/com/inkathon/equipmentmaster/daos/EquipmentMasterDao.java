package com.inkathon.equipmentmaster.daos;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
import java.util.ArrayList;
import com.inkathon.equipmentmaster.dos.EquipmentMasterDo;
import com.inkathon.equipmentmaster.dos.EquipmentStageDo;
import com.inkathon.equipmentmaster.dtos.EquipmentMasterDto;
import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Repository
public class EquipmentMasterDao extends BaseDao{
	
	private EquipmentMasterDo importMasterDto(EquipmentStageDto dto) {
		EquipmentMasterDo equipmentMasterDo = null;
		if(dto!=null)
		{
		equipmentMasterDo = new EquipmentMasterDo();
		equipmentMasterDo.setEquipmentId(dto.getEquipmentId());
		equipmentMasterDo.setEquipmentName(dto.getEquipmentName());
		equipmentMasterDo.setCategory(dto.getCategory());
		equipmentMasterDo.setStatus(dto.getStatus());
		equipmentMasterDo.setDescription(dto.getDescription());
		equipmentMasterDo.setValidFrom(dto.getValidFrom());
		equipmentMasterDo.setValidTo(dto.getValidTo());
		equipmentMasterDo.setUpdatePending(false);
		}

		return equipmentMasterDo;
	}


	private EquipmentMasterDto exportMasterDto(EquipmentMasterDo entity) {
		EquipmentMasterDto equipmentMasterDto = null;
		if (entity != null) {
			equipmentMasterDto = new EquipmentMasterDto();
			equipmentMasterDto.setEquipmentId(entity.getEquipmentId());
			equipmentMasterDto.setEquipmentName(entity.getEquipmentName());
			equipmentMasterDto.setCategory(entity.getCategory());
			equipmentMasterDto.setDescription(entity.getDescription());
			equipmentMasterDto.setStatus(entity.getStatus());
			equipmentMasterDto.setValidFrom(entity.getValidFrom());
			equipmentMasterDto.setValidTo(entity.getValidTo());
			equipmentMasterDto.setUpdatePending(entity.isUpdatePending());

		}
		return equipmentMasterDto;

	}
/*	public void saveEquipmentMaster(EquipmentStageDto dto) {
		try {
			getSession().saveOrUpdate(importMasterDto(dto));
		} catch (Exception e) {
			System.err.println("Error-EquipmentMasterDao.saveEquipmentMaster:" + e.getMessage());
		}

	}
	
	*/
	public Integer getmaxVersionId(String equipmentId) {
		try {
			String queryStr = "select s from EquipmentStageDo s where s.id.equipmentId='" + equipmentId + "'";
			queryStr += "  order by s.id.version desc ";
			Query<EquipmentStageDo> query = getSession().createQuery(queryStr, EquipmentStageDo.class);
			List<EquipmentStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList))
				return resultList.get(0).getId().getVersion();
			else
				return 0;

		} catch (Exception e) {
			System.err.println("Logger-EquipmentStageDao.getmaxVersionId():" + e.getMessage());
			return 0;
		}
	}

	public String saveEquipmentMaster(EquipmentStageDto dto) {
		String s="";

		try {
			Integer v=getmaxVersionId(dto.getEquipmentId());
			if(v==dto.getVersion()){
			getSession().saveOrUpdate(importMasterDto(dto));
			}else{
				s+="dont update";
			}
			
		} catch (Exception e) {
			System.err.println("Error-EquipmentMasterDao.saveEquipmentMaster:" + e.getMessage());
		}
      
		return s;
	}

	
	public List<Object> getEquipmentMasterList(Integer startIndex, Integer pageSize) {
		List<Object> equipmentMasterDtoList = new ArrayList<>();
		try{
		String queryStr = "select s from EquipmentMasterDo s order by s.equipmentId desc ";
		Query<EquipmentMasterDo> query = getSession().createQuery(queryStr, EquipmentMasterDo.class);
		if (startIndex != null && startIndex > -1)
			query.setFirstResult(startIndex);
		if (pageSize != null && pageSize > 0)
			query.setMaxResults(pageSize);
		List<EquipmentMasterDo> resultList = query.getResultList();
		if (!ServicesUtil.isEmpty(resultList)) {
			for (EquipmentMasterDo esdo : resultList) {
				EquipmentMasterDto esdto = exportMasterDto(esdo);
				equipmentMasterDtoList.add(esdto);
			}
		}
		} catch (Exception e) {
			System.err.println("Error-EquipmentMasterDao.getEquipmentMasterList:" + e.getMessage());
		}

		return equipmentMasterDtoList;
	}
	public Long getEquipmentMasterListMaxCount() {
		try {
			String queryStr = "select count(s) from EquipmentMasterDo s";
			Query<Long> query = getSession().createQuery(queryStr, Long.class);
			Long resultList = query.uniqueResult();
			return resultList;
		} catch (Exception e) {
			System.err.println("Error-EquipmentMasterDao.getEquipmentMasterListMaxCount:" + e.getMessage());

			return 0l;
		}
	}
	
	
	
	public List<Object> filterEquipmentMaster(EquipmentMasterDto dto, Integer startIndex, Integer pageSize) {

		List<Object> equipmentMasterDtoList = new ArrayList<>();
		try{

		String queryStr = "select s from EquipmentMasterDo s where 1=1 ";

		if (!ServicesUtil.isEmpty(dto.getEquipmentId()))

			queryStr += " and s.equipmentId='" + dto.getEquipmentId() + "'";

		if (!ServicesUtil.isEmpty(dto.getEquipmentName()))

			queryStr += " and s.equipmentName='" + dto.getEquipmentName() + "'";

		if (!ServicesUtil.isEmpty(dto.getCategory()))

			queryStr += " and s.category='" + dto.getCategory() + "'";

		if (!ServicesUtil.isEmpty(dto.getStatus()))

			queryStr += " and s.status='" + dto.getStatus() + "'";

		if (!ServicesUtil.isEmpty(dto.getDescription()))

			queryStr += " and s.description like '%" + dto.getDescription() + "%'";

		if (!ServicesUtil.isEmpty(dto.getValidFrom()))

			queryStr += " and (s.validFrom>='" + ServicesUtil.dateToStringWithoutT(dto.getValidFrom())
					+ "' and s.validTo<='" + ServicesUtil.dateToStringWithout(dto.getValidTo()) + "')";

		System.err.println("queryStr:" + queryStr);

		Query<EquipmentMasterDo> query = getSession().createQuery(queryStr, EquipmentMasterDo.class);

		if (startIndex != null && startIndex > -1)

			query.setFirstResult(startIndex);

		if (pageSize != null && pageSize > 0)

			query.setMaxResults(pageSize);

		List<EquipmentMasterDo> resultList = query.list();

		if (!ServicesUtil.isEmpty(resultList)) {

			for (EquipmentMasterDo esdo : resultList) {

				System.err.println("esdo:" + esdo);

				EquipmentMasterDto esdto = exportMasterDto(esdo);

				equipmentMasterDtoList.add(esdto);

			}

		}
		}catch (Exception e) {
			System.err.println("Error-EquipmentMasterDao.filterEquipmentMaster:" + e.getMessage());

		}

		return equipmentMasterDtoList;

	}

	public Long filterEquipmentMasterMaxCount(EquipmentMasterDto dto) {

		try {

			// same query without order by OrderBY

			String queryStr = "select count(s) from EquipmentMasterDo s where 1=1";

			if (!ServicesUtil.isEmpty(dto.getEquipmentId()))

				queryStr += " and s.equipmentId='" + dto.getEquipmentId() + "'";

			if (!ServicesUtil.isEmpty(dto.getEquipmentName()))

				queryStr += " and s.equipmentName='" + dto.getEquipmentName() + "'";

			if (!ServicesUtil.isEmpty(dto.getCategory()))

				queryStr += " and s.category='" + dto.getCategory() + "'";

			if (!ServicesUtil.isEmpty(dto.getStatus()))

				queryStr += " and s.status='" + dto.getStatus() + "'";

			if (!ServicesUtil.isEmpty(dto.getDescription()))

				queryStr += " and s.description like '%" + dto.getDescription() + "%'";

			if (!ServicesUtil.isEmpty(dto.getValidFrom()))

				queryStr += " and (s.validFrom>='" + ServicesUtil.dateToStringWithoutT(dto.getValidFrom())
						+ "' and s.validTo<='" + ServicesUtil.dateToStringWithout(dto.getValidTo()) + "')";

			System.err.println("queryStr:" + queryStr);

			Query<Long> query = getSession().createQuery(queryStr, Long.class);

			Long resultList = query.uniqueResult();

			return resultList;

		} catch (Exception e) {

			System.err.println("Ex-filterEquipmentMasterMaxCount:" + e.getMessage());

			return 0l;

		}

	}

	
	}
