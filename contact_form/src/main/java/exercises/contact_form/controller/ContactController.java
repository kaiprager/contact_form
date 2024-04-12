package exercises.contact_form.controller;

import exercises.contact_form.entity.Contact;
import exercises.contact_form.service.ContactServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    private ContactServiceInterface contactServiceInterface;

    @Autowired
    public ContactController(ContactServiceInterface contactServiceInterface) {
        this.contactServiceInterface = contactServiceInterface;
    }

    @GetMapping("/contact")
    public String contactForm(Model model) {

        Contact contact = new Contact();
        model.addAttribute("contact", contact);

        return "contact-form";
    }

    @PostMapping("/contact")
    public String submitContactForm(@Valid @ModelAttribute("contact") Contact contact, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "contact-form";
        }

        contactServiceInterface.saveContactToDatabase(contact);

        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success-page";
    }
}
