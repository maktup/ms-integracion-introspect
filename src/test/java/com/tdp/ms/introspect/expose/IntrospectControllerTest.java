package com.tdp.ms.introspect.expose;

import com.tdp.genesis.core.constants.HttpHeadersKey;
import com.tdp.ms.introspect.business.IntrospectService;
import com.tdp.ms.introspect.model.IntrospectRequest;
import com.tdp.ms.introspect.model.IntrospectResponse;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.mockito.Mockito.mock;

public class IntrospectControllerTest {

    private static final String POST = "post";
    private static final String GENESIS = "genesis";
    private static final String UUID = "550e8400-e29b-41d4-a716-446655440000";

    private static WebTestClient webClient;

    @Mock
    private static IntrospectService introspectService;

    private static Map<String, IntrospectResponse> introspectResponseMap = new HashMap<>();
    private static Map<String, IntrospectRequest> introspectRequestMap = new HashMap<>();

    @BeforeAll
    public static void setUp() {
        introspectService = mock(IntrospectService.class);
        webClient = WebTestClient.bindToController(new IntrospectController(introspectService))
                .configureClient()
                .baseUrl("/introspect/v1/greeting")
                .defaultHeader(HttpHeadersKey.UNICA_PID,UUID)
                .defaultHeader(HttpHeadersKey.UNICA_SERVICE_ID,UUID)
                .defaultHeader(HttpHeadersKey.UNICA_USER,GENESIS)
                .defaultHeader(HttpHeadersKey.UNICA_APPLICATION,GENESIS)
                .build();

        introspectResponseMap.put("get", new IntrospectResponse("Hello world!"));
        introspectResponseMap.put(POST, new IntrospectResponse("User created!"));
        introspectRequestMap.put(POST, new IntrospectRequest("User"));
        introspectRequestMap.put("empty", new IntrospectRequest(""));
    }

    @Test
    public void indexGetTest() {

        Mockito.when(introspectService.get())
                .thenReturn(new IntrospectResponse("Hello world!"));

        this.webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .header("ClientId","12122322")
                .exchange()
                .expectStatus().isOk()
                .expectBody(IntrospectResponse.class)
                .isEqualTo(new IntrospectResponse("Hello world!"));
    }

    @Test
    public void indexPostTest() {

        Mockito.when(introspectService.put("User"))
                .thenReturn(new IntrospectResponse("User created!"));

        this.webClient.put()
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(introspectRequestMap.get(POST)))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.METHOD_NOT_ALLOWED)
                .expectBody(IntrospectResponse.class)
                .isEqualTo(null);
    }

}
