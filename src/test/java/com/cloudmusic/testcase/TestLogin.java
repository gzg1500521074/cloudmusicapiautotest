package com.cloudmusic.testcase;

import com.cloudmusic.apibusiness.LoginBusiness;
import org.testng.annotations.Test;

public class TestLogin {
    LoginBusiness login = new LoginBusiness();

    @Test
    public void testLogin(){
        login.loginBusiness();
    }
}
