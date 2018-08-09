package com.zycus.pojo.cards;

public class Card {
	private Long primaryKey;
	private Long cardNumber;
	private Double maximumLimit;
	private Long expiryDate;
	private Long foreignKey;
	
	public Card() {
		super();
	}

	public Card(Long primaryKey, Long cardNumber, Double maximumLimit, Long expiryDate, Long foreignKey) {
		super();
		this.primaryKey = primaryKey;
		this.cardNumber = cardNumber;
		this.maximumLimit = maximumLimit;
		this.expiryDate = expiryDate;
		this.foreignKey = foreignKey;
	}

	public Long getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getMaximumLimit() {
		return maximumLimit;
	}

	public void setMaximumLimit(Double maximumLimit) {
		this.maximumLimit = maximumLimit;
	}

	public Long getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Long expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getforeignKey() {
		return foreignKey;
	}

	public void setforeignKey(Long foreignKey) {
		this.foreignKey = foreignKey;
	}
}
