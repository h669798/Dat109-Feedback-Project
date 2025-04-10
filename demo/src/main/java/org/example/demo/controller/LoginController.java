package org.example.demo.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        // Hent info om brukeren fra SecurityContext
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Sjekk om brukeren er logget inn
        if (auth != null && auth.isAuthenticated()
                && !(auth instanceof AnonymousAuthenticationToken)) {
            // Allerede logget inn -> send til f.eks. /dashboard
            return "redirect:/dashboard";
        }

        // Hvis anonym, vis login-siden
        return "login";
    }
}
