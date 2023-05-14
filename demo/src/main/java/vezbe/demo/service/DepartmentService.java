package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vezbe.demo.model.Department;
import vezbe.demo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department findOne(Long id){
        Optional<Department> foundDepartment = departmentRepository.findById(id);
        if (foundDepartment.isPresent())
            return foundDepartment.get();

        return null;
    }
    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public List<Department> findByEmployeeId(Long employeeId) {
        Optional<Department> foundDepartment = departmentRepository.findById(employeeId);
        if (foundDepartment.isPresent())
            return departmentRepository.findByEmployees(employeeId);
        return null;
    }

    }

