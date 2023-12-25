# MongoDB
* Mongodb good for one to many relationships
* mongodb is scalable as not compulsary data structure
* Case sensitive

**Comparison**
* 'Mongo' -> 'SQL'
* Collection -> Table
* Document -> Single Record

## Secondary Commands
`show dbs`: lists all databases. three created by default

`use <database name>`:  creates database or uses db

`db`: prints currently using database

`show collections`: collections of database

## Commands
### Create
`db.<collection name>.insertOne(<js object>)`
```
db.coll.insert(
	{
    _id: 3, name: “”, price: 1.3, stock: 43,
    reviews: [
      { auth_name: “”, rating: 5 },
      { auth_name: “”, rating: 4 }
    ]
  }
)
```
### Read
`db.<collection>.find()`: if no param then prints all data in coll
* accepts two optional params. query and projection
* **query operators** such as $eq $gt $gte $in $lt $lte $ne $nin | $and $not
* **Insert or Update One vs many** when using one, it operates on top most element sorted by time, and returns
```
db.products.find({name: “pencil”})
db.products.find({price: {$gt: 1.0}})
```

**projections**

which fields to return

First Param Query = {_id: 1}
Second Param Projection = {name:1, _id:0}
```
db.products.find({_id: 1}, {name:1, _id:0}) 
```
* id always returned by default. 

### Update
Pass javascript object in all
```
db.products.updateOne({_id:1}, {$set: {stock:32}}) // two params. first is where, second is what

db.products.updateMany()

db.products.replaceOne()
```

### Delete
deleteOne, deleteMany
