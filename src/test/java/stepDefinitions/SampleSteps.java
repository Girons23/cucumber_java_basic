package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Given("^Enter task page$")
    public void enterTaskPage() throws Throwable  {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^number I enter number (\\d+)$")
    public void numberIEnterNumber(int Number) throws Throwable  {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(Number));
    }

    @And("^I click on submit button$")
    public void iClickOnSubmitButton() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();

    }

    @Then("^I will see an error \"([^\"]*)\"$")
    public void iWillSeeAnError(String arg0) throws Throwable {
            assertEquals(arg0, driver.findElement(By.id("ch1_error")).getText());
        Thread.sleep(500);
    }

    @Then("^Result is shown$")
    public void resultIsShown() throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());

    }

    @When("^number I enter \"([^\"]*)\"$")
    public void numberIEnter(String arg1) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(arg1));
    }
    //////////////////////////TASK 2
    @Given("^I (?:am on|open) page$")
    public void iAmOnPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
        Thread.sleep(500);

}

    @When("^I press add person button$")
    public void iPressAddPersonButton() throws Throwable {
        driver.findElement(By.xpath("//body/div[4]/button[1]")).click();

    }

    @Then("^I add persons name$")
    public void iAddPersonsName() throws Throwable {
        driver.findElement(By.id("name")).sendKeys(String.valueOf("Alex"));
    }


    @Then("^I add persons job$")
    public void iAddPersonsJob() throws Throwable {
        driver.findElement(By.id("job")).sendKeys(String.valueOf("Tester"));

    }

    @Then("^I click add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
        Thread.sleep(500);
    }

    @When("^I press edit button for first person$")
    public void iPressEditButtonForFirstPerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
    }

    @And("^Change persons name$")
    public void changePersonsName() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(String.valueOf("Michael"));
    }

    @And("^Change persons job$")
    public void changePersonsJob() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"job\"]")).sendKeys(String.valueOf("Maneger"));
        Thread.sleep(500);
    }

    @Then("^Press edit button$")
    public void pressEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
    }

    @And("^Clear name field$")
    public void clearNameField() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
    }

    @And("^Clear job field$")
    public void clearJobField() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"job\"]")).clear();
    }

    @Then("^I add persons \"([^\"]*)\"$")
    public void iAddPersons(String name) throws Throwable {
         driver.findElement(By.id("name")).sendKeys(String.valueOf(name));
    }

    @Then("^I add person \"([^\"]*)\"$")
    public void iAddPerson(String arg0) throws Throwable {
        driver.findElement(By.id("job")).sendKeys(String.valueOf(arg0));
    }

    @Then("^I click reset list button$")
    public void iClickResetListButton()throws Throwable {
        driver.findElement(By.xpath("//body/div[2]/button[2]")).click();
        Thread.sleep(3000);
    }

    @Then("^I press remove button to first person$")
    public void iPressRemoveButtonToFirstPerson() throws Throwable{
        driver.findElement(By.cssSelector("#person2 > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")).click();
    }

    @Then("^I press first person edit button$")
    public void iPressFirstPersonEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
    }

    @And("^I press clear button$")
    public void iPressClearButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
        Thread.sleep(500);
    }

    @Then("^I check if name is removed$")
    public void iCheckIfNameIsRemoved() throws Throwable {
        assertEquals("", driver.findElement(By.xpath("//*[@id=\"name\"]")).getText());
    }

    @And("^if job is removed$")
    public void ifJobIsRemoved() throws Throwable {
        assertEquals("", driver.findElement(By.xpath("//*[@id=\"job\"]")).getText());
    }

    @Then("^I check if its removed$")
    public void iCheckIfItsRemoved()  throws Throwable {
        List<WebElement> allElementsWithClass = driver.findElements(By.xpath("//*[@id=\"listOfPeople\"]"));
        assertEquals(1,allElementsWithClass.size());
    }

    @Then("^Peron appears in main list with \"([^\"]*)\"$")
    public void peronAppearsInMainListWith(String name) throws Throwable {
        assertEquals(name,driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/ul[1]/div[4]/li[1]/span[3]")).getText());
    }

    @Then("^I check if edit is made$")
    public void iCheckIfEditIsMade() throws Throwable {
        assertEquals("Michael",driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
    }

    @Then("^I check if three persons are in list$")
    public void iCheckIfThreePersonsAreInList() throws Throwable{
        List<WebElement> allElementsWithClass = driver.findElements(By.xpath("//*[@id=\"listOfPeople\"]"));
        assertNotEquals(2,allElementsWithClass.size());
    }
}