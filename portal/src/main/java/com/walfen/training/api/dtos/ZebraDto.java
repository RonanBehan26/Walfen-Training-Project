package com.walfen.training.api.dtos;

public class ZebraDto extends AnimalDto {

	private String country;

	@Override
	public String getType() {
		return "Zebra";
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
