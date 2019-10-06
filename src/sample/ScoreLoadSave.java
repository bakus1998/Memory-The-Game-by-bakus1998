package sample;

import java.io.*;
import java.util.*;

public class ScoreLoadSave {
    static ArrayList<SetScore> array = new ArrayList<>();


    public static void saveScore() throws IOException {
        FileOutputStream fos = new FileOutputStream("score.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(array);
        oos.close();
        fos.close();
    }

    public static void loadScore() throws IOException{
        ArrayList<SetScore> loadarray;
        FileInputStream fis = new FileInputStream("score.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            loadarray = (ArrayList<SetScore>) ois.readObject();
            ois.close();
            fis.close();
            array=loadarray;
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Collections.sort(array,SetScoreComparator);
    }

    public static Comparator<SetScore> SetScoreComparator = new Comparator<SetScore>() {
        @Override
        public int compare(SetScore o1, SetScore o2) {
            if(o1.allPoints>o2.allPoints){
                return -1;
            }else if(o1.allPoints<o2.allPoints){
                return 1;
            }else{
                return 0;
            }
        }
    };


}
