package core;


import java.util.HashMap;

import domain.Post;
import io.restassured.response.Response;

public class PostApiClient extends BaseApiClient {
	   
	public Response getAllPosts() {
	        return getRequestSpec()
	                .when()
	                .get("/posts")
	                .then()
	                .extract().response();
	    }

	    public Response getPostById(int id) {
	        return getRequestSpec()
	                .when()
	                .get("/posts/" + id)
	                .then()
	                .extract().response();
	    }
	    
	    public Response getPostById(String id) {
	        return getRequestSpec()
	                .when()
	                .get("/posts/" + id)
	                .then()
	                .extract().response();
	    }

	    public Response getCommentsForPost(int id) {
	        return getRequestSpec()
	                .when()
	                .get("/posts/" + id + "/comments")
	                .then()
	                .extract().response();
	    }

	    public Response createPost(Post post) {
	        return getRequestSpec()
	                .body(post)
	                .when()
	                .post("/posts")
	                .then()
	                .extract().response();
	    }

	    public Response updatePost(int id, Post post) {
	        return getRequestSpec()
	                .body(post)
	                .when()
	                .put("/posts/" + id)
	                .then()
	                .extract().response();
	    }

	    public Response patchPost(int id, HashMap<String, String> post) {
	        return getRequestSpec()
	                .body(post)
	                .when()
	                .patch("/posts/" + id)
	                .then()
	                .extract().response();
	    }

	    public Response deletePost(int id) {
	        return getRequestSpec()
	                .when()
	                .delete("/posts/" + id)
	                .then()
	                .extract().response();
	    }
}
