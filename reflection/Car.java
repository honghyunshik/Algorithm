package org.example.reflection;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Car {

    private String name;
    private String color;
    private int size;

    private void carInfo(){
        System.out.println("이름은 : " + name + " 색깔은 : " + color + " 크기는 : " + size);
    }

    public Car(String name){
        this.name = name;
    }

}
