public class Spiel
{
    private Spielfeld feld;
    private Input inp;
    private Rules r;
    private Ai ai;
    private int spieler;
    public Spiel(){
        feld = new Spielfeld();
        inp = new Input(feld);
        r = new Rules(feld);
        ai = new Ai(inp,feld,r);
        spieler = 4;
        start();
    }
    public void start(){
       feld.draw_board(); 
       game_loop();
       r.draw_win_line(r.get_win_stone());
    }
    public void game_loop(){
        while(!r.game_won(feld.get_Spielfeld())){
            if(r.tie(feld.get_Spielfeld())){
                System.out.println("draw");
                return;
            }
            if (spieler==4){
                if(ZEICHENFENSTER.gibFenster().get_click()){
                    boolean add = inp.add_Stein(spieler);
                    ZEICHENFENSTER.gibFenster().reset_clicked();
                    if(add){
                        spieler=1;
                    }
                    feld.draw_board();
                }
                continue;
            }
            ZEICHENFENSTER.gibFenster().warte(100);
            if(ai.ai_move()){
                spieler = 4;
            }
            feld.draw_board();
        }
    }
}
