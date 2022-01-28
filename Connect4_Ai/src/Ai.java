public class Ai{

    private Input input;
    private Spielfeld feld;
    private Rules rules;

    public Ai(Input i, Spielfeld f, Rules r) {
        this.input = i;
        this.feld = f;
        this.rules = r;
    }
          

    public boolean ai_move() {
        return bestMove(feld.get_Spielfeld());
    }


    public boolean bestMove(Stein[][] board) {
        double bestScore = Double.NEGATIVE_INFINITY;
        int move=0;
        int y;
        for (int i = 0; i < board.length; i++) {
            y=rules.get_lowest(i);
            if(board[i][y] == null) {
                board[i][y] = new Stein(0,0,0,1);
                double score = minimax(board, 0,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY, false);
                board[i][y] = null;
                if(score > bestScore){
                    bestScore = score;
                    move = i;
                }
            }
          }
        return input.adding_stone(1, move);
    }
      
      
    public double minimax(Stein[][] board, int depth, double alpha, double beta, boolean isMaximizing) {
        boolean result = rules.game_won(board);
        if (result) {
            if(rules.win_player()==1){
                return 1.0;
            }
            return -1.0;
        }
        if(rules.tie(board)){
            return 0.0;
        }

        if(depth > 9){
            return 0.0;
        }
      
        if(isMaximizing){
          double bestScore = Double.NEGATIVE_INFINITY;
          int y;
          for (int i = 0; i < board.length; i++) {
              y=rules.get_lowest(i);
              if(board[i][y] == null) {
                board[i][y] = new Stein(0,0,0,1);
                double score = minimax(board, depth + 1, alpha, beta, false);
                board[i][y] = null;
                bestScore = Math.max(score, bestScore);
                alpha = Math.max(alpha, score);
                if(beta <= alpha){
                    break;
                }
              }
            }   
            return bestScore;
        }else {
          double bestScore = Double.POSITIVE_INFINITY;
          int y;
          for (int i = 0; i < board.length; i++) {
              y=rules.get_lowest(i);
              if (board[i][y] == null) {
                board[i][y] = new Stein(0,0,0,4);
                double score = minimax(board, depth + 1,alpha,beta, true);
                board[i][y] = null;
                bestScore = Math.min(score, bestScore);
                beta = Math.min(beta, score);
                if(beta <= alpha){
                    break;
                }
              }
            }
          return bestScore;
        }
      }
}
