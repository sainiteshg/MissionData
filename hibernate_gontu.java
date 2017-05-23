//pro 1
package org.nithish.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
    @Id
	private int rollno;
	private String student_name;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
package org.nithish.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

     Student_Info student=new Student_Info();
     student.setRollno(1);
     student.setStudent_name("Nithish");
     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
     Session session=sessionFactory.openSession();
     session.beginTransaction();
     session.save(student);
     session.getTransaction().commit();
     session.close();
     sessionFactory.close();
     

	}

}
<?xml version='1.0' encoding='utf-8'?>
<!--
  ~ Hibernate, Relational Persistence for Idiomatic Java
  ~
  ~ Copyright (c) 2010, Red Hat Inc. or third-party contributors as
  ~ indicated by the @author tags or express copyright attribution
  ~ statements applied by the authors.  All third-party contributions are
  ~ distributed under license by Red Hat Inc.
  ~
  ~ This copyrighted material is made available to anyone wishing to use, modify,
  ~ copy, or redistribute it subject to the terms and conditions of the GNU
  ~ Lesser General Public License, as published by the Free Software Foundation.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
  ~ or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
  ~ for more details.
  ~
  ~ You should have received a copy of the GNU Lesser General Public License
  ~ along with this distribution; if not, write to:
  ~ Free Software Foundation, Inc.
  ~ 51 Franklin Street, Fifth Floor
  ~ Boston, MA  02110-1301  USA
  -->
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- Database connection settings -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:8889/hibernate_tutorial</property>
        <property name="connection.username">root</property>
        <property name="connection.password">root</property>

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
        <mapping class="org.nithish.hibernate.Student_Info"/>
        

    </session-factory>

</hibernate-configuration>

Output Console-
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_INFORMATION (student_name, rollno) values (?, ?)

//pro 2
package org.nithish.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
    @Id
	private int rollno;
	@Column(name="FULL_NAME")
    private String student_name;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
Output Console-
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_INFORMATION (FULL_NAME, rollno) values (?, ?)


//pro 3
package org.nithish.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
    @Id
	private int rollno;
	@Column(name="FULL_NAME",nullable=false)
    private String student_name;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}

Output Console-
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_INFORMATION (FULL_NAME, rollno) values (?, ?)
//pro 4
package org.nithish.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
    @Id
	private int rollno;
	@Transient
    @Column(name="FULL_NAME",nullable=false)
    private String student_name;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
Output Console-
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_INFORMATION (rollno) values (?)
//pro 5
package org.nithish.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
    @Id
	private int rollno;
	@Transient
    @Column(name="FULL_NAME",nullable=false)
    private String student_name;
	private Date dateofbirth;
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}

package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

     Student_Info student=new Student_Info();
     student.setRollno(1);
     student.setStudent_name("Nithish");
     student.setDateofbirth(new Date());
     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
     Session session=sessionFactory.openSession();
     session.beginTransaction();
     session.save(student);
     session.getTransaction().commit();
     session.close();
     sessionFactory.close();
     

	}

}
Output Console-
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_INFORMATION (dateofbirth, rollno) values (?, ?)//date has time stamp also

//pro 6
package org.nithish.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
    @Id
	private int rollno;
	@Transient
    @Column(name="FULL_NAME",nullable=false)
    private String student_name;
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
Output Console-
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_INFORMATION (dateofbirth, rollno) values (?, ?)//no time stamp only date

//pro 7
package org.nithish.hibernate;

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
@Table(name="STUDENT_INFORMATION")
public class Student_Info {
    @Id @GeneratedValue
	private int rollno;
	
    @Column(name="FULL_NAME",nullable=false)
    private String student_name;
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}

package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

     Student_Info student=new Student_Info();
     student.setStudent_name("Nithish");
     Student_Info student1=new Student_Info();
     student1.setStudent_name("Pavan");
     
     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
     Session session=sessionFactory.openSession();
     session.beginTransaction();
     session.save(student);
     session.save(student1);
     session.getTransaction().commit();
     session.close();
     sessionFactory.close();
     

	}

}
Output Console-
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_INFORMATION (FULL_NAME) values (?)
Hibernate: insert into STUDENT_INFORMATION (FULL_NAME) values (?)
//pro 8
package org.nithish.hibernate;

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
@Table(name="STUDENT")
public class Student_Info {
    @Id @GeneratedValue
	private int student_id;
	
