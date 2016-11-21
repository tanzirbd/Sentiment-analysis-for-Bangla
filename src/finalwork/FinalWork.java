/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author PrinceOfNightmareH
 */
public class FinalWork {
    
    //private Map TfIdfPosMap = new HashMap();
    //private Map TfIdfNegMap = new HashMap();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = null;
        //String line, tokenized;
        Map totMap = new HashMap();
        
        Map posMap = new HashMap();
        Map negMap = new HashMap();
        int countPos=0, countNeg=0;
        
        Map tfPosMap = new HashMap();
        Map tfNegMap = new HashMap();
        
        Map idfMap = new HashMap();
        
        Map TfIdfPosMap = new HashMap();
        Map TfIdfNegMap = new HashMap();
        
        
        JOptionPane.showMessageDialog(null, "Select text document with positive sentences-");

        //This is where we open the text file where positive sentences are written.
        try {
            FileOpener fo = new FileOpener();
            file = fo.openFile();
            
            StringOperation so1 = new StringOperation();
            
            posMap = so1.bagOfWords(file);
            totMap = posMap;
            countPos = so1.countWord()-1;
            System.out.println(countPos);
            
            TfIdf ti1 = new TfIdf();
            tfPosMap = ti1.calculateTf(posMap, countPos);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        JOptionPane.showMessageDialog(null, "Select text document with negative sentences-");

        //This is where we open the text file where negative sentences are written.
        try {
            FileOpener fo = new FileOpener();
            file = fo.openFile();
            
            StringOperation so2 = new StringOperation();
            
            negMap = so2.bagOfWords(file);
            totMap.putAll(negMap);
            countNeg = so2.countWord()-1;
            System.out.println(countNeg);
            
            TfIdf ti1 = new TfIdf();
            tfNegMap = ti1.calculateTf(negMap, countNeg);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        TfIdf ti2 = new TfIdf();
        idfMap = ti2.calculateIdf(posMap, negMap, totMap);
        TfIdfPosMap = ti2.calculateTfIdf(tfPosMap, idfMap);
        TfIdfNegMap = ti2.calculateTfIdf(tfNegMap, idfMap);
        
        
        
        JOptionPane.showMessageDialog(null, "Select text document with test sentences-");

        //This is where we open the text file where positive sentences are written.
        try {
            FileOpener fo = new FileOpener();
            file = fo.openFile();
            
            PositivityNegativity pn = new PositivityNegativity();
            pn.calculatePosNeg(file, TfIdfPosMap, TfIdfNegMap);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
}
