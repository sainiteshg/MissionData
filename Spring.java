
//Program 1
package spring.practice;

public interface Wheel {
	public void rotate();

}


package spring.practice;

public class BridgeStone implements Wheel{

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		System.out.println("BridgeStone is wheel here");
	}

}


package spring.practice;

public class Car {

	public Wheel wheel;

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	public void move(){
		System.out.println("Car is moving");
		this.getWheel().rotate();
	}
}


package spring.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Traveller {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Travel.xml");
		Car car=(Car)ctx.getBean("car");
		car.move();

	}

}


<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
	
<bean id="car" class= "spring.practice.Car">
	 <property name="wheel" ref="wheel"/>
</bean> 
<bean id="wheel" class="spring.practice.BridgeStone"/>
</beans>
	
	
//Program 2

package spring.practice;

public class Student {
	private String name;
	private String age;
	private String department;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

}

package spring.practice;

public class Books {
	private String bookTitle;
	private String author;
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
package spring.practice;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Class {
	public Class (String collegeName) {
		this.collegeName = collegeName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Map<String, Student> getStudentContacts() {
		return studentContacts;
	}
	public void setStudentContacts(Map<String, Student> studentContacts) {
		this.studentContacts = studentContacts;
	}
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}
	public Properties getFaculties() {
		return faculties;
	}
	public void setFaculties(Properties faculties) {
		this.faculties = faculties;
	}
	
	public String getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(String establishedYear) {
		this.establishedYear = establishedYear;
	}
	private String collegeName;
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	private String establishedYear;
	private List<Student> students;
	private Map<String,Student> studentContacts;
	private Set<Books> books;
	private Properties faculties;
	
	

}
package spring.practice;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanWiringDemo {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("BasicBeanWiring.xml");
		Class college=(Class)context.getBean("college");
		System.out.println("College Name: "+college.getCollegeName()+"\t Established Year is: "+college.getEstablishedYear());
		
		List<Student> students=college.getStudents();
		for(int i=0;i<students.size();i++){
			Student student=students.get(i);
			System.out.println("Student Name: "+student.getName()+"Age:"+student.getAge()+"Department:"+student.getDepartment());
		}
		
		Iterator <Books> booksIterator=college.getBooks().iterator();
		while(booksIterator.hasNext()){
			Books books=booksIterator.next();
			System.out.println("Book Author: "+books.getAuthor()+"Book Title: "+books.getBookTitle());
		}
		Map<String,Student> studentContact=college.getStudentContacts();
		
		Iterator<String> contactIterator=studentContact.keySet().iterator();
		while(contactIterator.hasNext()){
			String contact=contactIterator.next();
			Student student=studentContact.get(contact);
			System.out.println("Contact:"+contact+"StudentName:"+student);
		}
		
		Properties faculties=college.getFaculties();
		System.out.println("Faculty:"+faculties.getProperty("Robert"));
		System.out.println("Faculty:"+faculties.getProperty("Casper"));
		
		
		

	}

}
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
	<bean name="college" class="spring.practice.Class">
	 <constructor-arg value="IIT"/>
	  <property name="establishedYear" value="1945"/>
	  
	  <property name="students">
	  <list>
	  <ref bean="Richard"/>
	  <ref bean="Steve"/>
	  </list>
	  </property>
	  
	  <property name="books">
	  <set>
	  <ref bean="DBMS"/>
	  <ref bean="Java"/>
	  </set>
	  </property>
	  
	  <property name="studentContacts">
	  <map>
	  <entry key="001" value-ref="Richard"/>
	  <entry key="002" value-ref="Steve"/>
	  </map>
	  </property>
	  
	  <property name="faculties">
	  <props>
	  <prop key="Robert">Computer Science</prop>
	  <prop key="Casper">Mechanical</prop>
	  </props>
	  </property>  
	</bean>
	
	<bean name="Richard" class="spring.practice.Student">
	  <property name="name" value="Richard"/>
	  <property name="age" value="20"/>
	  <property name="department" value="ComputerScience"/>
	</bean>
	
	<bean name="Steve" class="spring.practice.Student">
	  <property name="name" value="Steve"/>
	  <property name="age" value="21"/>
	  <property name="department" value="Mechanical"/>
	</bean>
	
	<bean name="DBMS" class="spring.practice.Books">
	<property name="bookTitle" value="DataBaseManagementStudies"/>
	<property name="author" value="Santosh_Yerra"/>
	</bean>
	
	<bean name="Java" class="spring.practice.Books">
	<property name="bookTitle" value="SCJP"/>
	<property name="author" value="Kathy"/>
	</bean>
	</beans>
