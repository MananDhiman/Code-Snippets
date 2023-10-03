Advisable to do each mogodb thing in try catch
# Connection
* First create cluster in mongodb atlas cloud
* Get username, password, uri
* In project directory `npm install mongoose`

```js
const mongoose = require('mongoose');
mongoose.set('strictQuery', false);

const start = async() => {
  try {
    await mongoose.connect('uri');

    app.listen(PORT, () => {
      console.log("App listeining on " + PORT);
    });
  } 
  catch(e) {
    console.log(e.message);
  }
 }
```
## Change DB from URI
after / and before ? write db name

`mongodb.net/customers?`

## Change Table from Model.js
replace ‘Customer' with tablename
```js
module.exports = mongoose.model('Customer', customerSchema);
```

# Mongoose
MongoDB object modelling for Node js

Sample
```js
const mongoose = require('mongoose');
mongoose.connect('mongodb://127.0.0.1:27017/test');

const Cat = mongoose.model('Cat', { name: String });

const kitty = new Cat({ name: 'Zildjian' });
kitty.save().then(() => console.log('meow. cat saved'));
```
## Mongoose Model
Model is a schema for a table

```js
const mongoose = require('mongoose');

// params for schema
const customerSchema = new mongoose.Schema({
 name: String,
 industry: String
});

// converts from js object to mongodb ‘object’
module.exports = mongoose.model('Customer', customerSchema);
```
Another example
```js
const customerSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true
  },
  industry: String
});
```
On creating new object from Model, an id automatically generated
```js
const customer = new Customer({
 name: "Caleb",
 industry: "marketing"
});

app.get('/', (req, res) => {
 res.send(customer);
});
```

# Save to MongoDB
if customer is a mongoose object, then .save() saves it to the db
```js
const customer = new Customer({
 name: "Caleb",
 industry: "marketing"
});

// send obj to mongodb
customer.save();
```

## Save using POST Request Body
```js
app.post('/api/customers', async(req, res) => {
  // console.log(req.body);
  const customer = new Customer({
    name: req.body.name,
    industry: req.body.industry
  });

  customer.save();
});
```
Passed body is:
```json
{
  "name": "Test from body",
  "industry": "Apple Staff"
}
```
* Directly passing body new Customer(req.body) works if customer schema is defined properly. Unless we want to extract something specific from the post body
* `Customer({customer})` means the attributes received will be under a object called customer


# READ 
## GET By ID
```js
app.get('/api/customers/:id', async(req,res) => {
  const customerId = req.params.id;

  try {
    console.log(customerId);
    const customer = await Customer.findById(customerId);
    res.json({customer});
  } catch(e) {
    res.status(500).json({error:'something went wrong'});
  }
});
```
## All records

only records that match customer schema are fetched
```js
app.get('/api/customers', async(req, res) => {
  const result = await Customer.find();
  res.send({"customers": result});
});
```
## READ all collections (databases)
`await mongoose.connection.db.listCollections().toArray();`

