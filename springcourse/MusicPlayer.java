package ru.kolikov.springcourse;

public class MusicPlayer {
    private String name;
    private int volume;
    private Music music;

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public  MusicPlayer(Music music) {
       this.music=music;
    }
    public void playMusicList() {
        System.out.println("Playing " + music.getSong());
    }
}
