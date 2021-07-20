package okestrocovid.covid19.controller;


import lombok.extern.slf4j.Slf4j;

import okestrocovid.covid19.service.TestApiService;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class TestApiController {

    private final TestApiService testApiService;


    @Autowired
    public TestApiController(TestApiService testApiService) {
        this.testApiService = testApiService;
    }

    // 매개변수에 따른 이전 날짜를 가져오는 API
//    @CrossOrigin("*")
//    @GetMapping("covid/day")
//    public String fetchWeek(@RequestParam("date") int date ) throws IOException {
////        Model model = null;
//        String xmlResponse = testApiService.getFirstTodosTest(date);
//
//        JSONObject jsonpObject = XML.toJSONObject(xmlResponse);
//
//        String response = jsonpObject.toString();
//
////        String a =" hi";
////        model.addAttribute("response", response);
//        log.info(xmlResponse);
//        return response;
//    }

    //
    @CrossOrigin("*")
    @GetMapping("covid/day")
    public String fetchMonth(@RequestParam("date") int date,@RequestParam("cycle")int cycle ) throws IOException {
//        Model model = null;
        String xmlResponse = testApiService.getSecondTodosTest(date,cycle);

        JSONObject jsonpObject = XML.toJSONObject(xmlResponse);

        String response = jsonpObject.toString();

//        String a =" hi";
//        model.addAttribute("response", response);
        log.info(xmlResponse);
        return response;
    }
}
