package pe.cibertec.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("titulo", "Inicio");
        model.addAttribute("opcion", "Bienvenido");

        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model, Principal principal, RedirectAttributes flash) throws Exception {

        if (principal != null) {
            flash.addFlashAttribute("info", "Usuario logueado en el sistema.");
            return "redirect:/";
        }

        if (error != null) {
            model.addAttribute("error", "Error de ingreso al sistema, usuario o contraseña incorrecta.");
        }

        if (logout != null) {
            model.addAttribute("success", "He cerrado sessión con éxito.");
        }

        return "login";
    }


}
