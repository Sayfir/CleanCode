import airportrunner.Airport;
import data.PlanesData;
import models.ClassificationLevel;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

public class AirportTest {

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(PlanesData.planes);
        for (MilitaryPlane militaryPlane : airport.getTransportMilitaryPlanes())
            Assert.assertTrue(militaryPlane.getType() == MilitaryType.TRANSPORT);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(PlanesData.planes);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity, PlanesData.planeWithMaxPassengerCapacity);
    }

    @Test
    public void testNextPlaneMaxLoadCapacityIsHigherThanCurrent() {
        Airport airport = new Airport(PlanesData.planes);
        for (int i = 0; i < airport.sortByMaxLoadCapacity().getPlanes().size() - 1; i++) {
            Plane currentPlane = airport.sortByMaxLoadCapacity().getPlanes().get(i);
            Plane nextPlane = airport.sortByMaxLoadCapacity().getPlanes().get(i + 1);
            Assert.assertFalse(currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity());
        }
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(PlanesData.planes);
        for (MilitaryPlane militaryPlane : airport.getBomberMilitaryPlanes()) {
            Assert.assertTrue(militaryPlane.getType() == MilitaryType.BOMBER);
        }
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(PlanesData.planes);
        for (ExperimentalPlane experimentalPlane : airport.getExperimentalPlanes()) {
            Assert.assertFalse(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED);
        }
    }
}

