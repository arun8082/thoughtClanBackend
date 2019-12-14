package com.thoughtClan.exc;

/**
 * This is custom exception used to raised runtime exception 
 * @author Arunendra Kumar
 *
 */
public class HotelException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public HotelException(String msg) {
		super(msg);
	}
}
