package com.railsreactor.moviedbapp.domain.models;

import com.google.gson.annotations.SerializedName;


public class Country {

	@SerializedName("name")
	private String name;

	@SerializedName("iso_3166_1")
	private String isoCode;

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public String getIsoCode() {
		return isoCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}