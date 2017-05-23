//program 1

package org.SpringAop;

import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
        System.out.println(shapeService.getCircle().getName());
	}

}

package org.SpringAop.service;

import org.SpringAop.model.Circle;
import org.SpringAop.model.Triangle;

public class shapeservice {

	private Circle circle;
	private Triangle triangle;
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
}


package org.SpringAop.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}

package org.SpringAop.model;

public class Triangle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
				http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd
				http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	
	<bean name="circle" class="org.SpringAop.model.Circle">
	  <property name="name" value="Circle Name"/>
	</bean>
	<bean name="triangle" class="org.SpringAop.model.Triangle">
	  <property name="name" value="Triangle Name"/>
	</bean>
	<bean name="shapeService" class="org.SpringAop.service.shapeservice" autowire="byName"/>
	</beans>
	
	
	//program 2 Writing first aspect
	
	package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {

	@Before("execution(public String getName())")
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
}

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
				http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd
				http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	<aop:aspectj-autoproxy/>
	<bean name="circle" class="org.SpringAop.model.Circle">
	  <property name="name" value="Circle Name"/>
	</bean>
	<bean name="triangle" class="org.SpringAop.model.Triangle">
	  <property name="name" value="Triangle Name"/>
	</bean>
	<bean name="shapeService" class="org.SpringAop.service.shapeservice" autowire="byName"/>
	<bean name="loggingAspect" class="org.SpringAop.Aspect.LoggingAspect"/>
	</beans>
	
	
	package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {

	@Before("execution(public String getName())")
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
}

//program 3 Pointcuts and Wildcard Expressions

//Restrict access only for class Circle
package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {

	@Before("execution(public String org.SpringAop.model.Circle.getName())")
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
}

//prog 4 wildcards
package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {

	@Before("execution(public * get*())")
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
}
//program 5
package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {

	@Before("execution(public * get*(..))")//any number of arguments inside get method
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
}
Out:
Jul 06, 2015 12:41:23 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 12:41:23 EDT 2015]; root of context hierarchy
Jul 06, 2015 12:41:23 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 12:41:23 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Aspect run.Get Method called//getCircle
Aspect run.Get Method called//getName
Circle Name

//program 6 tow advices called
package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {

	@Before("execution(public * get*())")
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
	@Before("execution(public * get*(..))")
	public void SecondAdvice()
	{
		System.out.println("Second Advice.Get Method called");
	}
}
Out:
Jul 06, 2015 12:49:20 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 12:49:20 EDT 2015]; root of context hierarchy
Jul 06, 2015 12:49:21 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 12:49:21 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Second Advice.Get Method called
Aspect run.Get Method called
Second Advice.Get Method called
Aspect run.Get Method called
Circle Name

//program 7 pointcuts
package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allGetters()")
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
	@Before("allGetters()")
	public void SecondAdvice()
	{
		System.out.println("Second Advice.Get Method called");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
}
Out:
Jul 06, 2015 12:55:17 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 12:55:17 EDT 2015]; root of context hierarchy
Jul 06, 2015 12:55:17 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 12:55:17 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Aspect run.Get Method called
Second Advice.Get Method called
Aspect run.Get Method called
Second Advice.Get Method called
Circle Name

//program 8 within circle all methods should run advice method

package org.SpringAop.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allGetters() && allCircleMethods()")
	public void LoggingAdvice()
	{
		System.out.println("Aspect run.Get Method called");
	}
	@Before("allGetters()")
	public void SecondAdvice()
	{
		System.out.println("Second Advice.Get Method called");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
Out:
Jul 06, 2015 1:31:57 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 13:31:57 EDT 2015]; root of context hierarchy
Jul 06, 2015 1:31:57 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 1:31:57 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Second Advice.Get Method called
Aspect run.Get Method called
Second Advice.Get Method called
Circle Name

//program 9 Join points and advice arguments
package org.SpringAop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.toString());//which method called
	}
	
	
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
Out:
Jul 06, 2015 3:34:45 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 15:34:45 EDT 2015]; root of context hierarchy
Jul 06, 2015 3:34:45 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 3:34:45 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
execution(String org.SpringAop.model.Circle.getName())
Circle Name

//program 10
package org.SpringAop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.getTarget());//object whose method was called is given
	}
	
	
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
out:
Jul 06, 2015 3:36:26 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 15:36:26 EDT 2015]; root of context hierarchy
Jul 06, 2015 3:36:26 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 3:36:27 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
org.SpringAop.model.Circle@2aa3cd93
Circle Name

//program 11
package org.SpringAop;

import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		shapeService.getCircle().setName("Dummy Name");
        System.out.println(shapeService.getCircle().getName());
	}

}

