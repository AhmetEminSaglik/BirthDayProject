package music;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {

    public static Clip clip = null;
    static int clipLoop;
    static float volume;

    public static void playMusic(String musicPath) {
        try {
            stopMusic();
            AudioInputStream stream = AudioSystem.getAudioInputStream(new File(musicPath));

            clip = AudioSystem.getClip();
            clip.open(stream);
            clip.start();
            clip.loop(clipLoop);

            FloatControl gainControl
                    = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volume); // Reduce volume by 10 decibels.
            clip.start();

        } catch (LineUnavailableException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void setLoopContinuously() {
        clipLoop = Clip.LOOP_CONTINUOUSLY;
    }

    static void setLoopOneTime() {
        clipLoop = 0;
    }

    public static String getCakeMusicPath() {
        setLoopContinuously();
        volume = 0.0f;
//        return "src/music/happyBirthDayToYou.wav";
        return "src/music/birthday-gursel.wav";
    }

    public static String getSnowMusicPath() {
        volume = 6.0f;
        setLoopContinuously();
        return "src/music/RiverFlowsinYou.wav";
    }

    public static String getfireworkMusicPath() {
        setLoopOneTime();
        volume = 5.0f;
        return "src/music/firework.wav";
    }

    public static void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}