    private String student_name;
	
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
package org.nithish.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="STUDENT_DETAIL_TABLE")
public class Student_Detail {
	@Id @GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator",strategy="foreign",parameters={@Parameter(value="student",name="property")})
	private int student_id;
	private String student_mobile_number;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student_Info student;
	
	public Student_Info getStudent() {
		return student;
	}
	public void setStudent(Student_Info student) {
		this.student = student;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_mobile_number() {
		return student_mobile_number;
	}
	public void setStudent_mobile_number(String student_mobile_number) {
		this.student_mobile_number = student_mobile_number;
	}

}
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

     Student_Info student=new Student_Info();
     student.setStudent_name("Nithish");
     Student_Detail studentdetail=new Student_Detail();
     studentdetail.setStudent_mobile_number("213-880-3338");
     studentdetail.setStudent(student);
     
     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
     Session session=sessionFactory.openSession();
     
     session.beginTransaction();
     
     session.save(studentdetail);
     session.getTransaction().commit();
     
     session.close();
     sessionFactory.close();
     

	}

}
<?xml version='1.0' encoding='utf-8'?>
<!--
  ~ Hibernate, Relational Persistence for Idiomatic Java
  ~
  ~ Copyright (c) 2010, Red Hat Inc. or third-party contributors as
  ~ indicated by the @author tags or express copyright attribution
  ~ statements applied by the authors.  All third-party contributions are
  ~ distributed under license by Red Hat Inc.
  ~
  ~ This copyrighted material is made available to anyone wishing to use, modify,
  ~ copy, or redistribute it subject to the terms and conditions of the GNU
  ~ Lesser General Public License, as published by the Free Software Foundation.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
  ~ or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
  ~ for more details.
  ~
  ~ You should have received a copy of the GNU Lesser General Public License
  ~ along with this distribution; if not, write to:
  ~ Free Software Foundation, Inc.
  ~ 51 Franklin Street, Fifth Floor
  ~ Boston, MA  02110-1301  USA
  -->
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- Database connection settings -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:8889/hibernate_tutorial</property>
        <property name="connection.username">root</property>
        <property name="connection.password">root</property>

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
        <mapping class="org.nithish.hibernate.Student_Info"/>
        <mapping class="org.nithish.hibernate.Student_Detail"/>
        

    </session-factory>

</hibernate-configuration>
Output Console-
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT (student_name) values (?)//one to one mapping
Hibernate: insert into STUDENT_DETAIL_TABLE (student_mobile_number, student_id) values (?, ?)

//pro 9
//Bidirectional one to one mapping
package org.nithish.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="STUDENT_DETAIL_TABLE")
public class Student_Detail {
	@Id @GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator",strategy="foreign",parameters={@Parameter(value="student",name="property")})
	private int student_id;
	private String student_mobile_number;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
	private Student_Info student;
	
	public Student_Info getStudent() {
		return student;
	}
	public void setStudent(Student_Info student) {
		this.student = student;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_mobile_number() {
		return student_mobile_number;
	}
	public void setStudent_mobile_number(String student_mobile_number) {
		this.student_mobile_number = student_mobile_number;
	}

}
package org.nithish.hibernate;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="STUDENT")
public class Student_Info {
    @Id @GeneratedValue
	private int student_id;
	
    private String student_name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="student_id")
    public Student_Detail studentdetail;
	
	public Student_Detail getStudentdetail() {
		return studentdetail;
	}
	public void setStudentdetail(Student_Detail studentdetail) {
		this.studentdetail = studentdetail;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
}
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Student_Info student=new Student_Info();
	     student.setStudent_name("Nithish");
	     Student_Detail studentdetail=new Student_Detail();
	     studentdetail.setStudent_mobile_number("213-880-3338");
	     studentdetail.setStudent(student);
	     student.setStudentdetail(studentdetail);
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(studentdetail);
	     session.getTransaction().commit();
	     
	     session.close();
	     sessionFactory.close();

	}

}
Output Console-
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT (student_name) values (?)
Hibernate: insert into STUDENT_DETAIL_TABLE (student_mobile_number, student_id) values (?, ?)

//pro 10 Many to One Mapping
package org.nithish.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="STUDENT")
public class Student {
	@Id @GeneratedValue
	private int student_id;
	
    private String student_name;
	
	@ManyToOne(cascade=CascadeType.ALL)
    private Student_addess studentadd;
	
