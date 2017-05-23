//pro 1
package org.javapractice.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}

package org.javapractice.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserId(1);
		user.setUserName("Venkata");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		

	}

}

<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 <hibernate-configuration>
<session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:8889/nithish_hibernate</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>

        <!-- JDBC connection pool (use the built-in) -->
        <property name="connection.pool_size">1</property>

        <!-- SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Disable the second-level cache  -->
        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hbm2ddl.auto">create</property>

        <!-- Names the annotated entity class -->
        <mapping class="org.javapractice.hibernate.UserDetails"/>
        
</session-factory>
</hibernate-configuration>

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into UserDetails (userName, userId) values (?, ?)
//pro 2
package org.javapractice.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_DETAILS")
public class UserDetails {
	@Id
	@Column(name="USER_ID")
	private int userId;
	@Column(name="USER_NAME")
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (USER_NAME, USER_ID) values (?, ?)


//pro3
package org.javapractice.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_DETAILS")
public class UserDetails {
	
	private int userId;
	
	private String userName;
	@Id
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName+"fromGetter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}//Takes user name from Getter
//pro 4
package org.javapractice.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	private int userId;
	@Transient
	private String userName;
	
	private Date joinedDate;
	
	private String description;
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName+"fromGetter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (description, joinedDate, userId) values (?, ?, ?)
//pro 5
package org.javapractice.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	private int userId;
	@Transient
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	private String description;
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName+"fromGetter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
//pro6
package org.javapractice.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	private int userId;
	@Transient
	private String userName;
	@Temporal(TemporalType.TIME)
	private Date joinedDate;
	
	private String description;
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName+"fromGetter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
//pro 7
//Retrieve objects from DataBase
package org.javapractice.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	private int userId;
	private String userName;
	@Temporal(TemporalType.TIME)
	private Date joinedDate;
	
	private String description;
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName+" from Getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}

<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 <hibernate-configuration>
<session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:8889/nithish_hibernate</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>

        <!-- JDBC connection pool (use the built-in) -->
        <property name="connection.pool_size">1</property>

        <!-- SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Disable the second-level cache  -->
        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hbm2ddl.auto">create</property>

        <!-- Names the annotated entity class -->
        <mapping class="org.javapractice.hibernate.UserDetails"/>
        
</session-factory>
</hibernate-configuration>

package org.javapractice.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserId(1);
		user.setUserName("Venkata");
		user.setJoinedDate(new Date());
		user.setDescription("Description of Venkata");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		user=(UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User Name is: "+user.getUserName());
				
		

	}

}

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (description, joinedDate, userName, userId) values (?, ?, ?, ?)
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.description as descript2_0_0_, userdetail0_.joinedDate as joinedDate0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
User Name is: Venkata from Getter

//pro 8
//primary key
package org.javapractice.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue
	private int userId;
	private String userName;
	@Temporal(TemporalType.TIME)
	private Date joinedDate;
	
	private String description;
	
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName+" from Getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user1=new UserDetails();
		user1.setUserName("Venkata");
        UserDetails user2=new UserDetails();
		user2.setUserName("Pavan");
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (description, joinedDate, userName) values (?, ?, ?)
Hibernate: insert into USER_DETAILS (description, joinedDate, userName) values (?, ?, ?)


//pro 8 value types and embeddable objects
package org.javapractice.hibernate;




import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	
	private String userName;
	@Embedded
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernate;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	private String city;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	private String state;
	private String pincode;

}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.Address;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
        
		
		Address addr=new Address();
		addr.setCity("Westborough");
		addr.setState("MA");
		addr.setPincode("01581");
		addr.setStreet("Otis");
		//missing
		user.setAddress(addr);
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (city, pincode, state, street, userName) values (?, ?, ?, ?, ?)

//pro 9 Attribute overrides and Embedded ObjectKeys
package org.javapractice.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="PIN_CODE")
	private String pincode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	

}

//remaing all same as above program
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME, userName) values (?, ?, ?, ?, ?)

//pro 10 Attribute overrides and Embedded ObjectKeys
package org.javapractice.hibernate;




