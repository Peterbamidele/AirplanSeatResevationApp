import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaitingListTest {
    WaitingList waitingList;
    PassengerDetailsApp passengerDetailsApp;
    SeatReservationApp seatReservationApp;

    @BeforeEach
    void setUp() {
        waitingList = new WaitingList();
        passengerDetailsApp = new PassengerDetailsApp();
        seatReservationApp= new SeatReservationApp();
    }

    @AfterEach
    void tearDown() {
        waitingList = null;
        passengerDetailsApp = null;
    }
    @Test
    void AddedPassengerToWaitingList(){
      passengerDetailsApp.addPassengerDetails("frank","lobi","sango");
      waitingList.addPassengerToWaitList(passengerDetailsApp.getpassengerdetails());
      assertEquals("{firstName=FRANK, lastName=LOBI, destination=sango}",waitingList.getNextPassengerOnWaitList());
    }

    @Test
    void GetNextPassengerOnWaitList(){
        passengerDetailsApp.addPassengerDetails("david","tobi","logoton");
        waitingList.addPassengerToWaitList(passengerDetailsApp.getpassengerdetails());
        passengerDetailsApp.addPassengerDetails("frank","lobi","sango");
        waitingList.addPassengerToWaitList(passengerDetailsApp.getpassengerdetails());
        assertEquals("{firstName=DAVID, lastName=TOBI, destination=logoton}",waitingList.getNextPassengerOnWaitList());
    }

    @Test
    void CheckIfWaitingListIsEmpty(){
        assertTrue(waitingList.checkIfWaitingListIsEmpty());
    }

    @Test
    void testToString(){
        assertNotNull(waitingList.toString());
    }
}