package com.demo.api.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppMVCController {
	@RequestMapping(value = "/addjson", method = RequestMethod.GET)
	public ModelAndView showJsonInputPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addjsonresponse");
		return mav;
	}
	
	@RequestMapping(value = "/savejson", method = RequestMethod.GET)
	public ModelAndView saveJson() {
		ModelAndView mav = new ModelAndView();
		//IOUtils.writeStringToFile(AppMVCController.class.getResourceAsStream(name), data);
		mav.setViewName("confirm");
		return mav;
	}
}
