package jotGenerator;

import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

public class JotTitlebar extends HBox {

    private Point2D localCursorDif;

    public JotTitlebar(Pane root){
        super();

        prefWidthProperty().bind(root.widthProperty());
        setPrefHeight(30);

        setOnMousePressed(this::setLocalDif);
        setOnMouseDragged(this::positionWindow);
        setOnMouseEntered(this::previewCursor);
    }

    private void setLocalDif(MouseEvent event) {
        localCursorDif = new Point2D(event.getScreenX(), event.getScreenY());
        localCursorDif = localCursorDif.subtract(localToScreen(getLayoutBounds()).getMinX(), localToScreen(getLayoutBounds()).getMinY());

        setCursor(Cursor.CLOSED_HAND);
        //System.out.println(localCursorDif);
    }

    private void positionWindow(MouseEvent event) {
        Window window = ((Node)event.getTarget()).getScene().getWindow();

        Point2D globalPos = new Point2D(event.getScreenX(), event.getScreenY());

        window.setX(globalPos.subtract(localCursorDif).getX());
        window.setY(globalPos.subtract(localCursorDif).getY());
    }

    private void previewCursor(MouseEvent event) {
        setCursor(Cursor.OPEN_HAND);
    }
}
