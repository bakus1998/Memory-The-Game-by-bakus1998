package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.io.FileNotFoundException;

public class myButton extends Button {
    boolean secondID =false;
    public static int sid=0;
    int id;
    int buttons_counter=0;
    public Images images = new Images();
    public Image buttonImage;
    int time=0;
    int extraPoint_counter=0;

    Timeline timel = new Timeline(new KeyFrame(Duration.millis(500), ev ->{
        time++;
        if (time == 1) {
            setCheck2();
            time = 0;
        }
    }));


    public myButton() throws FileNotFoundException {
        setPrefSize(120,120);
        buttons_counter++;
        id=sid;
        id++;
        sid=id;
        buttonImage = images.imagesArray.get(id-1);
        setStyle(style());


        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.GREEN);
        shadow.radiusProperty();

        setOnMouseMoved(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {

                setEffect(shadow);
            }
        });


        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (GameLayout.clickCount < 2) {
                    if (GameLayout.logic_first == false) {
                        timel.stop();
                        GameLayout.logic_first = true;
                        GameLayout.first_id = id;
                        GameLayout.arrayPosFirst = secondID;
                        GameLayout.how_many_movements++;
                        setImg();
                        setDisable(true);
                        GameLayout.clickCount++;
                        setStyle(darkStyle());
                        extraPoint_counter++;

                    } else {
                        GameLayout.clickCount++;
                        GameLayout.secound_id = id;
                        GameLayout.logic_first = false;
                        GameLayout.arrayPosSecond = secondID;
                        setImg();
                        setStyle(darkStyle());
                        if (GameLayout.first_id == GameLayout.secound_id) {
                            GameLayout.clickCount=0;
                            GameLayout.points += 1;
                            GameLayout.gameButtons.get(GameLayout.first_id - 1 + GameLayout.logic_grid).setImg();
                            GameLayout.gameButtons.get(GameLayout.first_id - 1).setImg();

                            GameLayout.gameButtons.get(GameLayout.first_id - 1 + GameLayout.logic_grid).setDisable(true);
                            GameLayout.gameButtons.get(GameLayout.first_id - 1).setDisable(true);
                            GameLayout.check_end_game[GameLayout.check_end_game_counter] = true;

                            GameLayout.check_end_game_counter++;

                            extraPoint_counter++;

                            if(GameLayout.gameButtons.get(GameLayout.first_id - 1 + GameLayout.logic_grid).extraPoint_counter==1 &&
                                    GameLayout.gameButtons.get(GameLayout.first_id - 1).extraPoint_counter==1){
                                System.out.println("EXTRA POINT");
                                int lol1=GameLayout.gameButtons.get(GameLayout.first_id - 1 + GameLayout.logic_grid).extraPoint_counter;
                                int lol2=GameLayout.gameButtons.get(GameLayout.first_id - 1).extraPoint_counter;
                                System.out.println("+logic; " + lol1 + " bez: " + lol2);
                                GameLayout.extraPoints++;
                            }
                            Main.check_end_game();

                        } else {
                            timel.setCycleCount(Animation.INDEFINITE);
                            timel.play();
                        }

                    }
                }
            }
        });


    }

    public void setCheck2(){
        timel.stop();
            if (GameLayout.arrayPosFirst == false) {
                GameLayout.gameButtons.get(GameLayout.first_id - 1 + GameLayout.logic_grid).deleteImg();
                GameLayout.gameButtons.get(GameLayout.first_id - 1 + GameLayout.logic_grid).setDisable(false);
                GameLayout.gameButtons.get(GameLayout.first_id - 1 + GameLayout.logic_grid).setStyle(style());
                GameLayout.clickCount=0;

            }

            if (GameLayout.arrayPosSecond == false) {
                GameLayout.gameButtons.get(GameLayout.secound_id - 1 + GameLayout.logic_grid).deleteImg();
                GameLayout.gameButtons.get(GameLayout.secound_id - 1 + GameLayout.logic_grid).setDisable(false);
                GameLayout.gameButtons.get(GameLayout.secound_id - 1 + GameLayout.logic_grid).setStyle(style());
                GameLayout.clickCount=0;
            }

            if (GameLayout.arrayPosFirst == true) {
                GameLayout.gameButtons.get(GameLayout.first_id - 1).deleteImg();
                GameLayout.gameButtons.get(GameLayout.first_id - 1).setDisable(false);
                GameLayout.gameButtons.get(GameLayout.first_id - 1).setStyle(style());
                GameLayout.clickCount=0;
            }

            if (GameLayout.arrayPosSecond == true) {
                GameLayout.gameButtons.get(GameLayout.secound_id - 1).deleteImg();
                GameLayout.gameButtons.get(GameLayout.secound_id - 1).setDisable(false);
                GameLayout.gameButtons.get(GameLayout.secound_id - 1).setStyle(style());
                GameLayout.clickCount=0;
            }
    }

    public void setImg(){
        setGraphic(new javafx.scene.image.ImageView(buttonImage));
    }

    public void deleteImg(){
        setGraphic(null);
    }

    public String style(){
        return "-fx-background-color:\n" +
                "        linear-gradient(#f0ff35, #75c300),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                "    -fx-background-radius: 6, 5;\n" +
                "    -fx-background-insets: 0, 1;\n" +
                "    -fx-background-radius: 40;\n"+
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-text-fill: #395306;"+
                "-fx-opacity: 1.0;";
    }

    public String darkStyle(){
        return "-fx-background-color:\n" +
                "        linear-gradient(#b8c630, #59a100),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #9fd435 45%, #6eb200 50%);\n" +
                "    -fx-background-radius: 6, 5;\n" +
                "    -fx-background-insets: 0, 1;\n" +
                "    -fx-background-radius: 40;\n"+
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-text-fill: #395306;"+
                "-fx-opacity: 1.0;";
    }

    public void setSid(int a){
        sid=a;
    }
}
