//program 1
//web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>SpringMvcProject</display-name>
  <servlet>
  <servlet-name>spring-dispatcher</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
 <servlet-mapping>
 <servlet-name>spring-dispatcher</servlet-name>
 <url-pattern>/</url-pattern>
 </servlet-mapping>
</web-app>

//spring-dispatcher-servlet.xml

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
<bean id="HandlerMapping"	class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
<bean name="/welcome.html" class="org.nithish.hellocontroller.HelloController"/>

<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix">
		<value>/WEB-INF/</value>
	</property>	
	<property name="suffix">
		<value>.jsp</value>	
	</property>		
</bean>
</beans>	
	
//HelloPage.jsp

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h1>First Spring MVC application</h1>
<h2>${welcomeMessage}</h2>
</body>
</html>




//HelloController.java

package org.nithish.hellocontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelandview=new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage","Hi User,Welcome to first Mvc application");
		return modelandview;	
		
	}
}

//program 2
//web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>SpringMvcProject</display-name>
  <servlet>
  <servlet-name>spring-dispatcher</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
 <servlet-mapping>
 <servlet-name>spring-dispatcher</servlet-name>
 <url-pattern>/</url-pattern>
 </servlet-mapping>
</web-app>
//spring-dispatcher-servlet.xml

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
	
<context:component-scan base-package="org.nithish.hellocontroller"/>

<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix">
		<value>/WEB-INF/</value>
	</property>	
	<property name="suffix">
		<value>.jsp</value>	
	</property>		
</bean>
</beans>	
	
//HelloController.java
package org.nithish.hellocontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg","hello world");
		return model; 	
	}
	
}
//HelloPage.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h1>First Spring MVC application</h1>
<h2>${msg}</h2>
</body>
</html>
//Program 3 Multi Action Controller

package org.nithish.hellocontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg","hello world");
		return model; 	
	}
	@RequestMapping("/hi")
	public ModelAndView hiWorld(){
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg","hi world");
		return model; 	
	}
}
//Url : http://localhost:8080/FirstSpringMvcProject/greet/welcome

//Prrogram 4
package org.nithish.hellocontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome/countryName/{userName}")
	public ModelAndView helloWorld(){
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg","hello world");
		return model; 	
	}
	
}

Url:
http://localhost:8080/FirstSpringMvcProject/welcome/countryName/gontu

//Program 5 path variable
package org.nithish.hellocontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome/countryName/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name){
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg","hello "+name);
		return model; 	
	}
	
}

Url:
http://localhost:8080/FirstSpringMvcProject/welcome/countryName/gontu
Out:
hello gontu 

//Program 6 path variable
package org.nithish.hellocontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name,@PathVariable("countryName") String country){
		ModelAndView model=new ModelAndView("HelloPage");
		model.addObject("msg","hello "+name+"You are from "+country);
		return model; 	
	}
	
}
Url:
http://localhost:8080/FirstSpringMvcProject/welcome/India/gontu
Out:
First Spring MVC application

hello gontuYou are from India

//program 7 PathVariable

package org.nithish.hellocontroller;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String,String> pathVars){
		ModelAndView model=new ModelAndView("HelloPage");
		String name=pathVars.get("userName");
		String country=pathVars.get("countryName");
		model.addObject("msg","hello "+name+"You are from "+country);
		return model; 	
	}
	
}
//servlet-dispatcher-servlet.xml


<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:context="http://www.springframework.org/schema/context"
xmlns:mvc="http://www.springframework.org/schema/mvc" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="
    http://www.springframework.org/schema/beans     
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context 
    http://www.springframework.org/schema/context/spring-context-3.0.xsd
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">
	
	
<context:component-scan base-package="org.nithish.hellocontroller"/>
 <mvc:annotation-driven/>

<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix">
		<value>/WEB-INF/</value>
	</property>	
	<property name="suffix">
		<value>.jsp</value>	
	</property>		
