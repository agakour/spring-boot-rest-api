package com.crudproject.springboot.cruddemo.dao;

import com.crudproject.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

    // define field for EntityManager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        return (entityManager.createQuery("from Employee", Employee.class)).getResultList();
    }

    @Override
    public Employee findById(int theId) {
         return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Employee employee = findById(theId);
        if(employee != null){
            entityManager.remove(employee);
        }
    }


}
