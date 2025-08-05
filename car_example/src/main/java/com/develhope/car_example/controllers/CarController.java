package com.develhope.car_example.controllers;

import com.develhope.car_example.model.Car;
import com.develhope.car_example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarRepository cr;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        System.out.println("findBYID");
        Optional<Car> carOpt =  cr.findById(id);
        if(carOpt.isEmpty())
            return ResponseEntity.status(404).body("Car not found.");
        return ResponseEntity.ok(carOpt.get());
    }

    @GetMapping()
    public ResponseEntity<List<Car>> findAll(){
        List<Car> cars =  cr.findAll();
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Car car){
        Car saved = cr.save(car);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<?> udate(@RequestBody Car car){
        Optional<Car> carOpt = cr.findById(car.getId());
        if (carOpt.isEmpty())
            return ResponseEntity.status(404).body("Car not found.");

        Car updated = carOpt.get();
        updated.setType(car.getType());
        updated.setModelnName(car.getModelnName());
        return ResponseEntity.ok(cr.save(updated));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable Integer id){
        Optional<Car> carOpt =  cr.findById(id);
        if(carOpt.isEmpty())
            return ResponseEntity.status(404).body("Car not found.");
        cr.delete(carOpt.get());
        return ResponseEntity.ok("deleted");
    }

    @DeleteMapping
    public  ResponseEntity<?> deleteById(){

        cr.deleteAll();
        return ResponseEntity.ok("deleted all");
    }


}
