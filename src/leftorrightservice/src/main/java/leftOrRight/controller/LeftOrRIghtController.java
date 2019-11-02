package leftOrRight.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestMapping
@RestController
public class LeftOrRIghtController {

    @RequestMapping(method = RequestMethod.GET, path = "/left-or-right")
    @Produces(MediaType.TEXT_PLAIN)
    public @ResponseBody
    String getLeftOrRight() {
        return Math.random() > 0.1 ? "LEFT" : "RIGHT";
    }
}
