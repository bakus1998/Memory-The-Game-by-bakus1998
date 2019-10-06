package sample;

import java.io.Serializable;

public class SetScore implements Serializable {
    String nick = "";
    int min=0;
    int sec=0;
    int grid=0;
    int how_many_movements=0;

    int allPoints=0;
    String msg="";

    public SetScore(String nick,int how_many_movements,int min,int sec,int grid){
        this.nick=nick;
        this.how_many_movements=how_many_movements;
        this.min=min;
        this.sec=sec;
        this.grid=grid;

        int extra = GameLayout.extraPoints;

        allPoints+=100/min*grid;
        allPoints+=590/sec*grid;

        int countHow = (int) (Math.pow(grid, 2) / 2);
        allPoints+=200*grid;

        //odejmowanie 10 pkt za kazdy niepotrzebny ruch
        if(countHow!=how_many_movements){
            int a=how_many_movements-countHow;
            for(int i=0;i<=a;i++){
                allPoints-=10;
            }
        }

        allPoints+=extra*50;

    }

    public void setMsg(){
        int myMin = min-1;
        msg=nick + " (Score: " + allPoints + ", Time: " + myMin + "m " + sec + "s, grid: " + grid + "x" + grid + ")";
    }

}
