# Password
```php
  $pwd_hashed = password_hash($pwd, PASSWORD_DEFAULT);

  password_verify($pwd, $hash); // returns boolean 
```