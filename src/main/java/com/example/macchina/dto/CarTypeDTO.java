package com.example.macchina.dto;

import com.example.macchina.enums.CarType;
import jakarta.validation.constraints.NotNull;


public class CarTypeDTO {
    @NotNull
    private CarType type;

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }
}
