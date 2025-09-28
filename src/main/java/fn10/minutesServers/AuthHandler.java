package fn10.minutesServers;

import java.net.PasswordAuthentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fn10.minutesServers.auth.TMUser;
import fn10.minutesServers.auth.UserRepository;

@Controller
@RequestMapping("/twenty/auth/")
@CrossOrigin
public class AuthHandler {

    private UserRepository userRepo;

    public AuthHandler(UserRepository repo) {
        this.userRepo = repo;
    }

    public static class LoginInfo {
        public String status;

        public LoginInfo(String status) {
            this.status = status;
        }
    }

    public static class LoginRequest {

        public String Username;
        public String Password;
        public long Time;
        public String key;
    }

    @PostMapping("/signup")
    public @ResponseBody LoginInfo createUser(@RequestBody LoginRequest req) {

    }

    @PostMapping("/login")
    public @ResponseBody LoginInfo login(@RequestBody LoginRequest req) {
        TMUser user = null;
        for (TMUser propuser : userRepo.findAll()) {
            if (propuser.getUsername().equals(req.Username)) {
                user = propuser;
            }
        }

        if (user == null) {
            return new LoginInfo("User not found");
        }

        if (req.Password.equals(new String(user.getPassword()))) {
            return new LoginInfo("OK");

        } else {
            return new LoginInfo("Wrong Password");
        }
    }

}
