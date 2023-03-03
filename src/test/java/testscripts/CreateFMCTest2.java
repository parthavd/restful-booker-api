package testscripts;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseService;
import constants.Status_Code;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.DataGenerator;

public class CreateFMCTest2 {
	
	String accessToken;
	String email = DataGenerator.createEmailID();
	String full_name = DataGenerator.createFullName();
	String phone_Number = DataGenerator.createPhoneNumber();
	String password = "Password_123";
	String otp;
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
	
	@Test
	public void createToken() {
		Map<String, String> headerMap = baseService.getHeadersWithoutAuth();
		res = baseService.executeGetApi("fmc/token", headerMap);
		//System.out.println(res.asPrettyString());
		accessToken = res.jsonPath().getString("accessToken");
		Assert.assertEquals(res.getStatusCode(), Status_Code.OK);
		System.out.println(accessToken);
	}
	
	@Test(priority = 1)
	public void emailSignUp() {
		JSONObject emailSignUpPayload = new JSONObject();
		emailSignUpPayload.put("email_id", email);
		Map<String, String> header = baseService.getHeadersWithAuth(accessToken);
		res = baseService.executePostApi("/fmc/email-signup-automation", header, emailSignUpPayload);	
		System.out.println(res.asPrettyString());	
		otp = res.jsonPath().getString("content.otp");
		System.out.println("OTP: " + otp);
		Assert.assertEquals(res.getStatusCode(), Status_Code.CREATED);
	}
	
	@Test(priority = 2)
	public void verifyOTP() {
		JSONObject putPayload = new JSONObject();
		putPayload.put("email_id", email);
		putPayload.put("full_name", full_name);
		putPayload.put("phone_number", phone_Number);
		putPayload.put("password", password);
		putPayload.put("otp", otp);
		Map<String, String> header = baseService.getHeadersWithAuth(accessToken);
		res = baseService.executePutApi("/fmc/verify-otp", header, putPayload);
		int userId = res.jsonPath().getInt("content.userId");
		Assert.assertEquals(res.statusCode(), Status_Code.OK);
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
	
	/*@Test
	public void postUserLogin() {
		createToken();
		String otp = emailSignUp(email);
		verifyOTP(email, full_name, phone_Number, password, otp);
		System.out.println("PUT Response: " + res.asPrettyString());	
	}*/


}
