package com.JSONArray;

import org.json.*;
import org.testng.annotations.Test;

public class ComplexJSONArray {

	@Test
	public void passBodyAsJsonArray() {
	 
	    // JSON Object for first employee
	    JSONObject data1 = new JSONObject();
	 
	    data1.put("firstname", "Tom");
	    data1.put("lastname", "Mathew");
	    data1.put("age", 59);
	    data1.put("salary", 720000);
	 
	    // JSON Object for second employee
	    JSONObject data2 = new JSONObject();
	 
	    data2.put("firstname", "Perry");
	    data2.put("lastname", "David");
	    data2.put("age", 32);
	    data1.put("salary", 365000);
	 
	    // Creating first JSON array 
	    JSONArray array1 = new JSONArray();
	    array1.put(data1);
	 
	    // Creating second JSON array 
	    JSONArray array2 = new JSONArray();
	    array2.put(data2);
	 
	    // Create JSON Object to add both JSONArrays
	    JSONObject data3 = new JSONObject();
	    data3.put("employee1", array1);
	    data3.put("employee2", array2);
	 
	    System.out.println(data3);
	 
	}
	
	//Another way
	@Test
    public void passBodyAsJsonArray1() {
 
        // Creating JSON array to add first JSON object
        JSONArray array1 = new JSONArray();
        array1.put(new JSONObject().put("firstname", "Tom").put("lastname", "Mathew").put("age", 59).put("salary",
                720000));
 
        // Creating JSON array 
        JSONArray array2 = new JSONArray();
        array2.put(new JSONObject().put("firstname", "Perry").put("lastname", "David").put("age", 32).put("salary",
                365000));
 
        // Create JSON Object to add JSONArrays
        JSONObject data1 = new JSONObject();
        data1.put("employee1", array1);
        data1.put("employee2", array2);
 
        System.out.println(data1.toString(4));
 
    }
}
