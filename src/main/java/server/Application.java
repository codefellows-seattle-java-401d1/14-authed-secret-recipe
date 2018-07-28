package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/")
    public String homepage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
//        username = (String) session.getAttribute("username");

        System.out.println("From Homepage" + session.getId() + " " + username);

        ////////////////////////
//        ModelAndView mv = new ModelAndView();
        System.out.println("/private " + session.getAttribute("loggedin"));

//        boolean isLoggedIn = (boolean) session.getAttribute("loggedin");

        if (session.getAttribute("loggedin") == null) {
            model.addAttribute("username", "user");
        }

        if (username != null) {
            model.addAttribute("username", username);
        }





            ///////////////////////
        return "index";
    }
}
