package services;

import java.util.HashMap;
import java.util.Map;

import base.BaseService;
import constants.ApiEndpoints;
import io.restassured.response.Response;
import pojo.request.createbooking.AddReportRequestPojo;

public class ReportService extends BaseService {

	GenerateTokenService gen = new GenerateTokenService();

	public Response addReport(AddReportRequestPojo payload) {
		Map<String, String> header = gen.getHeadersWithAuth(gen.getToken());
		Response res = executePostApi(ApiEndpoints.ADD_REPORT, header, payload);
		return res;
	}

	public int addReportAndGetReportId(AddReportRequestPojo payload) {
		Response res = addReport(payload);
		return res.jsonPath().getInt("content");
	}

	public Response getReport(int userId) {
		Map<String, String> header = gen.getHeadersWithAuth(gen.getToken());
		Map<String, Integer> pathParams = new HashMap<>();
		pathParams.put("userId", userId);
		return executeGetApi(ApiEndpoints.GET_REPORT, header, pathParams);
	}
	
	public Response deleteReport(int reportId, int userId) {
		Map<String, String> header = gen.getHeadersWithAuth(gen.getToken());
		Map<String, Integer> pathParams = new HashMap<>();
		pathParams.put("userId", userId);
		pathParams.put("reportId", reportId);
		Response res = executeDeleteApiWithoutBody(ApiEndpoints.DELETE_REPORT, header, pathParams);
		return res;
	}

}