</bean>
</beans>	
Url:
http://localhost:8080/FirstSpringMvcProject/welcome/India/gontu
Out:
First Spring MVC application

hello gontuYou are from India	

//program 8 Handling an HTML form using @RequestParam annotation

package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName")String name,@RequestParam("studentHobby")String hobby){
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details Submitted by you:: "+name+" Hobby:: "+hobby);
		return model; 
	}	
	
}
//AdmissionForm.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<body>
<h1>Student Admission Form for Engineering Courses</h1>


<form action="/FirstSpringMvcProject/submitAdmissionForm.html" method="post">
	<p>
		Student's Name:<input type="text" name="studentName"/>
	</p>
	<p>
		Student's Hobby:<input type="text" name="studentHobby"/>
	</p>
    <input type="submit" value="submit this form by clicking here"/>
</form>
</body>
</html>
//AdmissionSuccess.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<body>

<h1>Congratulations !! The Engineering College has processed your application Successfully</h1>

<h2>${msg}</h2>

</body>
</html>

Out:
Congratulations !! The Engineering College has processed your application Successfully

Details Submitted by you:: k Hobby:: k

//program 9 Handling an HTML form using @RequestParam annotation printing some default value

package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName",defaultValue="Mr XYZABC")String name,@RequestParam("studentHobby")String hobby){
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details Submitted by you:: "+name+" Hobby:: "+hobby);
		return model; 
	}	
	
}
Congratulations !! The Engineering College has processed your application Successfully

Details Submitted by you:: Mr XYZABC Hobby:: sex

//program 10 Handling an HTML form using @RequestParam annotation with map
package org.nithish.studentadmissioncontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String,String> reqParam){
		String name=reqParam.get("studentName");
		String hobby=reqParam.get("studentHobby");
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("msg","Details Submitted by you:: "+name+" Hobby:: "+hobby);
		return model; 
	}	
	
}

//program 11 
//Student.java
package org.nithish.studentadmissioncontroller;

public class Student {
  private String studentName;
  private String studentHobby;
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//StudentAdmissionController.java

package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("studentName")String name,
											@RequestParam("studentHobby")String hobby){
		Student student1=new Student();
		student1.setStudentHobby(hobby);
		student1.setStudentName(name);
		
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("headerMessage","Gvs College of Engineering,India");
		model.addObject("student1", student1);
		return model; 
	}	
	
}


//AdmissionSuccess.jsp

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<body>

<h1>${headerMessage}</h1>



<h3>Congratulations !! The Engineering College has processed your application Successfully</h3>



<h2>Details Submitted by You::</h2>
<table>
	<tr>
		<td>Student Name:</td>
		<td>${student1.studentName}</td>
	</tr>
	<tr>
		<td>Student Hobby:</td>
		<td>${student1.studentHobby}</td>
	</tr>

</table>

</body>
</html>

//program 12 Understanding @ModelAttribute annotation 02 ( using as a method argument )

package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1")Student student1){
		
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("headerMessage","Gvs College of Engineering,India");
		return model; 
	}	
	
}
//program 13 Understanding @ModelAttribute annotation 02 ( using at a method level )

package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");

		model.addObject("headerMessage","Gvs College of Engineering,India");
	
		return model;
	}
	
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1")Student student1){
		
		ModelAndView model=new ModelAndView("AdmissionSuccess");
		model.addObject("headerMessage","Gvs College of Engineering,India");
		return model; 
	}	
	
}

//program 14 Understanding @ModelAttribute annotation 02 ( using at a method level )

package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model1){
		model1.addAttribute("headerMessage","Gvs College of Engineering,India");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1")Student student1){
		
		ModelAndView model=new ModelAndView("AdmissionSuccess");return model; 
	}	
	
}
//program 15 Data Binding with Date, Collection (Arraylist), Long etc.
//Student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

