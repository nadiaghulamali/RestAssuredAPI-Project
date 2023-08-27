package tests;

import helpers.UserHelperService;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.testng.Assert.*;

public class TestDeleteUser {

    private static UserHelperService userHelperService;

    @BeforeClass

    public static void init() {
        userHelperService = new UserHelperService();
    }
    @Test

    public void testDeleteUser(){

         int  statusCode = userHelperService.deleteUser(3);
        assertEquals(statusCode, 200, "User deletion failed");

    }
}
