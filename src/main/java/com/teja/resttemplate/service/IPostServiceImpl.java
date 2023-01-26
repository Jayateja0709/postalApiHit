package com.teja.resttemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teja.resttemplate.output.PostOfficeDetailsBean;
import com.teja.resttemplate.output.PostOfficeResponseBean;

@Service("postalServiceImpl")
public class IPostServiceImpl implements IPostService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public PostOfficeResponseBean fetchPostOfficeDetailsByCity(String cityValue) {

		String url = "https://api.postalpincode.in/postoffice/{city}";
		url = url.replace("{city}", cityValue);

		ResponseEntity<PostOfficeResponseBean[]> postalResponseEntity = restTemplate.getForEntity(url,
				PostOfficeResponseBean[].class);

		System.out.println("Response code is " + postalResponseEntity.getStatusCodeValue());

		PostOfficeResponseBean[] responseBeans = postalResponseEntity.getBody();

		for (PostOfficeResponseBean postOfficeResponseBean : responseBeans) {
			List<PostOfficeDetailsBean> postoffice = postOfficeResponseBean.getPostoffice();

			for (PostOfficeDetailsBean pob : postoffice) {
				System.out.println(pob.getName() + " " + pob.getCountry() + " " + pob.getPincode());

			}

		}
		return responseBeans[0];
	}

}
