package tests;

import helpers.UserHelperService;
import model.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class TestPostUser {

    private static UserHelperService userHelperService;

    @BeforeClass

    public static void init() {
        userHelperService = new UserHelperService();
    }
    @Test

    public void testCreateUser(){

       String id = userHelperService.createUser().jsonPath().getString("id");
       assertNotNull(id,"User is not Created");
    }
}
