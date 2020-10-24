package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class OrganisationMasterPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2050194084651058260L;
	
	@Column(name = "EQUIPMENT_ID",nullable = false)
	private String equipmentId;
	
	@Column(name="COMPANY_CODE")
	private String companyCode;

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}


}
