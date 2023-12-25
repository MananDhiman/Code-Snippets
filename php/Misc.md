```php
// server root dir
echo $_SERVER["DOCUMENT_ROOT"];

// run a shell command
$a = shell_exec('php b.php');
```
# Password
```php
  $pwd_hashed = password_hash($pwd, PASSWORD_DEFAULT);

  password_verify($pwd, $hash); // returns boolean 
```

# Strict Types
```php
declare(strict_types=1);

function addNumbers(int $a, int $b) {
  return $a + $b;
}
```

# Display Errors
In php.ini
```ini
display_errors=On
```
In any php file
```php
error_reporting(E_ALL);
ini_set('display_errors', '1');
```

# API / JSON / HTTP 
```php
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');
```

## FORM Data HTTP Request Methods
```php
$req_method = $_SERVER['REQUEST_METHOD'];

// methods other than get, post
parse_str(file_get_contents("php://input"),$vars);
    
$todo_id = $vars['todo_id'];
$todo = $vars['todo'];
```

# Get from external api
```php
$url = 'data.json'; // path to your JSON file
$data = file_get_contents($url); // put the contents of the file into a variable
$characters = json_decode($data); // decode the JSON feed
```

## Cookies
```php
// set cookie - valid for 3600 seconds
setcookie("name", $value, time() + (3600), "/");
// delete cookie - set expiry before now
setcookie("name", "", time() - 3600, "/");
  
``` 