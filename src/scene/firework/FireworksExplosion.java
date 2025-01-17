package scene.firework;

import animationwaitingtime.AnimationWaitingTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.application.Platform;
import music.MusicPlayer;

public class FireworksExplosion {

    Firework firework;
    List<PieceOfFirework> pieceList = new ArrayList<PieceOfFirework>();
    double angle;

    public FireworksExplosion(Firework firework) {
        this.firework = firework;
        angle = (360.0 / firework.getNumberOfPieces());
        addAngleToThePieces();
    }

    void addAngleToThePieces() {
        int random = new Random().nextInt(3);
        for (int i = 0; i < firework.getNumberOfPieces(); i++) {

            PieceOfFirework pieceOfFirework = new PieceOfFirework(firework, random + 3, random + 3);

            pieceOfFirework.setAngle(angle * i);
            pieceList.add(pieceOfFirework);

        }
    }

    public void explode() {
        try{
        MusicPlayer.playMusic(MusicPlayer.getfireworkMusicPath());
        }catch (IllegalArgumentException e){
            System.err.println("FIREWORK DID NOT HAVE SOUND");
        }
        int slowMotion = 150;
        double burstTotalPower = (firework.getHeightPower() / 3 + firework.getWidthPower()) / slowMotion;
//        burstTotalPower /= slowMotion;


        for (int j = 0; j < slowMotion; j++) {
            new AnimationWaitingTime().wait(5);
//            new Thread(e -> {
                for (int i = 0; i < pieceList.size(); i++) {


                    pieceList.get(i).spreadAround(burstTotalPower);

                }
//            });

        }
        fallOfPieces();
    }

    void fallOfPieces() {
        int slowMotion = 100;
        double rate = 1.0 / slowMotion;
        double opacityDegree = 1;

        for (int j = 0; j < slowMotion; j++) {
            new AnimationWaitingTime().wait(8);
            for (int i = 0; i < pieceList.size(); i++) {

                pieceList.get(i).fallDown();

            }
            opacityDegree -= rate;
            hidePieces(opacityDegree);
        }

    }

    void hidePieces(double opacityDegree) {
        Platform.runLater(() -> {
            for (int i = 0; i < pieceList.size(); i++) {
                pieceList.get(i).setOpacity(opacityDegree);
            }
        });

    }

    public List<PieceOfFirework> getPieceList() {
        return pieceList;
    }

    public void setPieceList(List<PieceOfFirework> pieceList) {
        this.pieceList = pieceList;
    }

}
