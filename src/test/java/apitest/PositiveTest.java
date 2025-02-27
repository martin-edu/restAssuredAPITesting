package apitest;

import domain.Post;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class PositiveTest extends TestBase {
	
	/**
	 * @Description This is a get test for all post 
	 */
    @Test
    public void testGetAllPosts() {
    	System.out.println("Test positive thread number "+Thread.currentThread().getId());
        Response response = postApiClient.getAllPosts();
        //Post targetObject = new Gson().fromJson(response.body, Post.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response, "The response is null");
    }
    
    /**
	 * @Description This is a get test by ID for post resource
	 */
    @Test
    public void getPostById()
    {
    	Response response = postApiClient.getPostById(1);
    	Post post = response.as(Post.class);
    	
    	Assert.assertEquals(post.getId(), 1);
    	Assert.assertEquals(response.getStatusCode(), 200);
    	Assert.assertNotNull(response, "The response is null");
    	Assert.assertEquals(post.getBody(), "quia et suscipit\nsuscipit "
    			+ "recusandae consequuntur expedita et cum\nreprehenderit "
    			+ "molestiae ut ut quas totam\nnostrum rerum est autem sunt "
    			+ "rem eveniet architecto");
    }
    
    /**
	 * @Description This is a get test by ID for comment
	 */
    @Test
    public void getElementCommentsById()
	{
		//Post[] posts = get(url+"/posts/1/comments").as(Post[].class);
    	Response response = commentApiClient.getCommentsByPostId(1);
    	Assert.assertEquals(response.getStatusCode(), 200);
    	Assert.assertNotNull(response, "The response is null");
			
	}
    
    /**
	 * @Description This is a get test by ID for comments, parameter inside URL
	 */
    @Test
    public void getElementCommentsByIdWhitUrlParameter()
	{
    	Response response = commentApiClient.getCommentsByPostIdWithUrlParameter(1);
    	Assert.assertEquals(response.getStatusCode(), 200);
    	Assert.assertNotNull(response, "The response is null");
			
	}
    
    /**
	 * @Description This is a post test for create a new Post
	 */
    @Test
    public void testCreatePost() {
        Post newPost = new Post(1, 1,  "New Title", "New Body");
        Response response = postApiClient.createPost(newPost);
        Post postResponse = response.as(Post.class);
        
        Assert.assertEquals(response.getStatusCode(), 201);
    	Assert.assertNotNull(response, "The response is null");
    	Assert.assertEquals(postResponse.getUserId(), newPost.getUserId());
    	Assert.assertEquals(postResponse.getTitle(), newPost.getTitle());
    	Assert.assertEquals(postResponse.getBody(), newPost.getBody());
    	Assert.assertEquals(postResponse.getId(), 101);
    }
    
    /**
	 * @Description This is a put test for update a new Post
	 */
    @Test
	void putAPostById()
	{
        Post newPost = new Post(1, 1,  "New Title", "New Body");
    	
    	Response response = postApiClient.updatePost(1, newPost);
    	Post postResponse = response.as(Post.class);
    	 
    	Assert.assertEquals(response.getStatusCode(), 200);
     	Assert.assertNotNull(response, "The response is null");
        Assert.assertEquals(postResponse.getUserId(), newPost.getUserId());
     	Assert.assertEquals(postResponse.getTitle(), newPost.getTitle());
     	Assert.assertEquals(postResponse.getBody(), newPost.getBody());
     	Assert.assertEquals(postResponse.getId(), 1);
	}
    
    /**
	 * @Description This is a patch test for patch a new Post
	 */
    @Test
	void patchAPostById()
	{
		HashMap post = new HashMap();
		
		post.put("userId", "1");
		post.put("title", "Updating api element");
		
		Response response = postApiClient.patchPost(1, post);
		Post postResponse = response.as(Post.class);
		
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
     	Assert.assertNotNull(response, "The response is null");
        Assert.assertEquals(postResponse.getUserId(), 1);
     	Assert.assertEquals(postResponse.getTitle(), "Updating api element");
	}
    
    /**
	 * @Description This is a delete test by id
	 */
    @Test
    public void testDeletePost() {
        Response response = postApiClient.deletePost(1);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(response, "The response is null");
        Assert.assertNotNull(response, "{}");
        
    }
}
