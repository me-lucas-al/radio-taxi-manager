package entity;

import entity.dataType.Phone;
import entity.enums.RideStatus;

import java.time.LocalDateTime;

public class Ride {
    private Customer customer;
    private String vrCode;
    private String pickupAddress;
    private String destinationNeighborhood;
    private LocalDateTime departureTime;
    private Phone contactPhone;
    private RideStatus status;
    private boolean isScheduled;

    public Ride(Customer customer, String pickupAddress, String destinationNeighborhood, LocalDateTime departureTime, Phone contactPhone) {
        this.customer = customer;
        this.pickupAddress = pickupAddress;
        this.destinationNeighborhood = destinationNeighborhood;
        this.departureTime = departureTime;
        this.contactPhone = contactPhone;
        this.status = RideStatus.AGUARDANDO_VR;
        this.isScheduled = true;
    }

    public String getPickupAddress() { return pickupAddress; }
    public RideStatus getStatus() { return status; }

    public void confirmTaxi(String vrCode) {
        if (this.status != RideStatus.AGUARDANDO_VR) {
            throw new IllegalStateException("Não é possível confirmar o táxi neste status.");
        }
        this.vrCode = vrCode;
        this.status = RideStatus.AGUARDANDO_AVISO;
    }

    public void confirmNotice() {
        if (this.status != RideStatus.AGUARDANDO_AVISO) {
            throw new IllegalStateException("O aviso só pode ser confirmado se estiver esperando por aviso.");
        }
        this.status = RideStatus.AVISO_EFETUADO;
    }

     public void embarkPassenger() {
        this.status = RideStatus.TRIPULADO;
    }

    public void cancelByPassenger() {
        this.status = RideStatus.CANCELADO_PASSAGEIRO;
    }

    public void cancelByNoTaxi() {
        this.status = RideStatus.CANCELADO_FALTA_TAXI;
    }
}