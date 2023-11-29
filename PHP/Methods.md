# Password
```php
  $pwd_hashed = password_hash($pwd, PASSWORD_DEFAULT);

  password_verify($pwd, $hash); // returns boolean 
```

# Handle Request Except POST or GET
no such thing as put, delete
```php
parse_str(file_get_contents("php://input"),$vars);
echo $post_vars['todo']." is the variable\n";
```

# Display Errors
In any php file
```php
error_reporting(E_ALL);
ini_set('display_errors', '1');
```

# Get from api
```
$url = 'data.json'; // path to your JSON file
$data = file_get_contents($url); // put the contents of the file into a variable
$characters = json_decode($data); // decode the JSON feed
```