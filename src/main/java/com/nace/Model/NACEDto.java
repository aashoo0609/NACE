package com.nace.Model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
public class NACEDto {
    @Id
    @CsvBindByName(column="Order")
    private Long order_id;
    @CsvBindByName(column="Level")
    private Integer level_id;
    @CsvBindByName
    private String code;
    @CsvBindByName
    private String parent;
    @CsvBindByName
    @Lob
    private String description;
    @CsvBindByName(column = "This item includes")
    @Lob
    private String itemIncludes;
    @CsvBindByName(column = "This item also includes")
    @Lob
    private String itemAlsoIncludes;
    @CsvBindByName
    @Lob
    private String rulings;
    @CsvBindByName(column = "This item excludes")
    @Lob
    private String itemExcludes;
    @CsvBindByName(column = "Reference to ISIC Rev. 4")
    private String reference;

}
