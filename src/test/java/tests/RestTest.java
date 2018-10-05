package tests;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestTest {
	
@Test
	
	public void testResponseCode(){
		
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		int code = resp.getStatusCode();
		float getBaseValue = resp.path("main.temp");
		System.out.println("Status code is "+code);
		System.out.println("The base value is "+getBaseValue);
		 try{
				assertEquals(code, 200); 
//				System.out.println(actualResult);
	         }catch (Exception e){
				System.out.println("No Status code");
			}
	}
	
@Test
	
	public void testBody(){
		
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		
		String data  = resp.asString();
		System.out.println("Status code is "+data);
		System.out.println("Response time is " +resp.getTime());
	}
}

