package com.thoughtClan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thoughtClan.exc.HotelException;
import com.thoughtClan.pojo.Hotel;

/**
 * This class is responsible for data access i.e. has direct access to the database
 * implements IhotelDao
 * 
 * @author Arunendra Kumar
 *
 */
@Repository
public class HotelDaoImpl implements IHotelDao {
	
	@Autowired
	private EntityManager em;
	
	public List<Hotel> getAllHotels() throws HotelException{
		List<Hotel> list=new ArrayList<Hotel>();
		String jpql="select h from Hotel h";
		list=em.createQuery(jpql,Hotel.class).getResultList();		
		return list;
	}
	
	public boolean insertHotels(List<Hotel> list) throws HotelException{
		if(list.size()>=0) {
			for (Hotel hotel : list) {
				em.persist(hotel);
			}
			return true;
		}
		return false;
	}

	@Override
	public List<Hotel> searchHotel(String hotelName) throws HotelException {
		String jpql="select h from Hotel h where name like :hotelName";
		List<Hotel> list=em.createQuery(jpql,Hotel.class).setParameter("hotelName","%"+hotelName+"%").getResultList();
		return list;
	}

	@Override
	public List<Hotel> sortHotelsByPrice(String type) throws HotelException {
		String jpql;
		if(type.toUpperCase().equals("ASC") || type ==null || type == "") {
			jpql="select h from Hotel h order by price ASC";
		}else {
			jpql="select h from Hotel h order by price DESC";
		}
		List<Hotel> list=em.createQuery(jpql,Hotel.class).getResultList();
		return list;
	}
	
}
