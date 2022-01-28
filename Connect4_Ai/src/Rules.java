public class Rules
{
  private Spielfeld f;
  private Stein[] win_safe; 
  private int win_player;
  public Rules(Spielfeld feld)
  {
       this.f=feld;
       win_safe=new Stein[2];
       win_player=0;
  }

  public int win_player(){
    return win_player;
  }
  
  public int[] format_move(int pos_x,int pos_y){
      int[] count =  new int[2];
      for(int k = 100; k < ZEICHENFENSTER.gibFenster().get_hoehe();k+=100){
        if(pos_y > k - 100 && pos_y < k){
            break;
        }else{
           count[1]++;
        }
      }
      for(int i =100; i <ZEICHENFENSTER.gibFenster().get_breite();i+=100){
          if(pos_x > i - 100 && pos_x < i){
              break;
          }else{
             count[0]++;
          }
      }
      return count;
  }
  private boolean already_occupied(int pos_x,int pos_y){
    if(f.get_Spielfeld()[pos_x][pos_y] == null){
        return false;          
    }
    return true;
  }
  public int get_lowest(int pos_x){
    int lowest = 0;
    for (int i = 0; i < f.get_Spielfeld()[pos_x].length;i++){
        if(!already_occupied(pos_x,i)){
              lowest=i;
        }else{
            break;
        }
    }
    return lowest;
  }
    

  public void draw_fall(int x,int y, int farbnr){
    for(int  i = 0; i <= y;i++){
        ZEICHENFENSTER.gibFenster().fuelleKreis((x*100)+50, (i*100)-50, 40, farbnr);
        ZEICHENFENSTER.gibFenster().warte(100);
        ZEICHENFENSTER.gibFenster().loescheKreis((x*100)+50,(i*100)-50, 40);
    }
  }
  public void draw_win_line(Stein[] pos){
      ZEICHENFENSTER.gibFenster().zeichneStrecke(pos[0].get_Stein()[0], pos[0].get_Stein()[1], pos[1].get_Stein()[0], pos[1].get_Stein()[1]);
    }
  public Stein[] get_win_stone(){
      return win_safe;
  }
  public boolean get_valid_input(int pos_x,int pos_y){
       return !already_occupied(pos_x, pos_y);
  }
  public boolean game_won(Stein [][] my_board){
       if(check_vertikal(my_board)|| check_horizontal(my_board) || check_diagonal_right_to_left(my_board)|| check_diagonal_left_to_right(my_board)){
           return true;
       }
        return false;
  }
  //Unentschieden
  public boolean tie(Stein [][] board){
      for(int i =0;i < board.length;i++){
          for(int k =0;k < board[i].length;k++){
              if(board[i][k]==null){
                  return false;
              }
            }
      }
      return true;
  }
  private boolean check_vertikal(Stein[][] board){
      for(int i =0;i < board.length-3;i++){
          for(int k =0;k < board[i].length;k++){
              try{
                  if(board[i][k].get_Stein()[3] == board[i+1][k].get_Stein()[3] && board[i+2][k].get_Stein()[3] == board[i+3][k].get_Stein()[3] && board[i][k].get_Stein()[3]==board[i+3][k].get_Stein()[3]){
                      win_safe[0] = board[i][k];
                      win_safe[1] = board[i+3][k];
                      return true;
                    }
              }catch(Exception e){
                  ;
                }
            }
        }
      return false;
  }
  private boolean check_horizontal(Stein[][] board){
      for(int i =0;i < board.length;i++){
          for(int k =0;k < board[i].length-3;k++){
              try{
                  if(board[i][k].get_Stein()[3] == board[i][k+1].get_Stein()[3] && board[i][k+2].get_Stein()[3] == board[i][k+3].get_Stein()[3] && board[i][k].get_Stein()[3]==board[i][k+3].get_Stein()[3]){
                      win_safe[0] = board[i][k];
                      win_safe[1] = board[i][k+3];
                      return true;
                    }
              }catch(Exception e){
                  ;
                }
            }
        }
      return false;
  }
  private boolean check_diagonal_right_to_left(Stein[][] board){
      for(int i =0;i < board.length;i++){
          for(int k =0;k < board[i].length;k++){
              try{
                  if(board[i][k].get_Stein()[3] == board[i+1][k+1].get_Stein()[3] && board[i+2][k+2].get_Stein()[3] == board[i+3][k+3].get_Stein()[3] && board[i][k].get_Stein()[3]==board[i+3][k+3].get_Stein()[3]){
                      win_safe[0] = board[i][k];
                      win_safe[1] = board[i+3][k+3];
                      return true;
                    }
              }catch(Exception e){
                  ;
                }
            }
        }
      return false;
  }
  private boolean check_diagonal_left_to_right(Stein[][] board){
      for(int i =0;i < board.length;i++){
          for(int k =board[i].length;k > 0;k--){
              try{
                  if(board[i][k].get_Stein()[3] == board[i+1][k-1].get_Stein()[3] && board[i+2][k-2].get_Stein()[3] == board[i+3][k-3].get_Stein()[3] && board[i][k].get_Stein()[3]==board[i+3][k-3].get_Stein()[3]){
                      win_safe[0] = board[i][k];
                      win_safe[1] = board[i+3][k-3];
                      return true;
                    }
              }catch(Exception e){
                  ;
                }
            }
        }
      return false;
    }
}

