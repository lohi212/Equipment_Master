package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ORGANISATION_STAGE")
public class OrganisationStageDo {
	
    @EmbeddedId
    OrganisationStagePK id;

	
	@Column(name="BUSINESS_AREA")
	private String businessArea;
	
	@Column(name="ASSET")
	private String asset;
	
	@Column(name="COST_CENTRE")
	private String costCentre;
	
	@Column(name="MAINTENANCE_PLANNING_PLANT")
	private String maintenancePlanningPlant;
	
	@Column(name="PLANNER_GROUP")
	private String plannerGroup;
	
	@Column(name="MAIN_WORKCTR")
	private String mainWorkCtr;
	
	@Column(name="CATALOG_PROFILE")
	private String catalogProfile;
	
	@Column(name="CURRENCY_KEY")
	private char currencyKey;
	
	@Column(name="MANUFACTURER_SERIAL_NO")
	private String manufacturerSerialNo;
	
	@Column(name="PLANT_ASSOCIATED")
	private String plantAssociated;
	



	public OrganisationStagePK getId() {
		return id;
	}

	public void setId(OrganisationStagePK id) {
		this.id = id;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getCostCentre() {
		return costCentre;
	}

	public void setCostCentre(String costCentre) {
		this.costCentre = costCentre;
	}

	public String getMaintenancePlanningPlant() {
		return maintenancePlanningPlant;
	}

	public void setMaintenancePlanningPlant(String maintenancePlanningPlant) {
		this.maintenancePlanningPlant = maintenancePlanningPlant;
	}

	public String getPlannerGroup() {
		return plannerGroup;
	}

	public void setPlannerGroup(String plannerGroup) {
		this.plannerGroup = plannerGroup;
	}

	public String getMainWorkCtr() {
		return mainWorkCtr;
	}

	public void setMainWorkCtr(String mainWorkCtr) {
		this.mainWorkCtr = mainWorkCtr;
	}

	public String getCatalogProfile() {
		return catalogProfile;
	}

	public void setCatalogProfile(String catalogProfile) {
		this.catalogProfile = catalogProfile;
	}


	public char getCurrencyKey() {
		return currencyKey;
	}

	public void setCurrencyKey(char currencyKey) {
		this.currencyKey = currencyKey;
	}

	public String getManufacturerSerialNo() {
		return manufacturerSerialNo;
	}

	public void setManufacturerSerialNo(String manufacturerSerialNo) {
		this.manufacturerSerialNo = manufacturerSerialNo;
	}

	public String getPlantAssociated() {
		return plantAssociated;
	}

	public void setPlantAssociated(String plantAssociated) {
		this.plantAssociated = plantAssociated;
	}
	

	@Override
	public String toString() {
		return "Organisation [  id=" + id+ "BusinessArea ="
				+ businessArea + " , Asset =" + asset + " , CostCentre =" + costCentre + " , maintenancePP ="
				+ maintenancePlanningPlant + " ,PlannerGroup = " + plannerGroup + " , MainWorkCtr = " + mainWorkCtr
				+ " , CatalogProfile =" + catalogProfile + "CurrencyKey =" + currencyKey + " , ManufacturerSerialNo ="
				+ manufacturerSerialNo + " , PlantAssociated = " + plantAssociated + "]";
	}


}
	