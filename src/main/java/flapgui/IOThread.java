package flapgui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.application.Platform;

public class IOThread extends Thread
{
    private FlapGUI gui;
    public IOThread(FlapGUI i){
        gui = i;
    }
    
    @Override 
    public void run(){
       BufferedReader reader = new BufferedReader(
                                                new InputStreamReader(gui.getProcess().getInputStream()));
        String line;
        try{
            while((line = reader.readLine()) != null && gui.getProcess().isAlive()) {
                gui.parseOutput(line);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        gui.updateTop();
                        gui.updateBottom();
                    }
                });
            }
            reader.close();
        } catch (final Exception e){
            e.printStackTrace();

        }
    }
}
