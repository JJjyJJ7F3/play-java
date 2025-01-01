package self.jjjyjj.oop.example.solid.isp.revised;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that map command number to corresponding TV control
 */
public class Commands {
    private final Map<Integer, Command> commandsByNumber = new HashMap<>();

    /**
     * register TV control commands
     * @param isSmartTV whether it is a smart TV
     */
    public void initialise(boolean isSmartTV) {
        register(0, new On());
        register(1, new Off());

        if (isSmartTV) {
            register(3, new StartRecording());
        }
    }

    public void execute(int commandNumber) {
        Command command = commandsByNumber.get(commandNumber);

        if (command != null) {
            command.execute();
        } else {
            System.out.println("Unknown command");
        }
    }

    private void register(int number, Command command) {
        commandsByNumber.put(number, command);
    }
}
