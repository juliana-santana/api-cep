import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ViaCEPTest {

    private static final String BASE_URL = "https://viacep.com.br";
    private static final String CEP_PATH = "/ws/{cep}/json/";
    private static final String CEP = "38010-270";

    @Test
    public void consultaCEPValido() {

        Response response = RestAssured.given()
                .baseUri(BASE_URL)
                .basePath(CEP_PATH)
                .pathParam("cep", CEP)
                .when()
                .get()
                .then()
                .extract()
                .response()
                .prettyPeek();

        assertEquals(200, response.getStatusCode());

        String logradouro = response.jsonPath().getString("logradouro");
        String bairro = response.jsonPath().getString("bairro");
        String cidade = response.jsonPath().getString("localidade");

        assertEquals("Rua Major Eustáquio", logradouro);
        assertEquals("Centro", bairro);
        assertEquals("Uberaba", cidade);
    }
}
