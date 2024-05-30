package com.zee.springmodulithcourse.inventory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Getter
@Setter
@ToString
@Entity
@Table(indexes = @Index(name = "inv_name_Idx", columnList = "name"))
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;
    private long price;
}
