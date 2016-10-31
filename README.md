# customerservice

###Sample customer service.

Database: Contains a map based custom cache to store the customer details as key value pair,with key as `CUST_{id}`.It is cleared u when the application restarts.

Basic input validations are in place,with approriate response code.
Available apis:
```
GET /customers/{id} : get customer details based on id.
POST /customers : Post a new customer with mandatory details.
PUT /customers : update customer details with full details.
```

POST and PUT mandatory details:
Sample
```
{"firstName":"mohammed",
"lastName":"salman",
"phno":"12345"
}
```

Sample url: <host>:8001/service/customers/{id}
