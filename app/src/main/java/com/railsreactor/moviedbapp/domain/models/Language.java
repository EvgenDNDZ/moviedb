package com.railsreactor.moviedbapp.domain.models;

import com.google.gson.annotations.SerializedName;

public class Language {

	@SerializedName("name")
	private String name;

	@SerializedName("iso_639_1")
	private String isoCode;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIsoCode(String isoCode){
		this.isoCode = isoCode;
	}

	public String getIsoCode(){
		return isoCode;
	}
}