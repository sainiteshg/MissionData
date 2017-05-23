//program1
package org.nithish.javapractice.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	public Message(){
		// Noop constructor
	}
	public Message(long id,String message,String author){
		this.id=id;
		this.message=message;
		this.author=author;
		this.created=new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
package org.nithish.javapractice.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.nithish.javapractice.messenger.model.Message;

public class MessageService {

	public List<Message> getAllMessages(){
		Message m1= new Message(1L, "Hello World", "Nithish");
		Message m2= new Message(1L, "Hello Jersey", "Agni");
		List<Message> list=new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;	
	}
}
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
}

//web.xml

<?xml version="1.0" encoding="UTF-8"?>
<!-- This web.xml file is not required when using Servlet 3.0 container,
     see implementation details http://jersey.java.net/nonav/documentation/latest/jax-rs.html -->
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">
    <servlet>
        <servlet-name>Jersey Web Application</servlet-name>
        <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
        <init-param>
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>org.nithish.javapractice.messenger</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>Jersey Web Application</servlet-name>
        //check this<url-pattern>/webapi/*</url-pattern>
    </servlet-mapping>
</web-app>
//output
This XML file does not appear to have any style information associated with it. The document tree is shown below.
<messages>
<message>
<author>Nithish</author>
<created>2015-07-01T23:59:43.257-04:00</created>
<id>1</id>
<message>Hello World</message>
</message>
<message>
<author>Agni</author>
<created>2015-07-01T23:59:43.257-04:00</created>
<id>1</id>
<message>Hello Jersey</message>
</message>
</messages>
URL-
http://localhost:8080/messenger/webapi/messages
//program 2
package org.nithish.javapractice.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nithish.javapractice.messenger.database.DatabaseClass;
import org.nithish.javapractice.messenger.model.Message;

public class MessageService {

	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Nithish"));
		messages.put(2L, new Message(2, "Hello Jersey", "GVS"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());	
	}
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
package org.nithish.javapractice.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {

	private long id;
	private String fistName;
	private String lastName;
	private Date created;
	public Profile(){
		// Noop constructor
	}
	public Profile(long id,String message,String author){
		this.id=id;
		this.fistName=message;
		this.lastName=author;
		this.created=new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
package org.nithish.javapractice.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.model.Profile;



public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<Long, Profile> profiles = new HashMap<>();

	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

	
	
	
}
package org.nithish.javapractice.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	public Message(){
		// Noop constructor
	}
	public Message(long id,String message,String author){
		this.id=id;
		this.message=message;
		this.author=author;
		this.created=new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
Out: 
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<messages>
    <message>
        <author>Nithish</author>
        <created>2015-07-02T11:11:53.128-04:00</created>
        <id>1</id>
        <message>Hello World</message>
    </message>
    <message>
        <author>GVS</author>
        <created>2015-07-02T11:11:53.128-04:00</created>
        <id>2</id>
        <message>Hello Jersey</message>
    </message>
</messages>
//program 3
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "test";
	}
}
//program 4
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@PathParam("messageId")String messageId){
		//messageService.getMessage(messageId);
		return "Goth path Param :"+messageId;
	}
}
//program 5
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
}
out:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<message>
    <author>GVS</author>
    <created>2015-07-02T11:52:58.323-04:00</created>
    <id>2</id>
    <message>Hello Jersey</message>
</message>
url:
http://localhost:8080/messenger/webapi/messages/2
//program 6
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
}
Out:
[
  {
    "author": "Nithish",
    "created": "2015-07-02T12:19:55.944",
    "id": 1,
    "message": "Hello World"
  },
  {
    "author": "GVS",
    "created": "2015-07-02T12:19:55.944",
    "id": 2,
    "message": "Hello Jersey"
  },
  {
    "author": "Nithish",
    "created": "2015-07-02T15:18:36.889",
    "id": 3,
    "message": "Hello New World"
  }
]
//program 7
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
}
//program 8
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
}

