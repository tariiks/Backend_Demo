package org.etiya.entities;

import lombok.*;
import org.etiya.core.entities.BaseEntity;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Brand extends BaseEntity<Integer> {

    private String name;

    private List<Model> models;

}
