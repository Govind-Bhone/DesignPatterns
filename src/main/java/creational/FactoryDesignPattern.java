package creational;

/**
 * Created by govind.bhone on 6/6/2017.
 */

interface OS {
    public void spec();
}

class Android implements OS {

    public void spec() {
        System.out.println("Android os");
    }
}

class IOS implements OS {

    public void spec() {
        System.out.println("IOS os");
    }
}

class Windows implements OS {

    public void spec() {
        System.out.println("Windows os");
    }
}

class OperatingSystemFactory {
    public OS getInstance(String osType) {
        if (osType.equals("open")) {
            return new Android();
        } else if (osType.equals("closed")) {
            return new IOS();
        } else {
            return new Windows();
        }
    }

}

public class FactoryDesignPattern {
    public static void main(String args[]) {
        OperatingSystemFactory obj = new OperatingSystemFactory();
        obj.getInstance("open").spec();
        obj.getInstance("closed").spec();
    }
}
