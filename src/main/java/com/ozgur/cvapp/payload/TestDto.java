package com.ozgur.cvapp.payload;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class TestDto {
    String description;
    String title;
    Boolean published;

}
