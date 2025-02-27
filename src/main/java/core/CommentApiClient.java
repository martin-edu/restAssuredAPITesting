package core;

import io.restassured.response.Response;

public class CommentApiClient extends BaseApiClient {

    public Response getCommentsByPostIdWithUrlParameter(int postId) {
        return getRequestSpec()
                .when()
                .get("/comments?postId=" + postId)
                .then()
                .extract().response();
    }
    
    public Response getCommentsByPostIdWithUrlParameter(String postId) {
        return getRequestSpec()
                .when()
                .get("/comments?postId=" + postId)
                .then()
                .extract().response();
    }
    
    public Response getCommentsByPostId(int postId) {
        return getRequestSpec()
                .when()
                .get("/posts/" + postId + "/comments")
                .then()
                .extract().response();
    }
    
    public Response getCommentsByPostId(String postId) {
        return getRequestSpec()
                .when()
                .get("/posts/" + postId + "/comments")
                .then()
                .extract().response();
    }
}
