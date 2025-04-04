@Controller
@RequestMapping("/feedback")
public class feedbackController {
  @GetMapping
  public String feedbackForm(Model model) {
    return "feedback/form";
  }
  @PostMapping
  public String submitFeedback(/*@ModelAttribute Feedback*/) {
    //large feedback
    return "redirect:/thankyou";
  }
}
