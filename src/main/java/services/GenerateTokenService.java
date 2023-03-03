package services;

import java.util.Map;

import org.json.simple.JSONObject;

import base.BaseService;
import constants.ApiEndpoints;
import io.restassured.response.Response;
import utilities.DataGenerator;

public class GenerateTokenService extends BaseService{
	
	String email = DataGenerator.createEmailID();
	
	public Response getTokenResponse() {
		Map<String, String> headerMap = getHeadersWithoutAuth();
		Response res = executeGetApi(ApiEndpoints.TOKEN, headerMap);
		return res;
	}
	
	public String getToken() {
		Response res = getTokenResponse();
		return res.jsonPath().getString("accessToken");
	}
	
	public Response getEmailSignUpResponse(JSONObject emailSignUpPayload) {
		Map<String, String> header = getHeadersWithAuth(getToken());
		return executePostApi(ApiEndpoints.EMAIL_SIGNUP, header, emailSignUpPayload);
		
	}
	
	public String getOtpFromEmailSignUpResponse(JSONObject emailSignUpPayload) {
		Response res = getEmailSignUpResponse(emailSignUpPayload);
		String otp = res.jsonPath().getString("content.otp");
		return otp;
	}
	
	@SuppressWarnings("unchecked")
	public Response getEmailSignUpResponseWithoutPayload() {
		JSONObject emailSignUpPayload = new JSONObject();
		emailSignUpPayload.put("email_id", email);
		Map<String, String> header = getHeadersWithAuth(getToken());
		return executePostApi(ApiEndpoints.EMAIL_SIGNUP, header, emailSignUpPayload);		
	}
	
	public Response getVerifyOTPResponse(JSONObject putPayload) {
		Map<String, String> header = getHeadersWithAuth(getToken());
		return executePutApi(ApiEndpoints.VERIFY_OTP, header, putPayload);
		
	}
	
	public int getUserIdFromOTPResponse(JSONObject putPayload) {
		Response res = getVerifyOTPResponse(putPayload);
		int userId = res.jsonPath().getInt("content.userId");
		return userId;
	}
	
	@SuppressWarnings("unchecked")
	public int getUserId(String email, String password) {
		JSONObject emailSignUpPayload = new JSONObject();
		emailSignUpPayload.put("email_id", email);
		String otp = getOtpFromEmailSignUpResponse(emailSignUpPayload);
		String full_name = DataGenerator.createFullName();
		String phone_Number = DataGenerator.createPhoneNumber();
		JSONObject putPayload = new JSONObject();
		putPayload.put("email_id", email);
		putPayload.put("full_name", full_name);
		putPayload.put("phone_number", phone_Number);
		putPayload.put("password", password);
		putPayload.put("otp", otp);
		return getUserIdFromOTPResponse(putPayload);
	}
	
}
