package org.example;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class CarDto {
    private int id;
    private String марка;
    private String модель;
    private String госномер;
    private String год;
}
