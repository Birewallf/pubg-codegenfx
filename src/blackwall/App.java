package blackwall;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class App {


    private String[] stringhashs = new String[] {
            "P040", "P042", "P043", "P044", "P045", "P049", "P050", "P051", "P052", "P053",
            "P054", "P080", "P081", "P083", "P084", "P087", "P089", "P090", "P091", "P092",
            "P112", "P113", "P114", "P115", "P116", "P117", "P118", "P119", "P122", "P124",
            "P126", "P135", "P138", "P139", "P140", "P144", "P145", "P146", "P147", "P148",
            "P150", "P151", "P152", "P153", "P154", "P155", "P156", "P158", "P160", "P161",
            "P162", "P163", "P164", "P165", "P166", "P167", "P168", "P173", "P174", "P175",
            "P176", "P177", "P178", "P182", "P183", "P184", "P185", "P186", "P187", "P190",
            "P191", "P197", "P198", "P199", "P201", "P202", "P203", "P204", "P205", "P206",
            "P207", "P208", "P209", "P210", "P211", "P212", "P213", "P214", "P215", "P216",
            "P217", "P218", "P219", "P220", "P221", "P222", "P223", "P224", "P225", "P226",
            "P227", "P228", "P229"
    };
    private ArrayList<String> hash = new ArrayList<>(Arrays.asList(stringhashs));

    @FXML
    private ToggleButton exit;

    @FXML
    TextField outputTF;
    private Random random = new Random();

    /**
     * Toggle Button Action */
    public void onActionToggle(){
        try {
            ArrayList<String> al = (ArrayList<String>) hash.clone(); 
            String out = "P153-";

            int i = random.nextInt (al.size());
            out += al.get(i) + "-";
            al.remove(i);

            i = random.nextInt (al.size());
            out += al.get(i) + "-";
            al.remove(i);

            i = random.nextInt (al.size());
            out += al.get(i);
            outputTF.setText(out);
        } catch (Exception ignore) {
            outputTF.setText("#err");
        }
    }

    /**
     * copy to clipboard
     */
    public void onActionCopy(){
        String str = outputTF.getText();
        StringSelection stringSelection = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    @FXML
    public void initialize() {
    }

    public void onExit() {
        System.exit(0);
    }
    public void onMin() {
        Stage stage = (Stage)exit.getScene().getWindow();
        // is stage minimizable into task bar. (true | false)
        stage.setIconified(true);
    }

}
