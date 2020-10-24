package com.inkathon.equipmentmaster.dos;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.inkathon.equipmentmaster.util.EquipReqIdGen;

@Entity
@Table(name="EQUIPMENT_ID")
public class EquipmentIdDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BP_REQUEST_SEQ")//REQ000000000
	@GenericGenerator(name = "BP_REQUEST_SEQ", strategy = "com.inkathon.equipmentmaster.util.EquipReqIdGen", parameters = {
			@Parameter(name = EquipReqIdGen.INCREMENT_PARAM, value = "1"),
			@Parameter(name = EquipReqIdGen.VALUE_PREFIX_PARAMETER, value = "EQ"),
			@Parameter(name = EquipReqIdGen.NUMBER_FORMAT_PARAMETER, value = "%08d") })

//	@Column(name = "PRE_STRING")
//	private String preString;
	
	@Column(name = "EQUIPMENT_ID_DO", nullable = false)
	private String equipmentId;

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	

}
