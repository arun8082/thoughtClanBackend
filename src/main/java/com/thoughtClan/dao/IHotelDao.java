package com.thoughtClan.dao;

import java.util.List;

import com.thoughtClan.exc.HotelException;
import com.thoughtClan.pojo.Hotel;

/**
 * This interface is responsible for data access i.e. has direct access to the database
 * 
 * @author Arunendra Kumar
 *
 */
public interface IHotelDao {
	public List<Hotel> getAllHotels() throws HotelException;
	public boolean insertHotels(List<Hotel> list) throws HotelException;
	public List<Hotel> searchHotel(String hotelName) throws HotelException;
	public List<Hotel> sortHotelsByPrice(String type) throws HotelException;
}
