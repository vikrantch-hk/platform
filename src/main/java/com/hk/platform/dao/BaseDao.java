package com.hk.platform.dao;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public interface BaseDao{
	
	void saveOrUpdate(Collection entities) throws DataAccessException;
}
