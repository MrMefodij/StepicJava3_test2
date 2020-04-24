package dbService;

import account.DBService;
import account.UserProfile;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBServiceImpl implements DBService {
    private final Connection connection;

    public DBServiceImpl(){
        this.connection = getH2Connection();
    }

    private Connection getH2Connection() {
        try{
            String url = "jdbc:h2./h2db";
            String name = "tully";
            String pass = "tully";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url,name,pass);
            return connection;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long addUser(UserProfile userProfile) throws DBException{

    }

    @Override
    public UserProfile getUser(String login) throws DBException{

    }

    @Override
    public void create() throws DBException{

    }

    @Override
    public void check() throws DBException{

    }
}
