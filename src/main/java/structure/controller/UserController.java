package structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import structure.model.User;
import structure.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("index", userService.allUsers());
        System.out.println(userService.allUsers());
        return "index";
    }

    @GetMapping("/add")
    public String getUser() { //заполнение
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("addUser") User user) {
        userService.addUser(user);
        return "redirect:/User";
    }

    @GetMapping("/edit/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("edit", userService.getUserById(id));
        return "edit";
    }

    @PutMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("edit") User user) {
        userService.updateUser(user);
        return "redirect:/User";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/User";
    }

}

