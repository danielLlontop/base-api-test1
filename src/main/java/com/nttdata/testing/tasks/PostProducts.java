package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostProducts implements Task {

    private final String title, description, image, category, price;

    public PostProducts(String title, String price, String description, String image, String category) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;

    }

    public static Performable fromPage(String title, String price, String description, String image, String category) {
        return instrumented( PutProduct.class, title, price, description, image, category);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/products").with(requestSpecification -> requestSpecification.contentType("application/json").
                body("{\"title\":\"" + title + "\","
                        +"\"price\":\"" + price + "\","
                        + "\"description\":\"" + description + "\","
                        + "\"image\":\"" + image + "\","
                        + "\"category\":\"" + category + "\"}")
                .log().all()));
    }
}
