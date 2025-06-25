package com.example.macchina.repository;

import com.example.macchina.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    public Page<Car> findByModelName(String modelName, Pageable pageable);
}
