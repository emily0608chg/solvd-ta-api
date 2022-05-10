package pojotests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import pojo.CompanyDetails;
import pojo.CompanyPFDetails;
import pojo.Contractors;
import pojo.EntityJson;

import java.util.ArrayList;
import java.util.List;

public class CreateNestedJsonFromPojo {

    @Test
    public void generatePojoDat() throws JsonProcessingException {

        CompanyDetails nestedPojo = new CompanyDetails();
        nestedPojo.setCompanyName("Ems Company");
        nestedPojo.setCompanyHOCity("Buenos Aires");
        nestedPojo.setCompanyCEO("Emily Ch");

        List<String> supportedSalaryBanks = new ArrayList<>();
        supportedSalaryBanks.add("HDFC");
        supportedSalaryBanks.add("ICICI");
        supportedSalaryBanks.add("AXIS");
        nestedPojo.setSupportedSalaryBanks(supportedSalaryBanks);

        List<Integer> pinCodesOfCityOffice = new ArrayList<>();
        pinCodesOfCityOffice.add(560037);
        pinCodesOfCityOffice.add(360034);
        pinCodesOfCityOffice.add(450453);
        nestedPojo.setPinCodesOfCityOffice(pinCodesOfCityOffice);

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

        List<EntityJson> allEmployees = new ArrayList<EntityJson>();
        allEmployees.add(emily);
        allEmployees.add(dafne);
        allEmployees.add(ariana);
        nestedPojo.setEmployee(allEmployees);

        Contractors salome = new Contractors();
        salome.setFirstName("Salome");
        salome.setLastName("Mantilla");
        salome.setContractFrom("May-2022");
        salome.setContractTo("May-2028");

        Contractors gaby = new Contractors();
        gaby.setFirstName("Gaby");
        gaby.setLastName("Guerrero");
        gaby.setContractFrom("Oct-2022");
        gaby.setContractTo("Oct-2028");

        List<Contractors> contractors = new ArrayList<>();
        contractors.add(salome);
        contractors.add(gaby);
        nestedPojo.setContractors(contractors);

        CompanyPFDetails companyPFDetails = new CompanyPFDetails();
        companyPFDetails.setPfName("ABC");
        companyPFDetails.setPfYear("2020");
        companyPFDetails.setPfCity("Buenos Aires");
        companyPFDetails.setNoOfEmployees(20);
        nestedPojo.setCompanyPFDetails(companyPFDetails);

        ObjectMapper objectMapper = new ObjectMapper();
        String nestedPayLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(nestedPojo);
        System.out.println(nestedPayLoad);




    }
}