package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@Before("args(String)")
	public void stringArgumentMethods()
	{
		System.out.println("A method which take String arguments");
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
Out:
Jul 06, 2015 3:40:29 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 15:40:29 EDT 2015]; root of context hierarchy
Jul 06, 2015 3:40:29 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 3:40:29 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
A method which take String arguments
Dummy Name

//Program 12
package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@Before("args(name)")
	public void stringArgumentMethods(String name)
	{
		System.out.println("A method which take String arguments.It is "+name);
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
Out:
Jul 06, 2015 4:44:41 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 16:44:41 EDT 2015]; root of context hierarchy
Jul 06, 2015 4:44:41 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 4:44:41 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
A method which take String arguments.It is Dummy Name
Dummy Name

//Program 13 After advice Types
package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@After("args(name)")
	public void stringArgumentMethods(String name)
	{
		System.out.println("A method which take String arguments.It is "+name);
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
out:
Jul 06, 2015 6:14:53 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 18:14:53 EDT 2015]; root of context hierarchy
Jul 06, 2015 6:14:53 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 6:14:53 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Circle's Sttter Called//Initialization by Spring container by xml
Circle's Sttter Called
A method which take String arguments.It is Dummy Name
//program 

package org.SpringAop.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's Sttter Called");
		throw new RuntimeException();
		
	}

	

}
package org.SpringAop.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@AfterReturning("args(name)")
	public void stringArgumentMethods(String name)
	{
		System.out.println("A method which take String arguments.It is "+name);
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
				http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd
				http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	
	<aop:aspectj-autoproxy/>
	<bean name="circle" class="org.SpringAop.model.Circle">
	</bean>
	<bean name="triangle" class="org.SpringAop.model.Triangle">
	  <property name="name" value="Triangle Name"/>
	</bean>
	<bean name="shapeService" class="org.SpringAop.service.shapeservice" autowire="byName"/>
	<bean name="loggingAspect" class="org.SpringAop.Aspect.LoggingAspect"/>
	</beans>
Out:
Jul 06, 2015 6:20:20 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 18:20:20 EDT 2015]; root of context hierarchy
Jul 06, 2015 6:20:20 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 6:20:20 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Circle's Sttter Called
Jul 06, 2015 6:20:20 PM org.springframework.beans.factory.support.DefaultListableBeanFactory destroySingletons
INFO: Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'circle' defined in class path resource [spring.xml]: Error setting property values; nested exception is org.springframework.beans.PropertyBatchUpdateException; nested PropertyAccessExceptions (1) are:
PropertyAccessException 1: org.springframework.beans.MethodInvocationException: Property 'name' threw exception; nested exception is java.lang.RuntimeException
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1361)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1086)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:456)
	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:291)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:288)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:190)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:580)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:895)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:425)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:139)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:83)
	at org.SpringAop.Aopmain.main(Aopmain.java:10)
Caused by: org.springframework.beans.PropertyBatchUpdateException; nested PropertyAccessExceptions (1) are:
PropertyAccessException 1: org.springframework.beans.MethodInvocationException: Property 'name' threw exception; nested exception is java.lang.RuntimeException
	at org.springframework.beans.AbstractPropertyAccessor.setPropertyValues(AbstractPropertyAccessor.java:102)
	at org.springframework.beans.AbstractPropertyAccessor.setPropertyValues(AbstractPropertyAccessor.java:58)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyPropertyValues(AbstractAutowireCapableBeanFactory.java:1358)
	... 13 more

//Program 14 After advice Types
package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@AfterReturning("args(name)")
	public void stringArgumentMethods(String name)
	{
		System.out.println("A method which take String arguments.It is "+name);
	}
	
	 
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
//Program 15 After advice Types
package org.SpringAop;


package org.SpringAop.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's Sttter Called");
		throw new RuntimeException();
		
	}

	

}
package org.SpringAop;

import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		shapeService.getCircle().setName("Dummy Name");
        //System.out.println(shapeService.getCircle().getName());
	}

}
package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@AfterReturning("args(name)")
	public void stringArgumentMethods(String name)
	{
		System.out.println("A method which take String arguments.It is "+name);
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name)
	{
		System.out.println("An exception has been thrown");
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
Out:
Jul 06, 2015 6:25:21 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 18:25:21 EDT 2015]; root of context hierarchy
Jul 06, 2015 6:25:21 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 6:25:21 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Circle's Sttter Called
An exception has been thrown
Exception in thread "main" java.lang.RuntimeException
	at org.SpringAop.model.Circle.setName(Circle.java:13)
	at org.SpringAop.model.Circle$$FastClassByCGLIB$$67753a58.invoke(<generated>)
	at net.sf.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)
	at org.springframework.aop.framework.Cglib2AopProxy$CglibMethodInvocation.invokeJoinpoint(Cglib2AopProxy.java:688)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:150)
	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:55)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:161)
	at org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor.invoke(AfterReturningAdviceInterceptor.java:50)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:161)
	at org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:50)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:89)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at org.springframework.aop.framework.Cglib2AopProxy$DynamicAdvisedInterceptor.intercept(Cglib2AopProxy.java:621)
	at org.SpringAop.model.Circle$$EnhancerByCGLIB$$e02a93a2.setName(<generated>)
	at org.SpringAop.Aopmain.main(Aopmain.java:12)

