package com.inkathon.equipmentmaster.dtos;

import java.util.List;

public class OrganisationStageDtoList {
	
	private String equipmentId;

	private List<OrganisationStageDto> organisationslist;

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public List<OrganisationStageDto> getOrganisationslist() {
		return organisationslist;
	}

	public void setOrganisationslist(List<OrganisationStageDto> organisationslist) {
		this.organisationslist = organisationslist;
	}


}

/*package com.inkathon.equipmentmaster.dtos;

import java.util.List;

public class OrganisationStageDtoList {
	
	private List<OrganisationStageDto> organisationslist;

	public List<OrganisationStageDto> getOrganisationslist() {
		return organisationslist;
	}

	public void setOrganisationslist(List<OrganisationStageDto> organisationslist) {
		this.organisationslist = organisationslist;
	}


}
*/