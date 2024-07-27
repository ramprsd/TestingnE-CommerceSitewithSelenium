package stepdefenitionfile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobject.FlipkartHomePage;
import pageobject.FlipkartLoginPage;

import java.io.IOException;

public class FlipkartSteps {

    @Given("user Searches for {string} on the ‘flipkart.com’ homepage")
    public void userSearchesForOnTheFlipkartComHomepage(String searchWord) throws InterruptedException {
        FlipkartHomePage.searchKeyword(searchWord);
    }

    @Then("Fetch all the mobile phones listed in the product listing page along with their prices")
    public void fetchResultDetails() {
        FlipkartHomePage.storeResultToMap();
    }

    @And("output the result to an excel file and store them inside folder testresult")
    public void outputTheResultToExcel() throws IOException {
        FlipkartHomePage.storeResultToExcel();
    }

    @Then("sort the products in product listing page by price low to high")
    public void sortByPriceLowToHigh() throws InterruptedException {
        FlipkartHomePage.sortHighToLow();
    }

    @Then("verify page header assertions in page to validate if on the right page")
    public void verifyPageHeaderAssertions() {
        FlipkartHomePage.verifyPageHeaderAssertions();
    }

    @Given("user should get to login page")
    public void userShouldGetToLoginPage() {
        FlipkartHomePage.clickLoginButton();
    }

    @Then("user enters credentials {string} and validate login")
    public void userEntersCredentialsAndValidateLogin(String user) throws IOException, InterruptedException {
        FlipkartLoginPage.enterPhoneNoOrEmail(user);
        FlipkartLoginPage.clickRequestOTP();
        FlipkartLoginPage.enterOTP();

    }

    @Then("select phone from the product listing page and search for {string}, select a {string} GB phone on the product details")
    public void selectPhoneFromTheProductListingPageAndSearchForSelectAGBPhoneOnTheProductDetails(String phone, String variant) throws InterruptedException {
        FlipkartHomePage.searchKeyword(phone);
        FlipkartHomePage.selectProduct(phone);
        FlipkartHomePage.selectVariant(Integer.parseInt(variant));
    }

    @Then("Add the product to cart and validate if the product is added and available in Cart")
    public void addTheProductToCartAndValidateIfTheProductIsAddedAndAvailableInCart() throws InterruptedException {
        FlipkartHomePage.addToKart();
        FlipkartHomePage.verifyKart();
    }

    @Then("Add a new address for shipping and proceed to the checkout page then validate it")
    public void addANewAddressForShippingAndProceedToTheCheckoutPageThenValidateIt() throws InterruptedException {
        FlipkartHomePage.addShippingAddress();
        FlipkartHomePage.proceedToCheckout();
        FlipkartHomePage.verifyCheckout();
    }

}
