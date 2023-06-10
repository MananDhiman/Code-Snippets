<?php
	//credentials to login to database
	$DB_HOST = "localhost";
    $DB_USER = "root";
    $DB_PASS = "";
    $DB_NAME = "shophere";

	//connecting to database
    $conn = mysqli_connect($DB_HOST, $DB_USER, $DB_PASS, $DB_NAME);

	//sql query to get data from database
    $sql = "SELECT name,price,rating from products";
    $result = mysqli_query($conn, $sql);
    $data = array();
    
    //converting data from database to JSON and storing it in PHP variable
    if(mysqli_num_rows($result) > 0){
        $output = mysqli_fetch_all($result, MYSQLI_ASSOC);
        $jsonArray = json_encode($output);
    }else{
        echo json_encode(array('message' => 'No Record Found', 'status'=>false));
    }
    
?>
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
