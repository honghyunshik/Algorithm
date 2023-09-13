package org.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        /*
        //1
        Class<Car> carClass = Car.class;

        //2
        Car car = new Car();
        Class<? extends Car> carClass2 = car.getClass();

        //3
        Class<?> carClass3 = Class.forName("org.example.reflection.Car");
        */

        Car car = Car.builder()
                .name("내차")
                .color("빨강")
                .size(5)
                .build();

        Class<? extends Car> carClass = car.getClass();

        Field[] fields = carClass.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            if(field.getGenericType()!=int.class) field.set(car,"as");
            System.out.println(field.get(car));
        }

        Method seceret = carClass.getDeclaredMethod("carInfo");
        seceret.setAccessible(true);
        seceret.invoke(car);

    }
}
