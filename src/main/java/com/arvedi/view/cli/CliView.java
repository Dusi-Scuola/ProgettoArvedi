package com.arvedi.view.cli;

import java.util.Scanner;

import com.arvedi.controller.AppController;

/**
 * This class is the CLI VIEW (text interface).
 *
 * Responsibilities:
 *  - Reads input from the keyboard
 *  - Sends commands to the Controller
 *  - Displays updated values to the user
 *
 * NOTE:
 *  The CLI NEVER modifies the Model directly.
 *  It only communicates through the Controller.
 */
public class CliView {

    // Reference to the Controller (NOT the Model)
    private final AppController controller;

    /** The CLI receives the Controller through its constructor */
    public CliView(AppController controller) {
        this.controller = controller;
    }

    /**
     * Starts the interactive text interface.
     * The loop continues until the user types 'q' to quit.
     */
    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            String input;

            System.out.println("Counter CLI (I)ncrement, (D)ecrement, (R)eset, (Q)uit");
            print(); // show initial value

            while (true) {
                System.out.print("> ");
                input = sc.nextLine().trim().toLowerCase();

                switch (input) {
                    case "i": case "+":
                        controller.increment();
                        print();
                        break;

                    case "d": case "-":
                        controller.decrement();
                        print();
                        break;

                    case "r":
                        controller.reset();
                        print();
                        break;

                    case "q":
                        System.out.println("Bye!");
                        return;

                    default:
                        System.out.println("Commands: i/d/r/q");
                }
            }
        }
    }

    /** Prints the current counter value */
    private void print() {
        System.out.println("Count = " + controller.getCount());
    }
}