import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	
	
	private String userName;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city",column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode",column=@Column(name="HOME_PIN_CODE"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;
	
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.Address;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
        
		
		Address addr1=new Address();
		addr1.setCity("Westborough");
		addr1.setState("MA");
		addr1.setPincode("01581");
		addr1.setStreet("Otis");
		
		user.setHomeAddress(addr1);
		Address addr2=new Address();
		addr2.setCity("MArlborough");
		addr2.setState("MA");
		addr2.setPincode("01752");
		addr2.setStreet("Felton");
		user.setOfficeAddress(addr2);
		
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (HOME_CITY_NAME, HOME_PIN_CODE, HOME_STATE_NAME, HOME_STREET_NAME, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME, userName) values (?, ?, ?, ?, ?, ?, ?, ?, ?)
//pro 11 Saving Collections
package org.javapractice.hibernate;




import java.util.HashSet;
import java.util.Set;



import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
    @ElementCollection
	private Set<Address> listOfAddresses=new HashSet<Address>();
	
	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="STATE_NAME")
	private String state;
	@Column(name="PIN_CODE")
	private String pincode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	

}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.Address;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
        
		
		Address addr1=new Address();
		addr1.setCity("Westborough");
		addr1.setState("MA");
		addr1.setPincode("01581");
		addr1.setStreet("Otis");
		
		Address addr2=new Address();
		addr2.setCity("Marlborough");
		addr2.setState("MA");
		addr2.setPincode("01752");
		addr2.setStreet("Felton");
				
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into UserDetails_listOfAddresses (UserDetails_userId, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: insert into UserDetails_listOfAddresses (UserDetails_userId, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)

//pro 12 Configuring collections and adding keys

//I want name of new table for collection to change from UserDetails_listOfAddresses to USER_ADDRESS
package org.javapractice.hibernate;




import java.util.HashSet;
import java.util.Set;




import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
    @ElementCollection
	@JoinTable(name="USER_ADDRESS")
    private Set<Address> listOfAddresses=new HashSet<Address>();
	
	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_ADDRESS (UserDetails_userId, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: insert into USER_ADDRESS (UserDetails_userId, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
//pro 13 Configuring collections and adding keys
//I want name of column in new table USER_ADDRESS to change from UserDetails_userId to USER_ID
package org.javapractice.hibernate;




import java.util.HashSet;
import java.util.Set;





import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
    @ElementCollection
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
    private Set<Address> listOfAddresses=new HashSet<Address>();
	
	public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
//pro 14 Configuring collections and adding keys
package org.javapractice.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
    @ElementCollection
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
    private Collection<Address> listOfAddresses=new ArrayList<Address>();
	
	
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_ADDRESS (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)
Hibernate: insert into USER_ADDRESS (USER_ID, ADDRESS_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?, ?)

//pro 15 Lazy initialization
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.Address;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
        
		
		Address addr1=new Address();
		addr1.setCity("Westborough");
		addr1.setState("MA");
		addr1.setPincode("01581");
		addr1.setStreet("Otis");
		
		Address addr2=new Address();
		addr2.setCity("Marlborough");
		addr2.setState("MA");
		addr2.setPincode("01752");
		addr2.setStreet("Felton");
				
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session=sessionFactory.openSession();
		user=(UserDetails)session.get(UserDetails.class,9);
		System.out.println(user.getListOfAddresses().size());
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: select listofaddr0_.USER_ID as USER1_0_0_, listofaddr0_.CITY_NAME as CITY2_0_, listofaddr0_.PIN_CODE as PIN3_0_, listofaddr0_.STATE_NAME as STATE4_0_, listofaddr0_.STREET_NAME as STREET5_0_ from USER_ADDRESS listofaddr0_ where listofaddr0_.USER_ID=?
2
//pro16  Lazy initialization
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.Address;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
        
		
		Address addr1=new Address();
		addr1.setCity("Westborough");
		addr1.setState("MA");
		addr1.setPincode("01581");
		addr1.setStreet("Otis");
		
		Address addr2=new Address();
		addr2.setCity("Marlborough");
		addr2.setState("MA");
		addr2.setPincode("01752");
		addr2.setStreet("Felton");
				
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session=sessionFactory.openSession();
		user=(UserDetails)session.get(UserDetails.class,6);
		session.close();
		System.out.println(user.getListOfAddresses().size());
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Exception in thread "main" org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: org.javapractice.hibernate.UserDetails.listOfAddresses, no session or session was closed
	at org.hibernate.collection.AbstractPersistentCollection.throwLazyInitializationException(AbstractPersistentCollection.java:383)
	at org.hibernate.collection.AbstractPersistentCollection.throwLazyInitializationExceptionIfNotConnected(AbstractPersistentCollection.java:375)
	at org.hibernate.collection.AbstractPersistentCollection.readSize(AbstractPersistentCollection.java:122)
	at org.hibernate.collection.PersistentBag.size(PersistentBag.java:248)
	at org.javapractice.hibernatetest.HibernateTest.main(HibernateTest.java:45)
//pro17 Eager fetch
package org.javapractice.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;



@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
    @ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))
    private Collection<Address> listOfAddresses=new ArrayList<Address>();
	
	
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.Address;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
        
		
		Address addr1=new Address();
		addr1.setCity("Westborough");
		addr1.setState("MA");
		addr1.setPincode("01581");
		addr1.setStreet("Otis");
		
		Address addr2=new Address();
		addr2.setCity("Marlborough");
		addr2.setState("MA");
		addr2.setPincode("01752");
		addr2.setStreet("Felton");
				
		user.getListOfAddresses().add(addr1);
		user.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session=sessionFactory.openSession();
		user=(UserDetails)session.get(UserDetails.class,11);
		session.close();
		System.out.println(user.getListOfAddresses().size());
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: insert into USER_ADDRESS (USER_ID, CITY_NAME, PIN_CODE, STATE_NAME, STREET_NAME) values (?, ?, ?, ?, ?)
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_, listofaddr1_.USER_ID as USER1_0_2_, listofaddr1_.CITY_NAME as CITY2_2_, listofaddr1_.PIN_CODE as PIN3_2_, listofaddr1_.STATE_NAME as STATE4_2_, listofaddr1_.STREET_NAME as STREET5_2_ from USER_DETAILS userdetail0_ left outer join USER_ADDRESS listofaddr1_ on userdetail0_.userId=listofaddr1_.USER_ID where userdetail0_.userId=?
2
//pro 18 One to One mapping
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@OneToOne
	private Vehicle vehicle;
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;
import org.javapractice.hibernate.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
		
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleBrand("Audi");
		
		user.setVehicle(vehicle1);
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle1);
		session.save(user);
		
		session.getTransaction().commit();
		session.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW (userName, vehicle_vehicleNumber) values (?, ?)
