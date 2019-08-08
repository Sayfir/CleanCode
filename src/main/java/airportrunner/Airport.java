
package airportrunner;

import models.MilitaryType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Airport {
    private List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public  List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        PassengerPlane planeWithMaxCapacity = getPassengerPlanes().get(0);
        for (int i = 0; i < getPassengerPlanes().size(); i++) {
            if (getPassengerPlanes().get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = getPassengerPlanes().get(i);
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        for (int i = 0; i < getMilitaryPlanes().size(); i++) {
            MilitaryPlane plane = getMilitaryPlanes().get(i);
            if (plane.getType() == MilitaryType.TRANSPORT) {
                transportMilitaryPlanes.add(plane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        for (int i = 0; i < getMilitaryPlanes().size(); i++) {
            MilitaryPlane plane = getMilitaryPlanes().get(i);
            if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanes.add(plane);
            }
        }
        return bomberMilitaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        planes.sort((Comparator<Plane>)
                (planeWithGreaterDistance, planeWithLowerDistance) -> planeWithGreaterDistance.getMaxFlightDistance() - planeWithLowerDistance.getMaxFlightDistance()
        );
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort((Comparator<Plane>)
                (planeWithFastestSpeed, planeWithSlowerSpeed) -> planeWithFastestSpeed.getMaxSpeed() - planeWithSlowerSpeed.getMaxSpeed()
        );
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort((Comparator<Plane>)
                (planeWithGreaterCapacity, planeWithLowerCapacity) -> planeWithGreaterCapacity.getMaxLoadCapacity() - planeWithLowerCapacity.getMaxLoadCapacity()
        );
        return this;
    }
    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public List<Plane> getPlanes() {
        return (List<Plane>) planes;
    }
}
