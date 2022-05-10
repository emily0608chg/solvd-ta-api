package apitodos;

import com.jayway.jsonpath.JsonPath;
import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.api.GetTodoMethod;
import com.solvd.api.PatchTodoMethod;
import com.solvd.api.PostTodoMethod;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class ApiTodosTest extends AbstractTest {

    // add logger,replace system
    @Test
    public void testGetTodos() {
        GetTodoMethod getTodoMeth = new GetTodoMethod();
        getTodoMeth.callAPI();
        //getTodoMeth.validateResponse();
        getTodoMeth.validateResponseAgainstSchema("api/todos/get/rs.schema");
    }

    @Test
    public void postTodosCreation() {
        PostTodoMethod postTodoM = new PostTodoMethod();
        Response response = postTodoM.callAPI();
        postTodoM.validateResponse();
    }

    @Test
    public void patchTodosTest() {
        PostTodoMethod postTodoMethod = new PostTodoMethod();
        Response postResponse = postTodoMethod.callAPIExpectSuccess();
        postTodoMethod.validateResponse();

        Integer id = JsonPath.read(postResponse.asString(), "$.id");
        String stringId = id.toString();
        System.out.println("Id: " + stringId);

        PatchTodoMethod patchPostMethod = new PatchTodoMethod(1);
        Response response = patchPostMethod.callAPIExpectSuccess();
        patchPostMethod.addProperty("id", id);
        patchPostMethod.callAPIExpectSuccess();
        patchPostMethod.validateResponse();


    }

}

