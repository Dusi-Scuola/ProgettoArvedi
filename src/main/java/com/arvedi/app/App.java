package com.arvedi.app;

import com.arvedi.controller.AppController;
import com.arvedi.model.Counter;
import com.arvedi.view.cli.CliView;
import com.arvedi.view.gui.GuiApp;

import java.util.Locale;
import java.util.Scanner;

/**
 * This is the MAIN CLASS of the entire application.
 *
 * It acts as the LAUNCHER:
 *  - If the user passes "--cli" → it runs the text interface
 *  - If the user passes "--gui" → it runs the JavaFX graphical interface
 *  - If no arguments are given → it shows a small menu (1 or 2)
 *
 * IMPORTANT:
 *  App.java does NOT contain logic.
 *  It only decides WHICH interface to start.
 */
public class App {

    public static void main(String[] args) {

        // Determine which mode should be started: CLI, GUI, or the menu.
        String mode = parseMode(args);

        // Switch expression (Java 14+)
        switch (mode) {
            case "cli" -> runCli();  // Start Command Line Interface
            case "gui" -> runGui();  // Start Graphical Interface
            default    -> showMenu(); // Ask the user (1 or 2)
        }
    }

    /**
     * Reads the command-line arguments (if any).
     *
     * If the user wrote something like:
     *   java App --cli
     *   java App run_gui please
     *
     * The method checks if the text contains:
     *   "cli" → return "cli"
     *   "gui" → return "gui"
     *
     * Otherwise → return "menu"
     */
    private static String parseMode(String[] args) {
        for (String a : args) {
            String v = a.toLowerCase(Locale.ROOT);
            if (v.contains("cli")) return "cli";
            if (v.contains("gui")) return "gui";
        }
        return "menu";
    }

    /**
     * Creates a NEW MVC Controller with a NEW Model.
     *
     * This factory method ensures that each run
     * (CLI or GUI) receives its own independent instance.
     */
    private static AppController newController() {
        return new AppController(new Counter());
    }

    /**
     * Starts the text-based interface.
     * Creates a CLI View and calls start().
     */
    private static void runCli() {
        new CliView(newController()).start();
    }

    /**
     * Starts the JavaFX GUI.
     *
     * GUI works differently: JavaFX itself creates objects,
     * so we give JavaFX a "Controller Provider":
     *
     *   GuiApp.setControllerProvider(App::newController)
     *
     * This tells JavaFX:
     *   “When you need a GuiController, ask me for a new AppController”
     */
    private static void runGui() {
        GuiApp.setControllerProvider(App::newController);
        GuiApp.launch(GuiApp.class);  // Start JavaFX application
    }

    /**
     * If no arguments were provided, show a simple menu
     * so the user can choose:
     *
     *   1 → CLI
     *   2 → GUI
     */
    private static void showMenu() {
        System.out.println("=== Launcher ===");
        System.out.println("1) CLI");
        System.out.println("2) GUI (JavaFX)");
        System.out.print("Choose [1-2]: ");

        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine().trim();

        if ("1".equals(choice)) {
            runCli();
        }
        else if ("2".equals(choice)) {
            runGui();
        }
        else {
            System.out.println("Bye.");
        }
    }
}