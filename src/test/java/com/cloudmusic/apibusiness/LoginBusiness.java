package com.cloudmusic.apibusiness;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.testng.Assert;

import javax.crypto.interfaces.PBEKey;
import java.lang.invoke.ConstantCallSite;

import static com.jayway.restassured.RestAssured.given;

public class LoginBusiness {
    public static String access_token = null;


    public void  loginBusiness() {
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "/login/cellphone";

        Response res = given()
                // .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")   // 标准请求头写法
                .contentType("application/x-www-form-urlencoded;charset=utf-8")
                .formParam("phone", "15010065540")
                .formParam("password", "qwe123654")
                .when().log().all().post();

        // http响应码
        int resCode = res.statusCode();
        access_token = res.cookie("MUSIC_U");

        // 解析响应体
        JsonPath jsonPath = res.jsonPath();

        // 业务码
        int busCode = jsonPath.get("code");


        // 昵称
        String nickName = jsonPath.get("profile.nickname");

        // 断言
        Assert.assertEquals(resCode, 200, "http code reponse faild");
        Assert.assertEquals(busCode, 200, "login business code reponse faild");
        Assert.assertEquals(nickName, "东郭先生与猫", "nickname  incorrect");
    }


    public static String getToken(){
        System.out.println("getToken = " + access_token);
        return access_token;

        //return (access_token != null) ? access_token : loginBusiness();
    }
}
