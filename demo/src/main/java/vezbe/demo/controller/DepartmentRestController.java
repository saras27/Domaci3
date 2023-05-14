package vezbe.demo.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.DepartmentDto;
import vezbe.demo.model.Company;
import vezbe.demo.model.Department;
import vezbe.demo.model.Employee;
import vezbe.demo.service.DepartmentService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/api/department")
    public ResponseEntity<DepartmentDto> getDepartment(HttpSession session){
      
        Employee loggedEmployee = (Employee) session.getAttribute("employee");
        if(loggedEmployee == null) {
            System.out.println("Nema sesije");
        } else {
            Department department = departmentService.findOne(loggedEmployee.getDepartment().getId());
            if(department == null) {
                System.out.println("Departman nije pronadjen");
            }else {
                DepartmentDto responseDepartment = new DepartmentDto(department);
                return ResponseEntity.ok(responseDepartment);
            }
        }

        return null;
    }
}
