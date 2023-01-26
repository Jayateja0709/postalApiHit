
package com.teja.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teja.resttemplate.output.PostOfficeResponseBean;
import com.teja.resttemplate.service.IPostService;

@RestController
@RequestMapping("/postal")
public class PostDetailsController {

	@Autowired
	IPostService iPostService;

	@GetMapping(value = "/byCity", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PostOfficeResponseBean getPostalByCity(@RequestParam String city) {

		PostOfficeResponseBean response = iPostService.fetchPostOfficeDetailsByCity(city);
		return response;
	}

}
