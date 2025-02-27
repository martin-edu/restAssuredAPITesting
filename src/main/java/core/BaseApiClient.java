package core;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApiClient {
	
	protected RequestSpecification getRequestSpec() {
		
		 return RestAssured.given()
	                .baseUri(ConfigManager.getProperty("BASE_URL"))
	                .contentType(ContentType.JSON)
	                .log().all();
		
	}

}
