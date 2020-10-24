package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class OrganisationStagePK implements Serializable {
	
	
	private static final long serialVersionUID = -268284181847883300L;

	@Column(name="COMPANY_CODE")
	private String companyCode;

	@Column(name = "EQUIPMENT_ID",nullable = false)
	private String equipmentId;

	@Column(name = "VERSION",nullable = false)
	private int version;
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


}
