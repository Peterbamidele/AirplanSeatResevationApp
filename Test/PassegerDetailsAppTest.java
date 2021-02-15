import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerDetailsAppTest {
    PassengerDetailsApp passengerDetailsApp;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        passengerDetailsApp = new PassengerDetailsApp();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        passengerDetailsApp= null;
    }

    @Test
    void CheckIfFirstNameIsAdd(){
        passengerDetailsApp.addPassengerDetails("pet","bami","yaba");
        assertEquals(passengerDetailsApp.getpassengerdetails(),passengerDetailsApp.getpassengerdetails());

    }

    @Test
    void CheckIfPassegenerCanGetDetails(){
        passengerDetailsApp.addPassengerDetails("pet","bami","yaba");
        assertEquals("{firstName=PET, lastName=BAMI, destination=yaba}",passengerDetailsApp.getpassengerdetails());

    }

    @Test
    void getPassengerDetailsWithKey(){
        passengerDetailsApp.addPassengerDetails("pet","bami","yaba");
        assertEquals("pet".toUpperCase(),passengerDetailsApp.getpassengerdetailsWithkey("firstName"));

    }

    @Test
    void getPassengerDetails() {
        passengerDetailsApp.addPassengerDetails("Pet", "Bami", "Oyo");
        assertEquals(passengerDetailsApp.getPassengerDetails(), passengerDetailsApp.getPassengerDetails());
    }

}