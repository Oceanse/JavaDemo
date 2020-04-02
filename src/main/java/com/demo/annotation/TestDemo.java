package com.demo.annotation;


import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
 @interface AnnoDemo {
String value();
}



@AnnoDemo("anno")
public class TestDemo{

    @Test
    public void testAnno(){
        AnnoDemo annotation = TestDemo.class.getAnnotation(AnnoDemo.class);
        String value = annotation.value();
        System.out.println("value="+value);
    }
    }
