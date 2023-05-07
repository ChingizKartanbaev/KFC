package com.project.KFC.repositories;

import com.project.KFC.enums.PurchasesStatusEnum;
import com.project.KFC.models.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasesRep extends JpaRepository<Purchases, Long> {


    @Query(value = "\n" +
            "SELECT *\n" +
            "FROM tb_purchases as purchases\n" +
            "INNER JOIN tb_employee as employee \n" +
            "ON purchases.employee_id = employee.id\n" +
            "WHERE purchases.purchases_status = 'READY'",nativeQuery = true)
    List<Purchases> findAllByPurchases();
}
