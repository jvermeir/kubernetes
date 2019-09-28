package myservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RequestMapping
@RestController
public class MyController {
    public static String id = UUID.randomUUID().toString().substring(0, 6);
    private int counter = 0;

    @RequestMapping(method = RequestMethod.GET, path = "/counter")
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    ServiceData getCounter() {
        return new ServiceData(id, ++counter);
    }
}

class ServiceData {
    public final String id;
    public final int counter;
    ServiceData (String id, int counter) { this.id = id; this.counter = counter; }
}
