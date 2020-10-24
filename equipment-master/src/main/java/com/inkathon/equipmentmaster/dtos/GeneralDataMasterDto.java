package com.inkathon.equipmentmaster.dtos;

import java.util.Date;

public class GeneralDataMasterDto {
	private String equipmentId;
	private String classType;
	private String objectType;
	private int weight;
	private int size;
	private int acquisitionValue;
	private Date acquisitionDate;
	private String manufacturer;
	private String manufacturerCountry;
	private String modelNo;
	private String manufacturerPartNo;
    private String constr_yymm;

	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getAcquisitionValue() {
		return acquisitionValue;
	}
	public void setAcquisitionValue(int acquisitionValue) {
		this.acquisitionValue = acquisitionValue;
	}
	public Date getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getManufacturerCountry() {
		return manufacturerCountry;
	}
	public void setManufacturerCountry(String manufacturerCountry) {
		this.manufacturerCountry = manufacturerCountry;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getManufacturerPartNo() {
		return manufacturerPartNo;
	}
	public void setManufacturerPartNo(String manufacturerPartNo) {
		this.manufacturerPartNo = manufacturerPartNo;
	}
	public String getConstr_yymm() {
		return constr_yymm;
	}
	public void setConstr_yymm(String constr_yymm) {
		this.constr_yymm = constr_yymm;
	}

	@Override
	public String toString() {
		return "GeneralData[ EquipmentId="+ equipmentId +" , ClassType =" + classType 
				+" , ObjectType =" + objectType + " , Weight ="+ weight + " , Size =" + size + " , AcquisitionValue ="+ acquisitionValue 
				+ " , AcquisitionDate =" + acquisitionDate + " , Manufacturer=" +manufacturer +" , ManufacturerCountry =" + manufacturerCountry +" , ModelNo" + modelNo
				+ " , ManufacturerPartNo =" + manufacturerPartNo + " , Constr_yymm =" + constr_yymm + "]";
		}
}

	
	