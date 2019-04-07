package com.cloudmusic.apibusiness;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.codehaus.groovy.antlr.treewalker.SourcePrinter;
import org.testng.Assert;

import static com.jayway.restassured.RestAssured.given;

public class VideoDetailBussiness {

    public void getVideoDetailBussiness(){
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "video/url";

        Response res = given()
                .header("access_token", LoginBusiness.getToken())
                .param("id", "89ADDE33C0AAE8EC14B99F6750DB954D")
                .when().log().all().get();

        // http响应码
        int resCode = res.statusCode();

        // 解析响应体
        JsonPath jsonPath = res.jsonPath();

        // 业务码
        int busCode = jsonPath.get("code");


        // 昵称
        String id = jsonPath.get("urls[0].id");

        // 断言
        Assert.assertEquals(resCode, 200, "http code reponse faild");
        Assert.assertEquals(busCode, 200, "video detail business code reponse faild");
        Assert.assertEquals(id, "89ADDE33C0AAE8EC14B99F6750DB954D", "id  incorrect");
    }
}
