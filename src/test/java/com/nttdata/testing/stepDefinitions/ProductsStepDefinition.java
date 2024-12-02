package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.tasks.DeleteProduct;
import com.nttdata.testing.tasks.GetProducts;
import com.nttdata.testing.tasks.PostProducts;
import com.nttdata.testing.tasks.PutProduct;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ProductsStepDefinition {

    public static Logger LOGGER = LoggerFactory.getLogger(ProductsStepDefinition.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
    //GET Products
    @Given("el {actor} establece el endpoint para obtener los productos")
    public void elActorEstableceElEndpointParaObtenerLosProductos(Actor actor) {
        actor.whoCan(CallAnApi.at("https://fakestoreapi.com" ));
    }

    @When("el envia una solicitud GET")
    public void elActorEnviaUnaSolicitudGET() {
        theActorInTheSpotlight().attemptsTo(GetProducts.fromEndpoint("/products"));
    }
    //POST Products
    @Given("el {actor} establece el endpoint para crear un producto")
    public void elActorEstableceElEndpointParaCrearUnProducto(Actor actor) {
        actor.whoCan(CallAnApi.at("https://fakestoreapi.com" ));
    }

    @When("el envia una solicitud POST con el producto {string} {string} {string} {string} {string}")
    public void elEnviaUnaSolicitudPOSTConElProducto( String title, String price, String description, String image, String category) {
        theActorInTheSpotlight().attemptsTo(PostProducts.fromPage(title, price, description, image, category));
    }
    //PUT Product
    @Given("el {actor} establece el endpoint para actualizar el producto")
    public void elActorEstableceElEndpointParaActualizarElProductoConElId(Actor actor) {
        actor.whoCan(CallAnApi.at("https://fakestoreapi.com" ));

    }

    @When("el envia una solicitud PUT con el producto {string} {string} {string} {string} {string}")
    public void elActorEnviaUnaSolicitudPOSTConElProducto(String title, String price, String description, String image, String category) {

        theActorInTheSpotlight().attemptsTo(PutProduct.fromPage(title, price, description, image, category));
    }

    @Then("el codigo de respuesta deberia ser {int}")
    public void elCodigoDeRespuestaDeberiaSer(int responseCode) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus(), equalTo(responseCode)));

    }
    //DELETE Product
    @Given("el {actor} establece el endpoint para eliminar el producto")
    public void elActorEstableceElEndpointParaEliminarElProducto(Actor actor) {
        actor.whoCan(CallAnApi.at("https://fakestoreapi.com" ));
    }

    @When("el envia una solicitud DELETE con el producto")
    public void elEnviaUnaSolicitudDELETEConElProducto() {
        theActorInTheSpotlight().attemptsTo(DeleteProduct.fromEndpoint("/products/6"));
    }


}

