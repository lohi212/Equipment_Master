 package com.inkathon.equipmentmaster.dtos;
import java.util.Date;

public class EquipmentMasterDto {
	private String equipmentId;
	private String equipmentName;
	private String category;
	private String description;
	private String status;
	private Date validFrom;
	private Date validTo;
	private boolean updatePending;
	
	public boolean isUpdatePending() {
		return updatePending;
	}

	public void setUpdatePending(boolean updatePending) {
		this.updatePending = updatePending;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		return "Equipment[equipmentId=" + equipmentId +", equipmentName=" + equipmentName + ", category=" + category +", status= " + status + ", description=" + description
				+ ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}
	
	
}
