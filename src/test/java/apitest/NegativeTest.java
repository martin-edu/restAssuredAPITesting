package apitest;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class NegativeTest extends TestBase {
	
	/**
	 * @Description This is a post test with non existed id  
	 */
	@Test
    public void getPostByIdWithNonExistedId()
    {
    	Response response = postApiClient.getPostById(1000);   	
    	Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    	Assert.assertNotNull(response, "{}");
    }
	
	/**
	 * @Description This is a get test with wrong parameter as an ID  
	 */
	@Test
	void getPostByIdWithWrongParameter()
	{
		Response response = postApiClient.getPostById("a");
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    	Assert.assertNotNull(response, "{}");
	}
	
	/**
	 * @Description This is a get test for comment with wrong parameter as an ID
	 */
	@Test
	void getCommentsByIdWithWrongParameter()
	{
		Response response = commentApiClient.getCommentsByPostId("a");
    	Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    	Assert.assertNotNull(response, "[]");
	}
	
	/**
	 * @Description This is a get test for comment with wrong parameter as an ID inside URL
	 */
	@Test
	void getCommentsByIdWithWrongParameterInUrl()
	{
		Response response = commentApiClient.getCommentsByPostIdWithUrlParameter("a");
    	Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    	Assert.assertNotNull(response, "{}");
	}
}

