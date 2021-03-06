package com.ita.edu.softserve.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * The persistent class for the transports database table.
 * 
 * @author Roman
 */
@Entity
@Table(name = "transports")
@NamedQuery(name = Transports.TRANSPORTS_FIND_ALL, query = Transports.TRANSPORTS_FIND_ALL_QUERY)
public class Transports extends BaseEntity {

	static final String TRANSPORTS_FIND_ALL = "Transports.findAll";
	static final String TRANSPORTS_FIND_ALL_QUERY = "SELECT t FROM Transports t";

	@Id
	@Column(name = "TRANSPORTID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transportId;

	@Column(name = "TRANSPORTCODE", nullable = false, length = 20)
	private String code;

	@Column(name = "STARTTIME", nullable = false)
	private Time starttime;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROUTEID")
	private Routes routes;

	public Transports() {
		super();
	}

	public Transports(int transportid, String code, Time starttime, int route) {
		this();
		this.transportId = transportid;
		this.code = code;
		this.starttime = starttime;
		// this.route = route;
	}

	public int getTransportid() {
		return this.transportId;
	}

	public void setTransportid(int transportid) {
		this.transportId = transportid;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Time getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}

	public Routes getRoutes() {
		return routes;
	}

	public void setRoutes(Routes param) {
		this.routes = param;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(transportId)
		// .append(code)
				.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transports other = (Transports) obj;

		return new EqualsBuilder().append(transportId, other.transportId)
		// .append(code, other.code)
				.isEquals();
	}
}
