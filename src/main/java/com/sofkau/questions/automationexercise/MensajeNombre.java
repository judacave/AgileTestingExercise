package com.sofkau.questions.automationexercise;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


import static com.sofkau.ui.automationexercise.ConfirmacionRegistro.MENSAJE_INICIO;

public class MensajeNombre implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return MENSAJE_INICIO.resolveFor(actor).getText();
    }

    public static MensajeNombre mensajeNombre(){
        return new MensajeNombre();
    }
}
