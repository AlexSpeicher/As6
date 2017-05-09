<?php	
        $op=$_POST["getSchedule"];
        $val1=$_POST["day"];
        $val2=$_POST["skill"];
        $val3=$_POST["hour"];
        
        $cmd = "java -classpath /var/www/cgi-bin:/var/www/cgi-bin/mysql-connector-java-5.1.23-bin.jar schedule.server $op $val1 $val2 $val3"; 
        $str = shell_exec($cmd);
	print($str);
?>       


