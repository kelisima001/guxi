package com.smart.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class DatabaseDetector extends HibernateJpaVendorAdapter {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private DataSource dataSource;

	/**
	 * 返回数据库类型 {@link Database}，默认返回 id为dataSource的数据源的数据库类型
	 */
	@Override
	public Database getDatabase() {
		Database database = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			DatabaseMetaData meta = conn.getMetaData();
			String databaseName = meta.getDatabaseProductName();
			database = determineDatabase(databaseName);
			logger.info("Database:{}", databaseName);
			return database;
		} catch (SQLException e) {
			logger.error("Init  DatabaseMetadata failed!", e);
			throw new RuntimeException(e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error("Close Connection error:", e);
			}
		}
	}

	/**
	 * @param databaseName
	 * @return Database
	 */
	private Database determineDatabase(String databaseName) {
		if (databaseName.indexOf("Microsoft SQL Server") >= 0) {
			return Database.SQL_SERVER;
		} else if (databaseName.indexOf("Oracle") >= 0) {
			return Database.ORACLE;
		} else if (databaseName.indexOf("Derby") >= 0) {
			return Database.DERBY;
		} else if (databaseName.indexOf("MySQL") >= 0) {
			return Database.MYSQL;
		} else if (databaseName.indexOf("H2") >= 0) {
			return Database.H2;
		} else {
			//TODO 添加其他数据库支持
			return Database.DERBY;
		}
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
