package org.etiya.entities;

import lombok.*;
import org.etiya.core.entities.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Car extends BaseEntity<Integer> {

    private Model model;
    private Transmission transmission;
    private Fuel fuel;
    private String plate;
    private double dailyPrice;

}
