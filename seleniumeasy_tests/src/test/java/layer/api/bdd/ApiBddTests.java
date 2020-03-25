package layer.api.bdd;

import com.myserver.api.entities.*;
import data.generator.Email;
import data.generator.Name;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.restassured.http.ContentType;

import org.apache.log4j.*;

import java.io.File;
import java.util.*;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class ApiBddTests {
    private static Logger logger;
    private static Response response;

    private static String URI = "http://localhost:9876";
    private static String firstUserURI;
    private static String lastUserURI;
    private static User user;
    private static String failedMessage;

    @BeforeClass
    public void setup(){
        logger = Logger.getLogger("ApiBddTests.class");
        PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" +
                File.separator + "resources"+ File.separator +"log4j.properties");
        logger.setLevel(Level.ERROR);
        logger.info("=== BE Starts tests ===");
    }

    @Test(priority = 1)
    public void verifyRootGet(){
        logger.info("*** Started Root_Get Test ***");
        request("get",URI,null);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);
        checkResponseBodyWithJsonSchema(Root.getRootGetSchema());

        logger.info("* Checking some values of the Response Body *");
        String usersHref = response.jsonPath().get("_links.users.href");
        logger.info("Users href value is: " + usersHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/users", usersHref);
        String profileHref = response.jsonPath().get("_links.profile.href");
        logger.info("Profile href value is: " + profileHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/profile", profileHref);

        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);
        logger.info("*** Finished Root_Get Test ***");
    }

    @Test(priority = 2)
    public void verifyUsersGet(){
        logger.info("*** Started Users_Get Test ***");
        request("get",URI + "/users",null);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);
        checkResponseBodyWithJsonSchema(User.getUsersGetSchema());

        logger.info("* Checking some values of the Response Body *");
        String usersHref = response.jsonPath().get("_links.self.href");
        logger.info("Users href value is: " + usersHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/users", usersHref);
        String profileHref = response.jsonPath().get("_links.profile.href");
        logger.info("Profile href value is: " + profileHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/profile/users", profileHref);

        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);

        firstUserURI = response.jsonPath().get("_embedded.users[0]._links.self.href");
        logger.info("*** Finished Users_Get Test ***");
    }

    @Test(priority = 3)
    public void verifyUsersIdGet(){
        logger.info("*** Started Users_id_Get Test ***");
        request("get",firstUserURI,null);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);
        checkResponseBodyWithJsonSchema(User.getUsersIdGetSchema());

        logger.info("* Checking some values of the Response Body *");
        String usersHref = response.jsonPath().get("_links.self.href");
        logger.info("Users href value is: " + usersHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/users/1", usersHref);
        String profileHref = response.jsonPath().get("_links.user.href");
        logger.info("Profile href value is: " + profileHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/users/1", profileHref);

        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);

        logger.info("*** Finished Users_id_Get Test ***");
    }

    @Test(priority = 4)
    public void verifyUsersPost(){
        Random age = new Random();
        user = new User(Name.firstName(),
                Name.lastName(),
                age.nextInt(100),
                Name.firstName() + "." + Name.lastName(),
                Name.firstName() + age.nextInt(100) + Name.lastName(),
                Email.email(Name.firstName() + age.nextInt(100) + Name.lastName()));

        logger.info("*** Started Users_Post Test ***");
        request("post",URI + "/users",user);

        checkResponseStatusCode(201);
        checkResponseStatusLine(201);
        checkResponseBodyWithJsonSchema(User.getUsersIdGetSchema());
        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);

        lastUserURI = response.jsonPath().get("_links.self.href");
        logger.info("*** Finished Users_Post Test ***");
    }

    @Test(priority = 5)
    public void verifyUsersPostUsersIdGet(){
        logger.info("*** Started Users_Post_Users_id_Get Test ***");
        request("get", lastUserURI, null);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);

        logger.info("* Checking Response Body fields values from the last Post request *");
        String responseBody = response.getBody().asString();
        logger.info("Response Body is: " + responseBody);

        String userFirstName = response.jsonPath().get("firstName");
        failedMessage = "Test failed on post body values!";
        assertEquals(user.getFirstName(), userFirstName);

        String userLastName = response.jsonPath().get("lastName");
        failedMessage = "Test failed on post body values!";
        assertEquals(user.getLastName(), userLastName);

        int userAge = response.jsonPath().get("age");
        failedMessage = "Test failed on post body values!";
        assertEquals((int) user.getAge(), userAge);

        String userName = response.jsonPath().get("userName");
        failedMessage = "Test failed on post body values!";
        assertEquals(user.getUserName(), userName);

        String userPass = response.jsonPath().get("userPass");
        failedMessage = "Test failed on post body values!";
        assertEquals(user.getUserPass(), userPass);

        String userEmail = response.jsonPath().get("email");
        failedMessage = "Test failed on post body values!";
        assertEquals(user.getEmail(), userEmail);

        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);

        logger.info("*** Finished Users_Post_Users_id_Get Test ***");
    }

    @Test(priority = 6)
    public void verifyUsersIdPut(){
        user.setFirstName("George");
        logger.info("*** Started Users_id_Put Test ***");
        request("put",lastUserURI,user);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);
        checkResponseBodyWithJsonSchema(User.getUsersIdGetSchema());
        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);

        logger.info("*** Finished Users_id_Put Test ***");
    }

    @Test(priority = 7)
    public void verifyUsersIdPutUsersIdGet(){
        logger.info("*** Started Users_id_Put_Users_id_Get Test ***");
        request("get", lastUserURI, null);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);

        String userFirstName = response.jsonPath().get("firstName");
        failedMessage = "Test failed on put body values!";
        assertEquals(user.getFirstName(), userFirstName);

        String userLastName = response.jsonPath().get("lastName");
        failedMessage = "Test failed on put body values!";
        assertEquals(user.getLastName(), userLastName);

        int userAge = response.jsonPath().get("age");
        failedMessage = "Test failed on put body values!";
        assertEquals((int) user.getAge(), userAge);

        String userName = response.jsonPath().get("userName");
        failedMessage = "Test failed on put body values!";
        assertEquals(user.getUserName(), userName);

        String userPass = response.jsonPath().get("userPass");
        failedMessage = "Test failed on put body values!";
        assertEquals(user.getUserPass(), userPass);

        String userEmail = response.jsonPath().get("email");
        failedMessage = "Test failed on put body values!";
        assertEquals(user.getEmail(), userEmail);

        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);

        logger.info("*** Finished Users_id_Put_Users_id_Get Test ***");
    }

    @Test(priority = 8)
    public void verifyUsersIdDelete(){
        logger.info("*** Started Users_id_Delete Test ***");
        request("delete", lastUserURI, null);

        checkResponseStatusCode(204);
        checkResponseStatusLine(204);
        logResponseHeader();
        checkingResponseTime(2000);

        logger.info("*** Finished Users_id_Delete Test ***");
    }

    @Test(priority = 9)
    public void verifyUsersIdDeleteUsersIdGet(){
        logger.info("*** Started Users_id_Delete_Users_id_Get Test ***");
        request("get",lastUserURI,null);

        checkResponseStatusCode(404);
        checkResponseStatusLine(404);
        logResponseHeader();
        checkingResponseTime(2000);

        logger.info("*** Finished Users_id_Delete Test ***");
    }

    @Test(priority = 10)
    public void verifyProfileGet(){
        logger.info("*** Started Profile_Get Test ***");
        request("get", URI + "/profile",null);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);
        checkResponseBodyWithJsonSchema(Profile.getProfileGetSchema());

        logger.info("* Checking some values of the Response Body *");
        String usersHref = response.jsonPath().get("_links.self.href");
        logger.info("Users href value is: " + usersHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/profile", usersHref);
        String profileHref = response.jsonPath().get("_links.users.href");
        logger.info("Profile href value is: " + profileHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/profile/users", profileHref);

        logResponseHeader();
        checkingResponseHeaderContentType("application/hal+json");
        checkingResponseTime(2000);
        logger.info("*** Finished Profile_Get Test ***");
    }

    @Test(priority = 11)
    public void verifyProfileUsersGet(){
        logger.info("*** Started Profile_Users_Get Test ***");
        request("get", URI + "/profile/users", null);

        checkResponseStatusCode(200);
        checkResponseStatusLine(200);
        checkResponseBodyWithJsonSchema(Profile.getProfileUsersGetSchema());

        logger.info("* Checking some values of the Response Body *");
        String usersHref = response.jsonPath().get("alps.descriptor[0].href");
        logger.info("Users href value is: " + usersHref);
        failedMessage = "Test failed on body values!";
        assertEquals("http://localhost:9876/profile/users", usersHref);

        logResponseHeader();
        checkingResponseHeaderContentType("application/alps+json");
        checkingResponseTime(2000);

        logger.info("*** Finished Profile_Users_Get Test ***");
    }

    @Test(priority = 12)
    public void verifyProfileUsersOptions(){
        logger.info("*** Started Profile_Users_Options Test ***");
        request("options",URI + "/profile/users",null);

        checkResponseStatusCode(406);
        checkResponseStatusLine(406);
        checkResponseBodyWithJsonSchema(Profile.getProfileUsersOptionsSchema());

        logger.info("* Checking some values of the Response Body *");
        String message = response.jsonPath().get("message");
        logger.info("Users href value is: " + message);
        failedMessage = "Test failed on body values!";
        assertEquals("Could not find acceptable representation", message);

        logResponseHeader();
        checkingResponseHeaderContentType("application/json");
        checkingResponseTime(2000);

        logger.info("*** Finished Profile_Users_Options Test ***");
    }

    @Test(priority = 13, dataProvider="getUsers")
    public void verifyUsers(String user, String errorMessage){
        logger.info("*** Started Users Test ***");

        failedMessage = errorMessage;
        assertThat(user, JsonSchemaValidator.matchesJsonSchema(User.getUsersGetArraySchema()));

        logger.info("*** Finished Users Test ***");
    }

    @DataProvider(name="getUsers")
    public Object[][] getUsers(){
        request("get",URI + "/users",null);
        ArrayList<LinkedHashMap<String,Object>> users = response.jsonPath().get("_embedded.users");

        String [][] jsonString = new String[users.size()][2];
        int count = 0;
        for (LinkedHashMap<String, Object> user : users) {
            String userPath = response.jsonPath().get("_embedded.users" + "[" + count + "]._links.self.href");
            jsonString[count][0] = new JSONObject(user).toString();
            jsonString[count][1] = "Test failed on json schema validator for this " + userPath + " user route conforms to schema!";
            count++;
        }
        return jsonString;
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS != result.getStatus()) {
            logger.error("Test: " + result.getName() + " method is with status FAILED! " + failedMessage);
        }
    }

    public static void checkResponseStatusCode(int expectedCode){
        logger.info("* Checking Response Status code *");
        int statusCode = response.getStatusCode();
        logger.info("Status code is: "+ statusCode);
        failedMessage = "Test failed on status code!";
        assertEquals(expectedCode, statusCode);
    }

    public static void checkResponseStatusLine(int expectedLine){
        logger.info("* Checking Response Status line *");
        String statusLine = response.getStatusLine();
        logger.info("Status line is: " + statusLine);
        failedMessage = "Test failed on status line!";
        assertEquals("HTTP/1.1 " + expectedLine, statusLine.trim());
    }

    public static void checkResponseBodyWithJsonSchema(String jsonSchema){
        logger.info("* Checking Response Body with json schema *");
        String responseBody = response.getBody().asString();
        logger.info("Response Body is: " + responseBody);
        failedMessage = "Test failed on json schema validator!";
        assertThat(responseBody, JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    public static void logResponseHeader(){
        logger.info("* Logging Response Header *");
        Headers responseHeader = response.headers();
        logger.info("Response Header is: ");
        for(Header header: responseHeader){
            logger.info(header.getName()+ ": " + header.getValue());
        }
    }

    public static void checkingResponseHeaderContentType(String expectedContentType){
        logger.info("* Checking Content Type *");
        String contentType = response.header("Content-Type");
        logger.info("Content type is: " + contentType);
        failedMessage = "Test failed on content type!";
        assertEquals(expectedContentType, contentType);
    }

    public static void checkingResponseTime(long expectedTime){
        logger.info("* Checking Response Time *");
        long responseTime = response.getTime();
        logger.info("Response time is: " + responseTime);
        failedMessage = "Test failed on response time!";
        assertTrue(responseTime < expectedTime);
    }

    public static void request(String methodRequest,
                               String routeRequest,
                               Object payloadRequest) {
        if (methodRequest.equalsIgnoreCase("get")) {
            response =
                    given().
                            contentType(ContentType.JSON).
                    when().
                            get(routeRequest).
                    then().
                            extract().response();
        } else if (methodRequest.equalsIgnoreCase("post")) {
            response =
                    given().
                            contentType(ContentType.JSON).
                            body(payloadRequest).
                    when().
                            post(routeRequest).
                    then().
                            extract().response();
        } else if (methodRequest.equalsIgnoreCase("put")) {
            response =
                    given().
                            contentType(ContentType.JSON).
                            body(payloadRequest).
                    when().
                            put(routeRequest).
                    then().
                            extract().response();
        } else if (methodRequest.equalsIgnoreCase("delete")) {
            response =
                    given().
                            contentType(ContentType.JSON).
                    when().
                            delete(routeRequest).
                    then().
                            extract().response();
        } else if (methodRequest.equalsIgnoreCase("options")) {
            response =
                    given().
                            contentType(ContentType.JSON).
                    when().
                            options(routeRequest).
                    then().
                            extract().response();
        }
    }

    @AfterClass
    public void end() {
        logger.info("=== BE tests end ===");
    }
}
