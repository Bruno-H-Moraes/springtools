package com.example.demo;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalculadoraTests {

@Test 	
public void Addtest() {
Calculadora junit= new Calculadora();

int result= junit.soma(100, 200);

assertEquals(500, result);
}
}