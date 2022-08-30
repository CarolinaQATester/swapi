package com.testeapi.tests.people.tests;


import com.testeapi.tests.base.tests.BaseTest;
import com.testeapi.tests.people.requests.PeopleResquest;
import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import java.util.concurrent.TimeUnit;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;


public class PeopleTest extends BaseTest {

    PeopleResquest peopleResquest = new PeopleResquest();

    @Test
    @Tag("todos")
    @Description("Deve listar todas pessoas com sucesso.")
    public void devoListaTodasAsPessoas() throws Exception{
        peopleResquest.listar()
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(3L), TimeUnit.SECONDS);

    }
    @Test
    @Tag("todos")
    @Description("Deve obter um recurso Especifico.")
    public void devoObterUmRecursoEspecifico() throws Exception{

        String idPrimeiroPeople = peopleResquest.buscarIdPrimeiroPessoa();
        peopleResquest.buscarPorId(idPrimeiroPeople)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(3L), TimeUnit.SECONDS);

        Assertions.assertEquals("200", is(200));
    }
    @Test
    @Tag("todos")
    @Description("Deve obter um recurso Especifico com id invalido.")
    public void devoObterIdInvalido() throws Exception{

        String idPrimeiroPeople = peopleResquest.buscarIdPrimeiroPessoa();
        peopleResquest.buscarPorIdInvalido(idPrimeiroPeople)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .time(lessThan(3L), TimeUnit.SECONDS);

        Assertions.assertEquals("200", is(200));
    }
    @Test
    @Tag("todos")
    @Tag("schemas")
    @Description("Devo ver O Esquema JSON Para Este Recurso")
    public void devoVerOEsquemaJSONParaEsteRecurso(){
        peopleResquest.listar()
                .then().log().all()
                .statusCode(HttpStatus.SC_OK)
                .body(matchesJsonSchemaInClasspath("schema/peolpe/peopleContrato.json"));

    }


}
