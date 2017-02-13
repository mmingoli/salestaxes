Feature: Test data to show how sales taxes service works

  Scenario: Test 1
    Given the below purchasing items list:
      | IMPORTED | QUANTITY | NAME          | TYPE  | UNIT_PRICE |
      | false    | 1        | book name     | BOOKS | 12.49      |
      | false    | 1        | music CD      | MUSIC | 14.99      |
      | false    | 1        | chocolate bar | FOOD  | 0.85       |
    When the sales taxes service is called
    Then the receipt is made by the following purchasing items:
      | IMPORTED | QUANTITY | NAME          | TYPE  | UNIT_PRICE | TOTAL_PRICE |
      | false    | 1        | book name     | BOOKS | 12.49      | 12.49       |
      | false    | 1        | music CD      | MUSIC | 14.99      | 16.49       |
      | false    | 1        | chocolate bar | FOOD  | 0.85       | 0.85        |
    And total sales taxes is 1.50
    And total is 29.83

  Scenario: Test 2
    Given the below purchasing items list:
      | IMPORTED | QUANTITY | NAME              | TYPE      | UNIT_PRICE |
      | true     | 1        | box of chocolates | FOOD      | 10.00      |
      | true     | 1        | bottle of perfume | COSMETICS | 47.50      |
    When the sales taxes service is called
    Then the receipt is made by the following purchasing items:
      | IMPORTED | QUANTITY | NAME              | TYPE      | UNIT_PRICE | TOTAL_PRICE |
      | true     | 1        | box of chocolates | FOOD      | 10.00      | 10.50       |
      | true     | 1        | bottle of perfume | COSMETICS | 47.50      | 54.65       |
    And total sales taxes is 7.65
    And total is 65.15

  Scenario: Test 3
    Given the below purchasing items list:
      | IMPORTED | QUANTITY | NAME                       | TYPE             | UNIT_PRICE |
      | true     | 1        | bottle of perfume          | COSMETICS        | 27.99      |
      | false    | 1        | bottle of perfume          | COSMETICS        | 18.99      |
      | false    | 1        | packet of headache pills   | MEDICAL_PRODUCTS | 9.75       |
      | true     | 1        | box of imported chocolates | FOOD             | 11.25      |
    When the sales taxes service is called
    Then the receipt is made by the following purchasing items:
      | IMPORTED | QUANTITY | NAME                       | TYPE             | UNIT_PRICE | TOTAL_PRICE |
      | true     | 1        | bottle of perfume          | COSMETICS        | 27.99      | 32.19       |
      | false    | 1        | bottle of perfume          | COSMETICS        | 18.99      | 20.89       |
      | false    | 1        | packet of headache pills   | MEDICAL_PRODUCTS | 9.75       | 9.75        |
      | true     | 1        | box of imported chocolates | FOOD             | 11.25      | 11.85       |
    And total sales taxes is 6.70
    And total is 74.68
