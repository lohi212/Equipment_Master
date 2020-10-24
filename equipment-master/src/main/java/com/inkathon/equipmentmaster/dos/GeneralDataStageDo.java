package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GENERAL_DATA_STAGE")
public class GeneralDataStageDo {
	
    @EmbeddedId
	EquipmentStagePK id;
	@Column(name="CLASS_TYPE")
	private String classType;
	
	@Column(name="OBJECT_TYPE")
	private String objectType;
	
	@Column(name="WEIGHT_in_kgs")
	private int weight;
	
	@Column(name="SIZE")
	private int size;
	
	@Column(name="ACQUISITION_VALUE")
	private int acquisitionValue;
	
	@Column(name="ACQUISITION_DATE")
	private Date acquisitionDate;
	
	@Column(name="MANUFACTURER")
	private String manufacturer;
	
	@Column(name="MANUFACTURER_COUNTRY")
	private String manufacturerCountry;
	
	@Column(name="MODEL_NO")
	private String modelNo;
	
	@Column(name="MANUFACTURER_PART_NO")
	private String manufacturerPartNo;
	
	@Column(name="CONSTR_YYMM")
	private String constr_yymm;
	public EquipmentStagePK getId() {
		return id;
	}


	public void setId(EquipmentStagePK id) {
		this.id = id;
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
		return "GeneralData [ id=" + id +" , ClassType =" + classType 
				+" , ObjectType =" + objectType + " , Weight ="+ weight + " , Size =" + size + " , AcquisitionValue ="+ acquisitionValue 
				+ " , AcquisitionDate =" + acquisitionDate + " , Manufacturer=" +manufacturer +" , ManufacturerCountry =" + manufacturerCountry +" , ModelNo" + modelNo
				+ " , ManufacturerPartNo =" + manufacturerPartNo + " , Constr_yymm =" + constr_yymm + "]";

	
	}	
}
