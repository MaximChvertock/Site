package by.chvertock.web.site.web.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProtectedPage {// JUST FOR TEST

    @RequestMapping("protected")
    public String showProtectedPage() {
        return "ProtectedPage";
    }
}
