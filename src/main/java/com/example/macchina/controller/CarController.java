package com.example.macchina.controller;

import com.example.macchina.dto.ApiResponse;
import com.example.macchina.dto.PaginationDTO;
import com.example.macchina.model.Car;
import com.example.macchina.repository.CarRepository;
import com.example.macchina.utils.PaginationUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<ApiResponse> getAll(PaginationDTO paginationDTO){

        //paginazione, i parametri sono specificati in paginationDTO
        Pageable pageable =   PaginationUtil.create(paginationDTO);
        Page<Car> page = cr.findAll(pageable);

        ApiResponse ar = new ApiResponse(page);
        return ResponseEntity.ok(ar);
    }

    @GetMapping("/get/model")
    public ResponseEntity<ApiResponse> getByModel(
            PaginationDTO paginationDTO,
            @RequestParam(name = "mn") String modelName){

        if(modelName!=null){
            //paginazione
            Pageable pageable = PaginationUtil.create(paginationDTO);
            Page<Car> page = cr.findByModelNameStartingWith(modelName,pageable);
            ApiResponse ar = new ApiResponse(page);
            return ResponseEntity.ok(ar);
        }
        return ResponseEntity.badRequest().body(
                new ApiResponse("Model name needs to be specified "));

    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@Valid @RequestBody Car car,
                                            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ApiResponse ar = new ApiResponse(bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(ar);
        }

        if(car.getId()==null){//quando salvo la car non voglio che la richiesta mi invii l'id, perché è un campo auto incrementale e perché non voglio che questo metodo permetta un update
            Car saved = cr.save(car);
            ApiResponse ar = new ApiResponse(saved);
            return ResponseEntity.ok(ar);
        }

        ApiResponse ar = new ApiResponse("Error creating car, do not specify id");
        return ResponseEntity.badRequest().body(ar);
    }

    //aggiorna il cartype per id
    @PostMapping("/type/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Integer id,
                                              @Valid @RequestBody Car carRB,
                                              BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            ApiResponse ar = new ApiResponse(bindingResult.getAllErrors());
            return ResponseEntity.badRequest().body(ar);
        }

        Optional<Car> optionalCar = cr.findById(id);
        if(optionalCar.isEmpty()){
            ApiResponse ar = new ApiResponse("Car with id = "+id+" does not exists ");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ar);
        }

        Car carDb = optionalCar.get();//car presa dal db
        carDb.setType(
                carRB.getType()//se il requestBody è una car, come json devo passare un oggetto Car che rispetti i vincoli dei campi notNull,
                              // se il requestBody è CarTypeDto, come json mando un oggetto che ha solo il campo type
        );
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

    @GetMapping("/get/")
    public ResponseEntity<ApiResponse> getByColor(@RequestParam String color,
                                                  PaginationDTO paginationDTO) {

        Pageable pageable = PaginationUtil.create(paginationDTO);
        Page<Car> carPage = cr.findByColorContainsNative("%" + color +"%", pageable);

        ApiResponse ap = new ApiResponse(carPage);
        return ResponseEntity.ok(ap);
    }

    @GetMapping("/testPage")
    public ResponseEntity<ApiResponse> test(PaginationDTO paginationDTO){
        return ResponseEntity.ok(new ApiResponse(paginationDTO));
    }
}
