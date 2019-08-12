package jotGenerator;

import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

public class JotTitlebar extends HBox {

    private Point2D localCursorDif;

    public JotTitlebar(Pane root){
        super();

        prefWidthProperty().bind(root.widthProperty());
        setPrefHeight(50);
        setAlignment(Pos.CENTER_RIGHT);

        initControls();

        setOnMousePressed(this::setLocalDif);
        setOnMouseDragged(this::positionWindow);
    }

    private void initControls() {
        Button close = new Button(Character.toString((char) 0x274c));
        Button min = new Button(Character.toString((char) 0x2501));

        close.setCursor(Cursor.HAND);
        min.setCursor(Cursor.HAND);

        close.setPadding(new Insets(0, 30, 0, 0));
        min.setPadding(new Insets(0, 20, 0, 0));

        close.setOnMouseClicked((event)->{
            ((Stage) close.getScene().getWindow()).close();
        });

        min.setOnMouseClicked((event)->{
            ((Stage) min.getScene().getWindow()).setIconified(true);
        });

        getChildren().addAll(min, close);
    }

    private void setLocalDif(MouseEvent event) {
        localCursorDif = new Point2D(event.getScreenX(), event.getScreenY());
        localCursorDif = localCursorDif.subtract(localToScreen(getLayoutBounds()).getMinX(), localToScreen(getLayoutBounds()).getMinY());

        //System.out.println(localCursorDif);
    }

    private void positionWindow(MouseEvent event) {
        Window window = ((Node)event.getTarget()).getScene().getWindow();

        Point2D globalPos = new Point2D(event.getScreenX(), event.getScreenY());

        window.setX(globalPos.subtract(localCursorDif).getX());
        window.setY(globalPos.subtract(localCursorDif).getY());
    }
}
