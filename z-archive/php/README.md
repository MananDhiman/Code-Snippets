PDO - Method to interact with database

# Basics
```php
$x = "Name"; //string
$y = 15; // int
// Equal Returns true if $x is equal to $y
$x == $y

// Identical Returns true if $x is equal to $y, and they are of the same type
$x === $y
$x !== $y // not identical

// Increment
$i++
--$i

unset($float);  // Delete variable

// string template
echo "I drank some juice made of {$juice}s";
```

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

$s = "Hello Phper";
echo strlen($s);       # => 11

echo substr($s, 0, 3); # => Hel
echo substr($s, 1);    # => ello Phper
echo substr($s, -4, 3);# => hpe

echo strtoupper($s);   # => HELLO PHPER
echo strtolower($s);   # => hello phper

echo strpos($s, "l");      # => 2
var_dump(strpos($s, "L")); # => false
```

# Function
* Has support for default parameters
```php
function sum_numbers(int $a, int $b){
	return $a+$b;
}
echo sum_numbers(5,20);

// default params
function sum_numbers($num1, $num2 = 1) {
	return $num1 + $num2;
}

// return type declaration
function sum($a, $b): float { }
function get_item(): string { }
```

# Loops
```php
// for loop
for ($i = 1; $i <= 5; $i++) {
	echo $i;
}

//Loop through array
foreach ($people as $person){
	echo $person
}
```
# Array and Associative Array
```php
// array 
$people = array("A","B","C");
$num = [1, 3, 5, 7, 9];

// 2d array 
$multiArray = [ 
	[1, 2, 3],
	[4, 5, 6],
	[7, 8, 9],
];

echo count($num); 
array_push($num,10); // can insert single element or multiple elements
array_push($num,11,100);

print_r($people); // var dump is general, print_r only array
vardump($people, $num);

// sort array elements
sort($arr);
// check if element exists in array
if (in_array("A", $people)) // true
```
## Associative Array
```php
// method 1
$array = array(
	"foo" => "bar",
	"bar" => "foo",
	100   => -100,
	-100  => 100,
);

// method 2
$arr['foo'] = "bar"; 
$arr['bar'] = "foo"; 

// method 3
$arr = [
	"foo" => "bar",
	"bar" => "foo",
];

// loop through each key val pair
foreach ( $arr as $key => $value ) {
	echo "key: " . $key . "\n";
	echo "val: {$arr[$key]}\n";
}

// append key to assoc array
// method 1
$arr[$category] = $question; 

// method 2
$arr += array($category => $question);
```
