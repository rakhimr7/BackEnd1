package databasePushPackage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

class LatLong {
	private String locationName;
	private String latitude;
	private String longitude;
	private String country;
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}

public class Scraper {

	public static List<Map<String, Object>> getCrimesByLatLongArea(LatLong latlong) throws JsonMappingException, JsonProcessingException {
		String lat = latlong.getLatitude();
		String lon = latlong.getLongitude();
		RestTemplate rt = new RestTemplate();
		String uri = "https://data.police.uk/api/crimes-street/all-crime?lat="+lat+"&lng="+lon;
		ResponseEntity<String> response = rt.getForEntity(uri, String.class);
		String JSONString = response.getBody();//.replace("[", "").replace("]", "");
		System.out.println(JSONString);
		List<Map<String,Object>> userData = new ObjectMapper().readValue(JSONString,new TypeReference<List<Map<String,Object>>>(){});
		return userData;
		
	}
	
	public static LatLong getLatLong(String locationQuery) throws JsonMappingException, JsonProcessingException {
		LatLong result = new LatLong();
		RestTemplate rt = new RestTemplate();
		String uri = "http://api.openweathermap.org/geo/1.0/direct?q="+locationQuery+"&limit=1&appid=2a8dbb0383e2903fee5497cb5217a8ac";
		ResponseEntity<String> response = rt.getForEntity(uri, String.class);
		String JSONString = response.getBody().replace("[", "").replace("]", "");
		
		try {
			Map<String,Object> userData = new ObjectMapper().readValue(JSONString,new TypeReference<Map<String,Object>>(){});
			result.setLocationName((String) userData.get("name"));
			result.setLatitude(userData.get("lat").toString());
			result.setLongitude(userData.get("lon").toString());
			result.setCountry((String) userData.get("country"));
			
			return result;
		} catch (JsonParseException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		//System.out.println(getLatLong("Uxbridge").get("lon"));
		//System.out.println(getLatLong("Uxbridge").get("lat"));
		
		LatLong result = getLatLong("Uxbridge");
		System.out.println(getCrimesByLatLongArea(result).get(0).get("category"));
		Map<String,Object> x = (Map<String,Object>) getCrimesByLatLongArea(result).get(0).get("location");
		Map<String,Object> y = (Map<String, Object>) x.get("street");
		String z = (String) y.get("name");
		//String y = (String) x.get("street");
		System.out.println(z);
		//System.out.println(y);
		
		}
	}