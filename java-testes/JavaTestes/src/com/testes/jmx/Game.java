package com.testes.jmx;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

public class Game implements GameMBean {
 
    private String playerName;
 
    @Override
    public void playFootball(String clubName) {
        System.out.println(
          this.playerName + " playing football for " + clubName);
    }
 
    @Override
    public String getPlayerName() {
        System.out.println("Return playerName " + this.playerName);
        return playerName;
    }
 
    @Override
    public void setPlayerName(String playerName) {
        System.out.println("Set playerName to value " + playerName);
        this.playerName = playerName;
    }
    
    
    public static void main(String[] args) {
    	
    	ObjectName objectName = null;
    	try {
    	    objectName = new ObjectName("com.testes.jmx:type=basic,name=game");
    	} catch (MalformedObjectNameException e) {
    	    e.printStackTrace();
    	}
    	
    	while (true) {
    	}
	}
}

interface GameMBean {
	 
    public void playFootball(String clubName);
 
    public String getPlayerName();
 
    public void setPlayerName(String playerName);
 
}
