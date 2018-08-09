package com.zycus.pojo.accounts;

import java.util.List;
import com.zycus.pojo.cards.Card;

public class Account {
	private Long primaryKey;
	private Long accountNumber;
	private String holderName;
	private String accountType;
	private Double amount;
	private Long openingDate;
	private List <Card> connectedCards;
	
	public Account() {
		super();
	}

	public Account(Long primaryKey, Long accountNumber, String holderName, String accountType, Double amount,
			Long openingDate, List<Card> connectedCards) {
		super();
		this.primaryKey = primaryKey;
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.accountType = accountType;
		this.amount = amount;
		this.openingDate = openingDate;
		this.connectedCards = connectedCards;
	}

	public Long getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Long getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Long openingDate) {
		this.openingDate = openingDate;
	}

	public List<Card> getConnectedCards() {
		return connectedCards;
	}

	public void setConnectedCards(List<Card> connectedCards) {
		this.connectedCards = connectedCards;
	}
}
