package com.ejb.dao;

import javax.ejb.Local;

import com.book.response.PickResponse;

@Local
public interface PickDAOLocal {

	public PickResponse findPickById(long id);
	
}