//program
import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		shapeService.getCircle().setNameandReturn("Dummy Name");
        
	}

}
package org.SpringAop.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's Setter Called");
		throw new RuntimeException();
		
	}

	public String setNameandReturn(String name) {
		this.name = name;
		System.out.println("Circle's Sttter Called");
		return name;
		
	}

	

}
out:
Jul 06, 2015 6:34:07 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 18:34:07 EDT 2015]; root of context hierarchy
Jul 06, 2015 6:34:07 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 6:34:07 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Circle's Setter Called
A method which take String arguments.It is Dummy Name

//Program 16 After advice Types
package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentMethods(String name,String returnString)//other return types Object returntype is used
	{
		System.out.println("A method which take String arguments.It is "+name+"the output value is"+returnString);
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name)
	{
		System.out.println("An exception has been thrown");
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
Out:
Jul 06, 2015 6:36:08 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 18:36:08 EDT 2015]; root of context hierarchy
Jul 06, 2015 6:36:08 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 6:36:09 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Circle's Setter Called
A method which take String arguments.It is Dummy Namethe output value isDummy Name


//Program 17 After advice Type

	package org.SpringAop;

import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		shapeService.getCircle().setName("Dummy Name");
        
	}

}


package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentMethods(String name,String returnString)
	{
		System.out.println("A method which take String arguments.It is "+name+"the output value is"+returnString);
	}
	
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionAdvice(String name,RuntimeException ex)
	{
		System.out.println("An exception has been thrown"+ex);
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
Out:
Jul 06, 2015 6:41:10 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 18:41:10 EDT 2015]; root of context hierarchy
Jul 06, 2015 6:41:10 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 6:41:10 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Circle's Setter Called
Exception in thread "main" An exception has been thrownjava.lang.RuntimeException
java.lang.RuntimeException
	at org.SpringAop.model.Circle.setName(Circle.java:13)
	at org.SpringAop.model.Circle$$FastClassByCGLIB$$67753a58.invoke(<generated>)
	at net.sf.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)
	at org.springframework.aop.framework.Cglib2AopProxy$CglibMethodInvocation.invokeJoinpoint(Cglib2AopProxy.java:688)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:150)
	at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:55)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:161)
	at org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor.invoke(AfterReturningAdviceInterceptor.java:50)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:161)
	at org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:50)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:89)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at org.springframework.aop.framework.Cglib2AopProxy$DynamicAdvisedInterceptor.intercept(Cglib2AopProxy.java:621)
	at org.SpringAop.model.Circle$$EnhancerByCGLIB$$e02a93a2.setName(<generated>)
	at org.SpringAop.Aopmain.main(Aopmain.java:12)

//Program 17 Around advice Type	
package org.SpringAop;

import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		shapeService.getCircle();
        
	}

}

package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentMethods(String name,String returnString)
	{
		System.out.println("A method which take String arguments.It is "+name+"the output value is"+returnString);
	}
	
	
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
	
		Object returnValue=null;
		try {
			System.out.println("Before Advice");
			returnValue=proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionAdvice(String name,RuntimeException ex)
	{
		System.out.println("An exception has been thrown"+ex);
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}
package org.SpringAop;

import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		shapeService.getCircle();
        
	}

}
Out:
Jul 06, 2015 7:11:18 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 19:11:18 EDT 2015]; root of context hierarchy
Jul 06, 2015 7:11:18 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 7:11:19 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Before Advice
After Returning
After Finally




//Program 18 Naming convention and custom advice Annotations
package org.SpringAop.Aspect;

public @interface Loggable {

}
package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint)
	{
		
	}
	
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentMethods(String name,String returnString)
	{
		System.out.println("A method which take String arguments.It is "+name+"the output value is"+returnString);
	}
	
	
	@Around("@annotation(org.SpringAop.Aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
	
		Object returnValue=null;
		try {
			System.out.println("Before Advice");
			returnValue=proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void exceptionAdvice(String name,RuntimeException ex)
	{
		System.out.println("An exception has been thrown"+ex);
	}
	@Pointcut("execution(* get*())")
	public void allGetters()
	{
		
	}
	@Pointcut("within (org.SpringAop.model.Circle)")
	public void allCircleMethods(){}
}

package org.SpringAop.service;

import org.SpringAop.Aspect.Loggable;
import org.SpringAop.model.Circle;
import org.SpringAop.model.Triangle;

public class shapeservice {

	private Circle circle;
	private Triangle triangle;
	@Loggable
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
}

package org.SpringAop;

import org.SpringAop.service.shapeservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aopmain {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		shapeService.getCircle();
        
	}

}
Out:
Jul 06, 2015 8:21:32 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 20:21:32 EDT 2015]; root of context hierarchy
Jul 06, 2015 8:21:32 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 8:21:32 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@2eee9593: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect]; root of factory hierarchy
Before Advice
After Returning
After Finally

