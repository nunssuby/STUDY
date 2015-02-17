package test.driven.development;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;


class CoffeeMakerStub implements CoffeeMakerAPI{
	public boolean buttonPressed;
	public boolean lightOn;
	public boolean boilerOn;
	public boolean valveClosed;
	public boolean plateOn;
	public boolean boilerEmpty;
	public boolean potPresent;
	public boolean potNotEmpty;
	
	public CoffeeMakerStub(){
		buttonPressed = false; 
		lightOn = false;       
		boilerOn = false;      
		valveClosed = true;   
		plateOn = false;       
		boilerEmpty = true;   
		potPresent = true;    
		potNotEmpty = false;   

	}
	

	  public int getWarmerPlateStatus() {
	    if (!potPresent)
	      return WARMER_EMPTY;
	    else if (potNotEmpty)
	      return POT_NOT_EMPTY;
	    else
	      return POT_EMPTY;
	  }

	  public int getBoilerStatus() {
	    return boilerEmpty ? BOILER_EMPTY : BOILER_NOT_EMPTY;
	  }

	  public int getBrewButtonStatus() {
	    if (buttonPressed) {
	      buttonPressed = false;
	      return BREW_BUTTON_PUSHED;
	    } else {
	      return BREW_BUTTON_NOT_PUSHED;
	    }
	  }

	  public void setBoilerState(int boilerStatus) {
	    boilerOn = boilerStatus == BOILER_ON;
	  }

	  public void setWarmerState(int warmerState) {
	    plateOn = warmerState == WARMER_ON;
	  }

	  public void setIndicatorState(int indicatorState) {
	    lightOn = indicatorState == INDICATOR_ON;
	  }

	  public void setReliefValveState(int reliefValveState) {
	    valveClosed = reliefValveState == VALVE_CLOSED;
	  }
	
}

public class TestCoffeeMaker {

	private M4UserInterface ui;
	private M4HotWaterSource hws;
	private M4ContainmentVessel cv;
	private CoffeeMakerStub api;
	
	@Before
	public void init() throws Exception {
		api = new CoffeeMakerStub();
	    ui = new M4UserInterface(api);
	    hws = new M4HotWaterSource(api);
	    cv = new M4ContainmentVessel(api);
	    ui.init(hws, cv);
	    hws.init(ui, cv);
	    cv.init(ui, hws);
	}
	
	private void poll(){
		ui.poll();
		hws.poll();
		cv.poll();
	}
	
	@Test
	public void testInitialConditions() throws Exception {
		poll();
		
		assertThat(false, is(api.boilerOn));
		assertThat(false, is(api.lightOn));
		assertThat(false, is(api.plateOn));
		assertThat(true, is(api.valveClosed));
//		assert(api.boilerOn == false);
//		assert(api.lightOn == false);
//		assert(api.plateOn == false);
//		assert(api.valveClosed == false);
	}
	
	@Test
	public void testStartNoPot() throws Exception {
		poll();
		api.buttonPressed = true;
		api.potPresent = false;
		poll();
		assertThat(false, is(api.boilerOn));
		assertThat(false, is(api.lightOn));
		assertThat(false, is(api.plateOn));
		assertThat(true, is(api.valveClosed));
//		assert(api.boilerOn == false);
//		assert(api.lightOn == false);
//		assert(api.plateOn == false);
//		assert(api.valveClosed == true);
	}
	
	@Test
	public void testStartNoWater() throws Exception {
	    poll();
	    api.buttonPressed = true;
	    api.boilerEmpty = true;
	    poll();
		assertThat(false, is(api.boilerOn));
		assertThat(false, is(api.lightOn));
		assertThat(false, is(api.plateOn));
		assertThat(true, is(api.valveClosed));
//	    assert(api.boilerOn == false);
//	    assert(api.lightOn == false);
//	    assert(api.plateOn == false);
//	    assert(api.valveClosed == true);
	  }

	@Test
	  public void testGoodStart() throws Exception {
	    normalStart();
		assertThat(true, is(api.boilerOn));
		assertThat(false, is(api.lightOn));
		assertThat(false, is(api.plateOn));
		assertThat(true, is(api.valveClosed));
//	    assert(api.boilerOn == true);
//	    assert(api.lightOn == false);
//	    assert(api.plateOn == false);
//	    assert(api.valveClosed == true);
	  }

	  private void normalStart() {
	    poll();
	    api.boilerEmpty = false;
	    api.buttonPressed = true;
	    poll();
	  }
	  
