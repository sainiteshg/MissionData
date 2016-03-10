package org.nithish.practice;

import java.util.HashMap;

import org.junit.Test;

public class MissionDataTest {
	
	@Test
	public void testWithSumInCentsLessThanUsers(){
		object.put("user1", (double) 0);
		object.put("user2", (double) 0);
		object.put("user3", (double) 0.01);
		HashMap<String, String>  output=missionDataCode.methodName(object);
		for(String str:output.keySet()){
			System.out.println(str+":"+output.get(str));
		}
	}
	@Test
	public void testWithSumInDecimalsExtraCentsCase(){
		object.put("user1", (double) 25);
		object.put("user2", (double) 9);
		object.put("user3", (double) 10);
		HashMap<String, String>  output=missionDataCode.methodName(object);
		for(String str:output.keySet()){
			System.out.println(str+":"+output.get(str));
		}
	}
	@Test
	public void testWithSumInDecimalsNoChangeInCentsCase(){
		object.put("user1", (double) 25);
		object.put("user2", (double) 10);
		object.put("user3", (double) 10);
		HashMap<String, String>  output=missionDataCode.methodName(object);
		for(String str:output.keySet()){
			System.out.println(str+":"+output.get(str));
		}
	}
	@Test
	public void testWithSumInDecimalsLessCentsCase(){
		object.put("user1", (double) 25);
		object.put("user2", (double) 5);
		object.put("user3", (double) 10);
		HashMap<String, String>  output=missionDataCode.methodName(object);
		for(String str:output.keySet()){
			System.out.println(str+":"+output.get(str));
		}
	}
	@Test
	public void testWithSumInDecimalsNoCentsLostCase(){
		object.put("user1", (double) 0.01);
		object.put("user2", (double) 0.01);
		object.put("user3", (double) 0.01);
		HashMap<String, String>  output=missionDataCode.methodName(object);
		for(String str:output.keySet()){
			System.out.println(str+":"+output.get(str));
		}
	}
	MissionDataCode missionDataCode=new MissionDataCode();
	HashMap<String, Double> object=new HashMap<String, Double>();
	
}
