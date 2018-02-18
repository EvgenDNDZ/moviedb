package com.railsreactor.moviedbapp.data.net.response;

import com.google.gson.annotations.SerializedName;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class Dates{

	@SerializedName("maximum") private String maximum;

	@SerializedName("minimum") private String minimum;

	public void setMaximum(String maximum){
		this.maximum = maximum;
	}

	public String getMaximum(){
		return maximum;
	}

	public void setMinimum(String minimum){
		this.minimum = minimum;
	}

	public String getMinimum(){
		return minimum;
	}
}