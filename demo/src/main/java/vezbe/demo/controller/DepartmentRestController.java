package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import vezbe.demo.dto.DepartmentDto;
import vezbe.demo.model.Department;
import vezbe.demo.model.Employee;
import vezbe.demo.service.DepartmentService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentRestController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("api/department")
    public Optional<Department> getDepartment(HttpSession session){
        Employee loggedEmployee = (Employee) session.getAttribute("employee");
        List<Department> departmentList = departmentService.findAll();
        if(loggedEmployee != null){
           departmentList =  departmentService.findByEmployeeId(loggedEmployee.getId());
        }

        List<DepartmentDto> dtos = new ArrayList<>();
        for(Department department : departmentList){
        DepartmentDto dto = new DepartmentDto(department);
        dtos.add(dto);
        }


       /* Employee loggedEmployee = employeeService.login(loginDto.getUsername(), loginDto.getPassword());
        if (loggedEmployee == null)
            return new ResponseEntity<>("User does not exist!", HttpStatus.NOT_FOUND);

        session.setAttribute("employee", loggedEmployee);
        return ResponseEntity.ok("Successfully logged in!");*/
        return null;
    }
}
