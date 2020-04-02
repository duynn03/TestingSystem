package com.vti.testing.config.document;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/v1/documents")
public class Swagger2Controller {

	/**
	 * This method is used for redirecting to swagger2-ui.html.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 7, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 7, 2019
	 * @return swagger-ui.html page
	 */
	@GetMapping()
	public String getDocuments() {
		return "redirect:/swagger-ui.html";
	}
}
