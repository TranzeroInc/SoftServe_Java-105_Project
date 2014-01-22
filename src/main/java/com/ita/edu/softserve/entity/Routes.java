package com.ita.edu.softserve.entity;

import java.sql.Time;
import java.util.List;

import javax.persistence.*;

/**
 * @author admin
 * _
 *         The persistent class for the ROUTES database table.
 */
@Entity
@Table(name = "ROUTES")
@NamedQuery(name = Routes.FIND_BY_CODE, query = Routes.FIND_BY_CODE_QUERY)
@NamedQueries({
	@NamedQuery(name = Routes.FIND_ROUTERS_LIST_BY_STATION_ID_ARRIVING, query = Routes.FIND_ROUTERS_LIST_BY_STATION_ID_ARRIVING_QUERY),
	@NamedQuery(name = Routes.FIND_ROUTERS_LIST_BY_STATION_ID_DEPARTING, query = Routes.FIND_ROUTERS_LIST_BY_STATION_ID_DEPARTING_QUERY)})

public class Routes extends BaseEntity {

	public static final String FIND_BY_CODE = "Routes.findByCode";
	public static final String FIND_BY_CODE_QUERY = "SELECT u FROM Routes u WHERE u.routeCode = ?1";
	
	public static final String FIND_ROUTERS_LIST_BY_STATION_ID_ARRIVING = "Routes.findRoutersListByStationIdArriving";
	public static final String FIND_ROUTERS_LIST_BY_STATION_ID_ARRIVING_QUERY = " ";

	public static final String FIND_ROUTERS_LIST_BY_STATION_ID_DEPARTING= "Routes.findRoutersListByStationIdDeparting";
	public static final String FIND_ROUTERS_LIST_BY_STATION_ID_DEPARTING_QUERY = " ";

	@Id
	@Column(name = "ROUTEID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int routeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LINEID")
	private Lines lineId;

	@OneToMany(mappedBy = "routeId", fetch = FetchType.LAZY)
	private List<Stops> stops;

	@Column(name = "ROUTECODE", length = 20)
	private String routeCode;

	@Column(name = "STARTTIME")
	private Time startTime;

	/**
	 * Default Constructor
	 */
	public Routes() {
	}

	/**
	 * @return the routeId
	 */
	public int getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId
	 *            the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
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
	 * @return the stops
	 */
	public List<Stops> getStops() {
		return stops;
	}

	/**
	 * @param stops
	 *            the stops to set
	 */
	public void setStops(List<Stops> stops) {
		this.stops = stops;
	}

	/**
	 * @return the routeCode
	 */
	public String getRouteCode() {
		return routeCode;
	}

	/**
	 * @param routeCode
	 *            the routeCode to set
	 */
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	/**
	 * @return the startTime
	 */
	public Time getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

}
