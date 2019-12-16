package lesson14.io.lesson15.test;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LaunchStatistic implements Serializable {  // если родительский класс реализует Serializable все его потомки могут быть сериализованы

    private int launchCount;
    private LocalDateTime lastLaunch;   // если хотим сериализовать объект другого класса нужно чтобы класс имплиметировал Serializable
    private String user;
    transient private String name = "LaunchStatistic"; // transient - значит не учавствует в сериализации ( востановится как значение по умолчанию)

    // уникальный идентификатор версии сериализованного класса,
    // записывается в поток при сериализации
    // При десериализации значение этого поля сравнивается с имеющимся у локального класса
    private static final long serialVersionUID = 1L;

    public boolean isFirstLaunch() {
        return launchCount == 0 && lastLaunch == null;
    }

    public void update() {
        launchCount++;
        lastLaunch = LocalDateTime.now();
        user = System.getProperty("user.name");
    }


    @Override
    public String toString() {
        return "LaunchStatistic{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
