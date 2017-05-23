//Program 1 Using JDBC without Spring
package org.nithish.model;

public class Circle {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Circle(int cirlceId,String name){
		setId(cirlceId);
		setName(name);
	}
}

package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

import org.nithish.model.Circle;

public class JdbcDaoImpl {

	public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		String driver="org.apache.derby.jdbc.ClientDriver";
		Class.forName(driver).newInstance();
		conn=DriverManager.getConnection("jdbc:derby://localhost:1527/db");
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		
	}
	
}

package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;

public class JdbcDemo {

	public static void main(String args[]){
		Circle circle=new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}
}

//program2 Adding Spring and DataSource Configuration
package org.nithish.model;

public class Circle {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Circle(int cirlceId,String name){
		setId(cirlceId);
		setName(name);
	}
}


package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	@Autowired
	private DataSource dataSource;
	public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}

package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());
	}
}
<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context"
	>

	<context:annotation-config/>
	<context:component-scan base-package="org.nithish"/>
	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	<property name="driverClassName" value="org.apache.derby.jdbc.ClientDriver"/>
	<property name="url" value="jdbc:derby://localhost:1527/db;create=true"/>
	<property name="initialSize" value="1" />
    <property name="maxActive"   value="5" />
	</bean>
</beans>

//program 3 Using JdbcTemplate
package org.nithish.model;

public class Circle {

	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Circle(int cirlceId,String name){
		setId(cirlceId);
		setName(name);
	}
}
package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		
	}
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForInt(sql);
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		System.out.println(dao.getCircleCount());
	}
}
<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context"
	>

	<context:annotation-config/>
	<context:component-scan base-package="org.nithish"/>
	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	<property name="driverClassName" value="org.apache.derby.jdbc.ClientDriver"/>
	<property name="url" value="jdbc:derby://localhost:1527/db;create=true"/>
	<property name="initialSize" value="1" />
    <property name="maxActive"   value="5" />
	</bean>
</beans>
 //program 4 Using JdbcTemplate
 package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		
	}
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
//program 5 Returning Other Datatypes from JdbcTemplate
package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		
	}
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	public String getCircleName(int circleId){
		String sql="SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}

package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		//System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleName(1));
	}
}

//program 6 Implementing RowMapper
package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		
	}
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	public String getCircleName(int circleId){
		String sql="SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);
	}
	public Circle getCircleForId(int circleId){
		String sql="SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new CircleMapper());
	}
	private static final class CircleMapper implements RowMapper<Circle>{
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}	
		}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		//System.out.println(dao.getCircleCount());
		System.out.println(dao.getCircleForId(1).getName());
	}
}

//program 7 Implementing RowMapper
package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		
	}
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	public String getCircleName(int circleId){
		String sql="SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);
	}
	public Circle getCircleForId(int circleId){
		String sql="SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new CircleMapper());
	}
	public List<Circle> getAllCircles(){
		String sql="SELECT * FROM CIRCLE";
		return  jdbcTemplate.query(sql, new CircleMapper());	
	}
	private static final class CircleMapper implements RowMapper<Circle>{
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}	
		}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	
	
}
package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		//System.out.println(dao.getCircleCount());
		System.out.println(dao.getAllCircles().size());
	}
}
//program 8 Performing Write Operations with JdbcTemplate
package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	/*public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		}
	*/	
	
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	public String getCircleName(int circleId){
		String sql="SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);
	}
	public Circle getCircleForId(int circleId){
		String sql="SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new CircleMapper());
	}
	public List<Circle> getAllCircles(){
		String sql="SELECT * FROM CIRCLE";
		return  jdbcTemplate.query(sql, new CircleMapper());	
	}
	public void insertCircle(Circle circle){
		String sql="INSERT INTO CIRCLE(ID,NAME) VALUES(?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	private static final class CircleMapper implements RowMapper<Circle>{
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}	
		}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		//System.out.println(dao.getCircleCount());
		dao.insertCircle(new Circle(3, "Third Circle"));
		System.out.println(dao.getAllCircles().size());
	}
}

