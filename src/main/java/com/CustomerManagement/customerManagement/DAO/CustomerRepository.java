package com.CustomerManagement.customerManagement.DAO;

import com.CustomerManagement.customerManagement.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{


    @Modifying
    @Query(value = "UPDATE Customer SET first_name = :newFirstName, last_name = :newLastName, street = :newStreet, address = :newAddress, city = :newCity, state = :newState, email = :newEmail, phone = :newPhone WHERE id = :givenId", nativeQuery = true)
    void updateCustomerDetails(
            @Param("newFirstName") String newFirstName,
            @Param("newLastName") String newLastName,
            @Param("newStreet") String newStreet,
            @Param("newAddress") String newAddress,
            @Param("newCity") String newCity,
            @Param("newState") String newState,
            @Param("newEmail") String newEmail,
            @Param("newPhone") String newPhone,
            @Param("givenId") Long givenId
    );

    @Modifying
    @Query(value = "DELETE FROM Customer c WHERE c.id = :thegivenid",nativeQuery = true)
    void deleteCustomer(@Param("thegivenid") Long id);

}
