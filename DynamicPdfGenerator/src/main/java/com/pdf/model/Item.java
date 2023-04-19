package com.pdf.model;

public class Item {

	   private String name;
	    private String quantity;
	    private double rate;
	    private double amount;
	    
	    public Item() {
			// TODO Auto-generated constructor stub
		}
	    
	    
		public Item(String name, String quantity, double rate, double amount) {
			super();
			this.name = name;
			this.quantity = quantity;
			this.rate = rate;
			this.amount = amount;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getQuantity() {
			return quantity;
		}
		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
	    
	    
	    
	    
}
