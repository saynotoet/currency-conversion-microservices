package com.example.currencyexchangeservice.beans;

public class CurrencyExchange {

	private long id;
	private String from;
	private String to;
	private long exhcangeMultiple;
	private String environment;
	
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange(long id, String from, String to, long exhcangeMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.exhcangeMultiple = exhcangeMultiple;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public long getExhcangeMultiple() {
		return exhcangeMultiple;
	}
	public void setExhcangeMultiple(long exhcangeMultiple) {
		this.exhcangeMultiple = exhcangeMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
}
