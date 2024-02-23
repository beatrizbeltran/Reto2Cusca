package com.pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.response.Response;

public class pokeSearch {

	WebDriver driver;

	By searchfield = By.xpath("//input[@placeholder='Search Pokémon, moves, abilities, items, types, or more']");

	By pokemonName = By.xpath("//input[@placeholder='Search Pokémon, moves, abilities, items, types, or more']");

	By clickName = By.cssSelector(".col.pokemonnamecol");

	By h1des = By.xpath("//strong/span[@class='picon']");

	By rows = By.xpath("//table//child::td[@class='stat']");

	By rows2 = By.xpath("//dd[@class='imgentry']//a");
	
	Response rs = ApiCall.getRequest("https://pokeapi.co/api/v2/pokemon/" + "dratini");

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
		System.out.println("  Search Element is visible? " + sf);
	}

	public void EnterPokeName(String name) {
		driver.findElement(pokemonName).sendKeys(name);
	}

	public void ClickPokemonName() {
		driver.findElement(clickName).click();
	}

	public void PokemonDescrition() {
		String pd = driver.findElement(h1des).getText();
		System.out.println("  Pokemon Description is visible? " + pd);

	}

	public void ReviewStatsAgainstAPI() {
		List<WebElement> allrows = driver.findElements(rows);

		for (int i = 0; i < allrows.size(); i++) {

		}
		System.out.println("Stats Web");
		System.out.println(" HP: " + allrows.get(0).getText());
		System.out.println(" Attack: " + allrows.get(1).getText());
		System.out.println(" Defense: " + allrows.get(2).getText());
		System.out.println(" Sp. Atk: " + allrows.get(3).getText());
		System.out.println(" Sp. Def: " + allrows.get(4).getText());
		System.out.println(" Speed: " + allrows.get(5).getText());

		// int code = rs.getStatusCode();
		// System.out.println("Status code API : " + code);

		int s1 = rs.path("stats[0].base_stat");
		int s2 = rs.path("stats[1].base_stat");
		int s3 = rs.path("stats[2].base_stat");
		int s4 = rs.path("stats[3].base_stat");
		int s5 = rs.path("stats[4].base_stat");
		int s6 = rs.path("stats[5].base_stat");
		System.out.println("Stats API : " + " HP: " + s1 + " Attack: " + s2 + " Defense: " + s3 + " Sp. Atk: " + s4
				+ " Sp. Def: " + s5 + " Speed: " + s6);

		// Asserts web and api stats
		Assert.assertEquals(s1, Integer.parseInt(allrows.get(0).getText()));
		Assert.assertEquals(s2, Integer.parseInt(allrows.get(1).getText()));
		Assert.assertEquals(s3, Integer.parseInt(allrows.get(2).getText()));
		Assert.assertEquals(s4, Integer.parseInt(allrows.get(3).getText()));
		Assert.assertEquals(s5, Integer.parseInt(allrows.get(4).getText()));
		Assert.assertEquals(s6, Integer.parseInt(allrows.get(5).getText()));

	}

	public void ReviewSkillsAgainstAPI() {
		List<WebElement> allrows = driver.findElements(rows2);

		for (int i = 0; i < allrows.size(); i++) {

		}

		System.out.println("Skills1: " + allrows.get(0).getText());
		System.out.println("Skills2: " + allrows.get(1).getText());
		
		String sk1 = rs.path("abilities[0].ability.name");
		String sk2 = rs.path("abilities[1].ability.name");
		System.out.println("Skilss API : " + " Skill1: " + sk1 + " Skill2: " + sk2);
		
		driver.quit();

	}

}