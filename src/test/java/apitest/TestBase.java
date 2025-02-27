package apitest;

import core.CommentApiClient;
import core.PostApiClient;
import org.testng.annotations.BeforeClass;


public class TestBase {
    protected PostApiClient postApiClient;
    protected CommentApiClient commentApiClient;

    @BeforeClass
    public void setup() {
        postApiClient = new PostApiClient();
        commentApiClient = new CommentApiClient();
    }
}