//pro19 Join Column to change column name
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW (userName, VEHICLE_ID) values (?, ?)
//pro20 One to Many
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@OneToMany
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;
import org.javapractice.hibernate.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user=new UserDetails();
		user.setUserName("Venkata");
		
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleBrand("Audi");
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleBrand("Benz");
		
		user.getVehicle().add(vehicle1);
		user.getVehicle().add(vehicle2);
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(user);
		
		session.getTransaction().commit();
		session.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (USER_DETAILS_NEW_userId, vehicle_vehicleNumber) values (?, ?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (USER_DETAILS_NEW_userId, vehicle_vehicleNumber) values (?, ?)

//pro 21 name change for columns
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@OneToMany
	@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="VEHICLE_NUMBER"))
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: insert into USER_VEHICLE (USER_ID, VEHICLE_NUMBER) values (?, ?)
Hibernate: insert into USER_VEHICLE (USER_ID, VEHICLE_NUMBER) values (?, ?)

//pro 22 Many to One
package org.javapractice.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	@ManyToOne
	private UserDetails user;
	
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (user_userId, vehicleBrand) values (?, ?)
Hibernate: insert into VEHICLE_NEW (user_userId, vehicleBrand) values (?, ?)
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: update VEHICLE_NEW set user_userId=?, vehicleBrand=? where vehicleNumber=?
Hibernate: update VEHICLE_NEW set user_userId=?, vehicleBrand=? where vehicleNumber=?
Hibernate: insert into USER_VEHICLE (USER_ID, VEHICLE_NUMBER) values (?, ?)
Hibernate: insert into USER_VEHICLE (USER_ID, VEHICLE_NUMBER) values (?, ?)
//pro 23 mappedBy
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@OneToMany(mappedBy="user")
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private UserDetails user;
	
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (USER_ID, vehicleBrand) values (?, ?)
Hibernate: insert into VEHICLE_NEW (USER_ID, vehicleBrand) values (?, ?)
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: update VEHICLE_NEW set USER_ID=?, vehicleBrand=? where vehicleNumber=?
Hibernate: update VEHICLE_NEW set USER_ID=?, vehicleBrand=? where vehicleNumber=?
//pro 24 Many to Many first pgm
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@ManyToMany
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	@ManyToMany
	private Collection<UserDetails> user=new ArrayList<UserDetails>();

	public Collection<UserDetails> getUser() {
		return user;
	}
	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;
