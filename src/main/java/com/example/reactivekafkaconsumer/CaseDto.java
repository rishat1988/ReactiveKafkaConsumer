package com.example.reactivekafkaconsumer;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaseDto {

    private String number;
    private String description;
    private LocalDateTime startTime;
}