	public Student_addess getStudentadd() {
		return studentadd;
	}
	public void setStudentadd(Student_addess studentadd) {
		this.studentadd = studentadd;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

}

package org.nithish.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_ADDRESS")
public class Student_addess {

	@Id
	@GeneratedValue
	private int addess_id;
	private String address_detail;
	public int getAddess_id() {
		return addess_id;
	}
	public void setAddess_id(int addess_id) {
		this.addess_id = addess_id;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	
	
	
	
}
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Student_addess studentadd=new Student_addess();
		studentadd.setAddress_detail("Hyd,India");
		
		Student student1=new Student();
		student1.setStudent_name("Nithish");
		student1.setStudentadd(studentadd);
		Student student2=new Student();
		student2.setStudent_name("Pavan");
		student2.setStudentadd(studentadd);
		
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(student1);
	     session.save(student2);
	     session.getTransaction().commit();
	     
	     session.close();
	     sessionFactory.close();

	}

}
<?xml version='1.0' encoding='utf-8'?>
<!--
  ~ Hibernate, Relational Persistence for Idiomatic Java
  ~
  ~ Copyright (c) 2010, Red Hat Inc. or third-party contributors as
  ~ indicated by the @author tags or express copyright attribution
  ~ statements applied by the authors.  All third-party contributions are
  ~ distributed under license by Red Hat Inc.
  ~
  ~ This copyrighted material is made available to anyone wishing to use, modify,
  ~ copy, or redistribute it subject to the terms and conditions of the GNU
  ~ Lesser General Public License, as published by the Free Software Foundation.
  ~
  ~ This program is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
  ~ or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
  ~ for more details.
  ~
  ~ You should have received a copy of the GNU Lesser General Public License
  ~ along with this distribution; if not, write to:
  ~ Free Software Foundation, Inc.
  ~ 51 Franklin Street, Fifth Floor
  ~ Boston, MA  02110-1301  USA
  -->
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">

<hibernate-configuration>

    <session-factory>

        <!-- Database connection settings -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:8889/hibernate_tutorial</property>
        <property name="connection.username">root</property>
        <property name="connection.password">root</property>

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
        <mapping class="org.nithish.hibernate.Student"/>
        <mapping class="org.nithish.hibernate.Student_addess"/>
        

    </session-factory>

</hibernate-configuration>
Output Console-

SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_ADDRESS (address_detail) values (?)
Hibernate: insert into STUDENT (student_name, studentadd_addess_id) values (?, ?)
Hibernate: insert into STUDENT (student_name, studentadd_addess_id) values (?, ?)

//pro 11 ManyToOne / OneToMany Mapping ( Bidirectional )
package org.nithish.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="STUDENT")
public class Student {
	@Id @GeneratedValue
	private int student_id;
	
    private String student_name;
	
	@ManyToOne(cascade=CascadeType.ALL)
    private Student_addess studentadd;
	
	public Student_addess getStudentadd() {
		return studentadd;
	}
	public void setStudentadd(Student_addess studentadd) {
		this.studentadd = studentadd;
	}
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

}

package org.nithish.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_ADDRESS")
public class Student_addess {

	@Id
	@GeneratedValue
	private int addess_id;
	private String address_detail;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="studentadd")
	private Set<Student> students=new HashSet <Student>(0);
	
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public int getAddess_id() {
		return addess_id;
	}
	public void setAddess_id(int addess_id) {
		this.addess_id = addess_id;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	
	
	
	
}
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Student_addess studentadd=new Student_addess();
		studentadd.setAddress_detail("Hyd,India");
		
		Student student1=new Student();
		student1.setStudent_name("Nithish");
		student1.setStudentadd(studentadd);
		Student student2=new Student();
		student2.setStudent_name("Pavan");
		student2.setStudentadd(studentadd);
		
		studentadd.getStudents().add(student1);
		studentadd.getStudents().add(student2);
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(studentadd);
	     
	     session.getTransaction().commit();
	     
	     session.close();
	     sessionFactory.close();

	}

}
Output Console-
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_ADDRESS (address_detail) values (?)
Hibernate: insert into STUDENT (student_name, studentadd_addess_id) values (?, ?)
Hibernate: insert into STUDENT (student_name, studentadd_addess_id) values (?, ?)

//pro 11 Many to Many property
package org.nithish.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="STUDENT")
public class Student {
	@Id @GeneratedValue
	private int student_id;
	
