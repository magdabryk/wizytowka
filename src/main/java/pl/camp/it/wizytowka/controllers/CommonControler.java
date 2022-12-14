package pl.camp.it.wizytowka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.wizytowka.mail.JavaMail;
import pl.camp.it.wizytowka.model.Mail;

import javax.mail.MessagingException;

@Controller
public class CommonControler {

    @Autowired
    private JavaMail javaMail;


    @RequestMapping(value = "/main" , method = RequestMethod.GET)
    public String main() {
        return "redirect:/";
    }

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String main2() {
        return "main";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String message(Mail mail) throws MessagingException {
    javaMail.sendMail(mail);
        return "contact";
}
}
