package com.inkathon.equipmentmaster.daos;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base DAO Layer for adding common methods
 */

@Transactional
@PropertySource(value = { "classpath:hibernate.properties" })
public abstract class BaseDao {

	/** Session factory from Spring container. */
	@Autowired(required=true)
	private SessionFactory sessionFactory;
	
	Session session = null;
	/**
	 * Gets the current Session
	 * @return Session
	 */
	public Session getSession() {
		Session currentSession = null;
		if (!(this.session==null)) {
			currentSession = this.session;
		} else {
			currentSession = sessionFactory.getCurrentSession();
		}
		return currentSession;
	}
	
	
	
}