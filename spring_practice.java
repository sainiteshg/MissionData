Program1
//
package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle=(Triangle) factory.getBean("triangle");
		triangle.draw();

	}

}
//

public class Triangle {

	public void draw()
	{
		System.out.println("Traingle drawn");
	}
}

//xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle"/>
</beans>

program2

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();

	}

}
Program 3
package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();

	}

}

package spring.practice;

public class Triangle {

	
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void draw()
	{
		System.out.println(getType()+"Traingle drawn");
	}
}

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
  <property name="type" value ="Equilateral"/>
  </bean>
</beans>

program 4// Using constructor Injection

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();

	}

}


package spring.practice;

public class Triangle {

	
	private String type;
	
	public Triangle(String type)
	{
		this.type=type;
	}
	
	public String getType() {
		return type;
	}

	/*public void setType(String type) {
		this.type = type;
	}*/

	public void draw()
	{
		System.out.println(getType()+"Traingle drawn");
	}
}

package spring.practice;

public class Triangle {

	
	private String type;
	
	public Triangle(String type)
	{
		this.type=type;
	}
	
	public String getType() {
		return type;
	}

	/*public void setType(String type) {
		this.type = type;
	}*/

	public void draw()
	{
		System.out.println(getType()+"Traingle drawn");
	}
}
//program 4

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();

	}

}

package spring.practice;

public class Triangle {

	
	private String type;
	private int height;
	
	public int getHeight() {
		return height;
	}

	

	public Triangle(String type)
	{
		this.type=type;
	}
	public Triangle(String type,int height)
	{
		this.type=type;
		this.height=height;
	}
	
	public String getType() {
		return type;
	}

	/*public void setType(String type) {
		this.type = type;
	}*/

	public void draw()
	{
		System.out.println(getType()+" Traingle drawn and is of height "+getHeight());
	}
}

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
  <constructor-arg  value ="Equilateral"/>
  <constructor-arg  value ="11"/>
  </bean>
</beans>

//program 5 
package spring.practice;

public class Triangle {

	
	private String type;
	private int height;
	
	public int getHeight() {
		return height;
	}

	public Triangle(int height)
	{
		this.height=height;
	}
	public Triangle(String type)
	{
		this.type=type;
	}
	public Triangle(String type,int height)
	{
		this.type=type;
		this.height=height;
	}
	
	public String getType() {
		return type;
	}

	/*public void setType(String type) {
		this.type = type;
	}*/

	public void draw()
	{
		System.out.println(getType()+" Traingle drawn and is of height "+getHeight());
	}
}

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
  <constructor-arg type="java.lang.String" value ="Equilateral"/>
  <constructor-arg type="int" value ="11"/>
  </bean>
</beans>
//program 6
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
  <constructor-arg index="0" value ="Equilateral"/>
  <constructor-arg index="1" value ="11"/>
  </bean>
</beans>
//program 7 
package spring.practice;

public class Triangle {

	
	private Point PointA;
	private Point PointB;
	private Point PointC;
	
	
	public Point getPointA() {
		return PointA;
	}


	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}


	public Point getPointB() {
		return PointB;
	}


	public void setPointB(Point PointB) {
		this.PointB = PointB;
	}


	public Point getPointC() {
		return PointC;
	}


	public void setPointC(Point PointC) {
		this.PointC = PointC;
	}


	public void draw()
	{
		System.out.println("("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("("+getPointC().getX()+","+getPointC().getY()+")");
	}
}

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
   <property name="pointA" ref="point1"/>
   <property name="pointB" ref="point2"/>
   <property name="pointC" ref="point3"/>
  </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="point2" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="point3" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>
package spring.practice;

public class Point {
private int x;
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
private int y;
}
//Program 8 Inner beans

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
   <property name="pointA" ref="point1"/>
   <property name="pointB" >
      <bean  class="spring.practice.Point">
       <property name="x" value="20"/>
       <property name="y" value="0"/>
     </bean>
    </property>
   <property name="pointC" >
   <bean  class="spring.practice.Point">
     <property name="x" value="0"/>
     <property name="y" value="-20"/>
    </bean>
   </property>
 </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    
    
    
    
