Functionallity

1 --> http://localhost:{yourPort}/api/nft/{value}

2 --> GET:
http://localhost:8080/api/nft/all
Returns a list of all NFT'S.



3 --> POST:
http://localhost:8080/api/nft/add

Requires a body -->
{
"name" : "Test" ,
"price" : "250" ,
"category" : "Something"
}

3 Parameters required. Add an NFT to the list of NFT'S



4 --> PUT:
http://localhost:8080/api/nft/update/{id}

requires a body -->
{
"name": "Test123",
"price": 400,
"category": "SomethingElse"
}

Update an excisting NFT


5 --> DELETE:
http://localhost:8080/api/nft/delete/{id}

Deletes an NFT with id