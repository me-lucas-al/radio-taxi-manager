package control;

import entity.Ride;
import entity.Customer;
import entity.dataType.Phone;
import entity.enums.RideStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RideController {
    private List<Ride> rides = new ArrayList<>();


    private List<String> allowedStreets = List.of(
            "Avenida Paulista",
            "Rua Augusta",
            "Avenida Consolação"
    );


    public Ride requestRide(Customer customer, String pickupAddress, String destinationNeighborhood, LocalDateTime departureTime, Phone contactPhone) {
        if (!isStreetAllowed(pickupAddress)) {
            throw new IllegalArgumentException("Erro: A rua '" + pickupAddress + "' não é atendida pela cooperativa Mar & Sol.");
        }

        Ride ride = new Ride(customer, pickupAddress, destinationNeighborhood, departureTime, contactPhone);
        rides.add(ride);
        return ride;
    }

    private boolean isStreetAllowed(String street) {
        for (String allowed : allowedStreets) {
            if (allowed.equalsIgnoreCase(street.trim())) {
                return true;
            }
        }
        return false;
    }

    public void assignTaxiToRide(Ride ride, String vrCode) {
        ride.confirmTaxi(vrCode);
    }

    public void confirmNoticeForRide(Ride ride) {
        ride.confirmNotice();
    }

    public void embarkPassengerOnRide(Ride ride) {
        ride.embarkPassenger();
    }

    public void cancelRideByPassenger(Ride ride) {
        ride.cancelByPassenger();
    }

    public void cancelRideDueToNoTaxi(Ride ride) {
        ride.cancelByNoTaxi();
    }

    public List<Ride> getAllRides() {
        return rides;
    }

    public List<Ride> getPendingRides() {
        List<Ride> pending = new ArrayList<>();
        for (Ride r : rides) {
            if (r.getStatus() == RideStatus.AGUARDANDO_VR || r.getStatus() == RideStatus.AGUARDANDO_AVISO) {
                pending.add(r);
            }
        }
        return pending;
    }
}