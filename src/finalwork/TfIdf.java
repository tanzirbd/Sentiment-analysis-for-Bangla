/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalwork;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author PrinceOfNightmareH
 */
public class TfIdf {
    
    public Map calculateTf(Map wordMap, int totalWords){
        Map tfMap = new HashMap();
        for (Object key : wordMap.keySet()) {
            int wordCount = Integer.valueOf(String.valueOf(wordMap.get(key)));
            //System.out.println(wordCount);
            //System.out.println(totalWords);
            double TfOfWord = (wordCount/(double)totalWords);
            
            //System.out.println(TfOfWord);
            //System.out.println(key + " er Tf Value " + TfOfWord + " times.");
            tfMap.put(key, TfOfWord);
        }
        return tfMap;
    }
    
    public Map calculateIdf(Map posMap, Map negMap, Map totMap){
        
        Map idfMap = new HashMap();
        for (Object key1 : totMap.keySet()) {
            int n=0;
            for(Object key2: posMap.keySet()){
                if(key1==key2){
                    n++;
                    break;
                }
            }
            for(Object key3: negMap.keySet()){
                if(key1==key3){
                    n++;
                    break;
                }
            }
            idfMap.put(key1, Math.log(2/(double)n));
            //System.out.println(Math.log(2/(double)n));
        }
        return idfMap;
    }
    
    public Map calculateTfIdf(Map tfMap, Map idfMap){
        HashMap tfIdfMap = new HashMap();
        //Map<String, String> sorted = new TreeMap<String, String>(tfMap);
        for (Object key : tfMap.keySet()) {
            double tfIdf = Double.valueOf(String.valueOf(tfMap.get(key))) * Double.valueOf(String.valueOf(idfMap.get(key)));
            tfIdfMap.put(key, tfIdf);
            //System.out.println(key + " has TfIdf value " + tfIdf + " ");
        }
        StringOperation so = new StringOperation();
        TreeMap<String, Double> sortedMap = so.sortMapByValue(tfIdfMap);
        System.out.println(sortedMap);
        return tfIdfMap;
    }
}
