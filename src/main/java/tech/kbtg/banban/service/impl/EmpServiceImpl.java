package tech.kbtg.banban.service.impl;

import org.springframework.stereotype.Service;
import tech.kbtg.banban.entity.Employee;
import tech.kbtg.banban.repository.EmployeeRepository;
import tech.kbtg.banban.service.EmpService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {
    private EmployeeRepository employeeRepository;

    public EmpServiceImpl(EmployeeRepository employeeDAO )
    {
        this.employeeRepository = employeeDAO;
    }

    @Override
    public List<Employee> findAll()
    {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save( Employee employee )
    {
        return employeeRepository.save( employee );
    }

    @Override
    public Employee findById( Integer id )
    {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }
        else {
            throw new RuntimeException("Didn't find Employee ID - " + id );
        }
    }

    @Override
    public void deleteById( Integer id )
    {
        employeeRepository.deleteById( id );
    }
}
