Learn HTML, CSS
Understand MySQL parallel
PDO - Method to interact with database

# Strings
```php
$name = "Alpha";
$lastName = "Beta";
$age = 20;

echo "The name is $name and $lastName $age years old";
//The name is Alpha and Beta 20 years old

//String Concatenation with .
.
echo $first_name.$last_name;
```

```php
//Array
$people = array("A","B","C");
print_r($people);

//Loop through array
foreach ($people as $person){
	echo $person
}

//info of array
vardump($a,$b);
```

# Array

## Function
```php
function sum_numbers(int $a, int $b){
	return $a+$b;

}
echo sum_numbers(5,20);
```

## Classes
```php
class Bike{
	public $color;
	public $model;
	public function __construct($color,$model){
		$this->color = $color;
		$this->model = $model;
	}
	public function message(){
		return "My Bike is a ".$this->color." ".$this->model
	}
}

$myBike = new Bike("red","Honda");
echo $mmyBike -> message();

```