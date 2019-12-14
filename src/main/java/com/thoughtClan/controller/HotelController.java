package com.thoughtClan.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thoughtClan.exc.HotelException;
import com.thoughtClan.pojo.Hotel;
import com.thoughtClan.service.IHotelService;

/**
 * This Controller is the main handler class which accept all the request then
 * get the data and revert back
 * 
 * @author Arunendra kumar
 *
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class HotelController {

	@Autowired
	private IHotelService service;

	public HotelController() {
		System.out.println("Def constr of controller");
	}
	
	/**
	 * Get all the hotels list 
	 * @return List<Hotel>
	 */
	@GetMapping("getAll")
	public List<Hotel> getAllHotels() {
		try {
			return service.getAllHotels();
		} catch (HotelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *  Read the CSV file and insert the CSV data into the database
	 * @return true->success
	 * 			False->failed
	 */
	@GetMapping("insert")
	public boolean insertHotels() throws HotelException {		
		return service.insertHotels();
	}
	
	/**
	 * Read the name and find all the hotels details which has that keyword in name
	 * @param hotelName
	 * @return List<Hotel>
	 * @throws HotelException
	 */
	@GetMapping("getAll/{hotelName}")
	public List<Hotel> searchHotel(@PathVariable("hotelName") String hotelName) throws HotelException{
		return service.searchHotel(hotelName);
	}
	
	@GetMapping("getAllsorted/{sortBy}")
	public List<Hotel> sortedHotelsList(@PathVariable("sortBy") String sortBy) throws HotelException{
		return service.sortHotelsByPrice(sortBy);
	}
}
