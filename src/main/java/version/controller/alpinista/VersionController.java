package version.controller.alpinista;

/**
 * The {@code VersionController} class is responsible for managing and
 * incrementing
 * a version number following the semantic format "X.Y.Z".
 * <p>
 * The version follows a three-part numeric structure:
 * <ul>
 * <li>{@code X} (Major) - Increases after every 10 minor version
 * increments.</li>
 * <li>{@code Y} (Minor) - Increases after every 10 patch version
 * increments.</li>
 * <li>{@code Z} (Patch) - Increases with each call to
 * {@link #increment()}.</li>
 * </ul>
 * <p>
 * Example usage:
 * 
 * <pre>
 * VersionController vc = new VersionController("1.2.9");
 * String newVersion = vc.increment(); // Outputs "1.3.0"
 * </pre>
 */
public class VersionController {

    /**
     * The current version in "X.Y.Z" format.
     */
    private String currentVersion = "0.0.0";

    /**
     * Constructs a new {@code VersionController} with the specified initial
     * version.
     *
     * @param currentVersion The starting version in "X.Y.Z" format.
     */
    public VersionController(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    /**
     * Increments the version number by increasing the patch number (Z).
     * If {@code Z} reaches 10, it resets to 0 and increments {@code Y} (minor
     * version).
     * If {@code Y} reaches 10, it resets to 0 and increments {@code X} (major
     * version).
     *
     * @return The new incremented version as a string in "X.Y.Z" format.
     */
    public String increment() {
        String[] parts = currentVersion.split("\\.");

        int left = Integer.parseInt(parts[0]);
        int middle = Integer.parseInt(parts[1]);
        int right = Integer.parseInt(parts[2]);

        // Increment patch version
        right++;

        // Handle rollover
        if (right == 10) {
            right = 0;
            middle++;

            if (middle == 10) {
                middle = 0;
                left++;
            }
        }

        // Update and return the new version
        currentVersion = left + "." + middle + "." + right;
        return currentVersion;
    }
}
