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
