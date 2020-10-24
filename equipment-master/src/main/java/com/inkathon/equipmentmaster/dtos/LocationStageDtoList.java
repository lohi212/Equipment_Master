package com.inkathon.equipmentmaster.dtos;

import java.util.ArrayList;
import java.util.List;

public class LocationStageDtoList {

	private String equipmentId;


	private List<LocationStageDto> locationslist;
	
	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}


	public List<LocationStageDto> getLocationslist() {
		return locationslist;
	}

	public void setLocationslist(List<LocationStageDto> locationslist) {
		this.locationslist = locationslist;
	}

}

/*
 * package com.inkathon.equipmentmaster.dtos;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * public class LocationStageDtoList {
 * 
 * private List<LocationStageDto> locationslist;
 * 
 * public List<LocationStageDto> getLocationslist() { return locationslist; }
 * 
 * public void setLocationslist(List<LocationStageDto> locationslist) {
 * this.locationslist = locationslist; }
 * 
 * }
 */