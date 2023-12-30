package org.etiya.entities;

import lombok.*;

import org.etiya.core.entities.BaseEntity;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Model extends BaseEntity<Integer> {

    private String name;
    private Brand brand;

}