import org.javapractice.hibernate.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails user1=new UserDetails();
		user1.setUserName("Venkata");
		
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleBrand("Audi");
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleBrand("Benz");
		
		user1.getVehicle().add(vehicle1);
		user1.getVehicle().add(vehicle2);
		vehicle1.getUser().add(user1);
		vehicle2.getUser().add(user1);
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(user1);
		
		session.getTransaction().commit();
		session.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: insert into VEHICLE_NEW_USER_DETAILS_NEW (VEHICLE_NEW_vehicleNumber, user_userId) values (?, ?)
Hibernate: insert into VEHICLE_NEW_USER_DETAILS_NEW (VEHICLE_NEW_vehicleNumber, user_userId) values (?, ?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (USER_DETAILS_NEW_userId, vehicle_vehicleNumber) values (?, ?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (USER_DETAILS_NEW_userId, vehicle_vehicleNumber) values (?, ?)


//pro 25 Many to Many first pgm
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@ManyToMany
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	@ManyToMany(mappedBy="vehicle")
	private Collection<UserDetails> user=new ArrayList<UserDetails>();

	public Collection<UserDetails> getUser() {
		return user;
	}
	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (user_userId, vehicle_vehicleNumber) values (?, ?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (user_userId, vehicle_vehicleNumber) values (?, ?)

//pro 26 many to many with join table join columns for new names
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@ManyToMany
	@JoinTable(name="USER_MANY_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="VEHICLE_NUMBER"))
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: insert into USER_MANY_VEHICLE (USER_ID, VEHICLE_NUMBER) values (?, ?)
Hibernate: insert into USER_MANY_VEHICLE (USER_ID, VEHICLE_NUMBER) values (?, ?)
//pro 27 Cascade types and other things
//when a variable misses hibernate gives exception.we can avoid that by this

package org.javapractice.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private UserDetails user;
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
//pro 28 Cascade types and other things
package org.javapractice.hibernate;




import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS_NEW")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernate;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS_NEW (userName) values (?)
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into VEHICLE_NEW (vehicleBrand) values (?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (USER_DETAILS_NEW_userId, vehicle_vehicleNumber) values (?, ?)
Hibernate: insert into USER_DETAILS_NEW_VEHICLE_NEW (USER_DETAILS_NEW_userId, vehicle_vehicleNumber) values (?, ?)


//pro 29 Implementing Inheritance
package org.javapractice.hibernate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE_NEW")
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
package org.javapractice.hibernate;
import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
private String SteeringHandle;

public String getSteeringHandle() {
	return SteeringHandle;
}

public void setSteeringHandle(String steeringHandle) {
	SteeringHandle = steeringHandle;
}

}
package org.javapractice.hibernate;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
}
package org.javapractice.hibernatetest;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.FourWheeler;
import org.javapractice.hibernate.TwoWheeler;
import org.javapractice.hibernate.UserDetails;
import org.javapractice.hibernate.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleBrand("Nithish's");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setSteeringHandle("steeringHandle of Bike");
		bike.setVehicleBrand("Hero");
		
		FourWheeler car=new FourWheeler();
		car.setSteeringHandle("steeringHandle of Car");
		car.setVehicleBrand("Audi");
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		
		
		
		session.getTransaction().commit();
		session.close();

	}

}
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 <hibernate-configuration>
<session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:8889/nithish_hibernate</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>

        <!-- JDBC connection pool (use the built-in) -->
        <property name="connection.pool_size">1</property>

        <!-- SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Disable the second-level cache  -->
        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hbm2ddl.auto">create</property>

        <!-- Names the annotated entity class -->
        <mapping class="org.javapractice.hibernate.Vehicle"/>
        <mapping class="org.javapractice.hibernate.TwoWheeler"/>
        <mapping class="org.javapractice.hibernate.FourWheeler"/>
        
</session-factory>
</hibernate-configuration>
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand, DTYPE) values (?, 'Vehicle')
Hibernate: insert into VEHICLE_NEW (vehicleBrand, SteeringHandle, DTYPE) values (?, ?, 'FourWheeler')
Hibernate: insert into VEHICLE_NEW (vehicleBrand, SteeringHandle, DTYPE) values (?, ?, 'TwoWheeler')

