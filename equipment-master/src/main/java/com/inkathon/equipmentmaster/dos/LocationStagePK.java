package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocationStagePK implements Serializable{
	
	private static final long serialVersionUID = -7849413275122711206L;

	@Column(name="LOCATION_ID")
	private String locationId;
	
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
	public String getLocationId() {
		return locationId;
	}



	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}




}
