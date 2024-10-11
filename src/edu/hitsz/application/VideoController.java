package edu.hitsz.application;

public class VideoController {
    private static String MainVideo="src/videos/bgm.wav";
    private static String BossVideo="src/videos/bgm_boss.wav";
    private static String BombVideo="src/videos/bomb_explosion.wav";
    private static String GameOverVideo="src/videos/game_over.wav";
    private static String GetSupplyVideo="src/videos/get_supply.wav";

    private static String BulletHitVideo="src/videos/bullet_hit.wav";

    public static String getMainVideo() {
        return MainVideo;
    }

    public static String getBulletHitVideo() {
        return BulletHitVideo;
    }

    public static String getBossVideo() {
        return BossVideo;
    }

    public static String getBombVideo() {
        return BombVideo;
    }

    public static String getGameOverVideo() {
        return GameOverVideo;
    }

    public static String getGetSupplyVideo() {
        return GetSupplyVideo;
    }
}