</beans>

//Program 9 alias1
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
   <property name="pointA" ref="point1"/>
   <property name="pointB" >
      <bean  class="spring.practice.Point">
       <property name="x" value="20"/>
       <property name="y" value="0"/>
     </bean>
    </property>
   <property name="pointC" >
   <bean  class="spring.practice.Point">
     <property name="x" value="0"/>
     <property name="y" value="-20"/>
    </bean>
   </property>
 </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean>   
    
    <alias name="triangle" alias="triangle-alias"/>  
</beans>

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) context.getBean("triangle-alias");
		triangle.draw();

	}

}

//Program 10 alias2
package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) context.getBean("triangle-name");
		triangle.draw();

	}

}
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle" name="triangle-name">
   <property name="pointA" ref="point1"/>
   <property name="pointB" >
      <bean  class="spring.practice.Point">
       <property name="x" value="20"/>
       <property name="y" value="0"/>
     </bean>
    </property>
   <property name="pointC" >
   <bean  class="spring.practice.Point">
     <property name="x" value="0"/>
     <property name="y" value="-20"/>
    </bean>
   </property>
 </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean>   
    
    <alias name="triangle" alias="triangle-alias"/>  
</beans>

//Program 10 idref
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle" name="triangle-name">
   <property name="pointA" >
        <idref="point1"/>
    </property>
   <property name="pointB" >
      <bean  class="spring.practice.Point">
       <property name="x" value="20"/>
       <property name="y" value="0"/>
     </bean>
    </property>
   <property name="pointC" >
   <bean  class="spring.practice.Point">
     <property name="x" value="0"/>
     <property name="y" value="-20"/>
    </bean>
   </property>
 </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean>   
    
    <alias name="triangle" alias="triangle-alias"/>  
</beans>

//program11 Initializing collections


package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();

	}

}

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
   <property name="points">
   <list>
    <ref bean="point1"/>
    <ref bean="point2"/>
    <ref bean="point3"/>
    </list>
   </property>
  </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="point2" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="point3" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>

//Program 12 Bean autowiring
package spring.practice;

import java.util.List;

public class Triangle {

	
	private Point PointA;
	private Point PointB;
	private Point PointC;
	
	
	public Point getPointA() {
		return PointA;
	}


	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}


	public Point getPointB() {
		return PointB;
	}


	public void setPointB(Point PointB) {
		this.PointB = PointB;
	}


	public Point getPointC() {
		return PointC;
	}


	public void setPointC(Point PointC) {
		this.PointC = PointC;
	}


	public void draw()
	{
		System.out.println("("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("("+getPointC().getX()+","+getPointC().getY()+")");
	}
}

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle" autowire="byName">
   
  </bean>
  
    <bean id="pointA" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>


//Program13 collections usage

package spring.practice;

import java.util.List;

public class Triangle {

	
	List<Point> points;
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw()
	{
		for(Point point:points)
		{
			System.out.println("Point= ("+point.getX()+","+point.getY()+")");
		}
	}
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle">
   <property name="points">
   <list>
       <ref bean="point1" />
       <ref bean="point2" />
       <ref bean="point3" />
   </list>
   </property>
 </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="point2" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="point3" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>

//program 14
package spring.practice;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware{

	
	private Point PointA;
	private Point PointB;
	private Point PointC;
	
	private ApplicationContext context=null;
	
	
	
	public Point getPointA() {
		return PointA;
	}


	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}


	public Point getPointB() {
		return PointB;
	}


	public void setPointB(Point PointB) {
		this.PointB = PointB;
	}


	public Point getPointC() {
		return PointC;
	}


	public void setPointC(Point PointC) {
		this.PointC = PointC;
	}


