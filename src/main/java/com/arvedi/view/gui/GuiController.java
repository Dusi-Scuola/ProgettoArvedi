package com.arvedi.view.gui;

import com.arvedi.controller.AppController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controller for the JavaFX GUI.
 *
 * IMPORTANT:
 *  This is NOT the MVC Controller!
 *  This is the GUI Controller linked to main.fxml.
 *
 * The actual application logic is handled by AppController (MVC).
 * This class only manages GUI components and sends actions to AppController.
 */
public class GuiController {

    // MVC Controller (logic + model)
    private final AppController controller;

    // Components injected from the FXML file
    @FXML private Label lblCount;
    @FXML private Button btnInc;
    @FXML private Button btnDec;
    @FXML private Button btnReset;

    /** The constructor receives the AppController */
    public GuiController(AppController controller) {
        this.controller = controller;
    }

    /**
     * This method is called automatically by JavaFX
     * after the FXML file has been loaded.
     *
     * Here we:
     *  - initialize the GUI
     *  - connect buttons to actions
     */
    @FXML
    public void initialize() {
        refresh();

        btnInc.setOnAction(e -> {
            controller.increment();
            refresh();
        });

        btnDec.setOnAction(e -> {
            controller.decrement();
            refresh();
        });

        btnReset.setOnAction(e -> {
            controller.reset();
            refresh();
        });
    }

    /** Updates the label showing the counter value */
    private void refresh() {
        lblCount.setText(Integer.toString(controller.getCount()));
    }
}