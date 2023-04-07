package Inventory.Controller;

import Inventory.Exceptions.UnauthorizedUserException;
import Inventory.Model.Account;
import Inventory.Service.LoginService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"*"})
@RestController
//@CrossOrigin(origins = {"http://ec2-54-204-180-31.compute-1.amazonaws.com:4200/", "http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")

public class LoginController {


    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
        //post http endpoint, takes in json request body, attempts login, throws exception if invalid.
    @PostMapping("login")
    public Account login(@RequestBody Account account) throws UnauthorizedUserException {
        return loginService.login(account);
    }
        //post http endpoint, takes in json request body, attempts register
    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody Account account) {
        try {
            Account registeredAccount = loginService.register(account);
            return ResponseEntity.ok().body(registeredAccount);
            //service will return exception + message: username taken if username exists
        } catch (IllegalStateException ex) {
            // If the username already exists, return a 400 Bad Request response with an error message
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
        //handles UnauthorizedUserException thrown by login, returns 401 and message.
    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials!")
    public void handleUnauthorized(){

    }
}
