package com.thoughtClan.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thoughtClan.dao.IHotelDao;
import com.thoughtClan.exc.HotelException;
import com.thoughtClan.pojo.Hotel;
import com.thoughtClan.pojo.RoomType;

/**
 * This service interface is used to implement complex business level
 * 
 * @author Arunendra Kumar
 *
 */
@Service
@Transactional
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelDao dao;
	
	public List<Hotel> getAllHotels() throws HotelException{
		return dao.getAllHotels();
	}

	public boolean insertHotels() throws HotelException{
		List<Hotel> list = new ArrayList<Hotel>();
		String filePath = "resources/Singapore_Listings.csv";
		list = readCsv(filePath);
		return dao.insertHotels(list);
	}
	
	public static List<Hotel> readCsv(String file) throws HotelException {
		List<Hotel> list = new ArrayList<Hotel>();
		Hotel hotel;

		CSVParser csvParser=null;
		try {
			csvParser = new CSVParser(new FileReader("resources/Singapore_Listings.csv"), CSVFormat.DEFAULT);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<CSVRecord> records=null;
		try {
			records = csvParser.getRecords();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 0;
		for (CSVRecord csvRecord : records) {
			if (i++ == 0) {
				continue;
			}
			hotel = new Hotel();
			hotel.setName(csvRecord.get(0));
			hotel.setHostName(csvRecord.get(1));
			hotel.setNeighbourhoodGroup(csvRecord.get(2));
			hotel.setNeighbourhood(csvRecord.get(3));
			hotel.setLatitude(csvRecord.get(4));
			hotel.setLongitude(csvRecord.get(5));
			hotel.setRoomType(RoomType.valueOf(((csvRecord.get(6).replace(' ', '_')).replace('/', '_')).toUpperCase()));
			hotel.setPrice(Double.parseDouble(csvRecord.get(7)));

			list.add(hotel);
		}

		return list;
	}

	@Override
	public List<Hotel> searchHotel(String hotelName) throws HotelException{
		return dao.searchHotel(hotelName);
		
	}

	@Override
	public List<Hotel> sortHotelsByPrice(String type) throws HotelException {
		return dao.sortHotelsByPrice(type);
	}
	
}
