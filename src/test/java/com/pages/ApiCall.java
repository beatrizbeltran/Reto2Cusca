package com.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiCall {
	public String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";
	public Response response;
	public String newURL;
	RequestSpecification requestSpecification = RestAssured.given();
}
