package DistanceCalculator;

import java.io.IOException;

import org.json.JSONObject;

import ApiCaller.ApiCaller;

public class DistanceCalculator {

	private ApiCaller apiCaller;

	private double issLatitude = 0.0f;
	private double issLongitude = 0.0f;

	// Everything in km
	private double issAltitude = 408;
	private double earthRadius = 6371;

	public DistanceCalculator(ApiCaller api) {
		this.apiCaller = api;
	}

	public void setUpIssCoord() throws IOException {
		JSONObject obj = apiCaller.getJsonFromUrl("http://api.open-notify.org/iss-now.json");
		JSONObject latLong = obj.getJSONObject("iss_position");

		issLatitude = latLong.getDouble("latitude");
		issLongitude = latLong.getDouble("longitude");
	}

	// Haversine formula
	public double getDistanceBetweenTwoCoords(double lat1, double long1, double lat2, double long2) {
		double distance = 0.0;

		double distanceLat = Math.toRadians(lat2 - lat1);
		double distanceLong = Math.toRadians(long2 - long1);

		double lat1Radian = Math.toRadians(lat1);
		double lat2Radian = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(distanceLat / 2), 2)
				+ Math.pow(Math.sin(distanceLong / 2), 2) * Math.cos(lat1Radian) * Math.cos(lat2Radian);
		
		double c = 2 * Math.asin(Math.sqrt(a));
		
		distance = earthRadius * c;

		return distance;
	}
}
