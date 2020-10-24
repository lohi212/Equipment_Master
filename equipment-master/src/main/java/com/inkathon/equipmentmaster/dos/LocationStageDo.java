package com.inkathon.equipmentmaster.dos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION_STAGE")
public class LocationStageDo{

    @EmbeddedId
    LocationStagePK id;
	
	@Column(name="MANUFACTURE_PLANT")
	private String manufacturePlant;
	
	@Column(name="ABC_INDICATOR")
	private String abcIndicator;
	
	@Column(name="SORT_FIELD")
	private String sortField;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="TELEPHONE")
	private String telephone;

	@Column(name="FAX")
	private String fax;

	public LocationStagePK getId() {
		return id;
	}



	public void setId(LocationStagePK id) {
		this.id = id;
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
		return "Location [  id=" + id  + "ManufacturePlant ="+
		manufacturePlant +" , ABCIndicator =" + abcIndicator + " , SortField =" + sortField +" , Name ="+
		name +" ,Street = "+ street +" , Telephone = "+ telephone +" , Fax ="+ fax +"]" ;
	}




}