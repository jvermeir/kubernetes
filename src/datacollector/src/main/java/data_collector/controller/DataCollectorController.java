package data_collector.controller;

import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.time.Instant;

@RequestMapping
@RestController
public class DataCollectorController {

    @RequestMapping(method = RequestMethod.POST, path = "/store")
    @Consumes(MediaType.TEXT_PLAIN)
    public @ResponseBody void store(@RequestBody String logLine) {
        System.out.println(Instant.now().toString() + " " + logLine.split("=")[1]);
    }
}
