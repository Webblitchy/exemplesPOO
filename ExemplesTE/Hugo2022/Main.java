package ExemplesTE.Hugo2022;


import java.util.LinkedList;

interface Button {
    void tapUpper();

    void tapLower();
}

abstract class Device {
    private static LinkedList<Device> history = new LinkedList<>();
    private static int deviceCounter = 0;
    private final int id;

    protected Button button;

    public Device() {
        id = ++deviceCounter;
        history.add(this);
    }

    public static void showSystemState() {
        System.out.println("State of system:");
        for (Device d : history) {
            System.out.printf("- %s\n", d);
        }
    }

    public static void findDevice(Device other) {
        System.out.printf("Devices equal to %s:\n", other);
        for (Device d : history) {
            if (d.equals(other))
                System.out.printf("- %s\n", d);
        }
    }

    public String name() {
        return String.format("%s #%d", getClass().getSimpleName(), id);
    }

    public Button button() {
        return button;
    }

    public abstract String getStatus();

    public String toString() {
        return String.format("%s is %s", name(), getStatus());
    }
}

enum LightState {
    On,
    Off
}

class Light extends Device {
    private LightState status;

    public Light() {
        super();
        status = LightState.Off;
        button = new Button() {
            @Override
            public void tapUpper() {
                LightState status = Light.this.status;
                if (status == LightState.On)
                    System.out.print("Ignored, ");
                else
                    System.out.print("Ok, ");
                Light.this.status = LightState.On;
                System.out.println(Light.this);
            }

            @Override
            public void tapLower() {
                LightState status = Light.this.status;
                if (status == LightState.Off)
                    System.out.print("Ignored, ");
                else
                    System.out.print("Ok, ");
                Light.this.status = LightState.Off;
                System.out.println(Light.this);
            }
        };
    }

    @Override
    public String getStatus() {
        return status.toString();
    }

    @Override
    public boolean equals(Object o) {
        return this != o && o instanceof Light && getStatus().equals(((Light) o).getStatus());
    }
}

enum BlindState {
    Closed,
    HalfOpen,
    Open
}

class Blind extends Device {
    private BlindState status;

    Blind() {
        status = BlindState.Open;
        button = new Button() {
            @Override
            public void tapUpper() {
                BlindState status = Blind.this.status;
                switch (status) {
                    case Closed:
                        System.out.print("Ok, ");
                        Blind.this.status = BlindState.HalfOpen;
                        break;
                    case HalfOpen:
                        System.out.print("Ok, ");
                        Blind.this.status = BlindState.Open;
                        break;
                    case Open:
                        System.out.print("Ignored, ");
                }
                System.out.println(Blind.this);
            }

            @Override
            public void tapLower() {
                BlindState status = Blind.this.status;
                switch (status) {
                    case Open:
                        System.out.print("Ok, ");
                        Blind.this.status = BlindState.HalfOpen;
                        break;
                    case HalfOpen:
                        System.out.print("Ok, ");
                        Blind.this.status = BlindState.Closed;
                        break;
                    case Closed:
                        System.out.print("Ignored, ");
                        break;
                }
                System.out.println(Blind.this);
            }
        };
    }

    @Override
    public String getStatus() {
        return status.toString();
    }

    @Override
    public String toString() {
        return String.format("%s is in position %s", name(), getStatus());
    }

    @Override
    public boolean equals(Object o) {
        return this != o && o instanceof Blind && getStatus().equals(((Blind) o).getStatus());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("### Lights");
        Device d1 = new Light();
        System.out.println(d1);
        d1.button().tapUpper();
        d1.button().tapUpper();
        Device d2 = new Light();
        System.out.println(d2);

        System.out.println("\n### Blinds");
        Device d3 = new Blind();
        System.out.println(d3);
        Device d4 = new Blind();
        System.out.println(d4);
        d4.button().tapLower();
        d4.button().tapLower();
        d4.button().tapLower();

        System.out.println();
        Device.showSystemState();

        System.out.println("\n### Find device");
        Device.findDevice(new Light());
        Device.findDevice(new Blind());
    }
}