public class Student {
  private String studentName;
  private String studentHobby;
  private long studentMobile;
  private Date studentDOB;
  private ArrayList<String> studentSkills;
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//AdmissionForm.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<body>
<h1>${headerMessage}</h1>
<h3>Student Admission Form for Engineering Courses</h3>


<form action="/FirstSpringMvcProject/submitAdmissionForm.html" method="post">
	<table>
		<tr>
		<td>Student's Name:</td><td><input type="text" name="studentName"/></td>
	    </tr>
	    <tr>
		<td>Student's Hobby:</td><td><input type="text" name="studentHobby"/></td>
	    </tr>
		<tr>
		<td>Student's Mobile:</td><td><input type="text" name="studentMobile"/></td>
	    </tr>
		<tr>
		<td>Student's DOB:</td><td><input type="text" name="studentDOB"/></td>
	    </tr>
	    <tr>
		<td>Student's Skills Set:</td><td><select name="studentSkills"  multiple>
									<option value="Java Core">Java Core</option>
									<option value="Spring Core">Spring Core</option>
									<option value="Spring MVC">Spring MVC</option>
									</select>
							   </td>
	    </tr>
	    </table>
    <input type="submit" value="submit this form by clicking here"/>
</form>
</body>
</html>
//AdmisssionSuccess.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<body>

<h1>${headerMessage}</h1>



<h3>Congratulations !! The Engineering College has processed your application Successfully</h3>



<h2>Details Submitted by You::</h2>
<table>
	<tr>
		<td>Student Name:</td>
		<td>${student1.studentName}</td>
	</tr>
	<tr>
		<td>Student Hobby:</td>
		<td>${student1.studentHobby}</td>
	</tr>
    <tr>
		<td>Student Mobile:</td>
		<td>${student1.studentMobile}</td>
	</tr>
	<tr>
		<td>Student DOB:</td>
		<td>${student1.studentDOB}</td>
	</tr>
	<tr>
		<td>Student Skills:</td>
		<td>${student1.studentSkills}</td>
	</tr>
	
</table>

</body>
</html>
//program 16 Data Binding with a User-Defined Type, BindingResult (concept)
//Student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

public class Student {
  private String studentName;
  private String studentHobby;
  private long studentMobile;
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//Address.java
package org.nithish.studentadmissioncontroller;

public class Address {
	private String country;
	private String city;
	private String state;
	private int pincode;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}

//AdmisssionForm.html
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<body>
<h1>${headerMessage}</h1>
<h3>Student Admission Form for Engineering Courses</h3>


<form action="/FirstSpringMvcProject/submitAdmissionForm.html" method="post">
	<table>
		<tr>
		<td>Student's Name:</td><td><input type="text" name="studentName"/></td>
	    </tr>
	    <tr>
		<td>Student's Hobby:</td><td><input type="text" name="studentHobby"/></td>
	    </tr>
		<tr>
		<td>Student's Mobile:</td><td><input type="text" name="studentMobile"/></td>
	    </tr>
		<tr>
		<td>Student's DOB:</td><td><input type="text" name="studentDOB"/></td>
	    </tr>
	    <tr>
		<td>Student's Skills Set:</td><td><select name="studentSkills"  multiple>
									<option value="Java Core">Java Core</option>
									<option value="Spring Core">Spring Core</option>
									<option value="Spring MVC">Spring MVC</option>
									</select>
							   </td>
	    </tr>
	    </table>
	    <table>
	    <tr><td>Student Address:</td></tr>
	    <tr>
	    <td>Country::<input type="text" name="studentAddress.country"/></td>
	    <td>City::<input type="text" name="studentAddress.city"/></td>
	    <td>State::<input type="text" name="studentAddress.state"/></td>
	    <td>Pincode::<input type="text" name="studentAddress.pincode"/></td>
	    </tr>
	    </table>
    <input type="submit" value="submit this form by clicking here"/>
</form>
</body>
</html>
//AdmissionSuccess.html
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<body>

<h1>${headerMessage}</h1>



<h3>Congratulations !! The Engineering College has processed your application Successfully</h3>



<h2>Details Submitted by You::</h2>
<table>
	<tr>
		<td>Student Name:</td>
		<td>${student1.studentName}</td>
	</tr>
	<tr>
		<td>Student Hobby:</td>
		<td>${student1.studentHobby}</td>
	</tr>
    <tr>
		<td>Student Mobile:</td>
		<td>${student1.studentMobile}</td>
	</tr>
	<tr>
		<td>Student DOB:</td>
		<td>${student1.studentDOB}</td>
	</tr>
	<tr>
		<td>Student Skills:</td>
		<td>${student1.studentSkills}</td>
	</tr>
	<tr>
		<td>Student Address:</td>
		<td>
		Country::${student1.studentAddress.country}
		City::${student1.studentAddress.city}
		State::${student1.studentAddress.state}
		Pincode::${student1.studentAddress.pincode}
		</td>
	</tr>
	
</table>

</body>
</html>

//program 17 Data Binding  BindingResult errors
//StudentAdmissionController.java
package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model1){
		model1.addAttribute("headerMessage","Gvs College of Engineering,India");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1")Student student1,BindingResult result){
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("AdmissionForm");
			return model;	
		}
		ModelAndView model=new ModelAndView("AdmissionSuccess");return model; 
	}	
	
}
//AdmissionForm.jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<h1>${headerMessage}</h1>
<h3>Student Admission Form for Engineering Courses</h3>

