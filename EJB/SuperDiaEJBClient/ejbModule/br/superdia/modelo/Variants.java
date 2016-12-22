package br.superdia.modelo;

public class Variants {
	private Double price;
	private String inventory_quantify;
	private String old_inventory_quantify;
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getInventory_quantify() {
		return inventory_quantify;
	}
	
	public void setInventory_quantify(String inventory_quantify) {
		this.inventory_quantify = inventory_quantify;
	}
	
	public String getOld_inventory_quantify() {
		return old_inventory_quantify;
	}

	public void setOld_inventory_quantify(String old_inventory_quantify) {
		this.old_inventory_quantify = old_inventory_quantify;
	}
}
