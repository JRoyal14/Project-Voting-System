<?php
if($_SERVER["REQUEST_METHOD"]=="POST"){
	require 'connection.php';
	createStudent();
}
function createStudent()
{
	global $connect;
	
	$question = $_POST["question"];	
	$answer = $_POST["answer"];
	$email = $_POST["email"];
	
	$query = " REPLACE into students(question,answer,email) values ('$question','$answer','$email');";
	
	mysqli_query($connect, $query) or die (mysqli_error($connect));
	mysqli_close($connect);
	
}
?>