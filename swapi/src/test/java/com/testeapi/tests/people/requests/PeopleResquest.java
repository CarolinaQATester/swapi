package com.testeapi.tests.people.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class PeopleResquest  {

    private final String PATH_PEOPLE = "https://swapi.dev/api/people";

    @Step("Listar todas as pessoa cadastrada.")
    public Response listar() {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(PATH_PEOPLE);
    }
    @Step("Buscar people por ID")
    public Response buscarPorId(String id) {
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .pathParam("_id", id)
                .get(PATH_PEOPLE+ "/1");
    }
    @Step("Buscar people por ID invalido")
    public Response buscarPorIdInvalido(String id){
        return given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .pathParam("_id", id)
                .get(PATH_PEOPLE+ "1000");
    }

    @Step("Buscar ID do primeiro pessoa.")
    public String buscarIdPrimeiroPessoa() {
        return this.listar().then().statusCode(HttpStatus.SC_OK).extract().path("people[0]._id");
    }
}
