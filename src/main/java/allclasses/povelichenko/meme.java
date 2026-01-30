package allclasses.povelichenko;
import java.util.List;
import java.util.Random;

public class meme {
    private static final Random RANDOM = new Random();

    private static final List<String> PHRASES = List.of(
            "Когда понял задачу… но уже после дедлайна",
            "Я не тупой — я в кэш просто не попал",
            "Это не баг, это фича!",
            "Сейчас бы в прод… да рано ещё",
            "Код не работает? Добавь println!"
    );

    private static final List<String> SOUNDS = List.of(
            "Бум!",
            "Пщщщ!",
            "Клак-клак!",
            "Вжух!",
            "Трынь!"
    );

    public static String getRandomPhrase() {
        return PHRASES.get(RANDOM.nextInt(PHRASES.size()));
    }

    public static String getRandomSound() {
        return SOUNDS.get(RANDOM.nextInt(SOUNDS.size()));
    }

    public static void printRandomMeme() {
        System.out.println("Фраза: " + getRandomPhrase());
        System.out.println("Звук: " + getRandomSound());
    }
}
