package com.example.AuthDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/private")
public class PrivateController {
    @RequestMapping("/*")
    public ModelAndView handlePrivateRequests(HttpServletRequest request, Model model) {
        String servlet = request.getServletPath();
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession();
        boolean isLoggedIn = (boolean) session.getAttribute("loggedin");

        if (isLoggedIn) {
            mv.setViewName("secret");
        } else {
            model.addAttribute("username", null);
            mv.setViewName("accessdenied");
        }
        return mv;
    }
}