<form:errors path="student1.*"/>
<form action="/FirstSpringMvcProject/submitAdmissionForm.html" method="post">
	<table>
		<tr>
		<td>Student's Name:</td><td><input type="text" name="studentName"/></td>
	    </tr>
	    <tr>
		<td>Student's Hobby:</td><td><input type="text" name="studentHobby"/></td>
	    </tr>
		<tr>
		<td>Student's Mobile:</td><td><input type="text" name="studentMobile"/></td>
	    </tr>
		<tr>
		<td>Student's DOB:</td><td><input type="text" name="studentDOB"/></td>
	    </tr>
	    <tr>
		<td>Student's Skills Set:</td><td><select name="studentSkills"  multiple>
									<option value="Java Core">Java Core</option>
									<option value="Spring Core">Spring Core</option>
									<option value="Spring MVC">Spring MVC</option>
									</select>
							   </td>
	    </tr>
	    </table>
	    <table>
	    <tr><td>Student Address:</td></tr>
	    <tr>
	    <td>Country::<input type="text" name="studentAddress.country"/></td>
	    <td>City::<input type="text" name="studentAddress.city"/></td>
	    <td>State::<input type="text" name="studentAddress.state"/></td>
	    <td>Pincode::<input type="text" name="studentAddress.pincode"/></td>
	    </tr>
	    </table>
    <input type="submit" value="submit this form by clicking here"/>
</form>
</body>
</html>

//Program 19 @InitBinder annotation, WebDataBinder, CustomDateEditor (concept)

package org.nithish.studentadmissioncontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder){

		binder.setDisallowedFields(new String[]{"studentDOB"});
	}
	
	
	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model1){
		model1.addAttribute("headerMessage","Gvs College of Engineering,India");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1")Student student1,BindingResult result){
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("AdmissionForm");
			return model;	
		}
		ModelAndView model=new ModelAndView("AdmissionSuccess");return model; 
	}	
	
}
Out: Dob value is gone

//Program 20 @InitBinder annotation, WebDataBinder, CustomDateEditor (concept)

package org.nithish.studentadmissioncontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder){

		binder.setDisallowedFields(new String[]{"studentHobby"});
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class, "studentDOB",new CustomDateEditor(dateFormat, false));
	}
	
	
	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model1){
		model1.addAttribute("headerMessage","Gvs College of Engineering,India");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1")Student student1,BindingResult result){
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("AdmissionForm");
			return model;	
		}
		ModelAndView model=new ModelAndView("AdmissionSuccess");return model; 
	}	
	
}

Out: Date format as per need

//Program 21 Writing your own custom property editor class

