package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(
            Stage primaryStage) {/*
                                  * primaryStage.setTitle("Hello World!"); Label firstNameLabel = new Label("First Name"); TextField firstName = new
                                  * TextField("First Name"); Label lastNameLabel = new Label("Last Name"); TextField lastName = new TextField("Last Name");
                                  * Button btn = new Button(); btn.setText("Say 'Hello World'"); btn.setOnAction(new EventHandler<ActionEvent>() {
                                  * @Override public void handle(ActionEvent event) { System.out.println("Hello World!"); } }); Tab tab = new Tab();
                                  * tab.setText("Form"); tab.setContent(firstNameLabel); tab.setContent(firstName); tab.setContent(lastNameLabel);
                                  * tab.setContent(lastName); tab.setContent(btn); TabPane tabPane = new TabPane(tab); GridPane pane = new GridPane();
                                  * pane.setAlignment(Pos.CENTER); pane.add(firstNameLabel, 0, 1); pane.add(firstName, 1, 1); pane.add(lastNameLabel, 0, 2);
                                  * pane.add(lastName, 1, 2); pane.add(btn, 0, 3, 1, 2); primaryStage.setScene(new Scene(tabPane, 600, 600, true));
                                  * primaryStage.show();
                                  */

        primaryStage.setTitle("Tabs");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250, Color.WHITE);

        TabPane tabPane = new TabPane();

        BorderPane borderPane = new BorderPane();
        for (int i = 0; i < 5; i++) {
            Label firstNameLabel = new Label("First Name");
            TextField firstName = new TextField("First Name");
            Label lastNameLabel = new Label("Last Name");
            TextField lastName = new TextField("Last Name");
            Button btn = new Button();
            btn.setText("Say 'Hello World'");
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Hello World!");
                }
            });

            Tab tab = new Tab();
            tab.setText("Tab" + i);
            HBox hbox = new HBox();
            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);
            pane.add(firstNameLabel, 0, 1);
            pane.add(firstName, 1, 1);
            pane.add(lastNameLabel, 0, 2);
            pane.add(lastName, 1, 2);
            pane.add(btn, 0, 3, 1, 2);

            hbox.getChildren()
                .add(pane);

            hbox.setAlignment(Pos.CENTER);
            tab.setContent(hbox);
            tabPane.getTabs()
                .add(tab);
        }
        // bind to take available space
        borderPane.prefHeightProperty()
            .bind(scene.heightProperty());
        borderPane.prefWidthProperty()
            .bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren()
            .add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
