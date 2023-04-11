package com.sofkau.stepdefinitions.falabella;

import com.sofkau.questions.falabella.MsjCompra;
import com.sofkau.setup.SetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.logging.Logger;

import static com.sofkau.tasks.AbrirPaginaInicial.abrirPaginaInicial;
import static com.sofkau.tasks.falabella.NavegarAlInicioSesion.navegarAlInicioSesion;
import static com.sofkau.ui.falabella.MensajeInicioSesion.MSJ_INICIO_SESION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class InicioSesionFalabellaStepDefinition extends SetUp {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(InicioSesionFalabellaStepDefinition.class));

    @Given("el usuario esta en la pagina principal falabella")
    public void elUsuarioEstaEnLaPaginaPrincipalFalabella() {

        configurarNavegador();
        theActorInTheSpotlight().wasAbleTo(
                abrirPaginaInicial()
                        .conLaPagina("https://www.falabella.com.co/falabella-co")
        );
    }

    @When("navega hasta el incio de sesion")
    public void navegaHastaElIncioDeSesion() {
        try {
            theActorInTheSpotlight().attemptsTo(
                    navegarAlInicioSesion()
                            .conElUsuario("ayolima05@gmail.com")
                            .yConLaContrasenna("Contrasenia2045")
            );

            LOGGER.info("Incio de sesión correcto");

        } catch (Exception e) {
            LOGGER.info(" fallo al iniciar sesión");
            LOGGER.warning(e.getMessage());
            Assertions.fail();
            quitarDriver();
        }
    }

    @Then("debe observar un mensaje de registro exitoso")
    public void debeObservarUnMensajeDeRegistroExitoso() {
        try {
            theActorInTheSpotlight().should(
                    seeThat(MsjCompra.isEqualTo(MSJ_INICIO_SESION ), equalTo("Bienvenid@,"))
            );
            quitarDriver();
        } catch (Exception e){
            LOGGER.warning(e.getMessage());
            quitarDriver();
        }
    }
}
