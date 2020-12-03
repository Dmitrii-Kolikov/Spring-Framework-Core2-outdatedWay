package ru.kolikov.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicattionContext.xml"
        );
        //scope prototype-который каждый раз создает новый объект при вызове getBean.
       MusicPlayer firstClassicalMusic = context.getBean("musicPlayer", MusicPlayer.class);
       MusicPlayer secondClassicalMusic = context.getBean("musicPlayer", MusicPlayer.class);
       boolean properties1 = firstClassicalMusic==secondClassicalMusic; //prototype
        System.out.println(properties1); //проверяем ссылаются ли объекты на одну ссылку. false
        firstClassicalMusic.setName("Sergey"); //меняем значение
        firstClassicalMusic.setVolume(50); //меняем значение
        System.out.println(firstClassicalMusic.getName());   // Sergey
        System.out.println(firstClassicalMusic.getVolume());  // 50
        System.out.println(secondClassicalMusic.getName());   // Dmitrii
        System.out.println(secondClassicalMusic.getVolume());  // 20


        //Scope-singleton (по умолчанию)
       MusicPlayer firstRockMusic = context.getBean("musicPlayer1", MusicPlayer.class);
       MusicPlayer secondRockMusic = context.getBean("musicPlayer1", MusicPlayer.class);
        boolean properties2 = firstRockMusic==secondRockMusic;  //singleton
        System.out.println(properties2); //проверяем ссылаются ли объекты на одну ссылку. true
        firstRockMusic.setName("Aleksey"); //меняем значение
        firstRockMusic.setVolume(30);  //меняем значение
        System.out.println(firstRockMusic.getName()); //Aleksey
        System.out.println(firstRockMusic.getVolume()); //30
        System.out.println(secondRockMusic.getName()); //Aleksey
        System.out.println(secondRockMusic.getVolume()); //30



        context.close();

    }
}
