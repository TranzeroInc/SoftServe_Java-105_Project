package com.ita.edu.softserve.service;

import java.util.List;

import com.ita.edu.softserve.entity.Stations;

/**
 * Service interface for stations.
 * @author �����
 */
public interface StationsService {
	/**
	 * Get list of Stations.
	 * @author �����
	 */
	public List<Stations> findAllStations();

}
