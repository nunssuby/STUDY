package book.tdd.practice;

public class Beverage {
	private int price;
	private int onHandQuantity;
	private String name;
	
	public Beverage(int price, int onHandQuantity, String name){
		this.price = price;
		this.onHandQuantity = onHandQuantity;
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOnHandQuantity() {
		return onHandQuantity;
	}
	public void setOnHandQuantity(int onHandQuantity) {
		this.onHandQuantity = onHandQuantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