    private String student_name;
	
	@ManyToMany(cascade=CascadeType.ALL)
    private Set <StudentCertification> studentCertification=new HashSet<StudentCertification>(0);
	
	public Set<StudentCertification> getStudentCertification() {
		return studentCertification;
	}
	public void setStudentCertification(
			Set<StudentCertification> studentCertification) {
		this.studentCertification = studentCertification;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

}
package org.nithish.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="STUDENT_CERTIFICATION")
public class StudentCertification {
	@Id
	@GeneratedValue
	private int certification_id;
	private String certification_name;
	public int getCertification_id() {
		return certification_id;
	}
	public void setCertification_id(int certification_id) {
		this.certification_id = certification_id;
	}
	public String getCertification_name() {
		return certification_name;
	}
	public void setCertification_name(String certification_name) {
		this.certification_name = certification_name;
	}
	

}
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StudentCertification studentCertification1=new StudentCertification();
		studentCertification1.setCertification_name("Java Certification");
		StudentCertification studentCertification2=new StudentCertification();
		studentCertification2.setCertification_name("Oracle DB Certification");
		
		Student student1=new Student();
		student1.setStudent_name("Nithish");
		student1.getStudentCertification().add(studentCertification1);
		Student student2=new Student();
		student2.setStudent_name("Pavan");
		student2.getStudentCertification().add(studentCertification2);
		
		
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(student1);
	     session.save(student2);
	     
	     session.getTransaction().commit();
	     
	     session.close();
	     sessionFactory.close();

	}

}
Output Console-
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT (student_name) values (?)
Hibernate: insert into STUDENT_CERTIFICATION (certification_name) values (?)
Hibernate: insert into STUDENT (student_name) values (?)
Hibernate: insert into STUDENT_CERTIFICATION (certification_name) values (?)
Hibernate: insert into STUDENT_STUDENT_CERTIFICATION (STUDENT_student_id, studentCertification_certification_id) values (?, ?)
Hibernate: insert into STUDENT_STUDENT_CERTIFICATION (STUDENT_student_id, studentCertification_certification_id) values (?, ?)

//pro 12 save, get, update, delete database operations using Hibernate (CRUD)
package org.nithish.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name="STUDENT_NEW")
public class Student {
	@Id @GeneratedValue
	private int student_id;
	
    private String student_name;
	
	
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

}
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		Student student1=new Student();
		student1.setStudent_name("Nithish");
		
		
		
		
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(student1);
	     
	     session.getTransaction().commit();
	     
	     session.close();
	     sessionFactory.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT (student_name) values (?)

//pro 13
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		Student student=new Student();
		student.setStudent_name("Nithish");
		
		
		
		
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(student);
	     student=(Student) session.get(Student.class,1);
	     System.out.println("Student object having student name as :"+student.getStudent_name());
	     
	     session.getTransaction().commit();
	     
	     session.close();
	     //sessionFactory.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_NEW (student_name) values (?)
Student object having student name as :Nithish

//pro 14
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		Student student=new Student();
		student.setStudent_name("Nithish");
		
		
		
		
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(student);
	     
	     student=(Student) session.get(Student.class,1);
	     System.out.println("Student object having student name as :"+student.getStudent_name());
	     student.setStudent_name("Nithish_Chandra");
	     session.update(student);
	     
	     session.getTransaction().commit();
	     
	     session.close();
	     //sessionFactory.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_NEW (student_name) values (?)
Student object having student name as :Nithish
Hibernate: update STUDENT_NEW set student_name=? where student_id=?

//pro 15
package org.nithish.hibernate;



import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		Student student=new Student();
		student.setStudent_name("Nithish");
		
		
		
		
	     
	     SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	     Session session=sessionFactory.openSession();
	     
	     session.beginTransaction();
	     
	     session.save(student);
	     
	     student=(Student) session.get(Student.class,1);
	     System.out.println("Student object having student name as :"+student.getStudent_name());
	     student.setStudent_name("Nithish_Chandra");
	     session.delete(student);
	     
	     session.getTransaction().commit();
	     
	     session.close();
	     //sessionFactory.close();

	}

}
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Hibernate: insert into STUDENT_NEW (student_name) values (?)
Student object having student name as :Nithish
Hibernate: delete from STUDENT_NEW where student_id=?

//pro 16 Hibernate Object States 01 (Transient, Persistent and Detached States)
