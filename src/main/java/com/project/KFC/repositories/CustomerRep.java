package com.project.KFC.repositories;

import com.project.KFC.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRep extends JpaRepository<Customer, Long> {

    @Query(value = """
            select CASE WHEN COUNT(customer) > 0 THEN true ELSE false END
            from tb_customer as customer
            INNER join tb_user as users
            on customer.user_id=users.id
            WHERE users.login=:login AND users.password=:password""", nativeQuery = true)
    boolean findCustomerByByLoginAndPassword(String login, String password);

    @Query(value = """
            select *
            from tb_customer as customer
            INNER join tb_user as users
            on customer.user_id=users.id
            WHERE users.login=:login AND users.password=:password""", nativeQuery = true)
    Customer findCustomer(String login, String password);

    @Query(value = """
            SELECT *
            FROM tb_customer as customer
            INNER JOIN tb_purchases  as purchases\s
            ON customer.purchases_id = purchases.id
            WHERE purchases.purchases_status = 'PROCESS'""", nativeQuery = true)
    List<Customer> getProcessPurchasesFromCustomer();

}
