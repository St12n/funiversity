package com.switchfully.funiversity.api;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProfessorControllerIntegrationTest {

    @LocalServerPort
    private int port;



}