<?php
include_once 'connection2.php';

class User {
	
	private $db;
	private $connection;
	
	function __construct() {
		$this -> db = new DB_Connection();
		$this -> connection = $this->db->getConnection();
	}
	
	public function does_user_exist($email,$password)
	{
		$encrypted_password = md5($password);
		$query = "Select * from login where email='$email' and password = '$encrypted_password' ";
		$result = mysqli_query($this->connection, $query);
		if(mysqli_num_rows($result)>0){
			$json['success'] = ' Welcome '.$email;
			echo json_encode($json);
			mysqli_close($this -> connection);
		}else{
			$query = "insert into LOGIN (email, password) values ( '$email','$encrypted_password')";
			$inserted = mysqli_query($this -> connection, $query);
			if($inserted == 1 ){
				$json['success'] = 'Acount created';
			}else{
				$json['error'] = 'Wrong password';
			}
			echo json_encode($json);
			mysqli_close($this->connection);
		}
		
	}
	
}


$user = new User();
if(isset($_POST['email'],$_POST['password'])) {
	$email = $_POST['email'];
	$password = $_POST['password'];
	
	if(!empty($email) && !empty($password)){
		
		$encrypted_password = md5($password);
		$user-> does_user_exist($email,$password);
		
	}else{
		echo json_encode("you must type both inputs");
	}
	
}
?>