	public void draw()
	{
		System.out.println("PointA"+"("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB"+"("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointC"+"("+getPointC().getX()+","+getPointC().getY()+")");
	}


	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context=context;
		
	}


	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name:"+beanName);
		
	}
}
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle" autowire="byName">
   
 </bean>
  
    <bean id="pointA" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>

//program 15 BEAN DEFINITION INHERITANCE

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
   <bean id="parenttriangle" class="spring.practice.Triangle" >
     <property name="pointA" ref="pointA" />  
   </bean>

   <bean id="triangle1" class="spring.practice.Triangle" parent="parenttriangle">
      <property name="pointB" ref="pointB" />  
      <property name="pointC" ref="pointC" />
   </bean>

   <bean id="triangle2" class="spring.practice.Triangle" parent="parenttriangle">
        <property name="pointB" ref="pointB" />  
   </bean>
  
    <bean id="pointA" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>

//PROGRAM 16 BEAN DEFINITION INHERITANCE  init and destroy

package spring.practice;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements InitializingBean,DisposableBean
{

	
	private Point PointA;
	private Point PointB;
	private Point PointC;
	
	
	
	
	
	public Point getPointA() {
		return PointA;
	}


	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}


	public Point getPointB() {
		return PointB;
	}


	public void setPointB(Point PointB) {
		this.PointB = PointB;
	}


	public Point getPointC() {
		return PointC;
	}


	public void setPointC(Point PointC) {
		this.PointC = PointC;
	}


	public void draw()
	{
		System.out.println("PointA"+"("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB"+"("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointC"+"("+getPointC().getX()+","+getPointC().getY()+")");
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean Initialization done");
		
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy() method called");
		
	}


	
}
package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Triangle triangle=(Triangle) context.getBean("triangle");
		triangle.draw();

	}

}

//PROGRAM 17 init destroy

package spring.practice;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle 
{

	
	private Point PointA;
	private Point PointB;
	private Point PointC;
	
	
	
	
	
	public Point getPointA() {
		return PointA;
	}


	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}


	public Point getPointB() {
		return PointB;
	}


	public void setPointB(Point PointB) {
		this.PointB = PointB;
	}


	public Point getPointC() {
		return PointC;
	}


	public void setPointC(Point PointC) {
		this.PointC = PointC;
	}


	public void draw()
	{
		System.out.println("PointA"+"("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB"+"("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointC"+"("+getPointC().getX()+","+getPointC().getY()+")");
	}


	/*@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean Initialization done");
		
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy() method called");
		
	}*/
public void myInit(){
	System.out.println("Bean Initialization method calling done");
}
public void myDestroy()
{
	System.out.println("Destroy method called");
}

	
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans>
<bean id="triangle" class="spring.practice.Triangle" init-method="myInit" destroy-method="myDestroy">
   <property name="pointA" ref="point1"/>
   <property name="pointB" ref="point2"/>
   <property name="pointC" ref="point3"/>
  </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="point2" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="point3" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>

//PROGRAM 18 init destroy
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans default-init-method="myInit" default-destroy-method="myDestroy">
<bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="point1"/>
   <property name="pointB" ref="point2"/>
   <property name="pointC" ref="point3"/>
  </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="point2" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="point3" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
</beans>
//program 19 Bean factory post processors

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans >
<bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="point1"/>
   <property name="pointB" ref="point2"/>
   <property name="pointC" ref="point3"/>
  </bean>
  
    <bean id="point1" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="point2" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="point3" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    <bean class="spring.practice.MyBeanFactoryPP"/>
    
</beans>

package spring.practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayBeanName implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("In post processor after Initialization.Bean name is"+beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("In post processor before Initialization.Bean name is"+beanName);
		return bean;
	}

}
//pointsconfig.properties
pointA.PointX=0
pointA.PointY=0

<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context"
	>
	

