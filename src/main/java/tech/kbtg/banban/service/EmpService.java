package tech.kbtg.banban.service;

import tech.kbtg.banban.entity.Employee;

import java.util.List;

public interface EmpService
{
    List<Employee> findAll();
    Employee save(Employee employee);
    Employee findById(Integer id);
    void deleteById(Integer id);
}

