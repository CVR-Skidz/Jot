package jotGenerator;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JotOutput extends HBox {
    private Circle bullet;
    private Rectangle border;
    private Label label;

    public static int OUTPUTS;


    public JotOutput(){
        super();

        ++OUTPUTS;

        style();

        insertBullet();
        insertContainer();
    }

    private void style(){
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(15);
    }

    private void insertBullet(){
        bullet = new Circle(25/2);
        bullet.setFill(Color.rgb(226,197,46));

        getChildren().add(bullet);
    }

    private void insertContainer(){
        VBox container = new VBox();

        label = new Label(Integer.toString(OUTPUTS));
        label.setMinSize(300,35);
        label.setFont(Font.font("Segoe UI", FontWeight.BOLD, 12));

        border = new Rectangle(0, 1);
        border.widthProperty().bind(label.widthProperty());
        border.setFill(Color.rgb(196,196,196));

        HBox.setHgrow(container, Priority.ALWAYS);

        container.getChildren().add(label);
        container.getChildren().add(border);

        getChildren().add(container);
    }
}
