package server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//gives logged in users access to the private/secret data - in this case my honey mustard chicken recipe
@Controller
@RequestMapping("/private")
public class PrivateController {
    @RequestMapping("/*")
    public ModelAndView handlePrivateRequests(HttpServletRequest request){
        String servlet = request.getServletPath();
        ModelAndView newModelView = new ModelAndView();

        HttpSession session = request.getSession();
        boolean isLoggedIn = (boolean) session.getAttribute("loggedin");
        System.out.println("/private " + session.getAttribute("loggedin"));
        if(isLoggedIn){
            newModelView.setViewName("secret");
        }else{
            newModelView.setViewName("accessdenied");
        }
        return newModelView;
    }
}
