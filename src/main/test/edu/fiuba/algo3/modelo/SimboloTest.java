package edu.fiuba.algo3.modelo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SimboloTest {

    @Test
    public void test01SimboloEsIgualAOtro() {
        Simbolo globo = new Simbolo("globo");
        Simbolo globo1 = new Simbolo("globo");

        Assert.assertTrue(globo.esIgualA(globo1));
        Assert.assertTrue(globo1.esIgualA(globo));
    }

    @Test
    public void test02SimbolosNoSonIguales() {
        Simbolo globo = new Simbolo("globo");
        Simbolo maquina = new Simbolo("maquina");

        Assert.assertFalse(globo.esIgualA(maquina));
        Assert.assertFalse(maquina.esIgualA(globo));
    }
}
