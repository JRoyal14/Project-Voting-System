<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
	require 'connection.php';
	createStudent();
}
function createStudent()
{
	global $connect;
	
	$Q1 = $_POST["Q1"];	
	$Q2 = $_POST["Q2"];
	$Q3 = $_POST["Q3"];
	$Q4 = $_POST["Q4"];
	
	$query = " REPLACE into answers(Q1,Q2,Q3,Q4) values ('$Q1','$Q2','$Q3','$Q4');";
	
	mysqli_query($connect, $query) or die (mysqli_error($connect));
	mysqli_close($connect);
	
}
?>