//program 9
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
}
//program 10
package org.nithish.javapractice.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {

	private long id;
    private String profileName;
    private String firstName;
    private String lastName;
    private Date created;
    
    public Profile() {
    	
    }
    
	public Profile(long id, String profileName, String firstName, String lastName) {
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Profile;
import org.nithish.javapractice.messenger.service.ProfileService;
@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService profileService=new ProfileService();
	@GET
	public List<Profile> getProfiles() {
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return profileService.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		profileService.removeProfile(profileName);
	}
	
}
//program 11
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@QueryParam("year") int year) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
}
package org.nithish.javapractice.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.nithish.javapractice.messenger.database.DatabaseClass;
import org.nithish.javapractice.messenger.model.Message;

public class MessageService {

	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Nithish"));
		messages.put(2L, new Message(2, "Hello Jersey", "GVS"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());	
	}
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}

Url:
http://localhost:8080/messenger/webapi/messages?year=2014
//program 12
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size) {
		if (year > 0) {
			return messageService.getAllMessagesForYear(year);
		}
		if (start >= 0 && size >= 0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
}
Url:
http://localhost:8080/messenger/webapi/messages?start=1&size=1
//program 13
package org.nithish.javapractice.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("authSessionID") String header,
			@CookieParam("name") String cookie) {
return "Matrix param: " + matrixParam + " Header param: " + header + " Cookie param: " + cookie;
}
}
Url:
http://localhost:8080/messenger/webapi/injectdemo/annotations;param=value

//program 14
package org.nithish.javapractice.messenger.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}

package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
}

//program 15
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	@POST
	public Message  addMessage(Message message){
		return messageService.addMessage(message);
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
package org.nithish.javapractice.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {

	@GET
	public String test(){
		return "new Sub Resource";
	}
}
//program 16
package org.nithish.javapractice.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class CommentResource {

	@GET
	public String test(){
		return "new Sub Resource";
	}
	@GET
	@Path("/{commentId}")
	public String test2(){
		return "Method to return Comment ID";
	}
}
out:Method to return Comment ID
Url:http://localhost:8080/messenger/webapi/messages/2/comments/12

//program 17
package org.nithish.javapractice.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	@GET
	public String test(){
		return "new Sub Resource";
	}
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("messageId")long messageId,@PathParam("commentId")long commentId){
		return "Method to return Comment ID: "+commentId+" for message "+messageId;
	}
}
//program 18
package org.nithish.javapractice.messenger.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.nithish.javapractice.messenger.database.DatabaseClass;
import org.nithish.javapractice.messenger.model.Comment;
import org.nithish.javapractice.messenger.model.Message;



public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}

package org.nithish.javapractice.messenger.model;

import java.util.Date;

public class Comment {
	

	private long id;
    private String message;
    private Date created;
    private String author;
    
    public Comment() {
    	
    }
    
    public Comment(long id, String message, String author) {
    	this.id = id;
    	this.message = message;
    	this.author = author;
    	this.created = new Date();
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    
    

}
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nithish.javapractice.messenger.model.Comment;
import org.nithish.javapractice.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CommentResource {

	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id, Comment comment) {
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}
	
	
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
	
}
package org.nithish.javapractice.messenger.model;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
public class Message {

	private long id;
    private String message;
    private Date created;
    private String author;
    private Map<Long, Comment> comments = new HashMap<>();
    
    public Message() {
    	
    }
    
    public Message(long id, String message, String author) {
    	this.id = id;
    	this.message = message;
    	this.author = author;
    	this.created = new Date();
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
    
    
	
}

//program 19
package org.nithish.javapractice.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	
	@POST
	public Response addMessage(Message message) {
		Message newMessage = messageService.addMessage(message);
		return Response.status(Status.CREATED)
				.entity(newMessage)
				.build();
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
//program 20
package org.nithish.javapractice.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	
	@POST
	public Response addMessage(Message message) throws URISyntaxException {
		Message newMessage = messageService.addMessage(message);
		return Response.created(new URI("/messenger/webapi/messages/"+newMessage.getId()))
				.entity(newMessage)
				.build();
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
//program 21
package org.nithish.javapractice.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		return messageService.getMessage(id);
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
//program 22
package org.nithish.javapractice.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorMessage;
	private int errorCode;
	private String documentation;
	public ErrorMessage(){
		
	}
	public ErrorMessage(String errorMessage, int errorCode, String documentation) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
}
package org.nithish.javapractice.messenger.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.nithish.javapractice.messenger.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),404,"http://javabrains.koushik.org/");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
package org.nithish.javapractice.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message){
		super(message);
	}

	
}
package org.nithish.javapractice.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.eclipse.persistence.exceptions.i18n.DatabaseExceptionResource;
import org.nithish.javapractice.messenger.database.DatabaseClass;
import org.nithish.javapractice.messenger.exception.DataNotFoundException;
import org.nithish.javapractice.messenger.model.Message;

