package com.application.sounds;

import javax.sound.sampled.*;
public class Sound
{
    public static float SAMPLE_RATE = 8000f;
    SourceDataLine sdl;
    byte[] buf = new byte[1];

    public Sound()
            throws LineUnavailableException
    {
        AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
        this.sdl = AudioSystem.getSourceDataLine(af);
        this.sdl.open(af);
        this.sdl.start();
    }

    public void tone(int hz, int msecs, double vol)
            throws LineUnavailableException{
        for (int i=0; i < msecs*8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            this.buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
            this.sdl.write(buf, 0, 1);
        }
    }

    public void close() {
        this.sdl.drain();
        this.sdl.stop();
        this.sdl.close();
    }
}
