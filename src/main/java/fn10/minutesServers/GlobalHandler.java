package fn10.minutesServers;

import java.io.IOException;
import java.time.Instant;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GlobalHandler implements ErrorController {

    public static class PingStatus {

        public String status;

        public PingStatus(String status) {
            this.status = status;
        }
    }

    @RequestMapping("/error")
    public @ResponseBody String error(HttpServletRequest request) {
        return request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) + "! : "
                + request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
    }

    @RequestMapping
    public @ResponseBody String index() throws IOException {
        return new String(getClass().getResourceAsStream("/index.html").readAllBytes());
    }

    @GetMapping("/ping")
    @CrossOrigin
    public @ResponseBody PingStatus ping() {
        return new PingStatus("Before oil runs out...");
    }

    @GetMapping("/now")
    @CrossOrigin
    public @ResponseBody long now() {
        return Instant.now().toEpochMilli();
    }
}
