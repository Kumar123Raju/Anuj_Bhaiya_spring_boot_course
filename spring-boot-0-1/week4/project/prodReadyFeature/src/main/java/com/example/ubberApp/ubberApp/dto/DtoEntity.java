package com.example.ubberApp.ubberApp.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DtoEntity {
    private long id;
    private String tittle;
    private String description;
}
