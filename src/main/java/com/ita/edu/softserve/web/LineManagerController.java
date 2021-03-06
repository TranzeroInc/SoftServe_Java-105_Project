package com.ita.edu.softserve.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ita.edu.softserve.entity.Stations;
import com.ita.edu.softserve.manager.LinesManager;
import com.ita.edu.softserve.manager.PostForMainPageManager;
import com.ita.edu.softserve.manager.impl.LinesManagerImpl;

@Controller
public class LineManagerController {

	@Autowired
	private LinesManager linesManager;
	
	@RequestMapping(value = "/lines", method = RequestMethod.GET)
	public String getLinesByTwoStations(Map<String, Object> model) {
		return "lines";
	}
	
	@RequestMapping(value = "/linesFind", method = RequestMethod.GET)
	public String getLinesByTwoStations(
			@RequestParam("stationName1") String stationName1,
			@RequestParam("stationName2") String stationName2,
			Map<String, Object> model) {
		
		if (stationName1.equals("") || stationName2.equals("")) {
			return "lines";
		}
		
		model.put("LinesList", linesManager.getLinesTwoStationsCertainOrder(
				stationName1, stationName2));
		
		return "lines";
	}
	
}
