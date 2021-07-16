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

    @CrossOrigin("*")
    @GetMapping("covid/week")
    public String fetcgWeek(@RequestParam("date") int date ) throws IOException {
//        Model model = null;
        String xmlResponse = testApiService.getFirstTodosTest(date);

        JSONObject jsonpObject = XML.toJSONObject(xmlResponse);

        String response = jsonpObject.toString();

//        String a =" hi";
//        model.addAttribute("response", response);
        log.info(xmlResponse);
        return response;
    }
    @CrossOrigin("*")
    @GetMapping("covid/month")
    public String fetchMonth(@RequestParam String Date ) throws IOException {
//        Model model = null;
        String xmlResponse = testApiService.getFirstTodosTest(-10);

        JSONObject jsonpObject = XML.toJSONObject(xmlResponse);

        String response = jsonpObject.toString();

//        String a =" hi";
//        model.addAttribute("response", response);
        log.info(xmlResponse);
        return response;
    }
}