//StudentAdmissionController.class
package org.nithish.studentadmissioncontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder){

		binder.setDisallowedFields(new String[]{"studentHobby"});
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class, "studentDOB",new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());
	}
	
	
	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model1){
		model1.addAttribute("headerMessage","Gvs College of Engineering,India");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1")Student student1,BindingResult result){
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("AdmissionForm");
			return model;	
		}
		ModelAndView model=new ModelAndView("AdmissionSuccess");return model; 
	}	
	
}
//StudentNameEditor.class
package org.nithish.studentadmissioncontroller;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport{

	//When you will submit Admission Form-->
	@Override
	public void setAsText(String studentName){
		if(studentName.contains("Mr.")|| studentName.contains("Mrs.")){
			setValue(studentName); 
		}
		else {
			studentName="Mrs."+studentName;
			setValue(studentName);//What ever value you provide to setValue
								//Spring Mvc will use the same value to perform Data Binding for studentName Property	
		}
	}
	
}

//program 21 Form Validations 01 ( using JSR 303/349 provided annotations )
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

public class Student {
  private String studentName;
  @Size(min=2,max=30)
  private String studentHobby;
  private long studentMobile;
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
package org.nithish.studentadmissioncontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder){

		//binder.setDisallowedFields(new String[]{"studentHobby"});
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class, "studentDOB",new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());
	}
	
	
	@RequestMapping(value="/admisssionForm.html",method=RequestMethod.GET)
	public ModelAndView getAdmisssionForm(){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	
	@ModelAttribute
	public void addingCommonObjects(Model model1){
		model1.addAttribute("headerMessage","Gvs College of Engineering,India");
	}
	
	@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@Valid@ModelAttribute("student1")Student student1,BindingResult result){
		if(result.hasErrors()){
			ModelAndView model=new ModelAndView("AdmissionForm");
			return model;	
		}
		ModelAndView model=new ModelAndView("AdmissionSuccess");return model; 
	}	
	
}
//program 22 Form Validation 02 (customizing error messages using Spring MessageSource)

package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

