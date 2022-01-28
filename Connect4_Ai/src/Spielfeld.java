public class Spielfeld
{
  private Stein spielfeld[][] = new Stein[7][6];
  public Spielfeld(){
      ZEICHENFENSTER.gibFenster().setzeTitel("Connect 4");
  }
  public void draw_board() {
    for(int i =0; i < ZEICHENFENSTER.gibFenster().get_breite();i+=100) {
        for(int k =0; k < ZEICHENFENSTER.gibFenster().get_hoehe();k+=100){
            if (spielfeld[i/100][k/100]==null){
                ZEICHENFENSTER.gibFenster().zeichneKreis(i+50, k+50, 40);
            }else{
                spielfeld[i/100][k/100].zeichne();
            }
            ZEICHENFENSTER.gibFenster().zeichneRechteck(i, k, 100, 100);
        }
    }
  }
  public void clear_all(){
      ZEICHENFENSTER.gibFenster().loescheAlles();
   }
  public void clear(int x,int y){
      spielfeld[x][y].clear();
  }
  public void stein_einfuegen(Stein st,int pos_x,int pos_y){
      st.change_shape((pos_x*100)+50,(pos_y*100)+50);
      spielfeld[pos_x][pos_y]=st;
  }
  public Stein[][] get_Spielfeld(){
      return spielfeld;
    }
}
