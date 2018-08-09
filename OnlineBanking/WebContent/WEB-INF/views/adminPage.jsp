<%@page import="com.sun.accessibility.internal.resources.accessibility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.zycus.db.dao.AccountDao"  %>
<%@ page import = "com.zycus.pojo.accounts.Account"  %>
<%@ page import = "java.util.List"  %>
<%@ page import = "java.util.Date"  %>
<%@ page import = "java.text.DateFormat"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin</title>
		<style type="text/css">
            .show { display: block;  }
            .hide { display: none; }
			
			table, th, td {
    			border: 1px solid black;
    			border-collapse: collapse;
			}
			
			th, td {
				padding: 15px;
			}
			
			th {
   				text-align: left;
			}
		</style>
	</head>
	<body>
		<h1>Welcome          
			<%= session.getAttribute("username") %>
		</h1>
		<h4><a href= "logOut.jsp"> Log Out</a>
		</h4>
		<br/>
		<a href="createAccountForward.jsp"> <button>Create Account</button> </a>
		<br/>
		<br/>
		<%
			String message = (String)request.getAttribute("message");
		
			if(!(message == null || message.equals(""))) {
		%>
				<%=message %>
		<% 
			}
		%>
		<br/>
		<br/>
		<h3>All Accounts</h3>
		<table style = "width:100%"> 
			<tr>
				<th>Account Number</th>
				<th>Account Holder</th>
				<th>Account Type</th>
				<th>Amount</th>
				<th>Opening Date</th>
				<th>View Cards</th>
				<th>Add Card</th>
			</tr>

			<%
				List <Account> allAccounts = AccountDao.getAllAccount();
				long sze = allAccounts.size();

				for(Account account : allAccounts) {
					Date date = new Date(account.getOpeningDate());
					
					out.print("<tr><td>"+account.getAccountNumber()+
							  "</td><td>"+account.getHolderName()+
							  "</td><td>"+account.getAccountType()+
							  "</td><td>"+account.getAmount()+
							  "</td><td>"+DateFormat.getInstance().format(date).toString()+
							  "</td><td><form action = \"viewCardForward.jsp \" method = \"post\">"+
							  			"<input type = \"text\" name =\"account_pk\" value = \""+account.getPrimaryKey().toString()+"\" class = \"hide\">"+
							  			"<input type = \"submit\" value = \"View Cards\"></form>"+
							  "</td><td><form action = \"addCardForward.jsp \" method = \"post\">"+
									  	"<input type = \"text\" name =\"account_pk\" value = \""+account.getPrimaryKey().toString()+"\" class = \"hide\">"+
							  			"<input type = \"submit\" value = \"Add Card\"></form></td></tr>");
				}
			%>
		</table>
	</body>
</html>