public class Student {
  private String studentName;
  @Size(min=2,max=30,message="please enter the value for student Hobby between 2 and 30 characters")
  private String studentHobby;
  private long studentMobile;
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//program 23 Form Validation 02 (customizing error messages using Spring MessageSource)

package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

public class Student {
  private String studentName;
  @Size(min=2,max=30,message="please enter the value for student Hobby between {min} and {max} characters")
  private String studentHobby;
  private long studentMobile;
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//program 24 Form Validation 02 (customizing error messages using Spring MessageSource)
//spring-dispatcher-servlet.xml

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:mvc="http://www.springframework.org/schema/mvc" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd 
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    
 <mvc:annotation-driven/>   
 <context:component-scan base-package="org.nithish.studentadmissioncontroller"/>
 

<bean id="viewResolver" 
	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix">
		<value>/WEB-INF/</value>
	</property>	
	<property name="suffix">
		<value>.jsp</value>	
	</property>		
</bean>

<bean id="messageSource"
			class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
			<property name="basename" value="/WEB-INF/studentmessages"/>
</bean>
</beans>	
	
//studentmessages.properties
Size.student1.studentHobby=please enter the value for student Hobby between 2 and 30 characters
//student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Size;

public class Student {
  private String studentName;
  @Size(min=2,max=30)
  private String studentHobby;
  private long studentMobile;
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//program 25 Form Validation 03 (more on Spring MessageSource concept...)
Size.student1.studentHobby=please enter the value for {0} between {2} and {1} characters
//program 26 Form Validations 04 (@Pattern, @Past, @Max and some more...)
//Student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
  @Pattern(regexp="[^0-9]*")
  private String studentName;
  @Size(min=2,max=30)
  private String studentHobby;
  private long studentMobile;
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//program 27 Form Validations 04 (@Pattern, @Past, @Max and some more...)
//Student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
  @Pattern(regexp="[^0-9]*")
  private String studentName;
  @Size(min=2,max=30)
  private String studentHobby;
  private long studentMobile;
  @Past
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//program 28 Form Validations 04 (@Pattern, @Past, @Max and some more...)
//Student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
  @Pattern(regexp="[^0-9]*")
  private String studentName;
  @Size(min=2,max=30)
  private String studentHobby;
  @Max(2222)
  private long studentMobile;
  @Past
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//program 29 Form Validations 05 ( writing a custom Form Validation annotation )
//HobbyValidator.java
package org.nithish.studentadmissioncontroller;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby,String>{


	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if(studentHobby==null){
			return false;
		}
		if(studentHobby.matches("Music|Football|Cricket|Hockey")){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public void initialize(IsValidHobby isValidHobby) {
		// TODO Auto-generated method stub
		
	}
}
//IsValidHobby.java
package org.nithish.studentadmissioncontroller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;
import javax.validation.Constraint;

@Documented
@Constraint(validatedBy=HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {

	
	String message() default "Please provide a valid Hobby;"+
	         "accepted Hobbies are-Music,Football,Cricket,Hobby(Choose any one)";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};	
}
//Student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
  @Pattern(regexp="[^0-9]*")
  private String studentName;
  @Size(min=2,max=30)@IsValidHobby
  private String studentHobby;
  @Max(2222)
  private long studentMobile;
  @Past
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//program 30  Form Validations 06 (More on custom Form Validation annotation...)
//Student.java
package org.nithish.studentadmissioncontroller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
  @Pattern(regexp="[^0-9]*")
  private String studentName;
  @Size(min=2,max=30)@IsValidHobby
  private String studentHobby;
  @Max(2222)
  private long studentMobile;
  @Past
  private Date studentDOB;
  private ArrayList<String> studentSkills;
  private Address studentAddress;
  

public Address getStudentAddress() {
	return studentAddress;
}
public void setStudentAddress(Address studentAddress) {
	this.studentAddress = studentAddress;
}
public long getStudentMobile() {
	return studentMobile;
}
public void setStudentMobile(long studentMobile) {
	this.studentMobile = studentMobile;
}
public Date getStudentDOB() {
	return studentDOB;
}
public void setStudentDOB(Date studentDOB) {
	this.studentDOB = studentDOB;
}
public ArrayList<String> getStudentSkills() {
	return studentSkills;
}
public void setStudentSkills(ArrayList<String> studentSkills) {
	this.studentSkills = studentSkills;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getStudentHobby() {
	return studentHobby;
}
public void setStudentHobby(String studentHobby) {
	this.studentHobby = studentHobby;
}
}
//IsValidHobby.java
package org.nithish.studentadmissioncontroller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;
import javax.validation.Constraint;

@Documented
@Constraint(validatedBy=HobbyValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {

	String listOfValidHobbies()default "Music|Football|Cricket|Hockey";
	String message() default "Please provide a valid Hobby;"+
	         "accepted Hobbies are-Music,Football,Cricket,Hobby(Choose any one)";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};	
}
//HobbyValidator.java
package org.nithish.studentadmissioncontroller;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby,String>{

    private String listOfHobbies;
    @Override
	public void initialize(IsValidHobby isValidHobby) {
		this.listOfHobbies=isValidHobby.listOfValidHobbies();
		
	}
	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		if(studentHobby==null){
			return false;
		}
		if(studentHobby.matches(listOfHobbies)){
			return true;
		}
		else{
			return false;
		}
		
	}
}
//program 31 Interceptor 01 ( Introduction with a hands on session )

//DayOfWeekBasedAccessInterceptor.java
package org.nithish.studentadmissioncontroller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws IOException{
		//if this application returns true application will handle further request	
		//if this application returns false application will not handle further request	
		Calendar cal=Calendar.getInstance();
		@SuppressWarnings("static-access")
		int dayOfWeek=cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek==1){
			//1 means Sunday 2 means Monday..
			response.getWriter().write("Website is Closed On Sunday.Try on other days");
			return false;
		}
		else{
			return true;
		}
		
	}
	
}
//spring-dispatcher-servlet.xml

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:mvc="http://www.springframework.org/schema/mvc" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd 
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    
 <mvc:annotation-driven/>   
 <context:component-scan base-package="org.nithish.studentadmissioncontroller"/>
 
 
 <mvc:interceptors>
 <bean class="org.nithish.studentadmissioncontroller.DayOfWeekBasedAccessInterceptor"/>
 </mvc:interceptors>

<bean id="viewResolver" 
	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix">
		<value>/WEB-INF/</value>
	</property>	
	<property name="suffix">
		<value>.jsp</value>	
	</property>		
</bean>

<bean id="messageSource"
			class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
			<property name="basename" value="/WEB-INF/studentmessages"/>
</bean>
</beans>	
	
//program 32 Interceptor 02 ( more on understanding basics of it... )
	
