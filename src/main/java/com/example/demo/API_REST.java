package com.example.demo;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@RestController

public class API_REST {
    Gson gson = new Gson();
    JDBC jdbcController = new JDBC();

    @CrossOrigin
    @RequestMapping("/users")
        public Object users(){
        List<Person> array = jdbcController.selectPersons();
        String json = gson.toJson(array, new TypeToken<List<Person>>(){}.getType());
        return json;
     }


}
