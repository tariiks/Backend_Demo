package org.etiya.business.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreatedBrandResponse {

    private int id;
    private String name;
    private LocalDateTime createdDate;

}
