package DistanceCalculator;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ApiCaller.ApiCaller;

public class DistanceCalculatorTest {

	DistanceCalculator distanceCalc;
	JSONObject mockObj;
	JSONObject mockLatLong;
	
	ApiCaller mockApiCaller;
	
	@Before
	public void setUp() throws Exception {
		mockObj = Mockito.mock(JSONObject.class);
		mockLatLong = Mockito.mock(JSONObject.class);
		mockApiCaller = Mockito.mock(ApiCaller.class);
		
		distanceCalc = new DistanceCalculator(mockApiCaller);
	}

	@Test
	public void test_CalculateDistanceBigBenStatueOfLiberty() {
		double benLat = 51.5007;
		double benLong = 0.1246;
		double libLat = 40.6892;
		double libLong = 74.0445;
		
		assertEquals(5574.84045684855, distanceCalc.getDistanceBetweenTwoCoords(benLat, benLong, libLat, libLong), 0.00000000001);
	}

}