<bean id="triangle" class="spring.practice.Triangle"  >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean>
  
    <bean id="pointA" class="spring.practice.Point">
    <property name="x" value="${pointA.PointX}"/>
    <property name="y" value="${pointA.PointY}"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    
<bean class="spring.practice.MyBeanFactoryPP"/>
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
  <property name="locations" value="classpath:pointsconfig.properties"/>
</bean>
</beans>
//program 20 coding to interfaces

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		shape shape=(shape) context.getBean("circle");
		shape.draw();

	}

}


package spring.practice;

public interface shape {
	public void draw();

}


package spring.practice;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements shape
{

	
	private Point PointA;
	private Point PointB;
	private Point PointC;
	
	
	
	
	
	public Point getPointA() {
		return PointA;
	}


	public void setPointA(Point PointA) {
		this.PointA = PointA;
	}


	public Point getPointB() {
		return PointB;
	}


	public void setPointB(Point PointB) {
		this.PointB = PointB;
	}


	public Point getPointC() {
		return PointC;
	}


	public void setPointC(Point PointC) {
		this.PointC = PointC;
	}


	public void draw()
	{
		System.out.println("Drawing triangle");
		System.out.println("PointA"+"("+getPointA().getX()+","+getPointA().getY()+")");
		System.out.println("PointB"+"("+getPointB().getX()+","+getPointB().getY()+")");
		System.out.println("PointC"+"("+getPointC().getX()+","+getPointC().getY()+")");
	}


	
	
}


package spring.practice;

public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans >
<bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean>
  
    <bean id="pointA" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <bean id="circle" class="spring.practice.circle" >
      <property name="center" ref="pointA"/>
  </bean>
    
</beans>


//program 21 Required annotation
package spring.practice;

import org.springframework.beans.factory.annotation.Required;

public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans >
<bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean>
  
    <bean id="pointA" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <bean id="circle" class="spring.practice.circle" >
  </bean>
    <bean class="org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor"/>
</beans>

//program 22 Autowired annotation
package spring.practice;

import org.springframework.beans.factory.annotation.Autowired;


public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Autowired
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans >
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="pointA" class="spring.practice.Point">//this will  not give error as there are 3 of same type
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <!-- <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean> -->
    
    <bean id="circle" class="spring.practice.circle" >
  </bean>
    <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
</beans>


//program 23
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd" >

<beans >
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="center" class="spring.practice.Point">//this will  not give error
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <bean id="circle" class="spring.practice.circle" >
  </bean>
    <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
</beans>

//program 24

package spring.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}


<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="pointA" class="spring.practice.Point">
     <qualifier value="circleRelated"/>
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <bean id="circle" class="spring.practice.circle" >
  </bean>
    <bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor"/>
</beans>

//program 25
<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="pointA" class="spring.practice.Point">
     <qualifier value="circleRelated"/>
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <bean id="circle" class="spring.practice.circle" >
  </bean>
    <context:annotation-config/>
</beans>

//program 26 Java Specification request 250

package spring.practice;

import javax.annotation.Resource;




public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}
<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="pointA" class="spring.practice.Point">
     <qualifier value="circleRelated"/>
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="pointC" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <bean id="circle" class="spring.practice.circle" >
  </bean>
    <context:annotation-config/>
</beans>

//program 27 
package spring.practice;

import javax.annotation.Resource;




public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}


<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="pointA" class="spring.practice.Point">
     <qualifier value="circleRelated"/>
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="center" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <bean id="circle" class="spring.practice.circle" >
  </bean>
    <context:annotation-config/>
</beans>

//program 28

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		shape shape=(shape) context.getBean("circle");
		shape.draw();

	}

}

package spring.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;




public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	@PostConstruct
	public void initCircle()
	{
		System.out.println("Initialize circle");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy circle");
	}
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}


//program 29 component and stereotype annotations
package spring.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;



@Component
public class circle implements shape
{

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	@PostConstruct
	public void initCircle()
	{
		System.out.println("Initialize circle");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy circle");
	}
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
	}
}

