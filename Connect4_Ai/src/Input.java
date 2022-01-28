public class Input
{
  private int[] pos_;
  private Rules r;
  private Spielfeld feld;
  public Input(Spielfeld f){
      pos_ = new int[2];
      this.feld=f;
      this.r = new Rules(feld);
    }
  public int[] get_pos(){
      pos_[0]=ZEICHENFENSTER.gibFenster().get_pos_x();
      pos_[1]=ZEICHENFENSTER.gibFenster().get_pos_y();
      return pos_;
  }

  public boolean add_Stein(int spieler){
    get_pos();
    int pos[] = r.format_move(pos_[0], pos_[1]);
    return adding_stone(spieler, pos[0]);
  }

  public boolean adding_stone(int spieler, int pos){
        int y = r.get_lowest(pos);
        if(pos<8 && y >= 0 && r.get_valid_input(pos, y)){
            feld.stein_einfuegen(new Stein(pos,y,40,spieler),pos,y);
            r.draw_fall(pos, y, spieler);
            return true;
        }
        return false;
  }
}
