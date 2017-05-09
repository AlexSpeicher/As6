<?php	
        $op=$_POST["op"];
	switch($op){
		case "uploadSchedule":
			$val=$_POST("val");
			$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar schedule.server $op $val";
			print($cmd);
			break;
		case "getSchedule":
			$day=$_POST["day"];
        		$skill=$_POST["skill"];
        		$hour=$_POST["hour"];
  			$cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar schedule.server $op $day $skill $hour";
			echo ($cmd);
			break;
	}
        $str = shell_exec($cmd);
	print($str);
?>       


