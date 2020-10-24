package com.inkathon.equipmentmaster.daos;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inkathon.equipmentmaster.dos.EquipmentIdDo;
import com.inkathon.equipmentmaster.dos.EquipmentMasterDo;
import com.inkathon.equipmentmaster.dos.EquipmentStageDo;
import com.inkathon.equipmentmaster.dos.EquipmentStagePK;
import com.inkathon.equipmentmaster.dtos.EquipmentStageDto;
import com.inkathon.equipmentmaster.util.ServicesUtil;

@Repository
public class EquipmentStageDao extends BaseDao {

	private EquipmentStageDo importDto(EquipmentStageDto dto) {
		EquipmentStageDo equipmentStageDo = null;
		if (dto != null) {
			equipmentStageDo = new EquipmentStageDo();
			EquipmentStagePK pk = new EquipmentStagePK();
			pk.setEquipmentId(dto.getEquipmentId());
			pk.setVersion(dto.getVersion());
			equipmentStageDo.setId(pk);
			equipmentStageDo.setEquipmentName(dto.getEquipmentName());
			equipmentStageDo.setCategory(dto.getCategory());
			equipmentStageDo.setStatus(dto.getStatus());
			equipmentStageDo.setDescription(dto.getDescription());
			equipmentStageDo.setValidFrom(dto.getValidFrom());
			equipmentStageDo.setValidTo(dto.getValidTo());
		}
		return equipmentStageDo;

	}

