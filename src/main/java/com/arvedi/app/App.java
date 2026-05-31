package com.arvedi.app;

import com.arvedi.controller.AppController;
import com.arvedi.model.Cabina;
import com.arvedi.model.Controllo;
import com.arvedi.model.Esterno;
import com.arvedi.model.Intervento;
import com.arvedi.model.Quadro;
import com.arvedi.model.Tecnico;
import com.arvedi.model.TipoQuadro;
import com.arvedi.view.gui.GuiApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * This is the MAIN CLASS of the entire application.
 *
 * It acts as the LAUNCHER:
 * - If the user passes "--cli" → it runs the text interface
 * - If the user passes "--gui" → it runs the JavaFX graphical interface
 * - If no arguments are given → it shows a small menu (1 or 2)
 *
 * IMPORTANT:
 * App.java does NOT contain logic.
 * It only decides WHICH interface to start.
 */
public class App {

    public static void main(String[] args) {

        // Determine which mode should be started: CLI, GUI, or the menu.
        String mode = parseMode(args);

        // Switch on the selected mode
        switch (mode) {
            case "gui":
                runGui();
                break;
            default:
                showMenu();
                break;
        }
    }

    /**
     * Reads the command-line arguments (if any).
     *
     * If the user wrote something like:
     * java App --cli
     * java App run_gui please
     *
     * The method checks if the text contains:
     * "cli" → return "cli"
     * "gui" → return "gui"
     *
     * Otherwise → return "menu"
     */
    private static String parseMode(String[] args) {
        for (String a : args) {
            String v = a.toLowerCase(Locale.ROOT);
            if (v.contains("gui")) return "gui";
        }
        return "menu";
    }

    /**
     * Creates a NEW MVC Controller with NEW Model instances.
     *
     * This factory method ensures that each run
     * (CLI or GUI) receives its own independent instance.
     *
     * Sample data is provided so the app starts with
     * meaningful objects already in place.
     */
    private static AppController newController() {
        return new AppController();
    }

    /**
     * Starts the JavaFX GUI.
     *
     * GUI works differently: JavaFX itself creates objects,
     * so we give JavaFX a "Controller Provider":
     *
     * GuiApp.setControllerProvider(App::newController)
     *
     * This tells JavaFX:
     * "When you need a GuiController, ask me for a new AppController"
     */
    private static void runGui() {
        GuiApp.setControllerProvider(App::newController);
        GuiApp.launch(GuiApp.class); // Start JavaFX application
    }

    /**
     * If no arguments were provided, show a simple menu
     * so the user can choose:
     *
     * 1 → CLI
     * 2 → GUI
     */
    private static void showMenu() {
        System.out.println("=== Launcher ===");
        System.out.println("1 - CLI");
        System.out.println("2 - GUI");
        System.out.print("Scelta: ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();

        if (choice.equals("2")) {
            runGui();
        } else {
            System.out.println("Modalità CLI non disponibile.");
        }
    }
}