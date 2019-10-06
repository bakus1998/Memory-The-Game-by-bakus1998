package sample;

public class SetGridSize {
    public int grid_size=0;

    public SetGridSize(){
    }

    public void set_int(int a){
        grid_size=a;
    }

    public boolean checkGrid(int a){
        if(a%2!=0||a>6){
            return false;
        }else{
            set_int(a);
            return true;
        }
    }

}
