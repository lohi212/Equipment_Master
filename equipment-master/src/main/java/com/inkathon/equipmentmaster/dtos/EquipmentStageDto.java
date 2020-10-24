package com.inkathon.equipmentmaster.dtos;

import java.util.Date;

public class EquipmentStageDto {
	private String equipmentId;
	private String equipmentName;
	private int version;
	private String category;
	private String status;
	private String description;
	private Date validFrom;
	private Date validTo;



	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getEquipmentName() {
		return equipmentName;
	}


	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", version=" + version + ", category=" + category
				+ ", status= " + status + ", description=" + description + ", validFrom=" + validFrom + ", validTo="
				+ validTo + "]";
	}

}
