package tests;

import helpers.UserHelperService;
import model.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TestPatchUser {
    private static UserHelperService userHelperService;

    @BeforeClass

    public static void init() {
        userHelperService = new UserHelperService();
    }
    @Test

    public void testPatchUser(){

        String name = userHelperService.updateUser(6).jsonPath().getString("name");
        assertEquals(name,"rayler lum");
    }
}
