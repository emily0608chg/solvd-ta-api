package pojotests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.EntityJson;

public class DataSerializeAndDeserialize {

    @Test
    public void createDataFromPojo() throws JsonProcessingException {
        EntityJson employee = new EntityJson();

        employee.setName("Andrea");
        employee.setLastName("Guerrero");
        employee.setGender("female");
        employee.setAge(31);
        employee.setSalary(800000);


        // Converting a Java class object to a JSON payload as String
        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(employeeJson);
    }

    @Test
    public void getPojoFromObject() throws JsonProcessingException {
        EntityJson employee = new EntityJson();

        employee.setName("Salome");
        employee.setLastName("Chacon");
        employee.setGender("female");
        employee.setAge(25);
        employee.setSalary(900000);

        // Converting a Java class object to a JSON payload as String
        ObjectMapper objectMapper = new ObjectMapper();
        String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        System.out.println(employeeJson);

        //Converting json string to class object
        EntityJson employeeObj = objectMapper.readValue(employeeJson, EntityJson.class);
        System.out.println("Name: " + employeeObj.getName());
        System.out.println("Last Name: " + employeeObj.getLastName());
        System.out.println("Gender: " + employeeObj.getGender());
        System.out.println("Age: " + employeeObj.getSalary());

    }

}

