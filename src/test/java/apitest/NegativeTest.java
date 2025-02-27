package apitest;

import org.testng.Assert;
import org.testng.annotations.Test;

import domain.Post;
import io.restassured.response.Response;

public class NegativeTest extends TestBase {
	
	/**
	 * @Description This is a post test with non existed id  
	 */
	@Test
    public void getPostByIdWithNonExistedId()
    {
		System.out.println("Test negative thread number "+Thread.currentThread().getId());
    	Response response = postApiClient.getPostById(1000);
    	
    	Assert.assertEquals(response.getStatusCode(), 404);
    	Assert.assertNotNull(response, "{}");
    }
	
	/**
	 * @Description This is a get test with wrong parameter as an ID  
	 */
	@Test
	void getPostByIdWithWrongParameter()
	{
		Response response = postApiClient.getPostById("a");
		
		Assert.assertEquals(response.getStatusCode(), 404);
    	Assert.assertNotNull(response, "{}");
	}
	
	/**
	 * @Description This is a get test for comment with wrong parameter as an ID
	 */
	@Test
	void getCommentsByIdWithWrongParameter()
	{
		Response response = commentApiClient.getCommentsByPostId("a");
    	
    	Assert.assertEquals(response.getStatusCode(), 200);
    	Assert.assertNotNull(response, "[]");
	}
	
	/**
	 * @Description This is a get test for comment with wrong parameter as an ID inside URL
	 */
	@Test
	void getCommentsByIdWithWrongParameterInUrl()
	{
		//Post[] posts = get(url+"/posts/1/comments").as(Post[].class);
		Response response = commentApiClient.getCommentsByPostIdWithUrlParameter("a");
    	
    	Assert.assertEquals(response.getStatusCode(), 200);
    	Assert.assertNotNull(response, "{}");
	}
	
	

}
