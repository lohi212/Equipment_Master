package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EQUIPMENT_STAGE")
public class EquipmentStageDo {
	
    @EmbeddedId
	EquipmentStagePK id;
    
	@Column(name = "EQUIPMENT_NAME")
	private String equipmentName;

	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name="STATUS")
	private String status;
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "VALID_FROM")
	private Date validFrom;

	@Column(name = "VALID_TO")
	private Date validTo;

	

	public EquipmentStagePK getId() {
		return id;
	}


	public void setId(EquipmentStagePK id) {
		this.id = id;
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

	public String getEquipmentName() {
		return equipmentName;
	}


	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}


	@Override
	public String toString() {
		return "EquipmentStageDo [id=" + id + ", equipmentName=" + equipmentName + ", category=" + category
				+ ", status=" + status + ", description=" + description + ", validFrom=" + validFrom + ", validTo="
				+ validTo + "]";
	}

	
}
