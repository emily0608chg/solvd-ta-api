package pojotests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.EntityJson;
import java.util.ArrayList;
import java.util.List;

public class JsonArraySerialization {

    public String completeJson;

    @Test
    public void createJsonArrayFromPojo() throws JsonProcessingException {

        EntityJson emily = new EntityJson();
        emily.setName("emily");
        emily.setLastName("chacon");
        emily.setGender("female");
        emily.setAge(31);
        emily.setSalary(99999999);

        EntityJson dafne = new EntityJson();
        dafne.setName("dafne");
        dafne.setLastName("Pra");
        dafne.setGender("female");
        dafne.setAge(30);
        dafne.setSalary(19999999);

        EntityJson ariana = new EntityJson();
        ariana.setName("ariana");
        ariana.setLastName("chacon");
        ariana.setGender("female");
        ariana.setAge(28);
        ariana.setSalary(19999888);

        ArrayList<EntityJson> allEmployees = new ArrayList<EntityJson>();
        allEmployees.add(emily);
        allEmployees.add(dafne);
        allEmployees.add(ariana);

        ObjectMapper objectMapper = new ObjectMapper();
        completeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(allEmployees);
        System.out.println(completeJson);

    }

    @Test
    public void getPojoFromObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<EntityJson> allEmployees = objectMapper.readValue(completeJson, new TypeReference<List<EntityJson>>() {
        });

        for (EntityJson employee: allEmployees) {
            System.out.println("===========================================");
            System.out.println("First Name : " + employee.getName());
            System.out.println("Last Name : " + employee.getLastName());
            System.out.println("Age of employee : " + employee.getAge());
            System.out.println("Gender : " + employee.getGender());
            System.out.println("Salary : " + employee.getSalary());
            System.out.println("===========================================");
        }
    }
}
