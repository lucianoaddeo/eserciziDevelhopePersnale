package com.example.macchina.controller;

import com.example.macchina.dto.ApiResponse;
import com.example.macchina.dto.CarTypeDto;
import com.example.macchina.model.Car;
import com.example.macchina.repository.CarRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository cr;

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Integer id){
        Optional<Car> car = cr.findById(id);
        if(car.isPresent()){
            ApiResponse ap = new ApiResponse(car);
            return ResponseEntity.ok(ap);

        }
        ApiResponse ap = new ApiResponse("Car with id = "+id+" not found ");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ap);
    }

    @GetMapping("/get/all")
    public ResponseEntity<ApiResponse> getAll(
            @RequestParam(required = false, name = "pn") Integer pageNum,
            @RequestParam(required = false, name = "ps") Integer pageSize){
        //controllo sui parametri?
        int pn = (pageNum == null || pageNum < 0) ? 0 : pageNum;
        int ps = (pageSize == null || pageSize < 0) ? 10 : pageSize;
        //paginazione
        Pageable pageable = PageRequest.of(pn,ps);
        Page<Car> page = cr.findAll(pageable);

        ApiResponse ar = new ApiResponse(page);
        return ResponseEntity.ok(ar);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@Valid @RequestBody Car car,
                                            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ApiResponse ar = new ApiResponse(bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(ar);
        }

        Car saved = cr.save(car);
        ApiResponse ar = new ApiResponse(saved);
        return ResponseEntity.ok(ar);
        
    }

    //aggiorna il cartype per id
    @PostMapping("/type/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Integer id,
                                              @Valid @RequestBody CarTypeDto carTypeDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            ApiResponse ar = new ApiResponse(bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(ar);
        }

        Optional<Car> optionalCar = cr.findById(id);
        if(optionalCar.isEmpty()){
            ApiResponse ar = new ApiResponse("Car with id = "+id+" does not exists ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ar);
        }

        Car carDb = optionalCar.get();
        carDb.setType(carTypeDto.getType());
        Car saved = cr.save(carDb);
        ApiResponse ar = new ApiResponse(saved);
        return ResponseEntity.ok(ar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer id){

        Optional<Car> optionalCar = cr.findById(id);
        if(optionalCar.isPresent()) {
            cr.deleteById(id);
            ApiResponse ar = new ApiResponse(optionalCar.get());
            return ResponseEntity.ok().body(ar);
        }

        ApiResponse ar = new ApiResponse("Car with id = "+id+" does not exists ");
        return ResponseEntity.badRequest().body(ar);
    }

    @DeleteMapping("/all")
    public ResponseEntity<ApiResponse> deleteAll(){
        cr.deleteAll();
        ApiResponse ar = new ApiResponse("Deleted all cars", true);

        return ResponseEntity.ok().body(ar);
    }
}
