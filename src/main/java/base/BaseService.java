package base;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseService {

	public BaseService() {
		RestAssured.baseURI = "http://fmc-env.eba-5akrwvvr.us-east-1.elasticbeanstalk.com";
	}

	public BaseService(String uri) {
		RestAssured.baseURI = uri;
	}

	public Map<String, String> getHeadersWithoutAuth() {
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "application/json");
		return headerMap;
	}

	public Map<String, String> getHeadersWithAuth(String accessToken) {
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Content-Type", "application/json");
		headerMap.put("Accept", "application/json");
		headerMap.put("Authorization", "Bearer " + accessToken);
		return headerMap;
	}

	public Response executeGetApi(String endPoint, Map<String, String> header) {
		return RestAssured.given().headers(header).when().get(endPoint);
	}
	
	public Response executeGetApi(String endPoint, Map<String, String> header, Map<String, Integer> pathParams) {
		return RestAssured.given().pathParams(pathParams).headers(header).get(endPoint);
	}

	public Response executePostApi(String endPoint, Map<String, String> header, Object body) {
		return RestAssured.given().headers(header).body(body).when().post(endPoint);
	}

	public Response executePutApi(String endPoint, Map<String, String> header, Object body) {
		return RestAssured.given().headers(header).body(body).when().put(endPoint);
	}

	public Response executeDeleteApiWithoutBody(String endPoint, Map<String, String> header) {
		return RestAssured.given().headers(header).when().delete(endPoint);
	}
	
	public Response executeDeleteApiWithoutBody(String endPoint, Map<String, String> header, Map<String, Integer> pathParams) {
		return RestAssured.given().headers(header).pathParams(pathParams).when().delete(endPoint);
	}

	public Response executeDeleteApiWithBody(String endPoint, Map<String, String> header, Object body) {
		return RestAssured.given().headers(header).body(body).when().delete(endPoint);
	}
}
