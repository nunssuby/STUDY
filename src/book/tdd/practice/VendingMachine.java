package book.tdd.practice;

public class VendingMachine {
	private int change;
	private Beverage[] slot;
	
	public VendingMachine(){
		this.change = 0;
		this.slot = new Beverage[4];
	}

	public int getChange() {
		return change;
	}
	
	public Beverage getBeverage(int index){
		return slot[index];
	}
	
	public void displayChange() {
		System.out.println("거스름돈 : "+this.change);
	}

	public void setChange(int change) {
		this.change = change;
	}
	
	public void insertCoin(int coin){
		this.change += coin;
	}
	
	public void displayBeverage(){
		System.out.println("slot1 : "+ slot[0].getName() +" : "+slot[0].getOnHandQuantity() + " 개" + " : "+slot[0].getPrice() + " 원");
		System.out.println("slot2 : "+ slot[1].getName() +" : "+slot[1].getOnHandQuantity() + " 개" + " : "+slot[1].getPrice() + " 원");
		System.out.println("slot3 : "+ slot[2].getName() +" : "+slot[2].getOnHandQuantity() + " 개" + " : "+slot[2].getPrice() + " 원");
		System.out.println("slot4 : "+ slot[3].getName() +" : "+slot[3].getOnHandQuantity() + " 개" + " : "+slot[3].getPrice() + " 원");
	}
	
	public void selectBeverage(int index){
		this.change -= slot[0].getPrice();
	}
	
	public int giveChange(){
		
		return 0;
	}
	
	public void insertBeverage(int index, Beverage beverage){
		slot[index] = beverage;
	}
	
}
