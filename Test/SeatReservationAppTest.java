import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatReservationAppTest {
    SeatReservationApp seatReservationApp;
    PassengerDetailsApp passengerDetailsApp;
    WaitingList waitingList;


    @BeforeEach
    void setUp() {
        seatReservationApp = new SeatReservationApp();
        passengerDetailsApp = new PassengerDetailsApp();
        waitingList =new WaitingList();
    }

    @AfterEach
    void tearDown() {
        seatReservationApp = null;
        passengerDetailsApp = null;
        waitingList =null;
            }

    @Test
    void addPassengeerDetailsToSeat(){
        passengerDetailsApp.addPassengerDetails("Tony","luku","togo");
        seatReservationApp.addPassengerDetailsToSeat(passengerDetailsApp.getpassengerdetails(), waitingList);
       seatReservationApp.removePassengerDetailsFromSeat(0,0);
    }

    @Test
    void removePassengerDetilsFromSeat(){
        passengerDetailsApp.addPassengerDetails("Sony","Buku","japan");
        seatReservationApp.addPassengerDetailsToSeat(passengerDetailsApp.getpassengerdetails(),waitingList);
        seatReservationApp.displayAvailableSeats();//show available seat before the removed method
        seatReservationApp.removePassengerDetailsFromSeat(0,0);
        seatReservationApp.displayAvailableSeats();
    }

    @Test
    void getNextPassengerOnWaitList(){
        passengerDetailsApp.addPassengerDetails("Lony","duku","India");
        seatReservationApp.addPassengerDetailsToSeat(passengerDetailsApp.getpassengerdetails(),waitingList);
        passengerDetailsApp.addPassengerDetails("dony","guku","brazil");
        seatReservationApp.addPassengerDetailsToSeat(passengerDetailsApp.getpassengerdetails(),waitingList);
        assertEquals("{firstName=DONY, lastName=GUKU, destination=brazil}",passengerDetailsApp.getpassengerdetails());
    }



    @Test
    void addPassengerFRomWaitLngToSeat(){
        passengerDetailsApp.addPassengerDetails("dony","guku","brazil");
        waitingList.addPassengerToWaitList(passengerDetailsApp.getpassengerdetails());
        seatReservationApp.addPassengerFromWaitingListToSeat(waitingList);
        seatReservationApp.displayAvailableSeats();

    }

    @Test
    void displayAvailableSeat(){
        seatReservationApp.displayAvailableSeats();
    }



    @Test
    void CheckIfWaitingIsEmpty(){
        assertTrue(waitingList.checkIfWaitingListIsEmpty());
    }

    @Test
    void testToString(){
        assertNotNull(waitingList.toString());
    }

}