package com.smart.dao;

import org.hibernate.dialect.DB2Dialect;
import org.hibernate.dialect.DerbyTenSevenDialect;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.dialect.InformixDialect;
import org.hibernate.dialect.Oracle9iDialect;
import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.SybaseDialect;
import org.springframework.orm.jpa.vendor.Database;

public class DialectUtil {

	public static Dialect getDatabaseDialect(Database database) throws Exception {
		switch (database) {
		case DB2:
			return DB2Dialect.class.newInstance();
		case DERBY:
			return DerbyTenSevenDialect.class.newInstance();
		case H2:
			return H2Dialect.class.newInstance();
		case HSQL:
			return HSQLDialect.class.newInstance();
		case INFORMIX:
			return InformixDialect.class.newInstance();
		case ORACLE:
			return Oracle9iDialect.class.newInstance();
		case POSTGRESQL:
			return PostgreSQL82Dialect.class.newInstance();
		case SQL_SERVER:
			return SQLServerDialect.class.newInstance();
		case SYBASE:
			return SybaseDialect.class.newInstance();
		default:
			return null;
		}
	}

}