//pro 30 Implementing Inheritance, Single Table Strategy
package org.javapractice.hibernate;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE_NEW")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name="VEHICLE_TYPE" ,discriminatorType=DiscriminatorType.STRING)
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
package org.javapractice.hibernate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle{
private String SteeringHandle;

public String getSteeringHandle() {
	return SteeringHandle;
}

public void setSteeringHandle(String steeringHandle) {
	SteeringHandle = steeringHandle;
}

}
package org.javapractice.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into VEHICLE_NEW (vehicleBrand, VEHICLE_TYPE) values (?, 'Vehicle')
Hibernate: insert into VEHICLE_NEW (vehicleBrand, SteeringHandle, VEHICLE_TYPE) values (?, ?, 'Car')
Hibernate: insert into VEHICLE_NEW (vehicleBrand, SteeringHandle, VEHICLE_TYPE) values (?, ?, 'Bike')
//pro 30 Implementing Inheritance, Table per class strategy
package org.javapractice.hibernate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Vehicle {
	@Id@GeneratedValue(strategy=GenerationType.TABLE)
	private int vehicleNumber;
	private String vehicleBrand;
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
package org.javapractice.hibernate;
import javax.persistence.Entity;

@Entity

public class TwoWheeler extends Vehicle{
private String SteeringHandle;

public String getSteeringHandle() {
	return SteeringHandle;
}

public void setSteeringHandle(String steeringHandle) {
	SteeringHandle = steeringHandle;
}

}
package org.javapractice.hibernate;


import javax.persistence.Entity;

@Entity

public class FourWheeler extends Vehicle {
	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into Vehicle (vehicleBrand, vehicleNumber) values (?, ?)
Hibernate: insert into FourWheeler (vehicleBrand, SteeringHandle, vehicleNumber) values (?, ?, ?)
Hibernate: insert into TwoWheeler (vehicleBrand, SteeringHandle, vehicleNumber) values (?, ?, ?)

//pro 31 Implementing Inheritance by joined strategy
package org.javapractice.hibernate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	@Id@GeneratedValue
	private int vehicleNumber;
	private String vehicleBrand;
	
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	
}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into Vehicle (vehicleBrand) values (?)
Hibernate: insert into Vehicle (vehicleBrand) values (?)
Hibernate: insert into FourWheeler (SteeringHandle, vehicleNumber) values (?, ?)
Hibernate: insert into Vehicle (vehicleBrand) values (?)
Hibernate: insert into TwoWheeler (SteeringHandle, vehicleNumber) values (?, ?)
//pro 32 CRUD operations Insert 10 users in DB
package org.javapractice.hibernate;

import javax.persistence.*;



@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		for(int i=0;i<10;i++){
			UserDetails user=new UserDetails();
			user.setUserName("User"+i);
			session.save(user);	
		}
		session.getTransaction().commit();
		session.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: insert into USER_DETAILS (userName) values (?)
//pro 32 fetch from DB
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 6);
		System.out.println("User Name Pulled is :"+ user.getUserName());
		session.getTransaction().commit();
		session.close();

	}

}
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 <hibernate-configuration>
<session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:8889/nithish_hibernate</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>

        <!-- JDBC connection pool (use the built-in) -->
        <property name="connection.pool_size">1</property>

        <!-- SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- Disable the second-level cache  -->
        <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hbm2ddl.auto">update</property>

        <!-- Names the annotated entity class -->
        <mapping class="org.javapractice.hibernate.UserDetails"/>
        
        