	  @Test
	  public void testStartedPotNotEmpty() throws Exception {
		    normalStart();
		    api.potNotEmpty = true;
		    poll();
		    assertThat(true, is(api.boilerOn));
			assertThat(false, is(api.lightOn));
			assertThat(true, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == true);
//		    assert(api.lightOn == false);
//		    assert(api.plateOn == true);
//		    assert(api.valveClosed == true);
		  }

	  @Test
		  public void testPotRemovedAndReplacedWhileEmpty() throws Exception {
		    normalStart();
		    api.potPresent = false;
		    poll();
		    assertThat(false, is(api.boilerOn));
			assertThat(false, is(api.lightOn));
			assertThat(false, is(api.plateOn));
			assertThat(false, is(api.valveClosed));
//		    assert(api.boilerOn == false);
//		    assert(api.lightOn == false);
//		    assert(api.plateOn == false);
//		    assert(api.valveClosed == false);
		    api.potPresent = true;
		    poll();
		    assertThat(true, is(api.boilerOn));
			assertThat(false, is(api.lightOn));
			assertThat(false, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == true);
//		    assert(api.lightOn == false);
//		    assert(api.plateOn == false);
//		    assert(api.valveClosed == true);
		  }

	  @Test
		  public void testPotRemovedWhileNotEmptyAndReplacedEmpty() throws Exception {
		    normalFill();
		    api.potPresent = false;
		    poll();
		    assertThat(false, is(api.boilerOn));
			assertThat(false, is(api.lightOn));
			assertThat(false, is(api.plateOn));
			assertThat(false, is(api.valveClosed));
//		    assert(api.boilerOn == false);
//		    assert(api.lightOn == false);
//		    assert(api.plateOn == false);
//		    assert(api.valveClosed == false);
		    api.potPresent = true;
		    api.potNotEmpty = false;
		    poll();
		    assertThat(true, is(api.boilerOn));
			assertThat(false, is(api.lightOn));
			assertThat(false, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == true);
//		    assert(api.lightOn == false);
//		    assert(api.plateOn == false);
//		    assert(api.valveClosed == true);
		  }

		  private void normalFill() {
		    normalStart();
		    api.potNotEmpty = true;
		    poll();
		  }

		  @Test
		  public void testPotRemovedWhileNotEmptyAndReplacedNotEmpty() throws Exception {
		    normalFill();
		    api.potPresent = false;
		    poll();
		    api.potPresent = true;
		    poll();
		    assertThat(true, is(api.boilerOn));
			assertThat(false, is(api.lightOn));
			assertThat(true, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == true);
//		    assert(api.lightOn == false);
//		    assert(api.plateOn == true);
//		    assert(api.valveClosed == true);
		  }

		  @Test
		  public void testBoilerEmptyPotNotEmpty() throws Exception {
		    normalBrew();
		    assertThat(false, is(api.boilerOn));
			assertThat(true, is(api.lightOn));
			assertThat(true, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == false);
//		    assert(api.lightOn == true);
//		    assert(api.plateOn == true);
//		    assert(api.valveClosed == true);
		  }

		  private void normalBrew() {
		    normalFill();
		    api.boilerEmpty = true;
		    poll();
		  }

		  @Test
		  public void testBoilerEmptiesWhilePotRemoved() throws Exception {
		    normalFill();
		    api.potPresent = false;
		    poll();
		    api.boilerEmpty = true;
		    poll();
		    assertThat(false, is(api.boilerOn));
			assertThat(true, is(api.lightOn));
			assertThat(false, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == false);
//		    assert(api.lightOn == true);
//		    assert(api.plateOn == false);
//		    assert(api.valveClosed == true);
		    api.potPresent = true;
		    poll();
		    assertThat(false, is(api.boilerOn));
			assertThat(true, is(api.lightOn));
			assertThat(true, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == false);
//		    assert(api.lightOn == true);
//		    assert(api.plateOn == true);
//		    assert(api.valveClosed == true);
		  }

		  @Test
		  public void testEmptyPotReturnedAfter() throws Exception {
		    normalBrew();
		    api.potNotEmpty = false;
		    poll();
		    assertThat(false, is(api.boilerOn));
			assertThat(false, is(api.lightOn));
			assertThat(false, is(api.plateOn));
			assertThat(true, is(api.valveClosed));
//		    assert(api.boilerOn == false);
//		    assert(api.lightOn == false);
//		    assert(api.plateOn == false);
//		    assert(api.valveClosed == true);
		  }
}


