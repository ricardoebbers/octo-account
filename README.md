# octo-account
An Account service that keeps track of accounts, their balances and transactions, integrated with a Report service that enables querying on a replica of Account database

# Summary

## Technologies
* Java 11
* SpringBoot
* MyBatis
* Gradle
* Postgres
* RabbitMQ
* JUnit

## Services
### Account
Keeps track of accounts, their balances and transactions.
Account service must publish all insert and update operations to RabbitMQ.
Application provides the following REST APIs:
#### API definition
* **Create Account** (POST /accounts)
    * Creates a bank account for the customer and returns an account object together with balance objects.
    * Input:
        * Customer ID (Integer)
        * Country (String)
        * List of currencies (List of possible String values: EUR, SEK, GBP, USD)
    * Responses:
        * Status code:
            * 201 Created
        * Body:
            * Account ID (Integer)
            * Customer ID (Integer)
            * Balances (List of Balance)
                * The available amount (initialized as 0.00)
                * Currency (String)
        * Status code:
            * 400 Bad Request
        * Body:
            * Message (One of possible String below)
                * Invalid currency
                
* **Get Account** (GET /accounts/{id})
    * Returns the account object.
    * Input:
        * Account ID (Integer)
    * Responses:
        * Status code:
            * 200 OK
        * Body:
            * Account ID (Integer)
            * Customer ID (Integer)
            * Balances (List of Balance)
                * The available amount (initialized as 0.00)
                * Currency (String)
        * Status code:
            * 404 Not Found
        * Body:
            * Message (One of possible String below)
                * Account not found

* **Create Transaction** (POST /accounts/{id}/transactions)
    * Create a transaction on the account and return the transaction object.
    * Input:
        * Account ID (Integer)
        * Amount (BigDecimal)
        * Currency (One of possible String values: EUR, SEK, GBP, USD)
        * Direction (One of possible String values: IN, OUT)
        * Description (String)
    * Responses:
        * Status code:
            * 201 Created
        * Body (List of Transaction):
            * Account ID (Integer)
            * Transaction ID (Integer)
            * Amount (BigDecimal)
            * Currency (One of possible String values: EUR, SEK, GBP, USD)
            * Direction (One of possible String values: IN, OUT)
            * Description (String)
            * Balance after transaction (BigDecimal)
        * Status code:
            * 400 Bad Request
        * Body:
            * Message (One of possible String below)
                * Invalid account
                * Invalid currency
                * Invalid direction
                * Invalid amount
                * Insufficient funds
                * Account missing
                * Description missing
                
* **Get Transactions** (GET /accounts/{id}/transactions)
    * Returns a list of transactions.
    * Input:
        * Account ID (Integer)
    * Responses:
        * Status code:
            * 200 OK
        * Body (List of Transaction):
            * Account ID (Integer)
            * Transaction ID (Integer)
            * Amount (BigDecimal)
            * Currency (One of possible String values: EUR, SEK, GBP, USD)
            * Direction (One of possible String values: IN, OUT)
            * Description (String)
        * Status code:
            * 400 Bad Request
        * Body:
            * Message (One of possible String below)
                * Invalid account
    


### Reporting
Keeps track of all transactions on the account for reporting purposes


## Tests
Account and reporting services must contain integration tests and test coverage must be at least 80%.

# Setup

## Pre-requisites

* Docker
* Java 11

## Steps

* [TBD]

# Testing

* [TBD]