public class MessageService {

	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "Nithish"));
		messages.put(2L, new Message(2, "Hello Jersey", "GVS"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());	
	}
	public List<Message> getAllMessagesForYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size); 
	}
	
	
	public Message getMessage(long id) {
		Message message= messages.get(id);
		if(message==null){
			throw new DataNotFoundException("Message with Id: "+id+"not Found");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}

url:http://localhost:8080/messenger/webapi/messages/200
out:
{
  "documentation": "http://javabrains.koushik.org/",
  "errorCode": 404,
  "errorMessage": "Message with Id: 200not Found"
}
//program 23
package org.nithish.javapractice.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.nithish.javapractice.messenger.model.ErrorMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>  {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),500,"http://javabrains.koushik.org/");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}
}
//program 24
package org.nithish.javapractice.messenger.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.nithish.javapractice.messenger.database.DatabaseClass;
import org.nithish.javapractice.messenger.model.Comment;
import org.nithish.javapractice.messenger.model.Message;



public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Message message=messages.get(messageId);
		if(message==null){
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment=comments.get(commentId);
		if(comment==null){
			throw new WebApplicationException(Status.NOT_FOUND);
		}
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}

package org.nithish.javapractice.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.nithish.javapractice.messenger.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable>  {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage=new ErrorMessage(ex.getMessage(),500,"http://javabrains.koushik.org/");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}
}
//program 25
package org.nithish.javapractice.messenger.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.nithish.javapractice.messenger.database.DatabaseClass;
import org.nithish.javapractice.messenger.model.Comment;
import org.nithish.javapractice.messenger.model.ErrorMessage;
import org.nithish.javapractice.messenger.model.Message;



public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage=new ErrorMessage("Not Found",404,"http://javabrains.koushik.org/");
		Response response= Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		Message message=messages.get(messageId);
		if(message==null){
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment=comments.get(commentId);
		if(comment==null){
			throw new WebApplicationException(response);
		}
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}

Url:
http://localhost:8080/messenger/webapi/messages/100/comments/1
Out:
{
  "documentation": "http://javabrains.koushik.org/",
  "errorCode": 404,
  "errorMessage": "Not Found"
}
//program 26
package org.nithish.javapractice.messenger.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.nithish.javapractice.messenger.database.DatabaseClass;
import org.nithish.javapractice.messenger.model.Comment;
import org.nithish.javapractice.messenger.model.ErrorMessage;
import org.nithish.javapractice.messenger.model.Message;



public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		ErrorMessage errorMessage=new ErrorMessage("Not Found",404,"http://javabrains.koushik.org/");
		Response response= Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
		Message message=messages.get(messageId);
		if(message==null){
			throw new WebApplicationException(response);
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		Comment comment=comments.get(commentId);
		if(comment==null){
			throw new NotFoundException(response);
		}
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
		
}


//program 27
package org.nithish.javapractice.messenger.model;

public class Link {

	private String link;
	private String rel;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
}
package org.nithish.javapractice.messenger.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
public class Message {

	private long id;
    private String message;
    private Date created;
    private String author;
    private Map<Long, Comment> comments = new HashMap<>();
    private List<Link> links=new ArrayList<>();
    
    public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public Message() {
    	
    }
    
