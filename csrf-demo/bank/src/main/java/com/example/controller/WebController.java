package com.example.controller;

import com.example.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class WebController {

    @Autowired
    Account account;

    @RequestMapping("/")
    ModelAndView index() {

        ModelAndView mav = new ModelAndView("index");

        Map<String, Object> model = mav.getModel();
        model.put("balance", account.getBalance());
        model.put("history", account.getHistory().all());

        return mav;
    }

    @RequestMapping(value="/transfer", method= RequestMethod.POST)
    public ModelAndView transfer(@ModelAttribute("account") String accountNumber, @ModelAttribute("amount") double amount) {
        account.transferTo(accountNumber, amount);
        return new ModelAndView("redirect:/");
    }

    // avoid side-effects in GET requests!
    @RequestMapping(value="/transfer", method= RequestMethod.GET)
    public ModelAndView transferGet(@ModelAttribute("account") String accountNumber, @ModelAttribute("amount") double amount) {
        account.transferTo(accountNumber, amount);
        return index();
    }
}
