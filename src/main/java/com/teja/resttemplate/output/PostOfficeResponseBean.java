package com.teja.resttemplate.output;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PostOfficeResponseBean {

	@JsonProperty("Message")
	private String message;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("PostOffice")
	private List<PostOfficeDetailsBean> postoffice;

}