	package org.nithish.studentadmissioncontroller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws IOException{
		//if this application returns true application will handle further request	
		//if this application returns false application will not handle further request	
		Calendar cal=Calendar.getInstance();
		@SuppressWarnings("static-access")
		int dayOfWeek=cal.get(cal.DAY_OF_WEEK);
		if(dayOfWeek==1){
			//1 means Sunday 2 means Monday..
			response.getWriter().write("Website is Closed On Sunday.Try on other days");
			return false;
		}
		else{
			return true;
		}
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,ModelAndView model) throws IOException{
				
		//This method will be called after Spring Mvc executes request handler method for the request
	System.out.println("Handler Interceptor Adapter:Spring Mvc called postHandle method for: "+request.getRequestURI().toString());
	}
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler,Exception ex){
		//This method will be called after response object is produced by the view for the request
		System.out.println("Handler Interceptor Adapter:Spring Mvc called afterCompletion method for: "+request.getRequestURI().toString());
			
	}
}
//program 33 Interceptor 02 ( more on understanding basics of it... )

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:mvc="http://www.springframework.org/schema/mvc" 
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context.xsd 
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc.xsd">
    
 <mvc:annotation-driven/>   
 <context:component-scan base-package="org.nithish.studentadmissioncontroller"/>
 
 
 <mvc:interceptors>
 <mvc:interceptor>
 <mvc:mapping path="/admisssionForm.html"/>
 <bean class="org.nithish.studentadmissioncontroller.DayOfWeekBasedAccessInterceptor"/>
 </mvc:interceptor>
 </mvc:interceptors>

<bean id="viewResolver" 
	class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<property name="prefix">
		<value>/WEB-INF/</value>
	</property>	
	<property name="suffix">
		<value>.jsp</value>	
	</property>		
</bean>

<bean id="messageSource"
			class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
			<property name="basename" value="/WEB-INF/studentmessages"/>
</bean>
</beans>	
//program 34	
//File Uploading Spring MVC
package org.nithish.springmvc;

import org.springframework.web.multipart.MultipartFile;

public class File {
	MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
package org.nithish.springmvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class FileValidator implements Validator{

	public boolean supports(Class<?> paramClass) {
		return File.class.equals(paramClass);
	}

	public void validate(Object object, Errors errors) {
		File file=(File) object;
		if(file.getFile().getSize()==0){
			//errors.rejectValue("file", "valid.entry");
			errors.rejectValue("file", "Invalid Document","valid");
		}
		
		
	}

}
package org.nithish.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file.htm")
public class FileController {
	@Autowired
	FileValidator fileValidator;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
	        binder.setValidator(fileValidator);
	}
	@RequestMapping(method=RequestMethod.GET)
	public String getForm(Model model){
		File fileModel=new File();
		model.addAttribute("file",fileModel);
		return "file";	
	}
	@RequestMapping(method=RequestMethod.POST)
	public String fileUploaded(Model model, @Validated File file, BindingResult result){
	String returnVal="successFile";
	if(result.hasErrors()){
		returnVal= "file";
	}
	else{
		@SuppressWarnings("unused")
		MultipartFile multipartFile=file.getFile();
	}
	return returnVal;
	}


}
//file.jsp
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<body> 

