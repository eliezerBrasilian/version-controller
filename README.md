# VersionController

VersionController is a simple Java class for managing and incrementing version numbers in the "X.Y.Z" format.

## Installation

To install this package using Cryxie, run the following command:

```sh
cryxie install version_controller@0.0.1
```

> **Note:** This project uses Cryxie instead of Maven to provide a more lightweight and streamlined dependency management system.

## Usage

Below is an example of how to use the `VersionController` class:

```java
package version.controller.cryxie;

public class Main {
    public static void main(String[] args) {
        // Initialize VersionController with a starting version
        var versionController = new VersionController("0.0.0");

        // Increment the version
        var newVersion = versionController.increment();

        // Print the new version
        System.out.println("New version: " + newVersion);
    }
}
```

## How It Works

- The version format follows "X.Y.Z" (major.minor.patch).
- Calling `increment()` increases the patch version (`Z`).
- If `Z` reaches 10, it resets to 0 and increments `Y` (minor version).
- If `Y` reaches 10, it resets to 0 and increments `X` (major version).

## License

This project is licensed under the MIT License.
