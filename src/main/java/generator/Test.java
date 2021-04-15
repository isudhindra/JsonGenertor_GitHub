package generator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import org.json.JSONArray;


public class Test {

	public static void main(String[] args) {
		
		for (int i=1;i<Integer.parseInt(args[0]);i++) {
			GenerateJson("Parcels"+i);
		}

	}
	
	
	public static void GenerateJson(String Filename) {


		JSONArray jsonMain = new JSONArray();

		File filePath = new File("jsonFiles/"+Filename+".json");

		Map details = new LinkedHashMap();

		details.put("MessageId", "12345-§12345-12345-12345");
		details.put("MessageType", "CONFIRMED ITINERARY");
		details.put("MessageVersion", "1");
		details.put("RouteBarcode", "4342623602");
		details.put("BusinessUnit", "RM");
		details.put("DeviceID", "123456234");
		details.put("UserId", "1");
		details.put("ObiID", "11234");
		details.put("FuncationalLocationID", "272");
		details.put("StopPointsCount", "3");

		details.put("WorkProcessCode", "1");
		details.put("Latitude", 34.343243);
		details.put("Longitude", -0.99343434);
		details.put("Altitude", 2);
		details.put("ManifestId", "1");
		details.put("SubmissionTime", "1");

		details.put("FinalOptimisationTime", "1");
		details.put("ConfirmationTime", "1");
		details.put("TotalJourneyInSec", 7220);

		// Stop Points Object
		Map StopPoints = new LinkedHashMap();

		StopPoints.put("DepartureTime", "1");
		StopPoints.put("StopPointType", "1");
		StopPoints.put("Addr1", "1");
		StopPoints.put("Addr2", "1");
		StopPoints.put("Addr3", "1");
		StopPoints.put("Addr4", "1");
		StopPoints.put("Addr5", "1");
		StopPoints.put("Town", "1");
		StopPoints.put("PostCode", "1");
		StopPoints.put("DPS", "SL54EE1Z");
		
		details.put("StopPoints", StopPoints);
		jsonMain.put(details);

		// Adding StopPoints Object

		// Second Object
//        JSONObject second = new JSONObject();
//        
//        second.put("MessageVersion","1");
//        StopPoints.put("MessageVersion","1");
//        StopPoints.put("MessageVersion","1");
//        StopPoints.put("MessageVersion","1");
//        StopPoints.put("MessageVersion","1");

		// Write JSON file
		try (FileWriter file = new FileWriter(filePath)) {
			// We can write any JSONArray or JSONObject instance to the file
			System.out.println(filePath.getAbsolutePath());
			file.write(jsonMain.toString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}