package fn10.minutesServers;

import java.io.IOException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GlobalHandler implements ErrorController {

    @RequestMapping("/error")
    public String error(HttpServletRequest request) {
        return "404";
    }

    @RequestMapping
    public @ResponseBody String index() throws IOException {
        return new String(getClass().getResourceAsStream("/index.html").readAllBytes());
    }
}
