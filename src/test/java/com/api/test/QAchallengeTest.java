package com.api.test;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class QAchallengeTest {

	Response response = null;

	@Test(priority = 1)

	//  We need to verify search on all jobs 

	public void fetchResultBySearch() {

		System.out.println("********************** fetchResultBySearch function Start **************************");

		// request the server
		response = RestAssured.get("https://jobs.github.com/positions.json");

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		int responseStatusCode = response.getStatusCode();
		System.out.println("********************** fetchResultBySearch function End **************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));
		System.out.println("");

	}

	@Test(priority = 2)

	
	 // We need to verify search on the jobs with  all filling tow filters and retrieve it in body Job title, job location 
	 
	public void fetchResultBySearchWithFillters() {

		System.out.println("********************** fetchResultBySearchWithFillters Start **************************");

		// request the server
		response = RestAssured.get(
				"https://jobs.github.com/positions.json?description=Senior Android Developer (f/m/d) (80-100%)&location=Berlin");

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		int responseStatusCode = response.getStatusCode();
		System.out.println("********************* fetchResultBySearchWithFillters End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}

	@Test(priority = 3)

	//We need to verify search on the jobs with filling just job location  parameter and retrieve it in body 
	
	public void fetchResultBySearchWithCity() {

		System.out.println("********************** fetchResultBySearchWithCity Start **************************");

		// request the server
		response = RestAssured.get("https://jobs.github.com/positions.json?location=Amman");

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		int responseStatusCode = response.getStatusCode();
		System.out.println("********************* fetchResultBySearchWithCity End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}

	@Test(priority = 4)

	//We need to verify search on the job with latitude and longitude with sending Location  and retrieve it in the body 
	
	public void fetchResultWithPagination() {

		System.out.println("********************** fetchResultByLatandLongWithLocation Start **************************");

		// request the server
		response = RestAssured.get("https://jobs.github.com/positions.json?lat=37.3229978&long=-122.0321823&location=Berlin");

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		int responseStatusCode = response.getStatusCode();
		System.out.println("********************* fetchResultByLatandLongWithLocation End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}

	
	@Test(priority = 5)

	//We need to verify search on the job with sending latitude only  retrieve it in the body 
	
	public void fetchResultByLat() {

		System.out.println("********************** fetchResultByLat Start **************************");

		// request the server
		response = RestAssured.get("https://jobs.github.com/positions.json?lat=37.3229978");

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		int responseStatusCode = response.getStatusCode();
		System.out.println("********************* fetchResultByLat End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}
	

	@Test(priority = 6)

	//We need to verify the pagination with sending page parameter  
	public void fetchResultByLatandLongWithLocation() {

		System.out.println("********************** fetchResultWithPagination Start **************************");

		// request the server
		response = RestAssured
				.get("https://jobs.github.com/positions.json?description=ruby&page=0");

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		int responseStatusCode = response.getStatusCode();
		System.out.println("********************* fetchResultWithPagination End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}

	
	@Test(priority = 7)

	//We need to verify by limit results to full-time positions with full-time  and location
	public void fetchResultByFullTime() {

		System.out.println("********************** fetchResultByFullTime Start **************************");

		// request the server
		response = RestAssured
				.get("https://jobs.github.com/positions.json?description=python&full_time=true&location=sf");

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		int responseStatusCode = response.getStatusCode();
		System.out.println("********************* fetchResultByFullTime End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}
	

	@Test(priority = 8)
	
	//We need to verify fetching job by id 

	public void fetchResultById() {

		System.out.println("********************** fetchResultById Start **************************");

		// request the server
		response = RestAssured.get("https://jobs.github.com/positions/21516.json");
		int responseStatusCode = response.getStatusCode();
		System.out.println("Status Code => " + responseStatusCode);

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		System.out.println("********************* fetchResultById End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}

	@Test(priority = 9)
	
	//We need to verify fetching job by id and Markdown to view the description 

	public void fetchResultByIdandMarkdown() {

		System.out.println("********************** fetchResultByIdandMarkdown Start **************************");

		// request the server
		response = RestAssured.get("https://jobs.github.com/positions/21516.json");
		int responseStatusCode = response.getStatusCode();
		System.out.println("Status Code => " + responseStatusCode);

		// store the response body in string
		String responseBody = response.getBody().asString();

		// print the response with pretty print in console
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(responseBody);
		String prettyJsonString = gson.toJson(je);
		System.out.println("Response Body is =>  " + prettyJsonString);
		// store the response code
		System.out.println("********************* fetchResultByIdandMarkdown End ***************************");
		System.out.println("Status Code => " + responseStatusCode);
		System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));

	}
}