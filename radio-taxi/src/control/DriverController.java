package control;

import entity.Driver;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DriverController {
    private List<Driver> drivers = new ArrayList<>();

    public Driver registerDriver(String name, String cpf, String vrCode, LocalDate joinDate) {
        Driver newDriver = new Driver(name, cpf, vrCode, joinDate);
        drivers.add(newDriver);
        return newDriver;
    }

    public Driver findDriverByVrCode(String vrCode) {
        for (Driver driver : drivers) {
            if (driver.getVrCode().equalsIgnoreCase(vrCode)) {
                return driver;
            }
        }
        return null;
    }

    public void deactivateDriver(String vrCode, LocalDate leaveDate) {
        Driver driver = findDriverByVrCode(vrCode);
        if (driver == null) {
            throw new IllegalArgumentException("Erro: Motorista com VR " + vrCode + " não encontrado no sistema.");
        }
        driver.deactivate(leaveDate);
    }

    public List<Driver> getActiveDrivers() {
        List<Driver> activeDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.getLeaveDate() == null) {
                activeDrivers.add(driver);
            }
        }
        return activeDrivers;
    }
}