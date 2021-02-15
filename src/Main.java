import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        PassengerDetailsApp passengerDetailsApp = new PassengerDetailsApp();
        SeatReservationApp seatReservationApp = new SeatReservationApp();
        WaitingList waitingList = new WaitingList();

        int choice;
        do {
            System.out.print("""
                    __Welcome to PetTech Travel Reservation System__
                    - Enter(1) - to reserve seat for Passenger
                    - Enter(2) - to remove a reserved passenger from Seat
                    - Enter(3) - to reserve seats for multiple passengers
                    - Enter(4) - to list passengers with reservation 
                    - Enter(0) - to Quit
                    -\s""");

            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    seatReservationApp.displayAvailableSeats();
                    System.out.println("__Provide accurate Passenger Details");
                    System.out.print("- Enter First Name: ");
                    String firstName = input.next();
                    System.out.print("- Enter Last Name: ");
                    String lastName = input.next();
                    System.out.print("- Enter Destination: ");
                    String destination = input.next();
                    passengerDetailsApp.addPassengerDetails(firstName,lastName,destination);
                    loadingEffect(); //PSM loadingEffect
                    seatReservationApp.addPassengerDetailsToSeat(passengerDetailsApp.getpassengerdetails(), waitingList);
                    System.out.println("Thank you!");
                    seatReservationApp.addPassengerFromWaitingListToSeat(waitingList);
                }
                case 2 -> {
                    seatReservationApp.displayAvailableSeats();
                    System.out.println("__Provide an accurate seat row(X) and column(X)");
                    System.out.print("- Enter row number: ");
                    int row = input.nextInt();
                    System.out.print("- Enter column number: ");
                    int column = input.nextInt();
                    loadingEffect(); //PSM loadingEffect
                    seatReservationApp.removePassengerDetailsFromSeat(row,column);
                    seatReservationApp.addPassengerFromWaitingListToSeat(waitingList);
                }
                case 3 -> {
                    System.out.println("__This is a multiple reservation System\n" +
                            "ensure to provide accurate Passenger Details");
                    do {
                        seatReservationApp.displayAvailableSeats();
                        System.out.print("- Enter First Name or (Q) to exit: ");
                        String firstName = input.next();
                        if (firstName.equals("Q") || firstName.equals("q")) {
                            break;
                        }
                        System.out.print("- Enter Last Name or (Q) to exit: ");
                        String lastName = input.next();
                        if (lastName.equals("Q") || lastName.equals("q")) {
                            break;
                        }
                        System.out.print("- Enter Destination or (Q) to exit: ");
                        String destination = input.next();
                        if (destination.equals("Q") || destination.equals("q")) {
                            break;
                        }
                        passengerDetailsApp.addPassengerDetails(firstName,lastName,destination);
                        loadingEffect(); //PSM loadingEffect
                        seatReservationApp.addPassengerDetailsToSeat(passengerDetailsApp.getpassengerdetails(), waitingList);
                        System.out.println("Thank you!");
                        seatReservationApp.addPassengerFromWaitingListToSeat(waitingList);
                    } while (true);
                }
                case 4 -> {
                    System.out.println("__Here are Passenger Details with Reservation");
                    loadingEffect(); //PSM loadingEffect
                    seatReservationApp.listPassengersWithReservation();
                    seatReservationApp.addPassengerFromWaitingListToSeat(waitingList);
                }
                default -> {
                    if (choice == 0) {
                        seatReservationApp.displayAvailableSeats();
                        System.out.println("Bye for now");
                    } else {
                        System.out.println("I don't understand\n" +
                                "Try again");
                    }
                }
            }
        } while (choice != 0);
    }

public static void loadingEffect() throws InterruptedException {
    System.out.print("loading");
    for (int count = 0; count < 3; ++count) {
        Thread.sleep(1600);
        System.out.print(".");
    }
    System.out.println();
}
}