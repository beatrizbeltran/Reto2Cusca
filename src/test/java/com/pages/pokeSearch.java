package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pokeSearch {

	WebDriver driver;

	By searchfield = By.xpath("//input[@placeholder='Search Pokémon, moves, abilities, items, types, or more']");

	By pokemonName = By.xpath("//input[@placeholder='Search Pokémon, moves, abilities, items, types, or more']");

	By clickName = By.cssSelector(".col.pokemonnamecol");

	By h1des = By.xpath("//div[@class='pfx-body dexentry']//h1");

	By rows = By.xpath("//table//child::td[@class='stat']");

	By rows2 = By.xpath("//dd[@class='imgentry']//a");

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
		boolean pd = driver.findElement(h1des).isEnabled();
		System.out.println("  Pokemon Description is visible? " + pd);

	}

	public void ReviewStatsAgainstAPI() {
		List<WebElement> allrows = driver.findElements(rows);

		for (int i = 0; i < allrows.size(); i++) {

		}

		System.out.println("HP: " + allrows.get(0).getText());
		System.out.println("Attack: " + allrows.get(1).getText());
		System.out.println("Defense: " + allrows.get(2).getText());
		System.out.println("Sp. Atk: " + allrows.get(3).getText());
		System.out.println("Sp. Def: " + allrows.get(4).getText());
		System.out.println("Speed: " + allrows.get(5).getText());

	}

	public void ReviewSkillsAgainstAPI() {
		List<WebElement> allrows = driver.findElements(rows2);

		for (int i = 0; i < allrows.size(); i++) {

		}

		System.out.println("Skills1: " + allrows.get(0).getText());
		System.out.println("Skills2: " + allrows.get(1).getText());

	}
}