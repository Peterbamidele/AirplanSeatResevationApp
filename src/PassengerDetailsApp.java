import java.util.HashMap;
import java.util.Locale;
import java.util.Random;

public class PassengerDetailsApp {

    private HashMap<String, String> passenger;

    public void addPassengerDetails(String firstName, String lastName, String destination) {
        passenger = new HashMap<>();
        passenger.put("firstName", firstName.toUpperCase());
        passenger.put("lastName", lastName.toUpperCase());
        passenger.put("destination", destination);

    }

    private int generateRandomToken() {
        Random token = new Random();
        int upperbound = 1001;
        return token.nextInt(upperbound);
    }


    public String getpassengerdetails() {
        return String.valueOf(passenger);

    }

    public String getpassengerdetailsWithkey(String key) {
        return passenger.get(key);
    }


    public String getPassengerDetails() {
        return
                "[Identity: "+ getpassengerdetailsWithkey("Identity")+"], " +
                        "[First Name: "+getpassengerdetailsWithkey("First Name")+"], " +
                        "[Last Name: "+getpassengerdetailsWithkey("Last Name")+"], " +
                        "[Destination: "+getpassengerdetailsWithkey("Destination")+"],\n";
    }



}
