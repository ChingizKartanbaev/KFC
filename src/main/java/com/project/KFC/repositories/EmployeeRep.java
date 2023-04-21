package com.project.KFC.repositories;

import com.project.KFC.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRep extends JpaRepository<Employee, Long> {

    @Query(value = "\n"+
            "select CASE WHEN COUNT(employee) > 0 THEN true ELSE false END\n" +
            "from tb_employee as employee\n" +
            "INNER join tb_user as users\n" +
            "on employee.user_id=users.id\n" +
            "WHERE users.login=:login AND users.password=:password", nativeQuery = true)
    boolean findEmployeeByByLoginAndPassword(String login, String password);

    @Query(value = "\n"+
            "select *\n" +
            "from tb_employee as employee\n" +
            "INNER join tb_user as users\n" +
            "on employee.user_id=users.id\n" +
            "WHERE users.login=:login AND users.password=:password", nativeQuery = true)
    Employee findEmployeeId(String login, String password);

}
