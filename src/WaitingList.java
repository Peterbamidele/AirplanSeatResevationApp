import java.util.LinkedList;


public class WaitingList {

    private static LinkedList<String> theWaitList = new LinkedList<>();
//    private final LinkedList<String> theWaitList = new LinkedList<>();



    public void addPassengerToWaitList(String passengerdetails) {

        theWaitList.addLast(passengerdetails);
    }
    public static String getNextPassengerOnWaitList(){
        return theWaitList.removeFirst();// remove passenger detail that is first in line
    }


    public boolean checkIfWaitingListIsEmpty() {
        return theWaitList.isEmpty(); // check wait list if empty or not
    }

    @Override
    public String toString(){
        return "Passengers on wait List:\n" + theWaitList;
        // show passenger details
    }

}
