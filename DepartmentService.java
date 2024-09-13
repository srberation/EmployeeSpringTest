package com.ByshtSpringBoot.Bysht.Code.Service;

import com.ByshtSpringBoot.Bysht.Code.Entity.Department;
import com.ByshtSpringBoot.Bysht.Code.ErrorHandlers.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

   public Department getDepartment(Long id) throws DepartmentNotFoundException;

    public List<Department> getAllDepartment();

    public void deleteDepartmentById(Long id);

    public Department getDepartmentByName(String name) throws DepartmentNotFoundException;
}
