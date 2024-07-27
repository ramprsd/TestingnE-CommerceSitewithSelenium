Feature: Testing an E-Commerce Site with Selenium

  @ps1 @all
  Scenario: Store search an excel file
    Given user Searches for "Mobile Phone" on the ‘flipkart.com’ homepage
    Then Fetch all the mobile phones listed in the product listing page along with their prices
    And output the result to an excel file and store them inside folder testresult

  @ps22 @all
  Scenario: Search and Sort the items in home page
    Given user Searches for "Mobile Phone" on the ‘flipkart.com’ homepage
    Then sort the products in product listing page by price low to high
    Then verify page header assertions in page to validate if on the right page

  @ps21 @all
  Scenario: add iPhone15 256gb variant to kart and change shipping address
    Given user should get to login page
    Then user enters credentials "Number/Email" and validate login
    Then select phone from the product listing page and search for "iPhone 15", select a "256" GB phone on the product details
    Then Add the product to cart and validate if the product is added and available in Cart
    Then Add a new address for shipping and proceed to the checkout page then validate it

#  Problem Statement 1:
#  ● Search for ‘Mobile Phone’ on the ‘flipkart.com’ homepage
#  ● Fetch all the mobile phones listed in the product listing page along with
#  their prices and output them to an excel file and store them inside folder
#  ‘testresult’ in ‘src/test/resources’

#  Problem Statement 2:
#  ● Do login and validate if Login is successful
#  ● Search for ‘iPhone 12’ and select a 64GB phone on the product details
#  page after selecting the phone from the product listing page
#  ● Add the product to cart and validate if the product is added and available in
#  Cart
#  ● Add a new address for shipping and proceed to the checkout page then
#  validate it
#  ● Same test to be repeated on Chrome browser (assuming you’re using
#  Firefox as default browser else vice-versa)
#  ● Any actions in any page are welcome (like sorting the products in product
#  listing page, page header assertions in each page to validate if on the right
#  page, etc).