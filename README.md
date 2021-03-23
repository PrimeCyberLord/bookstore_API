How to create a new user

  Endpoint:ec2-3-128-192-93.us-east-2.compute.amazonaws.com:8080/api/user/create
  Method :Post
  Body Structure:
  {
    "name":"",
    "surname":"",
    "email":"",
    "password":"",
    "roles":["CUSTOMER","ADMIN"]
  }
  
How to create a new Order

API: ec2-3-128-192-93.us-east-2.compute.amazonaws.com:8080/api/order/create
method: Post
Body Structure:
 {
  "books":[{
    "isbn":"",
    "price":"",
    "quantity":""
  },
    {
    "isbn":"",
    "price":"",
    "quantity":""
  }],
    "address":""   
}


How to view all orders:
 Method: Get
 API : ec2-3-128-192-93.us-east-2.compute.amazonaws.com:8080/api/order/all
  
    
