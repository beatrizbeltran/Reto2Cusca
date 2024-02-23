package com.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiCall {

	public static Response getRequest(String url) {
        //RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon";

		Response response = RestAssured.get(url);	

		return response;
	}
}