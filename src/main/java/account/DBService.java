package account;

import dbService.DBException;

public interface DBService {
    long addUser(UserProfile userProfile) throws DBException;

    UserProfile getUser(String login) throws DBException;

    void create() throws DBException;

    void check() throws DBException;
}
