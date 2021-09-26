package pages;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefs.ApiStepDefs;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

/*
Muneera Shaik
Methods created using rest Assured to get data and validated using jsonpath and stream
 */

public class restApiTest {

    final Logger logger = LoggerFactory.getLogger(restApiTest.class);
    public HashSet<Boolean> flagList=new HashSet<>();
    public Response response;
    public List<String>  l1;
    List<HashMap<Object, Object>> jsonResponse;

    public void getRequest() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = "https://pro-api.coinmarketcap.com/v1";
        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", "2e633c5b-63b6-437a-9b4a-8c9b37ed5e97")
//                .param("postId", "2")
                .when()
                .get("/cryptocurrency/map")
                .then()
                .extract().response();
    }

    public void retrieveJsonResponse(String cur1,String cur2,String cur3) {
        Assertions.assertEquals(200, response.statusCode());
        jsonResponse = response.jsonPath().getList("data");
        System.out.println(jsonResponse.size());
        l1 = jsonResponse.stream().filter(s->
                s.get("name").toString().equals(cur1) || s.get("name").toString().equals(cur2)
                        || s.get("name").toString().equals(cur3)
        ).map(s->s.get("id").toString()).collect(Collectors.toList());
        l1.forEach(e -> System.out.println("id : "+e));
    }

    public void convertIdsToBoli(String convert) {
        List<String> l2 = l1.stream().map(s -> {
                    return given()
                            .contentType(ContentType.JSON)
                            .header("X-CMC_PRO_API_KEY", "2e633c5b-63b6-437a-9b4a-8c9b37ed5e97")
                            .param("amount", "1")
                            .param("convert", convert)
                            .param("id", s)
                            .when()
                            .get("/tools/price-conversion")
                            .then()
                            .extract().response().jsonPath().get("data.quote.BOLI.price").toString();
                }
        ).collect(Collectors.toList());
        l2.forEach(e -> System.out.println("converted BOLI prices : "+e));
        Assertions.assertEquals(200, response.statusCode());

    }


    public void getRequestForGivenId(String ID) {

        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", "2e633c5b-63b6-437a-9b4a-8c9b37ed5e97")
                .param("id", ID)
                .when()
                .get("/cryptocurrency/info")
                .then()
                .extract().response();
        logger.info(response.jsonPath().get("data.1027.urls.website").toString());
        List<Object> ll = response.jsonPath().get("data.1027.urls.website");
        Assertions.assertTrue(ll.size()>0);
    }
    public void valiateJsonResponseforID(String val1,String val2,String val3,String val4,String val5) {
        Assertions.assertEquals(val1, response.jsonPath().get("data.1027.logo").toString());
        Assertions.assertEquals(val2, response.jsonPath().getList("data.1027.urls.technical_doc").get(0).toString());
        System.out.println(response.jsonPath().get("data.1027.urls.technical_doc").toString());
        Assertions.assertEquals(val3, response.jsonPath().get("data.1027.symbol").toString());
        Assertions.assertEquals(val4, response.jsonPath().get("data.1027.date_added").toString());
        Assertions.assertTrue(
                response.jsonPath().getList("data.1027.tags").contains(val5));
        Assertions.assertEquals(200, response.statusCode());
    }

    public void getFirstTenCryptoCurrencies(){
        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", "2e633c5b-63b6-437a-9b4a-8c9b37ed5e97")
                .param("id", "1,2,3,4,5,6,7,8,9,10")
                .when()
                .get("/cryptocurrency/info")
                .then()
                .extract().response();
        Assertions.assertEquals(200, response.statusCode());
        Map<Object,HashMap<Object,Object>> jResponse = response.jsonPath().getMap("data");
        List<Object> newL = new ArrayList<>();
        jResponse.forEach(
                (i,j)->{
                    if(j.get("tags").toString().contains("mineable"))
                        System.out.println(j.get("name")+" tag: "+j.get("tags"));
                    newL.add(j.get("name"));
                }
        );

        for (Map.Entry<Object,HashMap<Object,Object>> entry : jResponse.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().get("tags")+ ":" + entry.getValue().get("name"));
            if(newL.contains(entry.getValue().get("name").toString())){
                flagList.add(true);
            }else{
                flagList.add(false);
            }
        }
    }

    public void cryptocurrencyValidation(){
        Boolean flag = true;
        if(flagList.contains(false)){
            flag=false;
        }
        Assertions.assertTrue(flag);
    }
}
