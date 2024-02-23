package TestDefinition;

import org.openqa.selenium.WebDriver;

import com.pages.pokeSearch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;

public class TestingSteps {
	WebDriver driver;

	pokeSearch ps = new pokeSearch(driver);

	@Given("Than site is available")
	public void than_site_is_available() {

		ps.GetBaseURL();
	}

	@Given("Search field is active")
	public void search_field_is_active() {
		ps.SearchPokeFieldActive();
	}

	@When("I enter the <name> of pokemon")
	public void i_enter_the_dratini_of_pokemon() {
		ps.EnterPokeName("Dratini");
	}

	@When("I click the pokemon name")
	public void i_click_the_search_button() {
		ps.ClickPokemonName();
	}

	@Then("The pokemon information is displayed")
	public void the_pokemon_information_is_displayed() {
		ps.PokemonDescrition();

	}

	@When("I review stats agains API")
	public void i_review_stats_agains_api() {
		ps.ReviewStatsAgainstAPI();

	}

	@When("I review skills agains API")
	public void i_review_skills_agains_api() {
		ps.ReviewSkillsAgainstAPI();
	}

}