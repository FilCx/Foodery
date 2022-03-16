# Foodery

Final Project QA Software Development Bootcamp.

### Why am I doing this?

I wanted to create a food delivery app that enables an user to:
1. Register
2. See a list of available restaurants
3. See the menu for a restaurant
4. Create a new order to a chosen restaurant
5. Add products to an order


### How I expected the challenge to go.

I was thinking it would be a great way to implement what I've learned during the past few weeks, learnt a lot from it.


### What went well? / What didn't go as planned?

The idea of the app was straightforward, but the implementation turned up trickier that expected. My initial challenge was how to structure the database tables. Once that was figured out, the data retrieval was straightforward thanks to the many Spring Boot JPA decorators.

The other challenging part was deciding how to structure the endpoints and which features to include in the app.


### Possible improvements for future revisions of the project.

The app need a stronger business layer to handle business requirements.

At the moment it is possible to add a new product to an order even though that order is already inside the order. A feature improvement would be to simply add the quantity of that product to the table, rather then creating a new row.

Another major improvement would be to add authentication. At the moment the order endpoint asks for an user_id to know which user to add the order for. Since there is no authentication layer, the API is not secure and any user can add orders for other users.


### Screenshots showing your postman requests and the output from the API.

### Screenshots of your database to prove that data is being persisted.

### Screenshot of your test results, including coverage report.

### Link to Jira Board - You must add your trainer(s) as collaborators also.

visible at: https://bmnp.atlassian.net/jira/software/projects/FIN/boards/2


**Foodery's Features**


**Feature: User registration**

Scenario: A new user wants to register 
    When the user sends his personal details
    Then the user is registered 


**Feature: Restaurants**

Scenario: User wants to see a list of restaurants
    When the user requests a list of restaurants
    Then app provides the list of the available restaurants


**Feature: Menus**

Scenario: User wants to see the restaurant’s menu
    When the user requests a restaurant menu
    Given the user has chosen a restaurant
    Then app provides a list of the products of the given restaurant


**Feature: Orders creation**

Scenario: User starts an order
    When the user wants to start a new order
    Given the user has chosen a restaurant
    Then a new order is created
    
    
**Feature: Add products to order**

Scenario: User add products to order
    When the user choose a product
    Given the user has created an order
    And the product belongs to that order restaurant
    Then the product is added to the order
    
## App endpoints
    
- /user/add                  (register a new user)
- /restaurant/all            (get all available restaurants)
- /restaurant/{id}           (get the details of a single restaurant)
- /restaurant/{id}/products  (get a restaurant products)
- /order/add  				 (create a new order)
- /order_product/add  		 (add a product to an order)
   
   
   
   
 
