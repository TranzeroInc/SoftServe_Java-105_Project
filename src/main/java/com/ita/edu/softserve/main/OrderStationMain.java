package com.ita.edu.softserve.main;

import java.util.List;

import com.ita.edu.softserve.entity.Lines;
import com.ita.edu.softserve.entity.Stations;

import com.ita.edu.softserve.service.LinesManager;
import com.ita.edu.softserve.service.StationsManager;
import com.ita.edu.softserve.service.impl.LinesManagerImpl;
import com.ita.edu.softserve.service.impl.StationsManagerImpl;

import com.ita.edu.softserve.service.LinesService;
import com.ita.edu.softserve.service.StationsManager;


public class OrderStationMain{

	public static void main(String[] args) {
		
		

		LinesManager lsImpl = (LinesManager) LinesManagerImpl.getInstance();
		StationsManager stationsDAOImpl = (StationsManager) StationsManagerImpl.getInstance();

		LinesService lsImpl = (LinesService) appContext.getBean("linesService");
		StationsManager stationsDAOImpl = (StationsManager) appContext
				.getBean("stationsService");


		List<Stations> stationsList = stationsDAOImpl.findAllStations();
		Stations station1 = stationsList.get(4);
		Stations station2 = stationsList.get(16);
		System.out.println("FROM: " + station1.getStationName());
		System.out.println("TO:   " + station2.getStationName());
//		List<Lines> lines = lsImpl.getLinesByStation(station1);
		List<Lines> lines = lsImpl.getLinesTwoStationsCertainOrder(station1, station2);
		for (Lines line : lines) {
			System.out.println(line.getLineId() + " "
					+ line.getLineName());
		}
	}

}
