package testscripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.datafaker.Faker;
import utilities.DataGenerator;

import static io.restassured.RestAssured.given;

import java.util.Map;
public class CreateFMCTest {
	
	String accessToken;
	String email;
	Response res;
	BaseService baseService = new BaseService();
	
	private void createToken1() {
		RestAssured.baseURI = "http://fmc-env.eba-5akrwvvr.us-east-1.elasticbeanstalk.com";
		Response res = RestAssured.given()
			.headers("Accept", "application/json")
			.when().log().all()
			.get("fmc/token");
		
		//System.out.println(res.asPrettyString());
		accessToken = res.jsonPath().getString("accessToken");
		System.out.println(accessToken);
	}
	
	private void createToken() {
		Map<String, String> headerMap = baseService.getHeadersWithoutAuth();
		res = baseService.executeGetApi("fmc/token", headerMap);
		//System.out.println(res.asPrettyString());
		accessToken = res.jsonPath().getString("accessToken");
		System.out.println(accessToken);
	}
	
	private String emailSignUp(String email) {
		JSONObject emailSignUpPayload = new JSONObject();
		Object payload = emailSignUpPayload.put("email_id", email);
		Map<String, String> header = baseService.getHeadersWithAuth(accessToken);
		res = baseService.executePostApi("/fmc/email-signup-automation", header, emailSignUpPayload);	
		System.out.println(res.asPrettyString());	
		String otp = res.jsonPath().getString("content.otp");
		System.out.println("OTP: " + otp);
		return otp;	
		
	}
	
	private void verifyOTP(String email, String fullname, String phoneNumber, String password, String otp) {
		JSONObject putPayload = new JSONObject();
		putPayload.put("email_id", email);
		putPayload.put("full_name", fullname);
		putPayload.put("phone_number", phoneNumber);
		putPayload.put("password", password);
		putPayload.put("otp", otp);
		Map<String, String> header = baseService.getHeadersWithAuth(accessToken);
		res = baseService.executePutApi("/fmc/verify-otp", header, putPayload);
		Assert.assertEquals(res.statusCode(), 200);
	}
	
	private void userLogin(String email, String password) {
		JSONObject postPayload = new JSONObject();
		postPayload.put("email_id", email);
		postPayload.put("password", password);
		res = given()
				.headers("Authorization", "Bearer " + accessToken)
				.headers("Content-Type", "application/json")
				.body(postPayload)
				.when()
				.post("/fmc/verify-otp");
	}
	
	@Test
	public void postUserLogin() {
		email = DataGenerator.createEmailID();
		String full_name = DataGenerator.createFullName();
		String phone_Number = DataGenerator.createPhoneNumber();
		String password = "Password_123";
		createToken();
		String otp = emailSignUp(email);
		verifyOTP(email, full_name, phone_Number, password, otp);
		System.out.println("PUT Response: " + res.asPrettyString());	
	}
}
