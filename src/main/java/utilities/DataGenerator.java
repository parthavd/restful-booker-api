package utilities;

import java.util.UUID;

import net.datafaker.Faker;

public class DataGenerator {
	
	static Faker faker = new Faker();
	
	public static String createEmailID() {
		String email = faker.name().firstName() + "." + faker.name().lastName() + "@gmail.com";
		return email;
	}

	public static String createFullName() {
		String fullName = faker.name().firstName() + " " + faker.name().lastName();
		return fullName;
	}
	
	public static String createPhoneNumber() {
		String phoneNumber = faker.phoneNumber().phoneNumber();
		return phoneNumber;
	}
	
	public static String generateUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static String generateStreetAddress() {
		return faker.address().streetAddress();
	}
	
	public static String generateCity() {
		return faker.address().city();
	}
	
	public static String generatePinCode() {
		return faker.address().postcode();
	}
	

	public static String generatePhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	
}
