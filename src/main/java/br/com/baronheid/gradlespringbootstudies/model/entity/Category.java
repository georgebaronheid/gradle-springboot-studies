package br.com.baronheid.gradlespringbootstudies.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CATEGORY")
@SequenceGenerator(name = "categoryGenerator", sequenceName = "SQ_T_CATEGORY", allocationSize = 1)
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoryGenerator")
    private int id;

    private String name;
}
