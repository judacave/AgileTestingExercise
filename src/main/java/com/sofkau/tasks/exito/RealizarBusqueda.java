package com.sofkau.tasks.exito;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.sofkau.ui.exito.PaginaInicial.*;
import static com.sofkau.ui.exito.PaginaInicioSesion.BOTON_INICIAR_SESION;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class RealizarBusqueda implements Task {
    private String producto;
    public RealizarBusqueda yConElProducto(String producto){
        this.producto=producto;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BOTON_INICIAR_SESION, isNotVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(CAMPO_BUSQUEDA, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CAMPO_BUSQUEDA),
                Enter.theValue(producto).into(CAMPO_BUSQUEDA),
                Click.on(BOTON_BUSQUEDA)
        );
    }
    public static RealizarBusqueda realizarBusqueda(){
        return new RealizarBusqueda();
    }
}
