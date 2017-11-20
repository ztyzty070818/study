package jackson;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class DeserializationExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //禁止未知属性打断反序列化
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Company company = mapper.readValue(new File("src/main/java/jackson/company_back.json"),Company.class);
        System.out.println("company_name:"+company.getName()+"\t");
        System.out.print("headquarters:"+company.getHeadquarters()+"\t");
        System.out.println("birthDate:"+company.getBirthday()); //birthDate被标记为@JsonIgnore，所以此处得到的值应该为null

        Department[] departments = company.getDepartments();

        for (Department department : departments) {
            System.out.print("department_name:" + department.getName()+"\t");
            System.out.print("employee_number:" + department.getProjectManager()+"\t");
            //Department中未定义的字段product,employee_number
            System.out.print("product:"+department.get("product")+"\t");
            System.out.println("projectManager:"+department.get("employee_number"));
        }
    }
}
