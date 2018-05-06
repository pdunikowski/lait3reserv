package pl.lait.przychodnia3;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObjects.LoginPage;
import pl.lait.pageObjects.Reservation2Page;
import pl.lait.pageObjects.ReservationPage;

public class ReservationTest {
	
	WebDriver driver = null;
	
	@Before
	public void open() {
		driver = Init.getDriver();
	}
	
	@Test
	public void loginWithPageObjects() {
		
		
		Init.log("Test z logowaniem i wypełnieniem formularza"
				+ " rezerwacji lotu");
		
		LoginPage loginPage = new LoginPage();
		ReservationPage reservPage = new ReservationPage();
		Reservation2Page reserv2Page = new Reservation2Page();
		
		loginPage.goToLoginPage();
		loginPage.login("andre", "andre");
		
		Init.sleep(15000);
		
		reservPage.oneWayRadioClick();
		reservPage.roundTripRadioClick();
		Init.sleep(3000);
		reservPage.setPassengersCount("2");
		reservPage.setFromDate("May", "10");
		reservPage.setDepartingFromDest("London");
		Init.sleep(3000);
		reservPage.setToDate("May", "15");
		reservPage.setArrivalInDest("Paris");
		reservPage.setBusinessClass();
		reservPage.setAirline("Blue Skies Airlines");
		Init.sleep(3000);
		reservPage.continueButtonClick();
		Init.sleep(5000);
		
		reserv2Page.departRadioClick();
		reserv2Page.returnRadioClick();
		reserv2Page.continueButtonClick();
		Init.sleep(5000);
		
	}
	
	@After
	public void tearDown() {
		Init.endTest();
	}

}
