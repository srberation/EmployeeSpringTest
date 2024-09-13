package com.ByshtSpringBoot.Bysht.Code.Repository;

import com.ByshtSpringBoot.Bysht.Code.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<Department> findByDepartmentName(String name);
}
