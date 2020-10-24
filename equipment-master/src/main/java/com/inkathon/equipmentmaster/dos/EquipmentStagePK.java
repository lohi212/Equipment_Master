package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EquipmentStagePK implements Serializable {

	private static final long serialVersionUID = -3785040067481107990L;

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

	@Override
	public String toString() {
		return "EquipmentStagePK [equipmentId=" + equipmentId + ", version=" + version + "]";
	}
	
	

}
