package com.thoughtClan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.thoughtClan.exc.HotelException;
import com.thoughtClan.pojo.Hotel;

/**
 * This service interface is used to implement complex business level
 * 
 * @author Arunendra Kumar
 *
 */
@Service
@Transactional
public interface IHotelService {

	public List<Hotel> getAllHotels() throws HotelException;

	public boolean insertHotels() throws HotelException;

	public List<Hotel> searchHotel(String hotelName) throws HotelException;
	
	public List<Hotel> sortHotelsByPrice(String type) throws HotelException;
	
	
	
}
