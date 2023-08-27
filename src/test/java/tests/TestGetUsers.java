package tests;

import helpers.UserHelperService;
import model.User;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TestGetUsers {

    private static UserHelperService userHelperService;

    @BeforeClass

    public static void init() {
        userHelperService = new UserHelperService();
    }
    @Test

    public void testGetAllUsers(){

        List<User> userList = userHelperService.getAllUsers();
        assertNotNull(userList,"Users list is empty");
        assertFalse(userList.isEmpty(),"Users list is not empty");
    }
}
