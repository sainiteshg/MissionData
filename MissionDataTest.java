
package org.nithish.practice;

import java.util.HashMap;

public class MissionDataTest {
	public static void main(String[] args){
		MissionDataCode missionDataCode=new MissionDataCode();
		HashMap<String, Double> object=new HashMap<String, Double>();
		/*object.put("user1", (double) 9);
		object.put("user2", (double) 1);
		object.put("user3", (double) 1);
		object.put("user4", (double) 1);
		object.put("user5", (double) 1);
		object.put("user6", (double) 1);*/
		object.put("user1", (double) 25);
		object.put("user2", (double) 10);
		object.put("user3", (double) 9);
		HashMap<String, String>  output=missionDataCode.methodName(object);
		for(String str:output.keySet()){
			System.out.println(str+":"+output.get(str));
		}
	}

}