<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="pointA" class="spring.practice.Point">
     <qualifier value="circleRelated"/>
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="center" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    
    <context:component-scan base-package="spring.practice"/>
    <context:annotation-config/>
</beans>


// component and stereotype annotations
@Service = same as @Component
@Repository=for data object  
@Controller=actually a sea of MVC controller objects as controller,function is it tells spring what role bean is doing

//program 30 using message source to get text from property files

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		shape shape=(shape) context.getBean("circle");
		shape.draw();
		System.out.println(context.getMessage("greeting", null, "DefaultGreeting", null));

	}

}

<?xml version="1.0" encoding="UTF-8"?>


<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
	xmlns:context="http://www.springframework.org/schema/context">
	
<!-- <bean id="triangle" class="spring.practice.Triangle" >
   <property name="pointA" ref="pointA"/>
   <property name="pointB" ref="pointB"/>
   <property name="pointC" ref="pointC"/>
  </bean> -->
  
    <bean id="pointA" class="spring.practice.Point">
     <qualifier value="circleRelated"/>
    <property name="x" value="0"/>
    <property name="y" value="0"/>
    </bean> 
    <bean id="pointB" class="spring.practice.Point">
    <property name="x" value="20"/>
    <property name="y" value="0"/>
    </bean>
    <bean id="center" class="spring.practice.Point">
    <property name="x" value="0"/>
    <property name="y" value="-20"/>
    </bean>
    <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
      <property name="basenames">
      <list>
      <value>mymessages</value>
      </list>
      </property>
    </bean>
    <context:component-scan base-package="spring.practice"/>
    <context:annotation-config/>
</beans>

//program 31 using message source to get text from property files

package spring.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		
		//Triangle triangle=new Triangle();
	     //BeanFactory factory=new XmlBeanFactory(new FileSystemResource("spring.xml"));
		//Triangle triangle=(Triangle) factory.getBean("triangle");
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		shape shape=(shape) context.getBean("circle");
		shape.draw();
		

	}

}
package spring.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;



@Component
public class circle implements shape
{

	private Point center;
	@Autowired
	private MessageSource messageSource;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	@PostConstruct
	public void initCircle()
	{
		System.out.println("Initialize circle");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy circle");
	}
	public void draw()
	{
		System.out.println("Drawing circle");
		System.out.println("Circle :center:"+"("+center.getX()+","+center.getY()+")");
		System.out.println(this.messageSource.getMessage("greeting", null, "DefaultGreeting", null));
	}
}

//program 32 using message source to get text from property files

package spring.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;



@Component
public class circle implements shape
{

	private Point center;
	@Autowired
	private MessageSource messageSource;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	@PostConstruct
	public void initCircle()
	{
		System.out.println("Initialize circle");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy circle");
	}
	public void draw()
	{
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object [] {center.getX(),center.getY()}, "Default point message", null));
		System.out.println(this.messageSource.getMessage("greeting", null, "DefaultGreeting", null));
	}
}
//program 33 Event Handling

package spring.practice;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListenerClass implements ApplicationListener
{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
		
	}

}
//program 34 Event Handling
package spring.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;



@Component
public class circle implements shape,ApplicationEventPublisherAware
{

	private Point center;
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	@PostConstruct
	public void initCircle()
	{
		System.out.println("Initialize circle");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy circle");
	}
	public void draw()
	{
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object [] {center.getX(),center.getY()}, "Default point message", null));
		System.out.println(this.messageSource.getMessage("greeting", null, "DefaultGreeting", null));
	    DrawEvent drawEvent =new DrawEvent(this) ;
	    publisher.publishEvent(drawEvent);
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher=publisher;
		
	}
}

package spring.practice;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListenerClass implements ApplicationListener
{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event.toString());
		
	}

}
package spring.practice;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{

	public DrawEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String toString()
	{
		return "Draw Event Occured";
	}
}






