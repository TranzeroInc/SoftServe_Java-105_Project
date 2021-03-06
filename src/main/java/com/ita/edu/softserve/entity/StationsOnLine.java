package com.ita.edu.softserve.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author admin
 * 
 *         The persistent class for the STATIONSONLINE database table.
 */

@Entity
@Table(name = "stationsonlines")
@NamedQuery(name = StationsOnLine.FIND_BY_STATIONS_ID, query = StationsOnLine.FIND_BY_STATIONS_ID_QUERY)
public class StationsOnLine extends BaseEntity {


	public static final String FIND_BY_STATIONS_ID = "StationsOnLine.findByStationID";
//	public static final String FIND_BY_STATIONS_ID_QUERY ="SELECT u FROM StationsOnLine u WHERE u.stationId = ?1";
//	public static final String FIND_BY_STATIONS_ID_QUERY ="SELECT stl FROM StationsOnLine stl INNER JOIN stl.stationId s WHERE s.stationId = ?1";
	public static final String FIND_BY_STATIONS_ID_QUERY ="SELECT stl FROM StationsOnLine stl WHERE stl.stationId.stationId = ?1";

	@Id
	@Column(name = "STATIONONLINEID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stationOnLineId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LINEID")
	private Lines lineId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "STATIONID")
	private Stations stationId;

	@OneToMany(mappedBy = "stationOnLineId", fetch = FetchType.LAZY)
	private Set<Stops> stops;

	@Column(name = "STATIONORDERNUM")
	private int stationOrderNum;

	/**
	 * Default Constructor
	 */
	public StationsOnLine() {
	}

	/**
	 * @return the stationOnLineId
	 */
	public int getStationOnLineId() {
		return stationOnLineId;
	}

	/**
	 * @param stationOnLineId
	 *            the stationOnLineId to set
	 */
	public void setStationOnLineId(int stationOnLineId) {
		this.stationOnLineId = stationOnLineId;
	}

	/**
	 * @return the lineId
	 */
	public Lines getLineId() {
		return lineId;
	}

	/**
	 * @param lineId
	 *            the lineId to set
	 */
	public void setLineId(Lines lineId) {
		this.lineId = lineId;
	}

	/**
	 * @return the stationId
	 */
	public Stations getStationId() {
		return stationId;
	}

	/**
	 * @param stationId
	 *            the stationId to set
	 */
	public void setStationId(Stations stationId) {
		this.stationId = stationId;
	}

	/**
	 * @return the stops
	 */
	public Set<Stops> getStops() {
		return stops;
	}

	/**
	 * @param stops
	 *            the stops to set
	 */
	public void setStops(Set<Stops> stops) {
		this.stops = stops;
	}

	/**
	 * @return the stationOrderNum
	 */
	public int getStationOrderNum() {
		return stationOrderNum;
	}

	/**
	 * @param stationOrderNum
	 *            the stationOrderNum to set
	 */
	public void setStationOrderNum(int stationOrderNum) {
		this.stationOrderNum = stationOrderNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stationOnLineId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StationsOnLine other = (StationsOnLine) obj;
		if (stationOnLineId != other.stationOnLineId)
			return false;
		return true;
	}

}
