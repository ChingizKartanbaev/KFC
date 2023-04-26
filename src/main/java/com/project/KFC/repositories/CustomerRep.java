package com.project.KFC.repositories;

import com.project.KFC.models.Customer;
import com.project.KFC.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRep extends JpaRepository<Customer, Long> {

    @Query(value = "\n"+
            "select CASE WHEN COUNT(customer) > 0 THEN true ELSE false END\n" +
            "from tb_customer as customer\n" +
            "INNER join tb_user as users\n" +
            "on customer.user_id=users.id\n" +
            "WHERE users.login=:login AND users.password=:password", nativeQuery = true)
    boolean findCustomerByByLoginAndPassword(String login, String password);

    @Query(value = "\n"+
            "select *\n" +
            "from tb_customer as customer\n" +
            "INNER join tb_user as users\n" +
            "on customer.user_id=users.id\n" +
            "WHERE users.login=:login AND users.password=:password", nativeQuery = true)
    Customer findCustomer(String login, String password);

}
