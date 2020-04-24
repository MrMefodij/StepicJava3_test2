package main;


import account.AccountService;
import account.DBService;
import dbService.DBServiceImpl;
import frontend.AccountServiceImpl;
import frontend.servlets.SignInServlet;
import frontend.servlets.SignUpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
    public static void main(String[] args) throws Exception {
        try {
            DBService dbService = new DBServiceImpl();
            dbService.create();
            dbService.check();

            AccountService accountService = new AccountServiceImpl(dbService);
            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
            context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");

            Server server = new Server(8080);
            server.setHandler(context);

            server.start();
            System.out.println("Server started!");
            server.join();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
