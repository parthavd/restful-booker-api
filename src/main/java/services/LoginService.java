package services;

import java.util.Map;

import org.json.simple.JSONObject;

import base.BaseService;
import constants.ApiEndpoints;
import io.restassured.response.Response;

public class LoginService extends BaseService{
	GenerateTokenService gen = new GenerateTokenService();
	
	@SuppressWarnings("unchecked")
	public Response userLogin(String email, String password) {
		JSONObject loginPayload = new JSONObject();
		loginPayload.put("email_id", email);
		loginPayload.put("password", password);
		return userLogin(loginPayload);
	}
	
	public Response userLogin(JSONObject loginPayload) {
		String password = loginPayload.get("password").toString();
		String emailId = loginPayload.get("email_id").toString();
		gen.getUserId(emailId, password);
		Map<String, String> header = getHeadersWithAuth(gen.getToken());
		return executePostApi(ApiEndpoints.LOGIN, header, loginPayload);
	}
	
	public int loginAndGetUserId(JSONObject loginPayload) {
		Response res = userLogin(loginPayload);
		int userId = res.jsonPath().getInt("content.userId");
		return userId;
	}
}
