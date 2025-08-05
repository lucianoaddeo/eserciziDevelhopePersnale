package com.develhope.car_example.app_runner;

import com.develhope.car_example.enums.CarType;
import com.develhope.car_example.model.Car;
import com.develhope.car_example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarInitialization implements ApplicationRunner{


//    @Bean
//    public ApplicationRunner init(CarRepository cr){
//        return new ApplicationRunner() {
//            @Override
//            public void run(ApplicationArguments args) throws Exception {
//                cr.save(new Car("BMW X5", CarType.SUV));
//
//            }
//        };
//    }


    private CarRepository cr;

    @Autowired
    //deve essere public per un problema di visibilità con la classe CarRepository
    public CarInitialization(CarRepository cr){
        this.cr = cr;
    }

    @Override
    public void run(ApplicationArguments arguments){
        cr.save(new Car("BMW X5", CarType.SUV));
        cr.save(new Car("Mazda MX-5", CarType.COUPE));
    }
}
