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
## PHP Path
```php 
$_SERVER['PATH_INFO']

PATH_INFO: /products/xxx/yyy
PATH_INFO is relative to the root URL. REQUEST_URI is not.
URL: http://api.yoursite.com/post/index.php/parameters/
REQUEST_URI: /post/index.php/xxx/yyy<br>\
PATH_INFO: /products/xxx/zzz
```
## FORM Data HTTP Request Methods
```php
// get request body
// Takes raw data from the request
$json = file_get_contents('php://input');

// Converts it into a PHP object
$data = json_decode($json);
$req_method = $_SERVER['REQUEST_METHOD'];

// methods other than get, post
parse_str(file_get_contents("php://input"),$vars);
// $vars contains request body
$todo_id = $vars['todo_id'];
$todo = $vars['todo'];

// 
$method = $_SERVER['REQUEST_METHOD'];  
switch ($method) {  
 case 'GET':  
 case 'POST':  
 case 'PUT':  
 case 'DELETE':    
}
```

## Get from external api
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

# htaccess
```
RewriteEngine on

RewriteCond %{REQUEST_FILENAME} !-d # not a directory

RewriteCond %{REQUEST_FILENAME}\.php -f # file ends with .php

RewriteRule ^article/([0-9]+)/([0-9a-zA-Z_-]+) article.php?id=$1&name=$2 [NC, L]
# ^ = anything, first final string, space separated source url
# NC = case insensitive, l = next line condition does not depend on previous condition
```