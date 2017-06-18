package structural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by govind.bhone on 6/17/2017.
 */

/*

The definition itself is very clear and proxy design pattern is used when we want to provide controlled access of a
functionality.

Let’s say we have a class that can run some command on the system. Now if we are using it, its fine but if we want to
give this program to a client application, it can have severe issues because client program can issue command to delete
some system files or change some settings that you don’t want.

Here a proxy class can be created to provide controlled access of the program.

 */
interface CommandExecutor {

    public void runCommand(String cmd) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) throws IOException, InterruptedException {
        //some heavy implementation
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
        BufferedReader reader=new BufferedReader(
                new InputStreamReader(p.getInputStream())
        );
        String line;
        while((line = reader.readLine()) != null)
        {
            System.out.println(line);
        }
        System.out.println("'" + cmd + "' command executed.");
    }

}

class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pwd) {
        if ("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) isAdmin = true;
        executor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                executor.runCommand(cmd);
            }
        }
    }

}

public class ProxyDesignPattern {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
        try {
            executor.runCommand("cmd /c dir");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }

    }
}
