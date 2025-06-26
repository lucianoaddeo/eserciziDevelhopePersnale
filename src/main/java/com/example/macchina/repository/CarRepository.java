package com.example.macchina.repository;

import com.example.macchina.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    public Page<Car> findByModelNameStartingWith(String modelName, Pageable pageable);

    //query per ricerca con like per enum
    //il nome del metodo non deve necessariamente seguire le convenzioni dei query methods
//    @Query("select c from Car c where c.color LIKE ?1")
//    public Page<Car> findByColorContains(String color);

    @NativeQuery("SELECT * FROM cars c WHERE c.color LIKE ?")
    public Page<Car> findByColorContainsNative(String color, Pageable pageable);
}
