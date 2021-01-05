package model.entities;

import model.exceptions.WithdrawException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;

	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withDraw(Double amount) {
		if (amount > withDrawLimit) {
			throw new WithdrawException("The amount exceeds withdraw limit");
		}
		if (amount > balance) {
			throw new WithdrawException("Not enough balance");
		} else {
			balance -= amount;
		}
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(Double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}

}
