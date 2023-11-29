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

## Cookies
```php
// set cookie - valid for 3600 seconds
setcookie("name", $value, time() + (3600), "/");
// delete cookie - set expiry before now
setcookie("name", "", time() - 3600, "/");
  
``` 