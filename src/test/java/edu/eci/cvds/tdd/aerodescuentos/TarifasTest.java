package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {

    @Test
    public void test3_1() {
        double result = CalculadorDescuentos.calculoTarifa(-100, 10, 50);
        Assert.assertEquals(-100, result, 0);
    }

    @Test
    public void test3_2() {
        double result = CalculadorDescuentos.calculoTarifa(100, -20, 50);
        Assert.assertEquals(100, result, 0);
    }

    @Test
    public void test3_3() {
        double result = CalculadorDescuentos.calculoTarifa(100, 10, -18);
        Assert.assertEquals(95, result, 0);
    }

    @Test
    public void test3_4() {
        double result = CalculadorDescuentos.calculoTarifa(100, 10, 9);
        Assert.assertEquals(95, result, 0);
    }

    @Test
    public void test3_5() {
        double result = CalculadorDescuentos.calculoTarifa(100, 10, 50);
        Assert.assertEquals(100, result, 0);
    }

    @Test
    public void test3_6() {
        double result = CalculadorDescuentos.calculoTarifa(100, 10, 80);
        Assert.assertEquals(92, result, 0);
    }

    @Test
    public void test3_7() {
        double result = CalculadorDescuentos.calculoTarifa(100, 30, 9);
        Assert.assertEquals(80, result, 0);
    }

    @Test
    public void test3_8() {
        double result = CalculadorDescuentos.calculoTarifa(100, 30, 50);
        Assert.assertEquals(85, result, 0);
    }

    @Test
    public void test3_9() {
        double result = CalculadorDescuentos.calculoTarifa(100, 30, 80);
        Assert.assertEquals(77, result, 0);
    }

    @Test
    public void test5_1() {
        double result = CalculadorDescuentos.calculoTarifa(-0.01, 20, 18);
        Assert.assertEquals(-0.01, result, 0);
    }

    @Test
    public void test5_2() {
        double result = CalculadorDescuentos.calculoTarifa(100, -1, 18);
        Assert.assertEquals(100, result, 0);
    }

    @Test
    public void test5_3() {
        double result = CalculadorDescuentos.calculoTarifa(100, 19, -1);
        Assert.assertEquals(95, result, 0);
    }

    @Test
    public void test5_4() {
        double result = CalculadorDescuentos.calculoTarifa(100, 0, 1);
        Assert.assertEquals(95, result, 0);
    }

    @Test
    public void test5_5() {
        double result = CalculadorDescuentos.calculoTarifa(100, 20, 18);
        Assert.assertEquals(100, result, 0);
    }

    @Test
    public void test5_6() {
        double result = CalculadorDescuentos.calculoTarifa(100, 19, 66);
        Assert.assertEquals(92, result, 0);
    }

    @Test
    public void test5_7() {
        double result = CalculadorDescuentos.calculoTarifa(100, 21, 17);
        Assert.assertEquals(80, result, 0);
    }

    @Test
    public void test5_8() {
        double result = CalculadorDescuentos.calculoTarifa(100, 21, 65);
        Assert.assertEquals(85, result, 0);
    }

    @Test
    public void test5_9() {
        double result = CalculadorDescuentos.calculoTarifa(100, 21, 66);
        Assert.assertEquals(77, result, 0);
    }

    @Test
    public void test5_10() {
        double result = CalculadorDescuentos.calculoTarifa(0, 20, 18);
        Assert.assertEquals(0, result, 0);
    }
}

