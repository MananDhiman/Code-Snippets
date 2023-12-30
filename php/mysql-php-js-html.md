Contents are of a single file only
```php
<?php
	//credentials to login to database
	$DB_HOST = "localhost";
	$DB_USER = "root";
	$DB_PASS = "";
	$DB_NAME = "shophere";

//connecting to database
	$conn = mysqli_connect($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME);
	// oops
	// $conn = new mysqli("localhost", "root", "", "test");

//sql query to get data from database
	$sql = "SELECT name,price,rating from products";
	$result = mysqli_query($conn, $sql);
	// $result = $conn->query($sql);
	// fetch all db rows fetch_all'MYSQLI_ASSOC'
	// $questions = json_encode($result->fetch_all(MYSQLI_ASSOC));
	$data = array();
	
	//converting data from database to JSON and storing it in PHP variable
	if(mysqli_num_rows($result) > 0){
		$output = mysqli_fetch_all($result, MYSQLI_ASSOC);
		$jsonArray = json_encode($output);
	}else{
		echo json_encode(array('message' => 'No Record Found', 'status'=>false));
	}
    
?>
```

```html
<html>
<body>
	
	<h1>Shopping Cart</h1>
	<span id="textSpan"></span>
	
	//javascript to display content
	<script>
		//converting data in php variable (string) to a JSON array
		let arr = JSON.parse('<?php echo $jsonArray;?>');
		
		let data = "";
		//appending each element of array to data variable
		for(let i=0;i<arr.length;i++)
			data += ("Name of phone "+arr[i].name+" | "+"Price of phone "+arr[i].price+" | "+"Rating of phone "+arr[i].rating+"\n");
		
		//displaying data in textSpan
		document.getElementById("textSpan").innerText = data;
	</script>
	
</body>
</html>
```

# Create API
## Headers
For setting API as JSON and allowing all to access
```php
header('Content-Type: application/json');
header('Access-Control-Allow-Origin: *');
```
## Connection
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

## Get Records
```php
$sql = "SELECT * FROM `records`;";
$result = $conn->query($sql);

// data in associative array
// to display in html
if($result->num_rows > 0){
	foreach($result as $rows){
		echo "$row['id']";
	}
}

// to display in api
if($result -> num_rows > 0) {

	$data = $result -> fetch_all(MYSQLI_ASSOC);
	echo json_encode($data);

} else {
	echo json_encode(['msg' => 'No Data!', 'status' => false]);
}
```

## Create
```php
if(isset($_POST)){
	$name = $_POST['names'];

	if ($result = $conn -> query("INSERT INTO `amount` (`id`, `name`, `initial_amount`, `gst`, `discount`, `packing_charges`, `amount`) 
	VALUES (NULL, '$name', '$initial_amount', '$gst', '$discount', '$packing_charges', '$amount');")) {
			echo 'added';
	}
		
}
```

HTML Form
```html
<form action="addEntry.php" method="post">

</form>
```
Same page submit button
```php
<html>
	<body>
		<form action='#' method='POST'>
			<input type='submit' name='submit' value='Submit'>
		</form>
	</body>
</html>

<?php
	if(isset($_POST['submit'])) {
		echo 'button clicked';
	}
?>
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
```

```html
<html>
	<body>
		<form method="post" enctype="multipart/form-data">
			Phone:<br>
			<input type="number" name="phone">
			Image:<br>
			<input type ="file" name="image">
			<input type="submit" name="button" value="Submit">
		</form>
	</body>
</html>
```