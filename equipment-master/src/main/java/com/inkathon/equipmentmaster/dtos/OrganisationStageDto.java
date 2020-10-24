package com.inkathon.equipmentmaster.dtos;

public class OrganisationStageDto {
	private String equipmentId;
	private int version;
	private String companyCode;
	private String businessArea;
	private String asset;
	private String costCentre;
	private String maintenancePlanningPlant;
	private String plannerGroup;
	private String mainWorkCtr;
	private String catalogProfile;
	private char currencyKey;
	private String manufacturerSerialNo;
	private String plantAssociated;
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
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "Organisation [ EquipmentId = " + equipmentId +" , Version = " + version+ " , CompanyCode = " + companyCode + "BusinessArea ="
				+ businessArea + " , Asset =" + asset + " , CostCentre =" + costCentre + " , maintenancePP ="
				+ maintenancePlanningPlant + " ,PlannerGroup = " + plannerGroup + " , MainWorkCtr = " + mainWorkCtr
				+ " , CatalogProfile =" + catalogProfile + "CurrencyKey =" + currencyKey + " , ManufacturerSerialNo ="
				+ manufacturerSerialNo + " , PlantAssociated = " + plantAssociated + "]";
	}




}

