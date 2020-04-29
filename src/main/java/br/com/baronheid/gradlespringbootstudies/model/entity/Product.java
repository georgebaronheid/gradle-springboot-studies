package br.com.baronheid.gradlespringbootstudies.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product")
    private int id;

    @NotBlank(message = "Name required")
    @Size(max = 50)
    private String name;

//    Min and max are inclusive
    @Min(value = 0, message = "Price can not be negative")
    private double price;

    private boolean newProduct;

//    Past means that the date must be older than current day
    @Past
    private LocalDate manufactureDate;

}
