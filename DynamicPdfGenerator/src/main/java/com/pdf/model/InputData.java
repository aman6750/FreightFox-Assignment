package com.pdf.model;

import java.util.List;

public class InputData {

	private String seller;
    private String sellerGstin;
    private String sellerAddress;
    private String buyer;
    private String buyerGstin;
    private String buyerAddress;
    private List<Item> items;
    
    
    
    public InputData() {
		// TODO Auto-generated constructor stub
	}
    
    
    
	public InputData(String seller, String sellerGstin, String sellerAddress, String buyer, String buyerGstin,
			String buyerAddress, List<Item> items) {
		super();
		this.seller = seller;
		this.sellerGstin = sellerGstin;
		this.sellerAddress = sellerAddress;
		this.buyer = buyer;
		this.buyerGstin = buyerGstin;
		this.buyerAddress = buyerAddress;
		this.items = items;
	}
	
	
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getSellerGstin() {
		return sellerGstin;
	}
	public void setSellerGstin(String sellerGstin) {
		this.sellerGstin = sellerGstin;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getBuyerGstin() {
		return buyerGstin;
	}
	public void setBuyerGstin(String buyerGstin) {
		this.buyerGstin = buyerGstin;
	}
	public String getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
    
    
    
	
}
