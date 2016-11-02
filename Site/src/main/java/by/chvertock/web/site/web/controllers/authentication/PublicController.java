package by.chvertock.web.site.web.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController { // JUST FOR TEST

    @RequestMapping("public")
    public String showPublicPage() {
        return "PublicPage";
    }
}
