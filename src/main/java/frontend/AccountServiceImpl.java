package frontend;

import account.AccountService;
import account.DBService;
import account.UserProfile;
import dbService.DBException;

public class AccountServiceImpl implements AccountService {
    private final DBService dbService;
    public AccountServiceImpl(DBService dbService){
        this.dbService = dbService;
    }

    @Override
    public void singUp(String login, String password){
        try {
            dbService.addUser(new UserProfile(login,password));
        } catch (DBException e) {
            System.out.println("Can't sing in: " + e.getMessage());
        }
    }

    @Override
    public boolean signIn(String login, String password){
        try{
            UserProfile profile = dbService.getUser(login);
            return profile != null && profile.getPassword().getUserPassword().equals(password);
        } catch (DBException e){
            System.out.println("Can't sing in: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean signIn(String login, String password, String email){
        try{
            UserProfile profile = dbService.getUser(login);
            return profile != null && profile.getPassword().getUserPassword().equals(password);
        } catch (DBException e){
            System.out.println("Can't sing in: " + e.getMessage());
            return false;
        }
    }
}
