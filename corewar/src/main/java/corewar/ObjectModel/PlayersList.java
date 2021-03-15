package corewar.ObjectModel;

import java.util.ArrayList; 

public class PlayersList{

  protected ArrayList<Player> playersList;

  public PlayersList(){
    this.playersList = new ArrayList<Player>();
  }

  public void add(Player player){
    if(isInList(player)){
      System.err.println("player already in list");
      System.out.println(this.toString());
      System.out.println(player.toString());
    }else{
      this.playersList.add(player);
    }
  }

  /*
    Retourne le joueur de la liste avec l'index donné en paramètre
    * {int} index: Position du joueur dans la position 
    * return {Player} si le joueur n'est pas trouvé renvoie null
  */
  public Player getByIndex(int index){
    if(index<0 && index>=playersList.size()){
      System.err.println("index "+index+" in players list out of bound");
      System.out.print(this.toString());
      return null;
    }
    return this.playersList.get(index);
  }

  /*
    Retourne le joueur de la liste avec l'id donné en paramètre
    * {int} ID 
    * return {Player} si le joueur n'est pas trouvé renvoie null
  */
  public Player getByID(int ID){
    Player player = null;
    int index = 0;
    boolean founded = false;

    do{
      Player currentPlayer = playersList.get(index);
      if(currentPlayer.getID()==ID){
        player = currentPlayer;
        founded = true;
      }
      index++;
    }while(!founded);
    
    if(!founded){
      System.err.println("Player "+ID+" not founded");
      System.out.print(this.toString());
    }
    return player;
  }

  public boolean isInList(Player player){
    return this.getByID(player.getID())!=null;
  }

  public int getSize(){
    return this.playersList.size();
  }

  @Override
  public String toString(){
    String toReturn = "";
    toReturn+="Players list info : \n";
    toReturn+="Size = "+this.getSize()+"\n";
    for(int x=0;x<this.getSize();x++){
      toReturn+="Player index n°"+x+" = "+this.getByIndex(x).toString()+"\n";
    }
    return toReturn;
  }
}