</session-factory>
</hibernate-configuration>
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
User Name Pulled is :User5
//pro 33 pull value after closing session.because of lazy fetch first level value
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 6);
		session.getTransaction().commit();
		session.close();
		System.out.println("User Name Pulled is :"+ user.getUserName());

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
User Name Pulled is :User5
//pro 34 delete
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 6);
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: delete from USER_DETAILS where userId=?
//pro 35 update
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 5);
		user.setUserName("Updated User");
		session.update(user);
		session.getTransaction().commit();
		session.close();
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: update USER_DETAILS set userName=? where userId=?
//pro 36 Transient Persistent Detached object
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("Test User");
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		user.setUserName("Updated User");
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("Test User");
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
	   user.setUserName("Updated User");
		
		session.getTransaction().commit();
		session.close();
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into USER_DETAILS (userName) values (?)
Hibernate: update USER_DETAILS set userName=? where userId=?
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("Test User");
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
	   user.setUserName("Updated User");
	   user.setUserName("Updated User Again");
		
		session.getTransaction().commit();
		session.close();
		

	}

}
//Here Updated User Again gets saved to DataBase

//pro 37 Detached object
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user=new UserDetails();
		user.setUserName("Test User");
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
	   user.setUserName("Updated User");
	   user.setUserName("Updated User Again");
		
		session.getTransaction().commit();
		session.close();
		user.setUserName("Updated for detached state check");

	}

}

//Here Updated User Again gets saved to DataBase as session.close is there before update

//pro 38 persisting detached objects
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Updated User name after closing Session");
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: update USER_DETAILS set userName=? where userId=?
//Db has Updated User name after closing Session 
//pro 39 slect befor update
package org.javapractice.hibernate;

import javax.persistence.*;



@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: select userdetail_.userId, userdetail_.userName as userName0_ from USER_DETAILS userdetail_ where userdetail_.userId=?
//2 selections
//pro 40 slect befor update

package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
	   	SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Changed Name");
		
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
		
		

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: select userdetail_.userId, userdetail_.userName as userName0_ from USER_DETAILS userdetail_ where userdetail_.userId=?
Hibernate: update USER_DETAILS set userName=? where userId=?
//here seltion occuring twice as data is diff its doing update

//pro 41 HQL and Quety object
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from UserDetails");
		List users=query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of list is: "+users.size());
	}
	 	
		
		

	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_
Size of list is: 10

//pro 42 HQL and Quety object
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from UserDetails where userId>5");
		List users=query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println("Size of list is: "+users.size());
	}
	}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId>5
Size of list is: 5
//pro 43 Select and Pagination in HQL
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from UserDetails");
		List <UserDetails> users=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:users){
			System.out.println(u.getUserName());
		}
	}
	 	
		
		

	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_
User1
User2
User3
User4
User5
User6
User7
User8
User9
User10

//pro 44 Select and Pagination in HQL
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		List <UserDetails> users=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:users){
			System.out.println(u.getUserName());
		}
	}
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ limit ?, ?
User6
User7
User8
User9
//pro 45
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("select userName from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(4);
		List <String> userNames=(List <String> )query.list();
		session.getTransaction().commit();
		session.close();
		for(String u:userNames){
			System.out.println(u);
		}
	}
	}

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userName as col_0_0_ from USER_DETAILS userdetail0_ limit ?, ?
User6
User7
User8
User9

//pro 46 Understanding parameter binding and sql injection
package org.javapractice.hibernatetest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int minUsedId=5;
		Query query=session.createQuery(" from UserDetails where userId>"+minUsedId);
		List <UserDetails> userNames=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
		
	}
	}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId>5
User6
User7
User8
User9
User10
//pro 47 sql injection
package org.javapractice.hibernatetest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String minUsedId="5 or 1=1";
		Query query=session.createQuery(" from UserDetails where userId>"+minUsedId);
		List <UserDetails> userNames=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
		
	}
	}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId>5 or 1=1
User1
User2
User3
User4
User5
User6
User7
User8
User9
User10

//pro 48 Understanding parameter binding and sql injection

package org.javapractice.hibernatetest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String minUsedId="5";
		Query query=session.createQuery(" from UserDetails where userId > ?");
		query.setInteger(0,Integer.parseInt(minUsedId));
		List <UserDetails> userNames=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
		
	}
	 	
		
		

	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId>?
