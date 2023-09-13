package org.example.reflection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @DisplayName("생성자 3개를 반환하는지 테스트")
    @Test
    public void is_constructor_three(){
        assertEquals(Car.class.getConstructors().length,3);
    }

    @DisplayName("기본생성자를 통해 인스턴스가 생성되는지 테스트")
    @Test
    public void can_make_instance_with_constructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<? extends Car> constructor = Car.class.getConstructor();
        Car car = constructor.newInstance();
        assertEquals(car.getSize(),0);
    }

    @DisplayName("다른 생성자를 통해 인스턴스가 생성되는지 테스트")
    @Test
    public void can_make_instance_with_other_constructor() throws Exception{
        Constructor<? extends Car> constructor = Car.class.getConstructor(String.class,String.class,int.class);
        Car car = constructor.newInstance("내차","검정",500);
        assertEquals(car.getName(),"내차");
        assertEquals(car.getColor(),"검정");
        assertEquals(car.getSize(),500);
    }

}