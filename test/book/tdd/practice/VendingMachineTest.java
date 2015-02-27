package book.tdd.practice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	private VendingMachine vendingMachine;
	private Beverage[] beverage;
	
	@Before
	public void init(){
		vendingMachine = new VendingMachine();
		beverage = new Beverage[4]; 
		beverage[0]	= new Beverage(500,10,"coffee");
		beverage[1]	= new Beverage(750,8,"coke");
		beverage[2]	= new Beverage(450,12,"2%");
		beverage[3]	= new Beverage(650,15,"soda");
		
		vendingMachine.insertBeverage(0, beverage[0]);
		vendingMachine.insertBeverage(1, beverage[1]);
		vendingMachine.insertBeverage(2, beverage[2]);
		vendingMachine.insertBeverage(3, beverage[3]);
	}
	
	@Test
	public void testInsertCoin(){
		int coin = 1000;
		int result = vendingMachine.getChange()+ coin;
		vendingMachine.insertCoin(coin);
		assertThat(vendingMachine.getChange(), is(result));
	}
	
	@Test
	public void testDisplayBeverage() {
//		fail("Not yet implemented"); // TODO
//		assertThat(vendingMachine., is());
		vendingMachine.displayBeverage();
	}

	@Test
	public void testSelectBeverage() {
//		fail("Not yet implemented"); // TODO
		vendingMachine.insertCoin(2000);
		int result = vendingMachine.getChange() - vendingMachine.getBeverage(0).getPrice();
		vendingMachine.selectBeverage(0);
		assertThat(vendingMachine.getChange(), is(result));
	}

	@Test
	public void testDisplayChange() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGiveChange() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testInsertBeverage() {
		fail("Not yet implemented"); // TODO
	}

}
