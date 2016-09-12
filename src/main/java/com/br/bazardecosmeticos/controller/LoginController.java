package com.br.bazardecosmeticos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lailson on 9/12/16.
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam (value = "error", required = false) String error,
                        @RequestParam (value = "logout", required = false) String logout, Model model){
        if (error != null){
            model.addAttribute("error", "Combinação de usuário e senha inválidos!");
        }
        if (logout != null){
            model.addAttribute("msg", "Você fez o logout com sucesso!");
        }
        return "login";
    }
}
