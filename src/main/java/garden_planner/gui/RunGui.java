package garden_planner.gui;

/**
 * Run this class to start up the GUI.
 */
public class RunGui {
    public static void main(String[] args) {
        /* IMPORTANT if you use a lab computer
        * If you use your own computers, please ignore this
        * The lab computers have very strong protection and the default user folder is disabled for cache reading/writing.
        * To make JAVAFX work, do the following steps:
        * (1) Create a folder with your username in C:\Scratch, e.g. UFOLDER
        * (2) Create a subfolder .openjfx
        * (3) Create a subfolder cache
        * (4) Enable the next statement and update the folder name from UFOLDER to your username
        **/
        //System.setProperty("javafx.cachedir", "C:\\Scratch\\UFOLDER\\.openjfx\\cache");

        // Run the standard implementation
        GuiMain.main(args);

        // Run the implementation with the optional requirements
        // GuiMainOpt.main(args);
    }
}
