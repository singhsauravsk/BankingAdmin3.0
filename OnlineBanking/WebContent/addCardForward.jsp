<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.zycus.db.dao.CardDao" %>
<%@ page import = "com.zycus.pojo.cards.Card" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Card</title>
	</head>
	<body>
		<%
			String accountPK = request.getParameter("account_pk");
			Long primaryKey = System.currentTimeMillis() % 1000000000000l;
			Long cardNumber = CardDao.CARD_NUMBER_GENERATOR + (primaryKey / 10);
			Long expiryDate = System.currentTimeMillis() + 93334254235l;
			
			Card card = new Card(primaryKey, cardNumber, CardDao.MAXIMUM_LIMIT, expiryDate, Long.parseLong(accountPK));
			CardDao.insert(card);
			
			request.setAttribute("message", "Card Added Successfully");
			request.getRequestDispatcher("/WEB-INF/views/adminPage.jsp").forward(request, response);
		%>
	</body>
</html>