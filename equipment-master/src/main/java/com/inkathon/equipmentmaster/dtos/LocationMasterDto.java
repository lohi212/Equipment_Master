package com.inkathon.equipmentmaster.dtos;

public class LocationMasterDto {
	private String equipmentId;
	private String locationId;
    private String manufacturePlant;
    private String abcIndicator;
	private String sortField;
	private String name;
	private String street;
    private String telephone;
    private String fax;
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
	public String getManufacturePlant() {
		return manufacturePlant;
	}
	public void setManufacturePlant(String manufacturePlant) {
		this.manufacturePlant = manufacturePlant;
	}
	public String getAbcIndicator() {
		return abcIndicator;
	}
	public void setAbcIndicator(String abcIndicator) {
		this.abcIndicator = abcIndicator;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
    
	@Override
	public String toString() {
		return "Location [  EquipmentId = "+ equipmentId +" LocationId= " + locationId + "ManufacturePlant ="+
		manufacturePlant +" , ABCIndicator =" + abcIndicator + " , SortField =" + sortField +" , Name ="+
		name +" ,Street = "+ street +" , Telephone = "+ telephone +" , Fax ="+ fax +"]" ;
	}

}