//Program 19 AOP XML Configuration
package org.SpringAop.Aspect;

import org.SpringAop.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LoggingAspect {

	
	
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
	{
	
		Object returnValue=null;
		try {
			System.out.println("Before Advice");
			returnValue=proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After Throwing");
		}
		System.out.println("After Finally");
		return returnValue;
	}
	
	
	}
	

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xmlns:context="http://www.springframework.org/schema/context"
		xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
				http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.0.xsd
				http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-2.5.xsd">

	<aop:aspectj-autoproxy/>
	<bean name="circle" class="org.SpringAop.model.Circle">
	  <!-- <property name="name" value="Circle Name"/> -->
	</bean>
	<bean name="triangle" class="org.SpringAop.model.Triangle">
	  <property name="name" value="Triangle Name"/>
	</bean>
	<bean name="shapeService" class="org.SpringAop.service.shapeservice" autowire="byName"/>
	<bean name="loggingAspect" class="org.SpringAop.Aspect.LoggingAspect"/>
	
	<aop:config>
	  <aop:aspect id="loggingAspect" ref="loggingAspect">
	    <aop:around pointcut="execution(* get*())" method="myAroundAdvice"/>
	  </aop:aspect>
	</aop:config>
	</beans>
out:
Jul 06, 2015 8:36:07 PM org.springframework.context.support.ClassPathXmlApplicationContext prepareRefresh
INFO: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@2e5d6d97: startup date [Mon Jul 06 20:36:07 EDT 2015]; root of context hierarchy
Jul 06, 2015 8:36:07 PM org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
INFO: Loading XML bean definitions from class path resource [spring.xml]
Jul 06, 2015 8:36:08 PM org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
INFO: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@d041cf: defining beans [org.springframework.aop.config.internalAutoProxyCreator,circle,triangle,shapeService,loggingAspect,org.springframework.aop.aspectj.AspectJPointcutAdvisor#0]; root of factory hierarchy
Before Advice
After Returning
After Finally
	
//AOP Proxies
//program 20
package org.SpringAop.service;

import org.SpringAop.model.Circle;
import org.SpringAop.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType)
	{
	 if(beanType.equals("shapeService"))	return new shapeservice() ;
	 if(beanType.equals("circle"))	return new Circle() ;
	 if(beanType.equals("triangle"))	return new Triangle() ;
	  return null;
	 
	}
}
package org.SpringAop.service;

import org.SpringAop.Aspect.Loggable;
import org.SpringAop.model.Circle;
import org.SpringAop.model.Triangle;

public class shapeservice {

	private Circle circle;
	private Triangle triangle;
	@Loggable
	public Circle getCircle() {
		System.out.println("Circle Getter Called");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
}
package org.SpringAop;

import org.SpringAop.service.FactoryService;
import org.SpringAop.service.shapeservice;

public class Aopmain {

	public static void main(String[] args) {
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		//shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		FactoryService factoryService=new FactoryService();
		shapeservice shapeservice=(shapeservice)factoryService.getBean("shapeService");
		shapeservice.getCircle();
        
	}

}
Out:
Circle Getter Called
//program 21 how before advice is developed
package org.SpringAop.service;

import org.SpringAop.model.Circle;
import org.SpringAop.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType)
	{
	 if(beanType.equals("shapeService"))	return new ShapeServiceProxy() ;
	 if(beanType.equals("circle"))	return new Circle() ;
	 if(beanType.equals("triangle"))	return new Triangle() ;
	  return null;
	 
	}
}
package org.SpringAop.service;

import org.SpringAop.Aspect.LoggingAspect;
import org.SpringAop.model.Circle;

public class ShapeServiceProxy  extends shapeservice{

	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
package org.SpringAop;

import org.SpringAop.service.FactoryService;
import org.SpringAop.service.shapeservice;

public class Aopmain {

	public static void main(String[] args) {
		//ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		//shapeservice shapeService=ctx.getBean("shapeService",shapeservice.class);
		FactoryService factoryService=new FactoryService();
		shapeservice shapeservice=(shapeservice)factoryService.getBean("shapeService");
		shapeservice.getCircle();
        
	}

}
package org.SpringAop.service;

import org.SpringAop.Aspect.LoggingAspect;
import org.SpringAop.model.Circle;

public class ShapeServiceProxy  extends shapeservice{

	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
Out:
Logging from the advice
Circle Getter Called



	
