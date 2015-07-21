/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package castille;
import java.util.*;

// @author Danielle

public class Mob{
    
    int strength, expertise, hardiness, evasiveness, guile, maxHealth, 
            special, level, currentHealth, i, j, numToAdd;
    String name;
    Random t;
    char[] nameLetters;
    
    public Mob(){try{
        //create a new mob
        
        t = new Random();
        strength = 1 + t.nextInt(100);
        expertise = 1 + t.nextInt(100);
        hardiness = 1 + t.nextInt(100);
        evasiveness = 1 + t.nextInt(100);
        special = 1 + t.nextInt(100);
        guile = 1 + t.nextInt(100);
        maxHealth = 1 + t.nextInt(100);
        currentHealth = maxHealth;
        level = 1;
        name = "";
        if(t.nextInt(100) < 80){ //80% chance of consonant at start
            genConsonant();
        }
        else
            genVowel(); 
        nameLetters = new char[1] ;
        nameLetters = name.toCharArray();
        nameLetters[0] = Character.toUpperCase(nameLetters[0]);
        name = new String(nameLetters);
        
        //printMobStats();//disable later
    }catch(Exception ex){System.out.println(ex.getMessage());}
    } //make a random one
    
    void genConsonant(){try{
        Boolean go;
        int ch;
        numToAdd = 1 + t.nextInt(3);
        for(i = 0; i < numToAdd; i++){
            go = true;
            while (go){
                ch = 1 + t.nextInt(26);
                if (ch == 5 || ch == 9 || ch == 15 || ch == 1 || ch ==  21) //if vowel
                    go = true;
                else{
                    name = name + (char)(ch + 96);
                    go = false;
                }
            }
        }
        j = t.nextInt(100);
        if ((name.length() < 6) || ( j < 50)) 
            //if its over 5 in length, 50% chance of termination, else we continue:
            genVowel();
    }catch(Exception ex){ex.printStackTrace();}
    }
    
     void genVowel(){try{
        Boolean go;
        int ch;
        numToAdd = 1 + t.nextInt(2);
        for(i = 0; i < numToAdd; i++){
            go = true;
            while (go){
                ch = 1 + t.nextInt(26);
                if (!(ch == 5 || ch == 9 || ch == 15 || ch == 1 || ch ==  21)) //if NOT vowel
                    go = true;
                else{
                    name = name + (char)(ch + 96);
                    go = false;
                }
            }
        }
        j = t.nextInt(100);
        if ((name.length() < 6) || ( j < 50)) 
            //if its over 5 in length, 50% chance of termination, else we continue:
            genConsonant();
    }catch(Exception ex){ex.printStackTrace();}
    }
    
    void printMobStats(){
        System.out.println("Mob stats: Name: \"" + name + "\" St: " + strength + " Ex: " + 
                expertise + " H: " + hardiness + " Ev: " + evasiveness + 
                " Sp " + special + " G " + guile + " MH " + maxHealth + " CH: " +
                currentHealth);
    }
    
    public void lowerHealth(int amount){
        currentHealth -= amount;
    }
}
