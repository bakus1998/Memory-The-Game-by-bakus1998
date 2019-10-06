package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;


public class Main extends Application {
    static public Stage window;
    SetGridSize setgridsize = new SetGridSize();
    Scene gamewindow;
    GameLayout gameboard;
    BorderPane bp_gamewindow = new BorderPane();
    static Label timer_game_task = new Label("Time: 0min 0sec");
    static TimerTask task = new TimerTask(); //thread

    //Rank window
    static BorderPane bp_rank = new BorderPane();
    static Scene rank_scene = new Scene(bp_rank,300,200);

    //score
    Stage secondStage;
    SetScore myscore;

    //shortcut
    KeyCombination kc = new KeyCodeCombination(KeyCode.Q,KeyCombination.SHIFT_ANY,KeyCombination.CONTROL_ANY);
    Runnable rn = ()-> {
        Alert exit_alert = new Alert(Alert.AlertType.INFORMATION);
        exit_alert.setTitle("Exit game!");
        exit_alert.setContentText("You turned off the game before the end!");
        exit_alert.showAndWait();
        System.exit(0);
    };


    @Override
    public void start(Stage primaryStage) throws Exception {
        ScoreLoadSave.loadScore();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Text title = new Text("Memory The Game!");
        title.setFont(Font.font(30));
        Label l = new Label("by s16696 Krzysztof Baka");

        BorderPane bp = new BorderPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.getChildren().add(title);
        vbox.getChildren().add(l);

        //buttons
        Button button_newgame = new Button("New Game");
        button_newgame.setPrefSize(150, 50);
        Button button_highscore = new Button("High Scores");
        button_highscore.setPrefSize(150, 40);
        Button button_exit = new Button("Exit");
        button_exit.setPrefSize(150, 40);

        button_newgame.setStyle(
                "-fx-background-color:\n" +
                        "        linear-gradient(#f0ff35, #a9ff00),\n" +
                        "        radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                        "    -fx-background-radius: 6, 5;\n" +
                        "    -fx-background-insets: 0, 1;\n" +
                        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                        "    -fx-text-fill: #395306;");

        button_highscore.setStyle(
                "-fx-background-color: \n" +
                        "        #090a0c,\n" +
                        "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                        "        linear-gradient(#20262b, #191d22),\n" +
                        "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                        "    -fx-background-radius: 5,4,3,5;\n" +
                        "    -fx-background-insets: 0,1,2,0;\n" +
                        "    -fx-text-fill: white;\n" +
                        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                        "    -fx-font-family: \"Arial\";\n" +
                        "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                        "    -fx-font-size: 12px;\n" +
                        "    -fx-padding: 10 20 10 20;");

        button_exit.setStyle(
                "-fx-background-color: \n" +
                        "        #090a0c,\n" +
                        "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                        "        linear-gradient(#20262b, #191d22),\n" +
                        "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                        "    -fx-background-radius: 5,4,3,5;\n" +
                        "    -fx-background-insets: 0,1,2,0;\n" +
                        "    -fx-text-fill: white;\n" +
                        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                        "    -fx-font-family: \"Arial\";\n" +
                        "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                        "    -fx-font-size: 12px;\n" +
                        "    -fx-padding: 10 20 10 20;");

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.GREEN);
        shadow.radiusProperty();

        button_newgame.setOnMouseMoved(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                button_newgame.setEffect(shadow);
            }
        });
        button_highscore.setOnMouseMoved(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                button_highscore.setEffect(shadow);
            }
        });
        button_exit.setOnMouseMoved(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                button_exit.setEffect(shadow);
            }
        });


        //exit_button OnAction i Alert zamykania aplikacji
        Alert acceptExit = new Alert(Alert.AlertType.CONFIRMATION);
        acceptExit.setTitle("Exit?");
        String alertMsg = "Are you sure you want to exit this game ?";
        acceptExit.setContentText(alertMsg);
        button_exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Optional<ButtonType> result = acceptExit.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.exit(0);
                }
            }
        });


        button_newgame.setEffect(shadow);
        GridPane gp_buttons = new GridPane();
        gp_buttons.setAlignment(Pos.CENTER);
        gp_buttons.setVgap(8.0);
        gp_buttons.add(button_newgame, 0, 0);
        gp_buttons.add(button_highscore, 0, 1);
        gp_buttons.add(button_exit, 0, 2);
        bp.setTop(vbox);
        bp.setCenter(gp_buttons);
        window = primaryStage;
        window.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

        //Scene strona glowna
        Scene scene = new Scene(bp, 650, 320);
        window.setScene(scene);
        window.setTitle("Memory the game by s16696");
        window.setResizable(false);
        window.show();
        try (FileInputStream fisIcon = new FileInputStream("images\\icon.png")) {
            window.getIcons().add(new Image(fisIcon));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


        //Scene gridsize
        BorderPane grid_bp = new BorderPane();
        Scene grid_scene = new Scene(grid_bp, 350, 150);

        button_newgame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(grid_scene);
                window.setTitle("New game");
            }
        });


        HBox grid_hbox = new HBox();
        grid_hbox.setAlignment(Pos.CENTER);
        Label grid_label = new Label("Select grid size: ");
        Spinner<Integer> dblSpinner = new Spinner<>(2, 6, 4, 1);
        grid_hbox.getChildren().add(grid_label);
        grid_hbox.getChildren().add(dblSpinner);
        grid_bp.setCenter(grid_hbox);

        Button grid_play = new Button("Play!");
        HBox grid_hbox_button = new HBox();
        grid_hbox_button.setAlignment(Pos.CENTER);
        grid_hbox_button.getChildren().add(grid_play);
        grid_play.setPrefSize(300, 40);
        grid_bp.setBottom(grid_hbox_button);

        grid_play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean check = setgridsize.checkGrid(dblSpinner.getValue());
                if (check) {
                    gameboard = new GameLayout(setgridsize.grid_size);
                    bp_gamewindow.setCenter(gameboard);
                    window.setScene(gamewindow);
                    window.setTitle("Game");
                    task.start();

                } else {
                    Alert error_grid_size = new Alert(Alert.AlertType.ERROR);
                    error_grid_size.setTitle("Error");
                    String alertMsg = "Please change grid size! The number must be even and less than 7!";
                    error_grid_size.setContentText(alertMsg);
                    error_grid_size.showAndWait();
                }
            }
        });


        {//button grid_play Styl i shadow
            grid_play.setStyle(
                    "-fx-background-color:\n" +
                            "linear-gradient(#f0ff35, #a9ff00),\n" +
                            "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                            "-fx-background-radius: 6, 5;\n" +
                            "-fx-background-insets: 0, 1;\n" +
                            "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                            "-fx-text-fill: #395306;");

            grid_play.setOnMouseMoved(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    grid_play.setEffect(shadow);
                }
            });


        }

        //Game Window
        HBox hb_gamewindow = new HBox(); // for label
        hb_gamewindow.setAlignment(Pos.CENTER);
        hb_gamewindow.getChildren().add(timer_game_task);
        bp_gamewindow.setBottom(hb_gamewindow);
        gamewindow = new Scene(bp_gamewindow);
        Main.timer_game_task.setFont(Font.font(20));
        gamewindow.getAccelerators().put(kc,rn);



        //Rank window
        VBox vbox_rank = new VBox();
        Button button_vrank = new Button("Accept");
        TextField textfield_rank = new TextField("Player nickname");
        Label label_rank = new Label("Set your nickname: ");
        vbox_rank.setAlignment(Pos.CENTER);
        vbox_rank.getChildren().add(label_rank);
        vbox_rank.getChildren().add(textfield_rank);
        vbox_rank.getChildren().add(button_vrank);
        vbox_rank.setSpacing(20.0);
        Main.bp_rank.setCenter(vbox_rank);

        button_vrank.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nickname = "";
                nickname=textfield_rank.getText().toString();
                myscore = new SetScore(nickname,GameLayout.how_many_movements,TimerTask.min+1,TimerTask.sec,GameLayout.grid_to_score);
                myscore.setMsg();
                ScoreLoadSave.array.add(myscore);

                Alert scoreAlert = new Alert(Alert.AlertType.INFORMATION);
                scoreAlert.setTitle("End Game!");
                scoreAlert.setContentText("Your score: " + myscore.allPoints + ", your game time: " + TimerTask.min + "min " + TimerTask.sec + "sec, grid: " + GameLayout.grid_to_score + "x" + GameLayout.grid_to_score);
                scoreAlert.showAndWait();

                try {
                    ScoreLoadSave.saveScore();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.exit(0);
            }
        });

        //HighScore Window
        BorderPane bp_highscore = new BorderPane();
        Scene highscore_scene = new Scene(bp_highscore,400,200);
        ListView lv = new ListView<>();
        for(int i=0;i<ScoreLoadSave.array.size();i++){
            int a=i+1;
            lv.getItems().add(a+ ". " + ScoreLoadSave.array.get(i).msg);
        }
        bp_highscore.setCenter(lv);

        button_highscore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                secondStage = new Stage();
                secondStage.setResizable(false);
                secondStage.setTitle("HighScore!");
                secondStage.setScene(highscore_scene);
                secondStage.show();
            }
        });

    }


    public static void main(String[] args) {
        launch(args);
    }


    public static void check_end_game() {
        int count=0;
        for(int i=0;i<GameLayout.check_end_game.length;i++){
            if(GameLayout.check_end_game[i]==true){
                count++;
            }
            if(count==GameLayout.check_end_game.length){
                task.stop();
                Main.window.setScene(Main.rank_scene);

            }
        }
    }

}
