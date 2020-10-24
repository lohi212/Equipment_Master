package com.inkathon.equipmentmaster.dos;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPMENT_MASTER")
public class EquipmentMasterDo {
	@Id
	@Column(name="EQUIPMENT_ID")
	private String equipmentId;
	
	@Column(name = "EQUIPMENT_NAME")
	private String equipmentName;

	
	@Column(name="CATEGORY")
	private String category;
	
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="VALID_FROM")
	private Date validFrom;
	
	@Column(name="VALID_TO")
	private Date validTo;
	
	@Column(name="UPDATE_PENDING")
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
		return "Equipment [equipmentId=" + equipmentId +", equipmentName=" + equipmentName +" , category=" + category +", status= " + status + ", description=" + description
				+ ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}
	
	
	
}

