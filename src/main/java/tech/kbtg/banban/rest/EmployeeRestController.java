package tech.kbtg.banban.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import tech.kbtg.banban.entity.Employee;
import tech.kbtg.banban.service.EmpService;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmpService employeeService;

    public EmployeeRestController( EmpService employeeService )
    {
        this.employeeService = employeeService;
    }

    @GetMapping ( "/employees" )
    public List < Employee > findAll()
    {
        return employeeService.findAll();
    }

    @GetMapping ( "/employees/{employeeId}" )
    public Employee getEmployeeById( @PathVariable int employeeId )
    {
        Employee employee = employeeService.findById( employeeId );

        if ( employee == null )
        {
            throw new RuntimeException( "Employee id not found - " + employeeId );
        }

        return employee;
    }

    @PostMapping( "/employees" )
    public Employee addEmployee( @RequestBody Employee employee )
    {
        employee.setId( 0 );

        Employee newEmployee = employeeService.save( employee );

        return newEmployee;
    }

    @DeleteMapping ( "employees/{employeeId}" )
    public String deleteEmployeeId( @PathVariable int employeeId )
    {
        Employee employee = employeeService.findById( employeeId );

        if ( employee == null )
        {
            throw new RuntimeException( "Employee id " + employeeId + " has been deleted" );
        }

        employeeService.deleteById( employeeId );

        return "Deleted employee id - " + employeeId;
    }


}
