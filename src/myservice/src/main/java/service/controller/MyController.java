package service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.UUID;

@RequestMapping
@RestController
public class MyController {
    private static final String ID = UUID.randomUUID().toString().substring(0, 6);
    private int counter = 0;

    @RequestMapping(method = RequestMethod.GET, path = "/counter")
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    ServiceData getCounter() {
        return new ServiceData(ID, ++counter);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/whatTimeIsItAnyway")
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    LocalDateTime whatTimeIsItAnyway() {
        return LocalDateTime.now();
    }
}

class ServiceData {
    private final String id;
    private final int counter;
    ServiceData (String id, int counter) { this.id = id; this.counter = counter; }
    public String getId () { return id; }
    public int getCounter () { return counter; }
}
