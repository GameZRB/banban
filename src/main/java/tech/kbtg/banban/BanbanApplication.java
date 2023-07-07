package tech.kbtg.banban;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.kbtg.banban.entity.Employee;
import tech.kbtg.banban.service.EmpService;

@SpringBootApplication
public class BanbanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanbanApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(EmpService employeeService )
	{
		return runner -> {
			initData( employeeService );
		};
	}

	private void initData( EmpService employeeService )
	{
		Employee employee1 = new Employee( "Somsri" , "Manugtong" , "a" , 2000 , "current" , "123/4" , "Dev" );
		Employee employee2 = new Employee( "Somsak" , "Man" , "a" , 2000 , "current" , "143/4" , "Dev" );
		Employee employee3 = new Employee( "Somchai" , "Jailuk" , "a" , 2500 , "current" , "163/4" , "Dev" );

		employeeService.save( employee1 );
		employeeService.save( employee2 );
		employeeService.save( employee3 );
	}

}