User6
User7
User8
User9
User10

//pro 49 Understanding parameter binding and sql injection
package org.javapractice.hibernatetest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String minUsedId="5";
		String userName="User10";
		Query query=session.createQuery(" from UserDetails where userId > ? and userName= ?");
		query.setInteger(0,Integer.parseInt(minUsedId));
		query.setString(1, userName);
		List <UserDetails> userNames=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
		
	}
	 	
		
		

	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId>? and userdetail0_.userName=?
User10

//pro 50 Understanding parameter binding and sql injection
package org.javapractice.hibernatetest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		String minUsedId="5";
		String userName="User10";
		Query query=session.createQuery(" from UserDetails where userId >:userId and userName=:userName");
		query.setInteger("userId",Integer.parseInt(minUsedId));//(0,Integer.parseInt(minUsedId));
		query.setString("userName", userName);
		List <UserDetails> userNames=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
		
	}
	 	
		
		

	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId>? and userdetail0_.userName=?
User10

//pro 51 Named Queries
  package org.javapractice.hibernate;

import javax.persistence.*;



@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where UserId = ?")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, 2);
		
		List <UserDetails> userNames=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
		
	}
	 	
		
		

	}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where UserId=?
User2

//pro 52 Named  native Queries
package org.javapractice.hibernate;

import javax.persistence.*;



@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where UserId = ?")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from USER_DETAILS where userName=?",resultClass=UserDetails.class)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User10");//positional parameter i.e there is one i/p paramter so 0 if two 0,1
		
		List <UserDetails> userNames=(List <UserDetails> )query.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
		
	}
	 	
		
		

	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select * from USER_DETAILS where userName=?
User10
 

//pro 53 Introduction to criteria API
package org.javapractice.hibernate;

import javax.persistence.*;



@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package org.javapractice.hibernatetest;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria =session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("userName","User10"));
		
		
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ where this_.userName=?
User10
//pro 54 Understanding restictions
package org.javapractice.hibernatetest;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria =session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.gt("userId", 5));
		
		
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ where this_.userId>?
User6
User7
User8
User9
User10

//pro 55 Understanding restictions
package org.javapractice.hibernatetest;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria =session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.like("userName","%User1%"))
				.add(Restrictions.between("userId", 5, 50));
		
		
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ where this_.userName like ? and this_.userId between ? and ?
User10

//pro 56 Understanding restictions
package org.javapractice.hibernatetest;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria =session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 7, 10)));
		
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ where (this_.userId between ? and ? or this_.userId between ? and ?)
User1
User2
User3
User7
User8
User9
User10
//pro 57 Projections and query by example
package org.javapractice.hibernatetest;
import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria =session.createCriteria(UserDetails.class)
									.addOrder(Order.desc("userId"));
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ order by this_.userId desc
User10
User9
User8
User7
User6
User5
User4
User3
User2
User1

//pro 58 Projections and query by example
package org.javapractice.hibernatetest;
import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria =session.createCriteria(UserDetails.class)
								.setProjection(Projections.property("userId"))	;
		System.out.println(criteria.list());
		session.getTransaction().commit();
		session.close();
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as y0_ from USER_DETAILS this_
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

//pro 59 Projections and query by example
package org.javapractice.hibernatetest;
import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria =session.createCriteria(UserDetails.class)
								.setProjection(Projections.property("userName"))	;
		System.out.println(criteria.list());
		session.getTransaction().commit();
		session.close();
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userName as y0_ from USER_DETAILS this_
[User1, User2, User3, User4, User5, User6, User7, User8, User9, User10]

//pro 60 Projections and query by example
package org.javapractice.hibernatetest;
import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails  exampleUser=new UserDetails();
		exampleUser.setUserId(5);
		exampleUser.setUserName("User5");
		
		Example example=Example.create(exampleUser);
		
		
		Criteria criteria =session.createCriteria(UserDetails.class)
									.add(example);
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ where (this_.userName=?)
User5

//pro 61 Projections and query by example

