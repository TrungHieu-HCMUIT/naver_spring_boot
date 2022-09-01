# SpringBoot project of Naver's course

## Note
> The available data is saved on file db.mv.db (H2)

## APIs
1. [Customer APIs](#customer-apis)
   1. [GET - Get customers](#get---get-customers)
   2. [POST - Create new customer](#post---create-new-customer)
2. [Product APIs](#product-apis)
   1. [GET - Get products without condition](#get---get-products-without-condition)
   2. [GET - Get products with condition](#get---get-products-with-condition)
   3. [POST - Create new product](#post---create-new-product)
3. [Cart APIs](#cart-apis)
   1. [GET - Get item from cart without param](#get---get-items-from-cart-without-param)
   2. [GET - Get item from cart with param](#get---get-item-from-cart-with-param)
   3. [POST - Add item to cart](#post---add-item-to-cart)
4. [Error Response](#error-response)
## Customer APIs
   ### GET - Get customers
   * Request api/customers
   * Response
   ```json
{
   "data": [
      {
         "id": 1,
         "name": "Trung Hieu 1",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 2,
         "name": "Trung Hieu 2",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 3,
         "name": "Trung Hieu 3",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 4,
         "name": "Trung Hieu 4",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 5,
         "name": "Trung Hieu 5",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 6,
         "name": "Trung Hieu 6",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 7,
         "name": "Trung Hieu 7",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 8,
         "name": "Trung Hieu 8",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 9,
         "name": "Trung Hieu 9",
         "address": "Tan Binh",
         "phone": "123456789"
      },
      {
         "id": 10,
         "name": "Trung Hieu 10",
         "address": "Tan Binh",
         "phone": "123456789"
      }
   ],
   "statusCode": 200
}
   ```
   ### POST - Create new customer
   * Request api/customer
   ```json
{
    "name" : "Trung Hieu 10",
    "address" : "Tan Binh",
    "phone" : "123456789"
}
   ```
   * Response
   ```json 
{
    "data": {
        "id": 10,
        "name": "Trung Hieu 10",
        "address": "Tan Binh",
        "phone": "123456789"
    },
    "statusCode": 200
}
   ```
## Product APIs
   ### GET - Get products without condition
   * Request api/products
   * Response
   ```json
{
   "data": [
      {
         "id": 1,
         "name": "Product 1",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 2,
         "name": "Product 2",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 3,
         "name": "Product 3",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 4,
         "name": "Product 4",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 5,
         "name": "Product 5",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 6,
         "name": "Product 6",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 7,
         "name": "Product 7",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 8,
         "name": "Product 8",
         "type": "product",
         "size": "XL",
         "price": 100000.00
      },
      {
         "id": 9,
         "name": "Product 9",
         "type": "product",
         "size": "XL",
         "price": 150000.00
      },
      {
         "id": 10,
         "name": "Product 10",
         "type": "product",
         "size": "XL",
         "price": 200000.00
      }
   ],
   "statusCode": 200
}
   ```
   ### GET - Get products with condition
   * Request api/products?price=150000&condition=greater_than
   * Response
   ```json
{
   "data": [
      {
         "id": 10,
         "name": "Product 10",
         "type": "product",
         "size": "XL",
         "price": 200000.00
      }
   ],
   "statusCode": 200
}
   ```
   ### POST - Create new product
  * Request api/product
   ```json
{
    "name" : "Product 10",
    "type" : "product",
    "size" : "XL",
    "price" : 200000
}
   ```
  * Response
  ```json
{
   "data": {
      "id": 10,
      "name": "Product 10",
      "type": "product",
      "size": "XL",
      "price": 200000.0
   },
   "statusCode": 200
}
   ```
## Cart APIs
   ### GET - Get items from cart without param
   * Request api/cart/items/:customerId
   * Response
   ```json
{
    "data": [
        {
            "cartId": 12,
            "productId": 1,
            "name": "Product 1",
            "type": "product",
            "size": "XL",
            "price": 100000.00,
            "quantity": 2,
            "totalAmount": 200000.00,
            "dateAdded": "29-08-2022"
        },
        {
            "cartId": 12,
            "productId": 2,
            "name": "Product 2",
            "type": "product",
            "size": "XL",
            "price": 100000.00,
            "quantity": 2,
            "totalAmount": 200000.00,
            "dateAdded": "29-08-2022"
        },
        {
            "cartId": 12,
            "productId": 3,
            "name": "Product 3",
            "type": "product",
            "size": "XL",
            "price": 100000.00,
            "quantity": 3,
            "totalAmount": 300000.00,
            "dateAdded": "29-08-2022"
        }
    ],
    "statusCode": 200
}
   ```
   ### GET - Get item from cart with param
  * Request api/cart/items/:customerId?productName=Product 1&offset=0&limit=100
  * Response
  ```json
   {
   "data": [
      {
         "cartId": 12,
         "productId": 1,
         "name": "Product 1",
         "type": "product",
         "size": "XL",
         "price": 100000.00,
         "quantity": 2,
         "totalAmount": 200000.00,
         "dateAdded": "29-08-2022"
      }
   ],
   "statusCode": 200
}
   ```
   ### POST - Add item to cart
   * Request api/cart/add-items/:customerId
   ```json
{
    "items": [
        {
            "productId": 3,
            "quantity": 3
        }
    ]
}
   ```
   * Response
   ```json
{
   "data": true,
   "statusCode": 200
}
   ```
## Error Response
```json
{
    "statusCode": 400,
    "message": "Invalid data",
    "err_key": "ErrInvalidRequest"
}
```


