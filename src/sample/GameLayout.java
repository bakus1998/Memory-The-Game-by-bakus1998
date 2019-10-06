package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameLayout extends GridPane {
    int buttoncounter = 0;
    static ArrayList<myButton> gameButtons = new ArrayList<>();
    boolean placeCheck[][];
    boolean statusPlace = true;

    //GameLOGIC
    static boolean logic_first=false;
    static boolean arrayPosFirst=false;
    static boolean arrayPosSecond=false;
    static int first_id;
    static int secound_id;
    static int points;
    static int logic_grid=0;
    static boolean check_end_game[];
    static int check_end_game_counter=0;
    static int how_many_movements=0;
    static int grid_to_score;
    static int clickCount=0;
    static int extraPoints=0;

    public GameLayout(int grid) {
        setHgap(8);
        setVgap(8);
        setPadding(new Insets(20, 10, 20, 10));
        check_end_game=new boolean[(int) (Math.pow(grid, 2) / 2)];
        grid_to_score=grid;



        for(int i=0;i<check_end_game.length;i++){
            check_end_game[i]=false;
        }

        placeCheck = new boolean[grid][grid];

        for (int i = 0; i < placeCheck.length; i++) {
            for (int j = 0; j < placeCheck[i].length; j++) {
                placeCheck[i][j] = false;
            }
        }

        int howButton = (int) (Math.pow(grid, 2) / 2);
        logic_grid=howButton;

        for (int i = 0; i < howButton; i++) {
            try {
                gameButtons.add(new myButton());
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            gameButtons.get(i).secondID =true;
        }


        for (int i = 0; i < howButton; i++) {
            if(i==0){
                gameButtons.get(gameButtons.size()-1).setSid(0);
            }
            try {
                gameButtons.add(new myButton());
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }

        }

        while (statusPlace==true){
            if(buttoncounter<gameButtons.size()){
                boolean check_in = true;
                while(check_in){
                    int gridix=grid;
                    int posa = (int) (Math.random() * gridix);
                    int posb = (int) (Math.random() * gridix);
                    if (placeCheck[posa][posb] == false) {
                        placeCheck[posa][posb] = true;
                        add(gameButtons.get(buttoncounter),posa,posb);
                        buttoncounter++;
                        check_in=false;
                    }
                }
            }else{
                statusPlace=false;
            }
        }
    }
}

