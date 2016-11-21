/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalwork;

import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author PrinceOfNightmareH
 */
class ValueComparator implements Comparator<String> {

    HashMap<String, Double> map = new HashMap<String, Double>();
 
	public ValueComparator(HashMap<String, Double> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(String s1, String s2) {
		if(map.get(s1) >= map.get(s2)){
			return -1;
		}else{
			return 1;
		}	
	}
}
