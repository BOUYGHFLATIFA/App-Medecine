package ma.projet.medecine.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthController {

    private static final Map<String, String> users = new HashMap<>();
    private String currentUser = null;

    static {
        users.put("admin", "password");
        users.put("user", "1234");
    }

    @GetMapping("/login")
    public String loginPage() {
        System.out.println("Page de connexion appelée");
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username; 
            return "redirect:/accueil"; 
        } else {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect !");
            return "login"; 
        }
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        if (currentUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", currentUser);
        return "Dashboard"; 
    }

    @GetMapping("/logout")
    public String logout() {
        currentUser = null; 
        return "redirect:/login";
    }
}
