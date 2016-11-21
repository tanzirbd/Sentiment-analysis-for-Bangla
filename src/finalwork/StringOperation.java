/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author PrinceOfNightmareH
 */
public class StringOperation {
    private int counter=0;
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

    public String tokenizeStringForSentenceLength(String text){

        StringTokenizer st = new StringTokenizer(text, ",.;:'‘’()— ");
        String text1 = "";
        while(st.hasMoreElements()){
            String s;
            s = st.nextToken();
            text1 = text1 + s + " ";
        }
        //System.out.println(text1);
        return text1;
    }
    
    public Map bagOfWords(File file){
        
        String line, tokenized;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            line = br.readLine();

            while (line != null) {

                //System.out.println(line);
                tokenized = tokenizeString(line);
                //System.out.println(tokenized);

                try {

                    String line1 = tokenized;

                    String[] words = line1.split(" ");
                    int c=0;
                    for (int i = 0; i < words.length; i++) {
                        if (map.get(words[i]) == null) {
                            map.put(words[i], 1);
                        } else {
                            int newValue = Integer.valueOf(String.valueOf(map.get(words[i])));
                            newValue++;
                            map.put(words[i], newValue);
                        }
                        c++;
                    }
                    counter = counter + c;
                } catch (Exception e) {
                    System.out.println(e);
                }
                line = br.readLine();
            }
            //TreeMap<String, Integer> sortedMap = sortMapByValue(map);
            //System.out.println(sortedMap);

            //Map<String, String> sorted = new TreeMap<String, String>(map);
            //for (Object key : sorted.keySet()) {
                //System.out.println(key + " was used " + map.get(key)+ " times.");
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return map;
    }
    
    public int countWord(){
        return counter;
    }
    
    public static TreeMap<String, Double> sortMapByValue(HashMap<String, Double> map){
            Comparator<String> comparator = new ValueComparator(map);
            //TreeMap is a map sorted by its keys. 
            //The comparator is used to sort the TreeMap by keys. 
            TreeMap<String, Double> result = new TreeMap<String, Double>(comparator);
            result.putAll(map);
            return result;
    }
}
