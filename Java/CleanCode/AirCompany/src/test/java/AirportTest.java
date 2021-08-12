import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AirportTest {
    private static Airport airport;
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VERTICAL_TAKEOFF_AND_LANDING, ClassificationLevel.TOP_SECRET)
    );

    @BeforeClass
    public void setUp() {
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> actualTransportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        List<MilitaryPlane> expectedTransportMilitaryPlanes = Collections.singletonList(new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT));
        Assert.assertEquals(expectedTransportMilitaryPlanes, actualTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        PassengerPlane actualPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengerCapacity, actualPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
    	List<Plane> planes = Arrays.asList(
    			new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
				new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
				new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER)
		);
    	airport = new Airport(planes);
        List<? extends Plane> expectedPlanesSortedByMaxLoadCapacity = Arrays.asList(
				new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
				new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
				new PassengerPlane("Boeing-747", 980, 16100, 70500, 242)
		);
		airport.sortByMaxLoadCapacity();
        List<? extends Plane> actualPlanesSortedByMaxLoadCapacity = airport.getPlanes();
        Assert.assertEquals(expectedPlanesSortedByMaxLoadCapacity, actualPlanesSortedByMaxLoadCapacity);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertEquals(bomberMilitaryPlanes.get(0).getType(), MilitaryType.BOMBER);
    }

    @Test
    public void testExperimentalPlanesHaveClassificationLevelHigherThanUnclassified() {
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes();
        Assert.assertNotEquals(experimentalPlanes.get(0).getClassificationLevel(),
                               ClassificationLevel.UNCLASSIFIED);
        Assert.assertNotEquals(experimentalPlanes.get(1).getClassificationLevel(),
                               ClassificationLevel.UNCLASSIFIED);
    }
}
