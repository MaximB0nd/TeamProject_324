package allclasses.golubev;

public class Piano {

    private float volume; // громкость от 0.0 (тихо) до 10.0 (максимум)

    public float getVolume() {
        return volume;
    }

    public Piano() {
        volume = 5.0f; // средняя громкость по умолчанию
    }

    public Piano(float initialVolume) {
        volume = initialVolume;
        normalizeVolume();
    }

    private void normalizeVolume() {
        if (volume > 10.0f) {
            volume = 10.0f;
        } else if (volume < 0.0f) {
            volume = 0.0f;
        }
    }

    public void increaseVolume() {
        volume += 1.0f;
        normalizeVolume();
    }

    public void decreaseVolume() {
        volume -= 1.0f;
        normalizeVolume();
    }

    public void increaseVolume(float amount) {
        volume += amount;
        normalizeVolume();
    }

    public void decreaseVolume(float amount) {
        volume -= amount;
        normalizeVolume();
    }

    public void setVolume(float value) {
        volume = value;
        normalizeVolume();
    }
}