import java.math.BigDecimal;
import allclasses.povelichenko.meme;


public class Main {

    public static void povelichenkomethod() {
        System.out.println();
        meme.printRandomMeme();

        System.out.println();
        System.out.println("Отдельно фраза: " + meme.getRandomPhrase());
        System.out.println("Отдельно звук: " + meme.getRandomSound());
    }

    public static void main(String[] args) {
        povelichenkomethod();
    }


}


