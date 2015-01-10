package com.oner.querydsl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.mysema.query.codegen.BeanSerializer;
import com.mysema.query.sql.H2Templates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.codegen.MetaDataExporter;
import com.oner.querydsl.models.Users;
import com.oner.querydsl.tables.QUsers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueryDslTest {

	@Autowired
	QueryDslJdbcTemplate queryDslJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	SQLTemplates dialect;
	
	@Before
	public void init() {
		dialect = new H2Templates();
	}
	
	@Test
	public void initTables() throws SQLException {
		MetaDataExporter exporter = new MetaDataExporter();
		exporter.setPackageName("com.oner.querydsl.tables");
		exporter.setTargetFolder(new File("target/generated-sources/java"));
		exporter.setBeanSerializer(new BeanSerializer());
		exporter.setBeanPackageName("com.oner.querydsl.models");
		exporter.export(dataSource.getConnection().getMetaData());
	}

	@Test
	public void test1_nativeQueryDsl() throws SQLException {	
		QUsers qUsers = new QUsers("users");
		SQLQuery query = new SQLQuery(dataSource.getConnection(), dialect);
		
		List<Users> users = query.from(qUsers)
				.where(qUsers.enabled.eq(true))
				.list(qUsers);
		
		Assert.notEmpty(users);
	}

	@Test
	public void test2_springJdbcTemplate() throws SQLException {	
		List<Map<String, Object>> users = jdbcTemplate
				.queryForList("select * from users where enabled = ?", true);
		
		Assert.notEmpty(users);
	}

	@Test
	public void test3_springQueryDslJdbcTemplate() throws SQLException {
		QUsers qUsers = new QUsers("users");

		List<Users> users = queryDslJdbcTemplate.newSqlQuery().from(qUsers)
				.where(qUsers.enabled.eq(true))
				.list(qUsers);
		
		Assert.notEmpty(users);
	}

	@Test
	public void test4_springQueryDslJdbcTemplate() throws SQLException {
		QUsers qUsers = new QUsers("users");
		
		SQLQuery sqlQuery = queryDslJdbcTemplate.newSqlQuery()
						.from(qUsers)
						.where(qUsers.enabled.eq(true));
		
		List<Users> users = queryDslJdbcTemplate.query(sqlQuery, qUsers);
		
		Assert.notEmpty(users);
	}
}
