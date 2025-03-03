package version.controller.alpinista;

public class Main {
    public static void main(String[] args) {

        var versionController = new VersionController("0.0.0");
        var newVersion = versionController.increment();

        System.out.println("New version: " + newVersion);
    }
}
