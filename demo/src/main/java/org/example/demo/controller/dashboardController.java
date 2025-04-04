@Controller
public class dashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Legg til dashboarddata i model hvis nødvendig
        return "dashboard";
    }
}
