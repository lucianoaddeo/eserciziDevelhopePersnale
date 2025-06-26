package com.example.macchina.model;

import com.example.macchina.enums.CarColor;
import com.example.macchina.enums.CarNation;
import com.example.macchina.enums.CarType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private String modelName;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType type;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CarColor color;
    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)//caso particolare, nel data.sql non ho specificato il campo nation
    private CarNation nation;

    //constructors

    private Car(){}

    public Car(String modelName, CarType type, CarColor color, String description){
        this.modelName = modelName;
        this.type = type;
        this.color = color;
        this.description = description;
    }

    public Car(String modelName, CarType type, CarColor color){
        this(modelName, type, color, null);
    }

    //getter & setter

    public @NotNull CarColor getColor() {
        return color;
    }

    public void setColor(@NotNull CarColor color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull String getModelName() {
        return modelName;
    }

    public void setModelName(@NotNull String modelName) {
        this.modelName = modelName;
    }

    public @NotNull CarType getType() {
        return type;
    }

    public void setType(@NotNull CarType type) {
        this.type = type;
    }

    public CarNation getNation() {
        return nation;
    }

    public void setNation(CarNation nation) {
        this.nation = nation;
    }
}
