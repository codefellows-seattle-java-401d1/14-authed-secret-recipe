//package server;
//
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import server.db.UserDB;
//import server.models.User;
//import server.pojo.UserPojo;
//
//import java.util.List;
//
///*
//=====  DOES NOT NEED TO BE CREATED =====
//This function is handled in the AuthController but I followed along with the lecture so I could get more practice. I'm still getting used to using the "/" for directing places.
// */
//
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    //List all the users
//    @GetMapping
//    @ResponseBody
//    public List<User> index() {
//        return UserDB.getAllUsers();
//    }
//
//    //List certain user by id number.  Have to parseInt the id number because it will come back in as string.
//    @GetMapping
//    @ResponseBody
//    public User getUser(@PathVariable String id) {
//        return UserDB.getUserById(Integer.parseInt(id));
//    }
//
//    //Create a new user
//    @GetMapping("new")
//    @ResponseBody
//    public User newUserForm() {
//        User user = new User();
//        return user;
//    }
//
//    @PostMapping()
//    @ResponseBody(consumes="application/json")
//    public User createNewUser(@RequestBody UserPojo userPojo) {
//        User user = new User(userPojo);
//
//        String password = "password";
//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
//
//        System.out.println(user.username);
//        System.out.println(userPojo.password);
//        System.out.println(user.bio);
//        System.out.println(hashed);
//
//        return user;
//    }
//
//    @GetMapping(value="{id}/edit"), consumes="application/json")
//    @ResponseBody
//    public User editUserForm(@PathVariable String username) {
//        User user = new User();
//        return user;
//    }
//
//    @PutMapping(value="{id}", consumes="application/jason")
//    @ResponseBody
//    public User editUser(@RequestBody UserPojo userPojo) {
//        User user = UserDB.getUserByName(userPojo.username);
//        user.bio = userPojo.bio;
//        return user;
//    }
//
//    @DeleteMapping("{id}")
//    @ResponseBody
//    public boolean deleteUser(@PathVariable String id) {
//        return UserDB.deleteUser(Integer.parseInt(id));
//    }
//}
