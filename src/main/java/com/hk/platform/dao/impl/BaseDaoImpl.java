package com.hk.platform.dao.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.hk.platform.dao.BaseDao;

@Repository
public class BaseDaoImpl implements BaseDao {
	
	
	@Autowired
	HibernateTemplate template;
	
	@Override
	public void saveOrUpdate(Collection entities) throws DataAccessException {
		saveOrUpdateAll(entities);
	}

	public void saveOrUpdateAll(final Collection<Object> entities) {{
		template.executeWithNativeSession(new HibernateCallback<Object>() {
		      public Object doInHibernate(Session session) throws HibernateException {
		        Collection<Object> va = Collections.unmodifiableCollection(entities);
		        Iterator<?> var3 = va.iterator();
		        while(var3.hasNext()) {
		          Object entity = var3.next();
		          session.saveOrUpdate(entity);
		        }
		        return null;
		      }
		    });
		  }}
	
}
