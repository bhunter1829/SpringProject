package Inventory.Controller;

import Inventory.Exceptions.UnauthorizedUserException;
import Inventory.Model.Account;
import Inventory.Service.LoginService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
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
    public ResponseEntity<Object> register(@RequestBody Account account) {
        // Delegate the registration to the AccountService class
        try {
            Account registeredAccount = loginService.register(account);
            return ResponseEntity.ok().body(registeredAccount);
        } catch (IllegalStateException ex) {
            // If the account already exists, return a 400 Bad Request response with an error message
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @ExceptionHandler(UnauthorizedUserException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "invalid login credentials!")
    public void handleUnauthorized(){

    }
}
