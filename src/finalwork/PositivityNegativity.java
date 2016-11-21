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
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author PrinceOfNightmareH
 */
public class PositivityNegativity {
    public void calculatePosNeg(File file, Map TfIdfPosMap, Map TfIdfNegMap){
        
        String line, tokenized;
        //Map stringMap = new HashMap();
        int pCount=0, nCount=0, totCount=0;
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            line = br.readLine();

            while (line != null) {

                //System.out.println(line);
                tokenized = tokenizeString(line);
                //System.out.println(tokenized
                double totPosValueOfLine = 0, totNegValueOfLine = 0;
                double totPositivityOfLine = 0, totNegitivityOfLine = 0;

                try {
                    //totPosValueOfLine = 0; totNegValueOfLine = 0;
                    String line1 = tokenized;

                    String[] words = line1.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        if (TfIdfPosMap.get(words[i]) != null ) {
                            double posValue = Double.valueOf(String.valueOf(TfIdfPosMap.get(words[i])));
                            //double negValue = Double.valueOf(String.valueOf(TfIdfNegMap.get(words[i])));
                            
                            totPosValueOfLine += posValue;
                            //totNegValueOfLine += negValue;
                            
                            //System.out.println(words[i] + " " + posValue);
                        }
                        if (TfIdfNegMap.get(words[i]) != null) {                            
                            //double posValue = Double.valueOf(String.valueOf(TfIdfPosMap.get(words[i])));
                            double negValue = Double.valueOf(String.valueOf(TfIdfNegMap.get(words[i])));
                            
                            //totPosValueOfLine += posValue;
                            totNegValueOfLine += negValue;
                            //System.out.println(words[i] + " " + negValue);
                        }
                        
                    }
                    //counter = counter + c;
                } catch (Exception e) {
                    System.out.println(e);
                }
                totPositivityOfLine = (totPosValueOfLine/(totPosValueOfLine+totNegValueOfLine)) * 100;
                totNegitivityOfLine = (totNegValueOfLine/(totPosValueOfLine+totNegValueOfLine)) * 100;
                
                totCount++;
                if(totPositivityOfLine>50){
                    //stringMap.put(line, 1);
                    pCount++;
                }else{
                    //stringMap.put(line, 0);
                    nCount++;
                }
                
                System.out.println(line + " has total positivity " + totPositivityOfLine + "% and total negativity " + totNegitivityOfLine + "% ");
                line = br.readLine();
            }

            //Map<String, String> sorted = new TreeMap<String, String>(map);
            //for (Object key : sorted.keySet()) {
                //System.out.println(key + " was used " + map.get(key)+ " times.");
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        float ap, an;
        ap = ((pCount/(float)totCount) * 100);
        an = ((nCount/(float)totCount) * 100);
        System.out.println("Total lines: " + totCount + ", positive lines: " + pCount + ", and negative lines: " + nCount + ", accuracy: for positive " + ap + ", accuracy: for negative " + an + ".");
    }
    
    public String tokenizeString(String text){

        StringTokenizer st = new StringTokenizer(text, ",.;:।!?'‘’()-— ");
        String text1 = "";
        while(st.hasMoreElements()){
            String s;
            s = st.nextToken();
            text1 = text1 + s + " ";
        }
        //System.out.println(text1);
        return text1;
    }
}