//program 3
package spring.practice;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Class {
	public Class (String collegeName) {
		this.collegeName = collegeName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Map<String, Student> getStudentContacts() {
		return studentContacts;
	}
	public void setStudentContacts(Map<String, Student> studentContacts) {
		this.studentContacts = studentContacts;
	}
	public Set<Books> getBooks() {
		return books;
	}
	public void setBooks(Set<Books> books) {
		this.books = books;
	}
	public Properties getFaculties() {
		return faculties;
	}
	public void setFaculties(Properties faculties) {
		this.faculties = faculties;
	}
	
	public String getEstablishedYear() {
		return establishedYear;
	}
	public void setEstablishedYear(String establishedYear) {
		this.establishedYear = establishedYear;
	}
	private String collegeName;
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	private String establishedYear;
	private List<Student> students;
	private Map<String,Student> studentContacts;
	private Set<Books> books;
	private Properties faculties;
	public void initMethod(){
		System.out.println("Hii bros");
	}
	

}
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
	<bean name="college" class="spring.practice.Class" init-method="initMethod">
	 <constructor-arg value="IIT"/>
	  <property name="establishedYear" value="1945"/>
	  
	  <property name="students">
	  <list>
	  <ref bean="Richard"/>
	  <ref bean="Steve"/>
	  </list>
	  </property>
	  
	  <property name="books">
	  <set>
	  <ref bean="DBMS"/>
	  <ref bean="Java"/>
	  </set>
	  </property>
	  
	  <property name="studentContacts">
	  <map>
	  <entry key="001" value-ref="Richard"/>
	  <entry key="002" value-ref="Steve"/>
	  </map>
	  </property>
	  
	  <property name="faculties">
	  <props>
	  <prop key="Robert">Computer Science</prop>
	  <prop key="Casper">Mechanical</prop>
	  </props>
	  </property>  
	</bean>
	
	<bean name="Richard" class="spring.practice.Student">
	  <property name="name" value="Richard"/>
	  <property name="age" value="20"/>
	  <property name="department" value="ComputerScience"/>
	</bean>
	
	<bean name="Steve" class="spring.practice.Student">
	  <property name="name" value="Steve"/>
	  <property name="age" value="21"/>
	  <property name="department" value="Mechanical"/>
	</bean>
	
	<bean name="DBMS" class="spring.practice.Books">
	<property name="bookTitle" value="DataBaseManagementStudies"/>
	<property name="author" value="Santosh_Yerra"/>
	</bean>
	
	<bean name="Java" class="spring.practice.Books">
	<property name="bookTitle" value="SCJP"/>
	<property name="author" value="Kathy"/>
	</bean>
	</beans>	
//Program 4
package spring.practice;

public class Book {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String bookTitle(){
		return this.getTitle();
	}
	

}
package spring.practice;

public class Car {

	public Wheel wheel;

	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
}
package spring.practice;

public class Student {

	private String studentName;
	private Book javaBook;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Book getJavaBook() {
		return javaBook;
	}
	public void setJavaBook(Book javaBook) {
		this.javaBook = javaBook;
	}
	
}
package spring.practice;

public class College {
	
	private Student collegeStudent;
	
	public College(Student student){
		this.collegeStudent=student;
	}

	public Student getCollegeStudent() {
		return collegeStudent;
	}

	public void setCollegeStudent(Student collegeStudent) {
		this.collegeStudent = collegeStudent;
	}

}
package spring.practice;

public class Wheel {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
package spring.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringDemo {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Autowiring.xml");
		
		//byName
		Student student=(Student) context.getBean("student");
		System.out.println(student.getJavaBook().getTitle());
		
		//byType
		Car car=(Car) context.getBean("car");
		System.out.println(car.getWheel().getName());
		
		//Constructor
		College college=(College) context.getBean("college");
		System.out.println(college.getCollegeStudent().getStudentName());

	}

}
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	<!-- Auto Wiring byName -->
	<bean name="student" class= "spring.practice.Student" autowire="byName">
	  <property name="studentName" value="Micheal"/>
	</bean>
	<bean name="javaBook" class="spring.practice.Book">
	 <property name="title" value="Java_Programming"/>
	</bean>
	<!-- Auto Wiring byType -->
	<bean name= "car" class="spring.practice.Car" autowire="byType"/>
	<bean name="alloyWheel" class="spring.practice.Wheel">
	 <property name="name" value="Alloy Wheel"/>
	</bean>
	
	<!-- Auto Wiring through Constructor -->
	<bean name="college" class="spring.practice.College" autowire="constructor"/>
</beans>
	

Output:
Jan 25, 2015 8:22:27 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@687c3b99: startup date [Sun Jan 25 20:22:27 EST 2015]; root of context hierarchy
Jan 25, 2015 8:22:27 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [Autowiring.xml]
Jan 25, 2015 8:22:27 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@9b6dce3: defining beans [student,javaBook,car,alloyWheel,college]; root of factory hierarchy
Java_Programming
Alloy Wheel
Micheal
//Program 5

	
	