package org.javapractice.hibernatetest;
import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails  exampleUser=new UserDetails();
		//exampleUser.setUserId(5);
		exampleUser.setUserName("User5");
		
		Example example=Example.create(exampleUser);
		
		
		Criteria criteria =session.createCriteria(UserDetails.class)
									.add(example);
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ where (this_.userName=?)
User5

//pro 62 Projections and query by example
package org.javapractice.hibernatetest;
import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails  exampleUser=new UserDetails();
		//exampleUser.setUserId(5);
		exampleUser.setUserName("User1%");
		
		Example example=Example.create(exampleUser).enableLike();
		
		
		Criteria criteria =session.createCriteria(UserDetails.class)
									.add(example);
		List <UserDetails> userNames=(List <UserDetails> )criteria.list();
		session.getTransaction().commit();
		session.close();
		for(UserDetails u:userNames){
			System.out.println(u.getUserName());
		}
	}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select this_.userId as userId0_0_, this_.userName as userName0_0_ from USER_DETAILS this_ where (this_.userName like ?)
User1
User10
//pro 63 Caching in Hibernate
package org.javapractice.hibernatetest;
import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		UserDetails user2=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
			}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Only on selct operation
//pro 64 Caching in Hibernate
package org.javapractice.hibernatetest;
import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		user.setUserName("Updated User");
		UserDetails user2=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
			}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: update USER_DETAILS set userName=? where userId=?
//pro 65 Caching in Hibernate
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails user2=(UserDetails)session2.get(UserDetails.class, 1);
		session2.getTransaction().commit();
		session2.close();
		
			}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
//2 select statements can be tackled by second level cache
//pro 66 Configuring second level cache
package org.javapractice.hibernatetest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		UserDetails  user=(UserDetails)session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails user2=(UserDetails)session2.get(UserDetails.class, 1);
		session2.getTransaction().commit();
		session2.close();
		
			}	
	}


package org.javapractice.hibernate;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 <hibernate-configuration>
<session-factory>
        <!-- Database connection settings -->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:8889/nithish_hibernate</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>

        <!-- JDBC connection pool (use the built-in) -->
        <property name="connection.pool_size">1</property>

        <!-- SQL dialect -->
        <property name="dialect">org.hibernate.dialect.MySQLDialect</property>

        <!-- second-level cache  -->
        <property name="cache.use_second_level_cache">true</property>
        <property name="cache.provider_class">org.hibernate.cache.EhCacheProvider</property>

        <!-- Echo all executed SQL to stdout -->
        <property name="show_sql">true</property>

        <!-- Drop and re-create the database schema on startup -->
        <property name="hbm2ddl.auto">update</property>

        <!-- Names the annotated entity class -->
        <mapping class="org.javapractice.hibernate.UserDetails"/>
        
        
</session-factory>
</hibernate-configuration>
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_0_, userdetail0_.userName as userName0_0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=?
//one select as secondary cache came into picture
//pro 67 Using Query Cache
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from UserDetails where  userId=1");
		List users=query.list();
		
		session.getTransaction().commit();
		session.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
 
		Query query2=session2.createQuery("from UserDetails where userId=1");
		List users2=query2.list();

		session2.getTransaction().commit();
		session2.close();
		
			}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=1
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=1

//pro 68 Using Query Cache
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from UserDetails where  userId=1");
		query.setCacheable(true);
		List users=query.list();
		
		session.getTransaction().commit();
		session.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
 
		Query query2=session2.createQuery("from UserDetails where userId=1");
		//query2.setCacheable(true);
		List users2=query2.list();

		session2.getTransaction().commit();
		session2.close();
		
			}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=1
//pro 69 Using Query Cache
package org.javapractice.hibernatetest;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javapractice.hibernate.UserDetails;

public class HibernateTest { 

	public static void main(String[] args) {
		
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
		Query query=session.createQuery("from UserDetails where  userId=1");
		query.setCacheable(true);
		List users=query.list();
		
		session.getTransaction().commit();
		session.close();
		
		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
 
		Query query2=session2.createQuery("from UserDetails where userId=1");
		query2.setCacheable(true);
		List users2=query2.list();

		session2.getTransaction().commit();
		session2.close();
		
			}	
	}


SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: select userdetail0_.userId as userId0_, userdetail0_.userName as userName0_ from USER_DETAILS userdetail0_ where userdetail0_.userId=1