	private EquipmentStageDto exportDto(EquipmentStageDo entity) {
		EquipmentStageDto equipmentStageDto = null;
		if (entity != null) {
			equipmentStageDto = new EquipmentStageDto();
			equipmentStageDto.setEquipmentId(entity.getId().getEquipmentId());
			equipmentStageDto.setVersion(entity.getId().getVersion());
			equipmentStageDto.setEquipmentName(entity.getEquipmentName());
			equipmentStageDto.setCategory(entity.getCategory());
			equipmentStageDto.setStatus(entity.getStatus());
			equipmentStageDto.setDescription(entity.getDescription());
			equipmentStageDto.setValidFrom(entity.getValidFrom());
			equipmentStageDto.setValidTo(entity.getValidTo());
		}
		return equipmentStageDto;
	}

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
			System.err.println("ERROR-EquipmentStageDao.getmaxVersionId():" + e.getMessage());
			return 0;
		}
	}

	
	public String saveEquipmentStage(EquipmentStageDto dto) {
		try {
			String eid = "";
			Integer latestVersion = 0;
			if (!ServicesUtil.isEmpty(dto.getEquipmentId())) {
				latestVersion = getmaxVersionId(dto.getEquipmentId());
				String queryStr = "select s from EquipmentMasterDo s where s.equipmentId='" + dto.getEquipmentId()
						+ "'";
				Query<EquipmentMasterDo> query = getSession().createQuery(queryStr, EquipmentMasterDo.class);
				EquipmentMasterDo resultRow = query.uniqueResult();
				if (!ServicesUtil.isEmpty(resultRow)) {
					Query q = getSession().createQuery(
							"UPDATE EquipmentMasterDo s SET s.updatePending =:updatePending where s.equipmentId =:equipmentId");
					q.setParameter("updatePending", true);
					q.setParameter("equipmentId", dto.getEquipmentId());
					int result = q.executeUpdate();

				}

			} else {
				EquipmentIdDo e = new EquipmentIdDo();
				eid = (String) getSession().save(e);
				System.err.println("eid:" + eid);
				dto.setEquipmentId(eid);
			}
			dto.setVersion(latestVersion + 1);
			EquipmentStageDo equipmentStageDo = importDto(dto);
			getSession().save(equipmentStageDo);
			return eid;
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.saveEquipmentStage:" + e.getMessage());
			return null;
		}
	}

	//////////////////////////////////////////////////////////

	public List<Object> getEquipmentStageList(Integer startIndex, Integer pageSize) {
		List<Object> equipmentStageDtoList = new ArrayList<>();
		List<EquipmentStageDto> esdl = new ArrayList<>();
		try {

			String queryStr = "select s from EquipmentStageDo s where s.id.version="
					+ "(select max(r.id.version) from EquipmentStageDo r where"
					+ " r.id.equipmentId=s.id.equipmentId)  order by s.id.equipmentId asc ";
			
			
			//without pagination all records
			Query<EquipmentStageDo> q = getSession().createQuery(queryStr, EquipmentStageDo.class);
			List<EquipmentStageDo> rList = q.getResultList();
			if (!ServicesUtil.isEmpty(rList)) {
				for (EquipmentStageDo esdo : rList) {
					EquipmentStageDto esdto = exportDto(esdo);
					esdl.add(esdto);
				}
			}

			//with pagination
			String qStr = "select s from EquipmentStageDo s where s.id.version="
					+ "(select max(r.id.version) from EquipmentStageDo r where"
					+ " r.id.equipmentId=s.id.equipmentId)  order by s.id.equipmentId desc ";

			Query<EquipmentStageDo> query = getSession().createQuery(qStr, EquipmentStageDo.class);

			if (startIndex != null && startIndex > -1)
				query.setFirstResult(startIndex);
			if (pageSize != null && pageSize > 0)
				query.setMaxResults(pageSize);
			List<EquipmentStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList)) {
				for (EquipmentStageDo esdo : resultList) {
					EquipmentStageDto esdto = exportDto(esdo);
					equipmentStageDtoList.add(esdto);
				}
			}
			


			insertToExcel(esdl);
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.getEquipmentStageList:" + e.getMessage());
			return null;
		}

		return equipmentStageDtoList;
	}

	public void insertToExcel(List<EquipmentStageDto> esdl) {
		String excelFilePath = "StageTableData.xls";
		try {

			writeExcel(esdl, excelFilePath);

		} catch (Exception e) {
			System.err.println("Error in -:insertToExcel" + e.getMessage());
		}

		try {

			FileInputStream fis = new FileInputStream(new File(excelFilePath));

			HSSFWorkbook wb = new HSSFWorkbook(fis);

			HSSFSheet sheet = wb.getSheetAt(0);

			FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
			for (Row row : sheet) {
				for (Cell cell : row) {
					switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:

						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_STRING:

						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					}
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.err.println("Error in -:insertToExcel in formulaevaluator " + e.getMessage());
		}

	}

	@SuppressWarnings("resource")
	public void writeExcel(List<EquipmentStageDto> equipmentStageDtoList, String excelFilePath) throws IOException {

		Workbook workbook = new HSSFWorkbook();

		Sheet sheet = workbook.createSheet();

		createHeaderRow(sheet);

		int rowCount = 1;

		for (EquipmentStageDto o : equipmentStageDtoList) {
			Row row = sheet.createRow(++rowCount);
			writeBook(o, row);
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);

			workbook.write(outputStream);

		} catch (Exception e) {
			System.err.println("Error in -:writeExcel" + e.getMessage());
		}

	}

	private void createHeaderRow(Sheet sheet) {

		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 8);
		cellStyle.setFont(font);

		Row row = sheet.createRow(0);

		Cell cellId = row.createCell(1);
		cellId.setCellStyle(cellStyle);
		cellId.setCellValue("EQUIPMENT_ID");

		Cell cellVersion = row.createCell(2);
		cellVersion.setCellStyle(cellStyle);
		cellVersion.setCellValue("VERSION");

		Cell cellName = row.createCell(3);
		cellName.setCellStyle(cellStyle);
		cellName.setCellValue("EQUIPMENT_NAME");

		Cell cellCategory = row.createCell(4);
		cellCategory.setCellStyle(cellStyle);
		cellCategory.setCellValue("CATEGORY");

		Cell cellStatus = row.createCell(5);
		cellStatus.setCellStyle(cellStyle);
		cellStatus.setCellValue("STATUS");

		Cell cellDesc = row.createCell(6);
		cellDesc.setCellStyle(cellStyle);
		cellDesc.setCellValue("DESCRIPTION");

		Cell cellValidFrom = row.createCell(7);
		cellValidFrom.setCellStyle(cellStyle);
		cellValidFrom.setCellValue("VALID_FROM");

		Cell cellValidTo = row.createCell(8);
		cellValidTo.setCellStyle(cellStyle);
		cellValidTo.setCellValue("VALID_TO");

	}

	private void writeBook(EquipmentStageDto o, Row row) {

		Cell cell = row.createCell(1);
		cell.setCellValue(o.getEquipmentId());

		cell = row.createCell(2);
		cell.setCellValue(o.getVersion());

		cell = row.createCell(3);
		cell.setCellValue(o.getEquipmentName());

		cell = row.createCell(4);
		cell.setCellValue(o.getCategory());

		cell = row.createCell(5);
		cell.setCellValue(o.getStatus());

		cell = row.createCell(6);
		cell.setCellValue(o.getDescription());

		cell = row.createCell(7);
		cell.setCellValue(o.getValidFrom());

		cell = row.createCell(8);
		cell.setCellValue(o.getValidTo());

	}
	/////////////////////////////////////////////

	public Long getEquipmentStageListMaxCount() {
		try {
			String queryStr = "select count(s) from EquipmentStageDo s where s.id.version="
					+ "(select max(r.id.version) from EquipmentStageDo r where"
					+ " r.id.equipmentId=s.id.equipmentId) ";
			Query<Long> query = getSession().createQuery(queryStr, Long.class);
			Long resultList = query.uniqueResult();
			return resultList;
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.getEquipmentStageListMaxCount:" + e.getMessage());

			return 0l;
		}
	}

	public List<Object> viewEquipmentStageListNotInMaster(Integer startIndex, Integer pageSize) {
		List<Object> equipmentStageDtoList = new ArrayList<>();
		try {
			String queryStr = "select s from EquipmentStageDo s where s.id.version="
					+ "(select max(r.id.version) from EquipmentStageDo r where"
					+ " r.id.equipmentId=s.id.equipmentId) and s.id.equipmentId not in (select m.equipmentId from EquipmentMasterDo m) order by s.id.equipmentId desc ";
			Query<EquipmentStageDo> query = getSession().createQuery(queryStr, EquipmentStageDo.class);
			if (startIndex != null && startIndex > -1)
				query.setFirstResult(startIndex);
			if (pageSize != null && pageSize > 0)
				query.setMaxResults(pageSize);
			List<EquipmentStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList)) {
				for (EquipmentStageDo esdo : resultList) {
					EquipmentStageDto esdto = exportDto(esdo);
					equipmentStageDtoList.add(esdto);
				}
			}
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.viewEquipmentStageListNotInMaster:" + e.getMessage());

		}

		return equipmentStageDtoList;
	}

	public Long viewEquipmentStageListMaxCount() {
		try {
			String queryStr = "select count(s) from EquipmentStageDo s where s.id.version="
					+ "(select max(r.id.version) from EquipmentStageDo r where"
					+ " r.id.equipmentId=s.id.equipmentId) and s.id.equipmentId not in (select m.equipmentId from EquipmentMasterDo m) ";
			Query<Long> query = getSession().createQuery(queryStr, Long.class);
			Long resultList = query.uniqueResult();
			return resultList;
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.viewEquipmentStageListMaxCount:" + e.getMessage());

			return 0l;
		}
	}

	public List<Object> viewEquipmentMasterList(Integer startIndex, Integer pageSize) {

		List<Object> equipmentMasterDtoList = new ArrayList<>();
		try {
			String queryStr = "select s from EquipmentStageDo s where s.id.version="
					+ "(select max(r.id.version) from EquipmentStageDo r where"
					+ " r.id.equipmentId=s.id.equipmentId) and s.id.equipmentId in "
					+ " (select m.equipmentId from EquipmentMasterDo m where m.updatePending=true) order by s.id.equipmentId desc";

			Query<EquipmentStageDo> query = getSession().createQuery(queryStr, EquipmentStageDo.class);
			if (startIndex != null && startIndex > -1)
				query.setFirstResult(startIndex);
			if (pageSize != null && pageSize > 0)
				query.setMaxResults(pageSize);
			List<EquipmentStageDo> resultList = query.getResultList();
			if (!ServicesUtil.isEmpty(resultList)) {
				for (EquipmentStageDo esdo : resultList) {
					EquipmentStageDto esdto = exportDto(esdo);
					equipmentMasterDtoList.add(esdto);
				}
			}
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.viewEquipmentMasterList:" + e.getMessage());

		}

		return equipmentMasterDtoList;
	}

	public Long viewEquipmentMasterListMaxCount() {
		try {
			String queryStr = "select count(s) from EquipmentMasterDo s where s.updatePending=true";
			Query<Long> query = getSession().createQuery(queryStr, Long.class);
			Long resultList = query.uniqueResult();
			return resultList;
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.viewEquipmentMasterListMaxCount:" + e.getMessage());

			return 0l;
		}
	}

	public List<Object> filterEquipmentStage(EquipmentStageDto dto, Integer startIndex, Integer pageSize) {

		List<Object> equipmentStageDtoList = new ArrayList<>();
		try {

			String queryStr = "select s from EquipmentStageDo s where s.id.version="

					+ "(select max(r.id.version) from EquipmentStageDo r where"

					+ " r.id.equipmentId=s.id.equipmentId) ";

			if (!ServicesUtil.isEmpty(dto.getEquipmentId()))

				queryStr += " and s.id.equipmentId='" + dto.getEquipmentId() + "'";

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

			Query<EquipmentStageDo> query = getSession().createQuery(queryStr, EquipmentStageDo.class);

			if (startIndex != null && startIndex > -1)

				query.setFirstResult(startIndex);

			if (pageSize != null && pageSize > 0)

				query.setMaxResults(pageSize);

			List<EquipmentStageDo> resultList = query.list();

			if (!ServicesUtil.isEmpty(resultList)) {

				for (EquipmentStageDo esdo : resultList) {

					System.err.println("esdo:" + esdo);

					EquipmentStageDto esdto = exportDto(esdo);

					equipmentStageDtoList.add(esdto);

				}

			}
		} catch (Exception e) {
			System.err.println("Error-EquipmentStageDao.filterEquipmentStage:" + e.getMessage());

		}

		return equipmentStageDtoList;

	}

	public Long filterEquipmentStageMaxCount(EquipmentStageDto dto) {

		try {

			// same query without order by OrderBY

			String queryStr = "select count(s) from EquipmentStageDo s where s.id.version="

					+ "(select max(r.id.version) from EquipmentStageDo r where"

					+ " r.id.equipmentId=s.id.equipmentId) ";

			if (!ServicesUtil.isEmpty(dto.getEquipmentId()))

				queryStr += " and s.id.equipmentId='" + dto.getEquipmentId() + "'";

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

			System.err.println("Error-EquipmentStageDao.-filterEquipmentStageMaxCount:" + e.getMessage());

			return 0l;

		}

	}
}
