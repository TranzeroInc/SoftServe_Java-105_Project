package com.ita.edu.softserve.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ita.edu.softserve.dao.AbstractDAO;
import com.ita.edu.softserve.dao.LinesDAO;
import com.ita.edu.softserve.entity.Lines;
import com.ita.edu.softserve.entity.Stations;

/**
 * 
 * @author iryna
 * 
 */
@Repository
public class LinesDAOImpl extends AbstractDAO<Lines> implements LinesDAO {

	@Override
	public Lines findByName(String lineName) {
		Query query = entityManager.createNamedQuery(Lines.FIND_BY_NAME)
				.setParameter(1, lineName);
		return (Lines) query.getSingleResult();
	}

	
	public List<Lines> getLinesTwoStationsCertainOrder(
			Stations station1, Stations station2) {
		Query query = entityManager
				.createNamedQuery(Lines.GET_LINES_TWO_STATIONS_CERTAIN_ORDER)
				.setParameter("station1", station1)
				.setParameter("station2", station2);
		@SuppressWarnings("unchecked")
		List<Lines> listOfLines = query.getResultList();

		return listOfLines;
	}
	
	/**
	 * 
	 * @return listOfLines
	 */
	public List<Lines> getFullLines(){
		Query query = entityManager.createNamedQuery(Lines.GET_FULL_LINES);
		@SuppressWarnings("unchecked")
		List<Lines> listOfLines = query.getResultList();
		return listOfLines;
	}
	
	/**
	 * @param stationName
	 * @return List of lines which has certain station
	 */
	public List<Lines> getLinesByStation(String stationName){
		Query query = entityManager.createNamedQuery(Lines.GET_LINES_BY_STATION).setParameter("CERTAINSTATIONNAME", stationName);
		@SuppressWarnings("unchecked")
		List <Lines> lines = query.getResultList();
		return lines;
		
	}


	
	@Override
	protected Class<Lines> getEntityClass() {
		
		return Lines.class;
	}
}
