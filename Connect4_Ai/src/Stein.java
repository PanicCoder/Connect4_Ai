public class Stein
{
   private int[] stein;
   public Stein(int xPos, int yPos, int radius,int farbnr){
       stein = new int[]{xPos,yPos,radius,farbnr};
   }
   public int[] get_Stein(){
       return stein;
   }
   public void zeichne(){
       ZEICHENFENSTER.gibFenster().fuelleKreis(stein[0], stein[1], stein[2], stein[3]);
   }
   public void change_shape(int x_pos,int y_pos){
       stein[0]=x_pos;
       stein[1]=y_pos;
    }
   public void clear(){
       ZEICHENFENSTER.gibFenster().loescheKreis(stein[0], stein[1], stein[2]);
    }
   }
