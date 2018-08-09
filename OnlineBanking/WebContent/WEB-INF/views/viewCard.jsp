<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.zycus.db.dao.CardDao"  %>
<%@ page import = "com.zycus.pojo.cards.Card"  %>
<%@ page import = "java.util.List"  %>
<%@ page import = "java.util.Date"  %>
<%@ page import = "java.text.DateFormat"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>View Card</title>
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
		<h2>All Cards</h2>
		<table style = "width:100%"> 
			<tr>
				<th>Card Number</th>
				<th>Maximum Limit</th>
				<th>Expiry Date</th>
			</tr>

			<%
				String accountPK = (String)request.getAttribute("account_pk");
				List <Card> allCards = CardDao.findByAccountPK(Long.parseLong(accountPK));
				long sze = allCards.size();
			%>
			<% 
				if(sze != 0) {
					
					for(Card Card : allCards) {
						Date date = new Date(Card.getExpiryDate());
						
						out.print("<tr><td>"+Card.getCardNumber()+
								  "</td><td>"+Card.getMaximumLimit()+
								  "</td><td>"+DateFormat.getInstance().format(date).toString()+"</td></tr>");
					}
				}
				else {
			%>
					<h3><%=		"There is no card linked with this account" %></h3>
			<%
				}
			%>
		</table>
	</body>
</html>