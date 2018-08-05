package server;

//imports from class demo
import com.example.AuthorizationDemo.db.UserDB;
import server.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//allow users to login and check to see if they're authorized
@Controller
@RequestMapping("/auth")
@SessionAttributes("username")
public class AuthController {

    //controller path for registering to create a new user
    @PostMapping("/registration")
    public ModelAndView registration(@RequestParam String username, @RequestParam String password) {
        ModelAndView newModelView = new ModelAndView();

        //check the database to make sure the username doesn't already exist
        if (UserDB.getUserByName(username) != null) {
            newModelView.setViewName("loginerror");
            newModelView.addObject("error", "Sorry, that user name has already been chosen by someone else. Try a " +
                    "different username.");
        } else {
            //if the username doesn't already exist, create it
            UserDB.createUser(username, password);
            newModelView.setViewName("loggedin");
            newModelView.addObject("username", username);
        }
        return newModelView;
    }

    //controller routing to show new view for valid - or invalid - logins
    @PostMapping("/login")
    public ModelAndView login(
            HttpServletRequest request,
            @RequestParam String username,
            @RequestParam String password
    ) {
        ModelAndView newModelView = new ModelAndView();

        User user = UserDB.getUserByName(username);
        if (user == null) {
            newModelView.setViewName("loginerror");
            newModelView.addObject("error", "Sorry that user doesn't exist. Try another username");
        } else {
            boolean isCorrectPassword = user.checkPassword(password);
            if (isCorrectPassword) {
                newModelView.setViewName("loggedin");
                newModelView.addObject("username", username);
                HttpSession ssession = request.getSession();
                ssession.setAttribute("loggedin", true);
            } else {
                newModelView.setViewName("loginerror");
                newModelView.addObject("error", "That's not the correct password. Please try loggin in again or " +
                        "register as a new user.");
            }
        }
        return newModelView;
    }

    //controller routing to show logout view when user chooses to click on "logout" button in logout submit form
    @PostMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("loggedin", false);
        return new ModelAndView("loggedout");
    }
}
