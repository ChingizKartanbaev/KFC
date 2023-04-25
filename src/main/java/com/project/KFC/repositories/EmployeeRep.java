package com.project.KFC.repositories;

import com.project.KFC.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRep extends JpaRepository<Employee, Long> {

    @Query(value = "\n"+
            "select CASE WHEN COUNT(employee) > 0 THEN true ELSE false END\n" +
            "from tb_employee as employee\n" +
            "INNER join tb_user as users\n" +
            "on employee.user_id=users.id\n" +
            "WHERE users.login=:login AND users.password=:password AND users.active = true AND employee.active = true", nativeQuery = true)
    boolean findEmployeeByByLoginAndPassword(String login, String password);

    @Query(value = "\n"+
            "select *\n" +
            "from tb_employee as employee\n" +
            "INNER join tb_user as users\n" +
            "on employee.user_id=users.id\n" +
            "WHERE users.login=:login AND users.password=:password", nativeQuery = true)
    Employee findEmployeeId(String login, String password);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "\n" +
            "WITH updated_employee AS (\n" +
            "  UPDATE tb_employee\n" +
            "  SET active = false\n" +
            "  WHERE id=:id\n" +
            "  RETURNING user_id\n" +
            ")\n" +
            "UPDATE tb_user\n" +
            "SET active = false\n" +
            "WHERE id IN (SELECT user_id FROM updated_employee);", nativeQuery = true)
    void softDelete(Long id);

    List<Employee> findAllByActiveIsTrue();
}
