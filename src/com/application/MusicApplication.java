package com.application;

import com.application.functions.Functions;
import com.application.sounds.Sound;

import javax.sound.sampled.LineUnavailableException;

import static java.lang.Math.round;

/*
 * Created by Guillaume ROCHE on 07/05/2023.
 * Email : guillaume.roche@reseau.eseo.fr
 * 
 * Project : Generated some music with functions
 */

public class MusicApplication {
    static long startTime = System.currentTimeMillis();
    static Sound sound;

    static {
        try {
            sound = new Sound();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws LineUnavailableException {
        Functions sbf = new Functions("sin(x/200)*300 + 500");
        Functions bf = new Functions("abs(cos(x/100)*400 + 100)");
        Functions mf = new Functions("abs(abs(x*200+10000)*(exp(-sin(x))-exp(cos(x))))");
        Functions hf = new Functions("13000+abs(sin(x/10)*100)");
        while (true) {
            int x = round((float) (System.currentTimeMillis() - startTime)/1000);
            System.out.println(x);
            if (x%3 == 0)
                sound.tone((int) sbf.calculate(x), 10, 0.5);

            sound.tone((int) bf.calculate(x), 10, 0.5);
            if (x%2 == 0)
                sound.tone((int) mf.calculate(x), 10, 0.4);

            if (x%3 == 0)
                sound.tone((int) hf.calculate(x), 10, 0.5);
        }
        //sound.close();
    }
}
