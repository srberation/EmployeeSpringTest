package com.ByshtSpringBoot.Bysht.Code.Service;

import com.ByshtSpringBoot.Bysht.Code.Entity.Department;
import com.ByshtSpringBoot.Bysht.Code.ErrorHandlers.DepartmentNotFoundException;
import com.ByshtSpringBoot.Bysht.Code.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;



    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()){
            try {
                throw new DepartmentNotFoundException();
            } catch (DepartmentNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return department.get();
    }

    @Override
    public List<Department> getAllDepartment() {

        return departmentRepository.findAll();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department getDepartmentByName(String name) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findByDepartmentName(name);
        if(department.isPresent()){
            return department.get();
        }
        else{
            throw new DepartmentNotFoundException("Department not found");
        }
    }

}