//program 9 Performing Write Operations with JdbcTemplate
package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	/*public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		}
	*/	
	
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	public String getCircleName(int circleId){
		String sql="SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);
	}
	public Circle getCircleForId(int circleId){
		String sql="SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new CircleMapper());
	}
	public List<Circle> getAllCircles(){
		String sql="SELECT * FROM CIRCLE";
		return  jdbcTemplate.query(sql, new CircleMapper());	
	}
	public void insertCircle(Circle circle){
		String sql="INSERT INTO CIRCLE(ID,NAME) VALUES(?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	public void createTriangleTable(){
		String sql="CREATE TABLE TRIANGLE(ID INTEGER,NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	private static final class CircleMapper implements RowMapper<Circle>{
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}	
		}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		//System.out.println(dao.getCircleCount());
		/*dao.insertCircle(new Circle(3, "Third Circle"));
		System.out.println(dao.getAllCircles().size());*/
		dao.createTriangleTable();
	}
}
//program 10 Named Parameter JDBC Template
package org.nithish.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.nithish.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class JdbcDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/*public Circle getCircle(int circleId){
		Connection conn=null;
		try{
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle WHERE id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			 circle=new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return circle;
		
	}
	catch(Exception ex){
		throw new RuntimeException(ex);
	}
		finally{
			try{
				conn.close();
			}
			catch(SQLException ex){
			}
		}
		}
	*/	
	
	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForInt(sql);
	}
	public String getCircleName(int circleId){
		String sql="SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleId}, String.class);
	}
	public Circle getCircleForId(int circleId){
		String sql="SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId},new CircleMapper());
	}
	public List<Circle> getAllCircles(){
		String sql="SELECT * FROM CIRCLE";
		return  jdbcTemplate.query(sql, new CircleMapper());	
	}
	/*public void insertCircle(Circle circle){
		String sql="INSERT INTO CIRCLE(ID,NAME) VALUES(?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}*/
	public void insertCircle(Circle circle){
		String sql="INSERT INTO CIRCLE(ID,NAME) VALUES(:id,:name)";
		SqlParameterSource namedParameters=new MapSqlParameterSource("id",circle.getId())
																						.addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	
	public void createTriangleTable(){
		String sql="CREATE TABLE TRIANGLE(ID INTEGER,NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	private static final class CircleMapper implements RowMapper<Circle>{
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}	
		}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao=ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		//System.out.println(dao.getCircleCount());
		dao.insertCircle(new Circle(4, "Fourth Circle"));
		System.out.println(dao.getAllCircles().size());
		//dao.createTriangleTable();
	}
}

//program 11 DAO Support Classes
<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context"
	>

	<context:annotation-config/>
	<context:component-scan base-package="org.nithish"/>
	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	<property name="driverClassName" value="org.apache.derby.jdbc.ClientDriver"/>
	<property name="url" value="jdbc:derby://localhost:1527/db;create=true"/>
	<property name="initialSize" value="1" />
    <property name="maxActive"   value="5" />
	</bean>
	<bean id="simpleJdbcDaoImpl" class="org.nithish.dao.SimpleJdbcDaoImpl">
		<property name="dataSource" ref="dataSource"/>
	</bean>
</beans>
package org.nithish.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;


public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

	public int getCircleCount(){
		String sql="SELECT COUNT(*) FROM CIRCLE";
		return this.getJdbcTemplate().queryForInt(sql);
	}
}

package org.nithish;

import org.nithish.dao.JdbcDaoImpl;
import org.nithish.dao.SimpleJdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		SimpleJdbcDaoImpl dao=ctx.getBean("simpleJdbcDaoImpl",SimpleJdbcDaoImpl.class);
		/*Circle circle=dao.getCircle(1);
		System.out.println(circle.getName());*/
		//System.out.println(dao.getCircleCount());
		/*dao.insertCircle(new Circle(5, "Fifth Circle"));
		System.out.println(dao.getAllCircles().size());*/
		//dao.createTriangleTable();
		System.out.println(dao.getCircleCount());
	}
}
//program 12 Using Hibernate with Spring
<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context"
	>

	<context:annotation-config/>
	<context:component-scan base-package="org.nithish"/>
	
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	<property name="driverClassName" value="org.apache.derby.jdbc.ClientDriver"/>
	<property name="url" value="jdbc:derby://localhost:1527/db;create=true"/>
	<property name="initialSize" value="1" />
    <property name="maxActive"   value="5" />
	</bean>
	
	<bean id="simpleJdbcDaoImpl" class="org.nithish.dao.SimpleJdbcDaoImpl">
		<property name="dataSource" ref="dataSource"/>
	</bean>
	<bean id="sessionFactory" class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
	 <property name="dataSource" ref="dataSource"/>
	 <property name="packagesToScan" value="org.nithish.model"/>
	 <property name="hibernateProperties">
	 	<props>
	 		<prop key="dialect">org.hibernate.dialect.DerbyDialect</prop>
	 	</props>
	 </property>
	
	</bean>
</beans>
package org.nithish.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circle {

	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Circle(int cirlceId,String name){
		setId(cirlceId);
		setName(name);
	}
	public Circle() {
		// TODO Auto-generated constructor stub
	}
}
package org.nithish.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HibernateDaoImpl {
    @Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public int getCircleCount(){
		String hql="select count(*) from Circle";
		Query query=sessionFactory.openSession().createQuery(hql);
		return((Long)query.uniqueResult()).intValue();
	}
}


package org.nithish;

import org.nithish.dao.HibernateDaoImpl;
import org.nithish.dao.JdbcDaoImpl;
import org.nithish.dao.SimpleJdbcDaoImpl;
import org.nithish.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {

	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		HibernateDaoImpl dao=ctx.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
		System.out.println(dao.getCircleCount());
	}
}
