package br.com.baronheid.gradlespringbootstudies.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "TBL_PRODUCT")
@SequenceGenerator(name = "productSeq", sequenceName = "SQ_PRODUCT", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate manufactureDate;

    @ManyToOne
    private Category category;

}
