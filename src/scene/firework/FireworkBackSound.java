/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene.firework;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import music.MusicPlayer;

/**
 *
 * @author Ahmet Emin
 */
public class FireworkBackSound {

    public static Clip clip = null;

    public static void playMusic() {
        try {
            stopMusic();
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File("D:/projects/intelijidea/BirthdayProject/src/music/fireworkBackSound.wav"));

            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.loop(LOOP_CONTINUOUSLY);

            FloatControl gainControl
                    = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-5.0f); // Reduce volume by 10 decibels.
            clip.start();

        } catch (LineUnavailableException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void stopMusic() {
        if (clip != null && clip.isRunning()) {

            clip.stop();
        }
    }
}