    public Message(long id, String message, String author) {
    	this.id = id;
    	this.message = message;
    	this.author = author;
    	this.created = new Date();
    }
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
    public void addLink(String url,String rel){
    	Link link=new Link();
    	link.setLink(url);
    	link.setRel(rel);
    	links.add(link);
    }
    
	
}
package org.nithish.javapractice.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id,@Context UriInfo uriInfo){
		Message message=messageService.getMessage(id);
		String uri=uriInfo.getBaseUriBuilder()
		        .path(MessageResource.class)
		        .path(Long.toString(message.getId()))
		        .build()
		        .toString();
		
		message.addLink(uri, "self");
		return message;
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
Uri:
http://localhost:8080/messenger/webapi/messages/1
Out:
{
  "author": "Nithish",
  "created": "2015-07-04T14:49:37.378",
  "id": 1,
  "links": [
    {
      "link": "http://localhost:8080/messenger/webapi/messages/1",
      "rel": "self"
    }
  ],
  "message": "Hello World"
}
//program 28
package org.nithish.javapractice.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id,@Context UriInfo uriInfo){
		Message message=messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		
		return message;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
		        .path(ProfileResource.class)
		        .path(message.getAuthor())
		        .build()
		        .toString();
		return uri;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
		        .path(MessageResource.class)
		        .path(Long.toString(message.getId()))
		        .build()
		        .toString();
		return uri;
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
Uri:
http://localhost:8080/messenger/webapi/messages/1
out:
{
  "author": "Nithish",
  "created": "2015-07-04T15:08:59.021",
  "id": 1,
  "links": [
    {
      "link": "http://localhost:8080/messenger/webapi/messages/1",
      "rel": "self"
    },
    {
      "link": "http://localhost:8080/messenger/webapi/profiles/Nithish",
      "rel": "profile"
    }
  ],
  "message": "Hello World"
}
//program 29
package org.nithish.javapractice.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >=0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id,@Context UriInfo uriInfo){
		Message message=messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");
		
		return message;
	}

	private String getUriForComments(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
		        .path(MessageResource.class,"getCommentResource")
		        .path(CommentResource.class)
		        .resolveTemplate("messageId", message.getId())
		        .build()
		        .toString();
		return uri;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
		        .path(ProfileResource.class)
		        .path(message.getAuthor())
		        .build()
		        .toString();
		return uri;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
		        .path(MessageResource.class)
		        .path(Long.toString(message.getId()))
		        .build()
		        .toString();
		return uri;
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
uri:
http://localhost:8080/messenger/webapi/messages/2
Out:
{
  "author": "GVS",
  "created": "2015-07-04T15:18:30.426",
  "id": 2,
  "links": [
    {
      "link": "http://localhost:8080/messenger/webapi/messages/2",
      "rel": "self"
    },
    {
      "link": "http://localhost:8080/messenger/webapi/profiles/GVS",
      "rel": "profile"
    },
    {
      "link": "http://localhost:8080/messenger/webapi/messages/2/comments/",
      "rel": "comments"
    }
  ],
  "message": "Hello Jersey"
}
//program 30
package org.nithish.javapractice.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.nithish.javapractice.messenger.model.Message;
import org.nithish.javapractice.messenger.resources.beans.MessageFilterBean;
import org.nithish.javapractice.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService=new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJsonMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("Json Method Called");
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Message> getXmlMessages(@BeanParam MessageFilterBean filterBean) {
		System.out.println("Xml Method Called");
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() >0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id,@Context UriInfo uriInfo){
		Message message=messageService.getMessage(id);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComments(uriInfo, message), "comments");
		
		return message;
	}

	private String getUriForComments(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
		        .path(MessageResource.class,"getCommentResource")
		        .path(CommentResource.class)
		        .resolveTemplate("messageId", message.getId())
		        .build()
		        .toString();
		return uri;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
		        .path(ProfileResource.class)
		        .path(message.getAuthor())
		        .build()
		        .toString();
		return uri;
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri=uriInfo.getBaseUriBuilder()
		        .path(MessageResource.class)
		        .path(Long.toString(message.getId()))
		        .build()
		        .toString();
		return uri;
	}
	
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId")long id){
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
//program 31
