package by.chvertock.web.site.web.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AccessDeniedController {

    @RequestMapping("authentication/access-denied")
    public String showAccessDenied() {
        return "AccessDeniedPage";
    }
}
