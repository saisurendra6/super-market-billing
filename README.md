# Super Market Billing

A simple Java project for supermarket billing.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- [Visual Studio Code](https://code.visualstudio.com/) (recommended)
- Java extensions for VS Code (optional, for better experience)

### Folder Structure

- `src/` — Java source files
- `bin/` — Compiled `.class` files (auto-generated)
- `lib/` — External dependencies (optional)
- `.vscode/` — VS Code settings (auto-generated)

### Building the Project

Open a terminal in the project root and run:

```sh
javac -d bin -sourcepath src src/App.java
```

### Running the Project

After building, run your main class (e.g., `App`) with:

```sh
java -cp bin App
```

### Cleaning Build Files

To remove compiled files, delete the `bin/` directory:

```sh
rm -rf bin
```

On Windows:
```sh
rmdir /s /q bin
```

### Dependency Management

Place any external `.jar` files in the `lib/` directory and add them to your classpath when compiling/running.

### Version Control

This project uses a `.gitignore` file to exclude build outputs, logs, IDE settings, and dependencies from version control.

