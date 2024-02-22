package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class pokeSearch {

	public String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";
	public Response response;
	public String newURL;
	RequestSpecification requestSpecification = RestAssured.given();

	WebDriver driver;

	By searchfield = By.xpath("//input[@placeholder='Search Pokémon, moves, abilities, items, types, or more']");

	By pokemonName = By.xpath("//input[@placeholder='Search Pokémon, moves, abilities, items, types, or more']");

	By clickName = By.cssSelector(".col.pokemonnamecol");

	By h1 = By.cssSelector("//div[@class='pfx-body dexentry']//h1");

	By s1 = By.cssSelector(
			"body > div:nth-child(3) > div:nth-child(1) > dl:nth-child(8) > dd:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2)");

	public pokeSearch(WebDriver driver) {
		this.driver = driver;
	}

	public void GetBaseURL() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://dex.pokemonshowdown.com/");
		String BU = driver.getCurrentUrl();
		System.out.println(BU);

	}

	public void SearchPokeFieldActive() {

		boolean sf = driver.findElement(searchfield).isEnabled();
		System.out.println("Element is visible? " + sf);
	}

	public void EnterPokeName(String name) {
		driver.findElement(pokemonName).sendKeys(name);
	}

	public void ClickPokemonName() {
		driver.findElement(clickName).click();
	}

	public void PokemonDescrition() {
		boolean h1IsDis = driver.findElement(h1).isDisplayed();
		System.out.println("Element is visible? " + h1IsDis);

	}

	public void ReviewStats() {
		String stats1 = driver.findElement(s1).getText();
		System.out.println(stats1);
		RestAssured.baseURI = BASE_URL;
		newURL = BASE_URL + "dratini";
		System.out.println(newURL);
		RequestSpecification requestSpecification = RestAssured.given();
		response = requestSpecification.when().get(newURL);
		int code = response.then().extract().statusCode();
		System.out.println(code);
		boolean comparation1 = response.path("stats.0.base_stat").equals(Integer.parseInt(stats1));
		System.out.println(comparation1);

	}
}