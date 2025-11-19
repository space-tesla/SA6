// Command Interface
interface Command {
    void execute();
}

// Receiver class
class Light {
    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command: Turn Light ON
class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}

// Concrete Command: Turn Light OFF
class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}

// Invoker class (Remote Control)
class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void pressButton() {
        slot.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args) {

        Light light = new Light();

        // Commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Invoker
        RemoteControl remote = new RemoteControl();

        System.out.println("---- Testing Remote Control ----");

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
