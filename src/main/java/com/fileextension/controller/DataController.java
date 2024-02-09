package com.fileextension.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private WebClient.Builder builder;

    String url = "http://10.0.0.68:8080/api/v1/ocr-data?base64=base&fileType=passport";

    public DataController() throws JsonProcessingException {
    }


    @GetMapping("response")
    public String getData() {

        return builder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class).block();
    }
    ObjectMapper mapper=new ObjectMapper();
    ResponseData responseData=mapper.readValue(getData(),ResponseData.class);






}





