package testscripts;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import pojo.request.createbooking.AddReportRequestPojo;
import pojo.request.createbooking.ChildDetails;
import pojo.request.createbooking.IncidentDetails;
import pojo.request.createbooking.ReporterDetails;
import services.LoginService;
import services.ReportService;
import utilities.DataGenerator;

public class FMCReportTest {
	int userId;
	int reportId;
	LoginService loginService = new LoginService();
	ReportService reportService = new ReportService();
	AddReportRequestPojo addRequestPayload = new AddReportRequestPojo();

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void loginMethod() {
		LoginService loginService = new LoginService();
		JSONObject loginPayload = new JSONObject();
		loginPayload.put("email_id", DataGenerator.createEmailID());
		loginPayload.put("password", "Password_123");
		userId = loginService.loginAndGetUserId(loginPayload);
	}

	@Test
	public void addReportTest() {
		ChildDetails childObject = new ChildDetails();
		IncidentDetails incidentObject = new IncidentDetails();
		ReporterDetails reporterObject = new ReporterDetails();
		reporterObject.setRequest_id(DataGenerator.generateUUID());
		reporterObject.setUser_id(userId);
		reporterObject.setReport_date("2022-09-01T01:37:30Z");
		reporterObject.setReporter_fullname(DataGenerator.createFullName());
		reporterObject.setReporter_age(50);
		reporterObject.setReporter_gender("Male");
		reporterObject.setReporter_relation("Father");
		reporterObject.setParenting_type("Own Child");
		reporterObject.setContact_address_type("Home");
		reporterObject.setContact_address_line_1(DataGenerator.generatePinCode());
		reporterObject.setCountry("India");
		reporterObject.setPrimary_country_code("+91");
		reporterObject.setPrimary_contact_number(DataGenerator.generatePhoneNumber());
		reporterObject.setSecondary_country_code("+91");
		reporterObject.setSecondary_contact_number(DataGenerator.generatePhoneNumber());
		reporterObject.setCommunication_language("English");
		reporterObject.setStatus("INCOMPLETE");
		childObject.setFullname(DataGenerator.createFullName());
		childObject.setAge(10);
		childObject.setGender("Female");
		childObject.setHeight("5ft");
		childObject.setWeight("45kg");
		childObject.setComplexion("fair");
		childObject.setClothing("Red and black pant");
		childObject.setBirth_signs("mark on right hand");
		childObject.setOther_details("wears specs");
		childObject.setImage_file_key(null);
		childObject.setNickname("Kara");
		incidentObject.setIncident_date("2022-09-01T01:37:30Z");
		incidentObject.setIncident_brief("Child went missing near the school");
		incidentObject.setLocation(DataGenerator.generateCity());
		incidentObject.setLandmark_signs(DataGenerator.generateStreetAddress());
		incidentObject.setNearby_police_station("City police station");
		incidentObject.setNearby_NGO("City NGO");
		incidentObject.setAllow_connect_police_NGO(true);
		incidentObject.setSelf_verification(true);
		incidentObject.setCommunity_terms(true);
		addRequestPayload.setReporter_details(reporterObject);
		addRequestPayload.setChild_details(childObject);
		addRequestPayload.setIncident_details(incidentObject);
		Response res = reportService.addReport(addRequestPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.jsonPath().getString("status"), "Success");
		reportId = res.jsonPath().getInt("content");
		System.out.println("Report ID: " + reportId);
		Assert.assertTrue(reportId > 0);
	}

	@Test(dependsOnMethods = "addReportTest")
	public void getReportTest() {
		System.out.println("User ID: " + userId);
		boolean matchFlag = false;
		Response res = reportService.getReport(userId);
		Assert.assertEquals(res.getStatusCode(), 200);
		List<Integer> reportIdList = res.jsonPath().getList("content.reporter_details.report_id");
		for (int listId: reportIdList ) {
			if (listId == reportId) matchFlag = true;
		}
		Assert.assertTrue(matchFlag);
	}
	
	@Test(dependsOnMethods = "addReportTest")
	public void deleteReportTest() {
		Response res = reportService.deleteReport(reportId, userId);
		Assert.assertEquals(res.getStatusCode(), 200);
		boolean matchFlag = true;
		res = reportService.getReport(userId);
		Assert.assertEquals(res.getStatusCode(), 200);
		List<Integer> reportIdList = res.jsonPath().getList("content.reporter_details.report_id");
		for (int listId: reportIdList ) {
			if (listId == reportId) matchFlag = false;
		}
		Assert.assertTrue(matchFlag);		
	}

}
