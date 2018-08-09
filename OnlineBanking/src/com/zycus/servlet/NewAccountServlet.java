package com.zycus.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zycus.db.dao.AccountDao;
import com.zycus.pojo.accounts.Account;
import com.zycus.pojo.cards.Card;

/**
 * Servlet implementation class NewAccountServlet
 */
@WebServlet("/new-account.do")
public class NewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Long ACCOUNT_GENERATOR = 1234567654321L;
	private static final Double OPENING_AMOUNT = 10000D;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String holderName = request.getParameter("holderName");
		String accountType = request.getParameter("accountType");
		
		if(holderName == null || holderName.equals("")) {
			request.setAttribute("message", "Please Enter Holder Name");
		}
		else {
			
			if(accountType == null || accountType.equals("Select")) {
				request.setAttribute("message", "Please select a account type");
			}
			else {
				Long accountNumber = createAccount(holderName, accountType);
				request.setAttribute("message", "Account created. Account Number is "+accountNumber.toString());
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/views/adminPage.jsp").forward(request, response);
	}
	
	public static Long createAccount(String accountHolder, String accountType) {
		Date date = new Date();
		Long primaryKey = System.currentTimeMillis() % 1000000000000l;
		Long accountNumber = primaryKey + ACCOUNT_GENERATOR;
		List <Card> allCards = new ArrayList<>();
		
		Account account = new Account(primaryKey, accountNumber, accountHolder, accountType, OPENING_AMOUNT, date.getTime(), allCards);
		AccountDao.insert(account);
		
		return accountNumber;
	}
}
