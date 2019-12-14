package com.thoughtClan.pojo;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")
/**
 * Purpose:
 * This class known as pojo contains properties of hotels and also used by hibernate ORM 
 * create table with properies column name
 *  
 * @author Arunendra Kumar
 *
 */
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hid;
	private String name;
	private String hostName;
	private String neighbourhoodGroup;
	private String neighbourhood;
	private String latitude;
	private String longitude;
	@Enumerated(EnumType.STRING)
	private RoomType roomType;
	private double price;
	
	public Hotel() {
		super();
	}

	public Hotel(Integer hid, String name, String hostName, String neighbourhoodGroup, String neighbourhood,
			String latitude, String longitude, RoomType roomType, double price) {
		super();
		this.hid = hid;
		this.name = name;
		this.hostName = hostName;
		this.neighbourhoodGroup = neighbourhoodGroup;
		this.neighbourhood = neighbourhood;
		this.latitude = latitude;
		this.longitude = longitude;
		this.roomType = roomType;
		this.price = price;
	}

	public Hotel(String name, String hostName, String neighbourhoodGroup, String neighbourhood, String latitude,
			String longitude, RoomType roomType, double price) {
		super();
		this.name = name;
		this.hostName = hostName;
		this.neighbourhoodGroup = neighbourhoodGroup;
		this.neighbourhood = neighbourhood;
		this.latitude = latitude;
		this.longitude = longitude;
		this.roomType = roomType;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Hotel [hid=" + hid + ", name=" + name + ", hostName=" + hostName + ", neighbourhoodGroup="
				+ neighbourhoodGroup + ", neighbourhood=" + neighbourhood + ", latitude=" + latitude + ", longitude="
				+ longitude + ", roomType=" + roomType + ", price=" + price + "]";
	}

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getNeighbourhoodGroup() {
		return neighbourhoodGroup;
	}

	public void setNeighbourhoodGroup(String neighbourhoodGroup) {
		this.neighbourhoodGroup = neighbourhoodGroup;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}	

}
