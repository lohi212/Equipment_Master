package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocationMasterPK implements Serializable{
	
	
	private static final long serialVersionUID = 7256513886122230522L;

	@Column(name="LOCATION_ID")
	private String locationId;

	@Column(name = "EQUIPMENT_ID",nullable = false)
	private String equipmentId;

	
	public String getLocationId() {
		return locationId;
	}



	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}



	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

}
