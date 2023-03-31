package Inventory.Service;

import Inventory.Exceptions.UnauthorizedUserException;
import Inventory.Model.Account;
import Inventory.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    //    LoginAttemptRepository
    AccountRepository accountRepository;
    @Autowired
    public LoginService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    /**
     * 1. retrieve the actual account by the username, provided in object 'account'
     * 2. check if the actual account has a matching password to the provided account
     * 3. if the username and password are a match, return the account and update the secureToken
     * 4. if the username and password do not match, throw an UnauthorizedUserException, and let the
     * Controller handle produce the 401 response
     * @param account
     * @return
     */
    public Account login(Account account) throws UnauthorizedUserException {
        Account actual = accountRepository.findUserByUsername(account.getUsername());
        if(actual.getPassword().equals(account.getPassword())){
//            generate a new token for this account
            long token = (long) (Math.random()*Long.MAX_VALUE);
            actual.setSecureToken(token);
            accountRepository.save(actual);
            return actual;
        }else{
            throw new UnauthorizedUserException();
        }
    }
    public Account register(Account account) {
        if (accountRepository.findUserByUsername(account.getUsername()) != null) {
            throw new IllegalStateException("Username already taken.");

        }
            long token = (long) (Math.random() * Long.MAX_VALUE);
            account.setSecureToken(token);
            accountRepository.save(account);
            return account;
        }
}



