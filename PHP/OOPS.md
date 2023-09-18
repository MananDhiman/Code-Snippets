# Classes and Objects
```php
class Bike{
  // maybe no need to declare members
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

# Inheritance
```php
class ExtendClass extends SimpleClass {
  // Redefine the parent method
  function displayVar() {
    echo "Extending class\n";
    parent::displayVar();
  }
}

$extended = new ExtendClass();
$extended->displayVar();
```