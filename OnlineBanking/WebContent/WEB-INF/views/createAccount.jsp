<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Account</title>
	</head>
	<body>
		<form action = "new-account.do" method = "post">
			Account Holder Name : <input type = "text" name = "holderName"> 
			Account Type : 
			<select id="accountType" name = "accountType">
                <option value="Saving">Saving</option>
                <option value="Current">Current</option>
                <option value="Select" selected>Select</option>
            </select> 
            <input type = "submit" value = "Create New Account">
		</form>
		</br>
		</br>
	</body>
</html>