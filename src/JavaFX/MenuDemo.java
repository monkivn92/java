package JavaFX;

// Demonstrate Menus

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.image.*;

import javafx.event.*;
import javafx.geometry.*;

public class MenuDemo extends Application
{

    Label response;

    public static void main(String[] args)
    {

        // Start the JavaFX application by calling launch().
        launch(args);
    }

    // Override the start() method.
    public void start(Stage myStage) {

        // Give the stage a title.
        myStage.setTitle("Demonstrate Menus");

        // Use a BorderPane for the root node.
        BorderPane rootNode = new BorderPane();

        // Create a scene.
        Scene myScene = new Scene(rootNode, 300, 300);

        // Set the scene on the stage.
        myStage.setScene(myScene);

        // Create a label that will report the selection.
        response = new Label("Menu Demo");

        // Create the menu bar.
        MenuBar mb = new MenuBar();

        // Create the File menu.
        Menu fileMenu = new Menu("_File");
        fileMenu.setMnemonicParsing(true);
        MenuItem open = new MenuItem("Open");
        MenuItem close = new MenuItem("Close");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(open, close, save,  new SeparatorMenuItem(), exit);

        // Add keyboard accelerators for the File menu.
        open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
        close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
        save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));


        // Add File menu to the menu bar.
        mb.getMenus().add(fileMenu);

        // Create the Options menu.
        Menu optionsMenu = new Menu("Options");

        // Create the Colors submenu.
        Menu colorsMenu = new Menu("Colors");
        // Use check menu items for colors. This allows
        // the user to select more than one color.
        CheckMenuItem red = new CheckMenuItem("Red");
        CheckMenuItem green = new CheckMenuItem("Green");
        CheckMenuItem blue = new CheckMenuItem("Blue");
        colorsMenu.getItems().addAll(red, green, blue);
        optionsMenu.getItems().add(colorsMenu);

        // Create the Priority submenu.
        Menu priorityMenu = new Menu("Priority");

        // Use radio menu items for the priority setting.
        // This lets the menu show which priority is used
        // and also ensures that one and only one priority
        // can be selected at any one time.
        RadioMenuItem high = new RadioMenuItem("High");
        RadioMenuItem low = new RadioMenuItem("Low");

        // Create a toggle group and use it for the radio menu items.
        ToggleGroup tg = new ToggleGroup();
        high.setToggleGroup(tg);
        low.setToggleGroup(tg);

        // Select High priority for the default selection.
        high.setSelected(true);

        // Add the radio menu items to the priority menu and
        // add the priority menu to the options menu.
        priorityMenu.getItems().addAll(high, low);
        optionsMenu.getItems().add(priorityMenu);

        // Add a separator.
        optionsMenu.getItems().add(new SeparatorMenuItem());

        // Create the Reset menu item.
        MenuItem reset = new MenuItem("Reset");
        optionsMenu.getItems().add(reset);

        // Add Options menu to the menu bar.
        mb.getMenus().add(optionsMenu);

        // Create the Help menu.
        Menu helpMenu = new Menu("Help");

        ImageView aboutIV = new ImageView("file:/media/DataBackup/java/src/JavaFX/AboutIcon.gif");
        MenuItem about = new MenuItem("About", aboutIV);
        helpMenu.getItems().add(about);

        // Add Help menu to the menu bar.
        mb.getMenus().add(helpMenu);

        // Create the context menu items
        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");
        // Create a context (i.e., popup) menu that shows edit options.
        final ContextMenu editMenu = new ContextMenu(cut, copy, paste);

        // Create one event handler that will handle menu action events.
        EventHandler<ActionEvent> MEHandler =      new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent ae) {
                        String name = ((MenuItem)ae.getTarget()).getText();

                        // If Exit is chosen, the program is terminated.
                        if(name.equals("Exit")) Platform.exit();

                        response.setText( name + " selected");
                    }
                };

        // Add the context menu to the entire scene graph.
        rootNode.setOnContextMenuRequested(
                new EventHandler<ContextMenuEvent>() {
                    public void handle(ContextMenuEvent ae) {
                        // Popup menu at the location of the right click.
                        editMenu.show(rootNode, ae.getScreenX(), ae.getScreenY());
                    }
                });
        // Set action event handlers for the menu items.
        open.setOnAction(MEHandler);
        close.setOnAction(MEHandler);
        save.setOnAction(MEHandler);
        exit.setOnAction(MEHandler);
        red.setOnAction(MEHandler);
        green.setOnAction(MEHandler);
        blue.setOnAction(MEHandler);
        high.setOnAction(MEHandler);
        low.setOnAction(MEHandler);
        reset.setOnAction(MEHandler);
        about.setOnAction(MEHandler);

        cut.setOnAction(MEHandler);
        copy.setOnAction(MEHandler);
        paste.setOnAction(MEHandler);

        // Create a text field and set its column width to 20.
        TextField tf = new TextField();
        tf.setPrefColumnCount(20);
        tf.setOnContextMenuRequested(new EventHandler<Event>()
        {
            @Override
            public void handle(Event arg0)
            {
                System.out.println("selected text:"   + tf.getSelectedText());
            }
        });
        // Add the context menu to the textfield.
        tf.setContextMenu(editMenu);

        // Add the menu bar to the top of the border pane and
        // the response label to the center position.
        rootNode.setTop(mb);

        // Create a flow pane that will hold both the response
        // label and the text field.
        FlowPane fpRoot = new FlowPane(10, 10);
        // Center the controls in the scene.
        fpRoot.setAlignment(Pos.CENTER);
        // Add both the label and the text field to the flow pane.
        fpRoot.getChildren().addAll(response, tf);
        // Add the flow pane to the center of the border layout.
        rootNode.setCenter(fpRoot);

        //##############################
        //########## TOOL BAR ##########
        //##############################
        // Define a tool bar. First, create tool bar items.
        Button btnSet = new Button("Set Breakpoint", new ImageView("file:/media/DataBackup/java/src/JavaFX/setBP.gif"));
        Button btnClear = new Button("Clear Breakpoint",new ImageView("file:/media/DataBackup/java/src/JavaFX/clearBP.gif"));
        Button btnResume = new Button("Resume Execution", new ImageView("file:/media/DataBackup/java/src/JavaFX/resume.gif"));

        // Now, turn off text in the buttons.
        btnSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        // Set tooltips.
        btnSet.setTooltip(new Tooltip("Set a breakpoint."));
        btnClear.setTooltip(new Tooltip("Clear a breakpoint."));
        btnResume.setTooltip(new Tooltip("Resume execution."));

        // Create the tool bar.
        ToolBar tbDebug = new ToolBar(btnSet, btnClear, btnResume);

        // Create a handler for the tool bar buttons.
        EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText(((Button)ae.getTarget()).getText());
            }
        };

        // Set the tool bar button action event handlers.
        btnSet.setOnAction(btnHandler);
        btnClear.setOnAction(btnHandler);
        btnResume.setOnAction(btnHandler);
        //////
        rootNode.setBottom(tbDebug);
        //*****Show the stage and its scene.
        myStage.show();
    }
}