<h2>Spring MVC - Uploading a file.. </h2>
	<form:form method="POST" commandName="file"	enctype="multipart/form-data">
 
		Upload your file please: 
		<input type="file" name="file" />
		<input type="submit" value="upload" />
		<form:errors path="file" cssStyle="color: #ff0000;" />
	</form:form>
 
</body>
</html>
//successFile.jsp
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<h2>Spring MVC - Uploading a file.. </h2>
Your file is successfully uploaded.
</body>
</html>
//web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0"> <display-name>Archetype Created Web Application</display-name>
 
	<servlet>
		<servlet-name>mvc-dispatcher</servlet-name>
		<servlet-class>
			org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
 
	<servlet-mapping>
		<servlet-name>mvc-dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping> 
</web-app>	
//mvc-dispatcher-servlet.xml
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:context="http://www.springframework.org/schema/context" xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation=" http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">

	<context:component-scan base-package="org.nithish.springmvc" />
	<mvc:annotation-driven />

	<bean id="fileValidator"
		class="org.nithish.springmvc.FileValidator" />

	<bean id="multipartResolver"
		class="org.springframework.web.multipart.commons.CommonsMultipartResolver" />

	<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
      <property name="basenames">
      <list>
      <value>classpath:message</value>
      </list>
      </property>
    </bean>
  

	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix">
			<value>/WEB-INF/</value>
		</property>
		<property name="suffix">
			<value>.jsp</value>
		</property>
	</bean>

</beans>	
//program 35
//Exception Handling in Spring MVC
package org.nithish.springmvc;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message="This is an Custom Exception";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CustomException(String message){
		this.message=message;
	}
	

}
package org.nithish.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	@RequestMapping(value="/second",method=RequestMethod.GET)
	public ModelAndView controller ()throws CustomException{
		System.out.println("Throwing exception");
		 throw new CustomException("This is Exception from Controller");	
	}
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex){
		System.out.println("Handling Custom Exception");
		ModelAndView model=new ModelAndView("error");
		model.addObject("error",ex);
		return model;
	}

}
//error.jsp
<html>
<body>
	<h1>Spring 3.2.3 MVC</h1>
	
	<h3>Error page..:  "${error.getMessage()}"</h3>	
</body>
</html>

//Spring REST Hello World JSON
package org.nithish.springmvc;

public class Shop {
	String name;
	String staffName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

}
package org.nithish.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/kfc/brands")
public class JSONController {
	@RequestMapping(value="{name}/{staffName}",method=RequestMethod.GET)
	public @ResponseBody Shop getShopDetails(@PathVariable("name")String name,@PathVariable("staffName")String staff){
		Shop shop=new Shop();
		shop.setName(name);
		shop.setStaffName(staff);
		return shop;
	}

}

//Movie name Like HelloWorld

package org.nithish.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieController {
	
	@RequestMapping("movieSite/{movieName}")
	public ModelAndView getMovieName(@PathVariable("movieName") String name){
		ModelAndView model=new ModelAndView("movieName");
		model.addObject("name",name);
		return model;
	}

}
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<f:view>
<h3>Movie Name  "${name}"</h3>
</f:view>
</body>
</html>
//Spring mvc Rest XML response
package org.nithish.springmvc;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coffee {
	
	private String brand;
	private int quantity;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Coffee(String brand, int quantity) {
		super();
		this.brand = brand;
		this.quantity = quantity;
	}
	public Coffee(){
		
	}

}
package org.nithish.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/coffee")
public class CoffeeController {
	
	@RequestMapping(value="/{brand}/{quantity}",method=RequestMethod.GET)
	@ResponseBody
	public Coffee coffeeController (@PathVariable("brand") String coffeeBrand ,@PathVariable("quantity")int  quantity){
		Coffee coffee= new Coffee();
		coffee.setBrand(coffeeBrand);
		coffee.setQuantity(quantity);
		return coffee;
		
	}

}



