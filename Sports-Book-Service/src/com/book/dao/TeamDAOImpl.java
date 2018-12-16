package com.book.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.book.response.TeamResponse;
import com.util.SessionHelper;

public class TeamDAOImpl implements TeamDAO {

	@Override
	public TeamResponse getTeamById(long id) {
		Session ssn = null;
		Transaction tn = null;
		TeamResponse team = null;
		try {
			SessionFactory sf = SessionHelper.getSessionFactory();
			ssn = SessionHelper.getSessionFactory().getCurrentSession().isOpen()
					? SessionHelper.getSessionFactory().getCurrentSession()
					: SessionHelper.getSessionFactory().openSession();
			tn = ssn.beginTransaction();

			tn.begin();

			return team;
		} catch (Exception e) {
			throw e;
		} finally {
			if (ssn != null) {
				ssn.close();
			}
			if (tn != null) {
				tn.commit();
			}
		}
	}

}
