package Inventory.Controller;

import Inventory.Exceptions.UnauthorizedUserException;
import Inventory.Model.Account;
import Inventory.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
public class LoginController {

    LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }
    @PostMapping("login")
    public Account login(@RequestBody Account account) throws UnauthorizedUserException {
        return loginService.login(account);
    }
    @PostMapping("register")
    public Account register(@RequestBody Account account){
        return loginService.register(account);
    }
    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials!")
    public void handleUnauthorized(){

    }
}
