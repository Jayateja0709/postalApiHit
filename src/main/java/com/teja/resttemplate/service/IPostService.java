package com.teja.resttemplate.service;

import com.teja.resttemplate.output.PostOfficeResponseBean;

public interface IPostService {

	public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String city);

}
