import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ViewFile extends JFrame {
    private JButton btn1;
    private JTextArea txtArea;
    private JPanel PanelMain;

    public static void main(String[] args) {
        ViewFile viewFile = new ViewFile();
    }
    public ViewFile(){
       setContentPane(PanelMain);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);
        setTitle("Text File View");
        btn1.addActionListener(e -> openFile());
    }
    public void openFile(){
        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(this);
        File selectedFile = fc.getSelectedFile();
        if (result == JFileChooser.APPROVE_OPTION) {
            System.out.println("User opened file: "+selectedFile.getPath());
        } else {
            System.out.println("User did not select any file.");
            System.out.println("User selected Storno/Cancel.");
        }
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader(selectedFile)))){
            String storeText= "";
            while(sc.hasNextLine()){
            String lines = sc.nextLine()+ "\n";
            storeText = storeText + lines;
            }
            txtArea.setText(storeText);
            txtArea.setLineWrap(true);
            txtArea.setWrapStyleWord(true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

