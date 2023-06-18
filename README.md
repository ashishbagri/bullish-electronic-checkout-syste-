# bullish-electronic-checkout-system
Java back-end of a web-based electronics store’s checkout system

* How to build : maven install

Two type os Users :
1. Admin

2. Customer


Model :
User
- id
- password
- Role : Admin Customer

Product
- id
- name
- price
- description
- Deal

Deal
- id
- DealType : Discount
- name

Basket
- id
- name
- List<Product> products
- user_id

Receipt
- id
- List<Product> products
- List<Deal>
- total_price

{EndPoints}
//Design Rest API for Electronic Checkout System
* Users REST API
    * Reterive all Users
        * GET /users
    * Create a Users
        * POST /users
    * Reterive one User
        * GET /users/{id}
    * Delete a User
        * DELETE /user/{id}

* Bucket REST API
    * Reterive all Buckets
        * GET /buckets
    * Create an Empty Bucket
        * POST /buckets
    * Reterive one Bucket
        * GET /buckets/{id}
    * Reterive Bucket for a user/
        * GET /buckets/user/id
    * Add Product to a Bucket
        * POST /buckets/{id}/items
    * Delete a Product from the Bucket
        * DELET /buckets/{id}/items/{id}

* Product REST API
    * Reterive all Products
        * GET /products
    * Create a new Product
        * POST /products
    * Reterive one Product
        * GET /products/{id}
    * Delete one product
        * DELET /products/{id}

* Discount REST API
    * Reterive all Discounts
        * GET /discounts
    * Reterive one discount
        * GET /discounts/{id}
    * Create a new Discount
        * POST /discounts

* Receipt REST API
    * Get all receipts
        * GET /receipts
    * Create a receipt
        * POST /receipts/buckets/{id}
    