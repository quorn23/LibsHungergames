package me.libraryaddict.Hungergames.Managers;

import me.libraryaddict.Hungergames.Types.Extender;
import me.libraryaddict.Hungergames.Types.PlayerJoinThread;

public class MySqlManager extends Extender {
    public String SQL_USER = "";
    public String SQL_PASS = "";
    public String SQL_DATA = "";
    public String SQL_HOST = "";
    public boolean enabled = false;
    private PlayerJoinThread joinThread;

    public MySqlManager() {
        joinThread = new PlayerJoinThread(this, pm);
        joinThread.start();
        // joinThread.start();
        // quitThread.start();
        // pointsThread.start();*/
    }

    public PlayerJoinThread getPlayerJoinThread() {
        return joinThread;
    }

}
