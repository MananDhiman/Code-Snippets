# Connection
```php
<?php
$host = "localhost";
$username = "root";
$password = "";
$database = "manan_school";

$conn = new mysqli($host, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>
```

# Get Records
```php
$sql = "SELECT * FROM `records`;";
$result = $conn->query($sql);

if($result->num_rows > 0){
	foreach($result as $rows){
		echo "$row['id']";
	}
}
```

PHP
```php
if(isset($_POST)){
		$name = $_POST['names'];
		if ($result = $conn -> query("INSERT INTO `amount` (`id`, `name`, `initial_amount`, `gst`, `discount`, `packing_charges`, `amount`) VALUES (NULL, '$name', '$initial_amount', '$gst', '$discount', '$packing_charges', '$amount');")) {
            echo 'added';
        }
		
	}
```

HTML Form
```html
<form action="addEntry.php" method="post">

</form>
```




# Upload Image
## And Insert Data
image is a 2d array. image is the name of file, name is its parameter
Main function is move_uploaded_file('file_name','where to move file and its name')

```php
<?php

    $conn = new mysqli("localhost","root","","database");
    
    if($conn->connect_error){
        echo 'error';
    }

    if(isset($_POST['button'])){
        $phone = $_POST['phone'];
        
        if(isset($_FILES['image'])){
            echo "<pre>";
            print_r($_FILES);
            echo "</pre>";
            
            $file_name = $_FILES['image']['name'];
            $file_size = $_FILES['image']['size'];
            $file_tmp = $_FILES['image']['tmp_name'];
            $file_type = $_FILES['image']['type'];
            
            move_uploaded_file($file_tmp, "upload-images/".$phone.".jpg");
        }
        
        $sql = "INSERT INTO `table` (`id`, `image`, `age`, `phone`) VALUES (NULL, '$phone', '', '$phone');";
        if($conn->query($sql)===TRUE){
            echo'sent';
        }
        
    }

?>

<html>
    <body>
        <form method="post" enctype="multipart/form-data">
            Phone:<br>
            <input type="number" name="phone">
            Image:<br>
            <input type ="file" name="image">
            <input type="submit" name="button" value="Submit">
    </body>
    
</html>
```