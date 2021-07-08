package com.example.okestromybatis.service;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.net.*;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
@Service
public class TestApiService {
    private final WebClient webClient;

    @Autowired
    Covid covid;

//    Covid covid =new Covid();

    public TestApiService(WebClient.Builder webClientBuilder) throws UnsupportedEncodingException, URISyntaxException {

        String serviceKey = URLEncoder.encode("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?ServiceKey=%2F6YC05LX402Mq1%2Beg8O2m74njrcI2N0h7Km4BNbneOT0MOJlEhWA7Zj7y5c0NrBO2PYPPHWjGBfMFEk6731aug%3D%3D&ServiceKey=-&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315","UTF-8");
        String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?ServiceKey";
        this.webClient = webClientBuilder.baseUrl("http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson?ServiceKey=%2F6YC05LX402Mq1%2Beg8O2m74njrcI2N0h7Km4BNbneOT0MOJlEhWA7Zj7y5c0NrBO2PYPPHWjGBfMFEk6731aug%3D%3D&ServiceKey=-&pageNo=1&numOfRows=10&startCreateDt=20200310&endCreateDt=20200315")
                .build();
    }

    public String getFirstTodosTest() throws IOException {
//        String response =
//                this.webClient.get()
//                .retrieve().bodyToMono(String.class)
//                .block();


        return covid.fetchData();

    }



}


