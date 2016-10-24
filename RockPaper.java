import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RockPaper extends Frame{
  private Label lblChoice;
  private CheckboxGroup choices;
  private TextArea txtA;
  private Button bttnGame;
  private Button bttnExit;
  private Label lblPlrScore;
  private Label lblCmpScore;
  private TextArea txtPlrScore;
  private TextArea txtCmpScore;
  private boolean pWin;
  private boolean cWin;
  private Dialog dia;
  private Label res;
  private Button rest;
  private int plrScore;
  private int cmpScore;
  
  public RockPaper(){
    setLayout(new FlowLayout());
    lblChoice = new Label("Your choice: ");
    choices = new CheckboxGroup();
    Checkbox rock = new Checkbox("Rock", choices, true);
    Checkbox paper = new Checkbox("Paper", choices, true);
    Checkbox scissors = new Checkbox("Scissors", choices, true);
    Checkbox lizard = new Checkbox("Lizard", choices, true);
    Checkbox spock = new Checkbox("Spock", choices, true);
    txtA = new TextArea("Results:",5, 40);
    txtA.setEditable(false);
    bttnGame = new Button("RockPaperScissorsLizardSpock!");
    lblPlrScore = new Label("Player Score: ");
    lblCmpScore = new Label("Computer Score: ");    
    txtPlrScore = new TextArea(1, 40);
    txtPlrScore.setEditable(false);
    txtCmpScore = new TextArea(1, 40);
    txtCmpScore.setEditable(false);
    dia = new Dialog(this);
    bttnExit = new Button("Exit");
    res = new Label("Restart?");
    rest = new Button("OK");
    
    bttnExit.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent s){
        System.exit(0);
      }
    });
    
    rest.addActionListener( new ActionListener(){
      public void actionPerformed(ActionEvent l){
        restart();
        dia.setVisible(false);
      }
    });
    
    bttnGame.addActionListener( new ActionListener() {
      int c = 0;
      String[] pick = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
      public void actionPerformed(ActionEvent e){
        Random r = new Random();
        int n = r.nextInt(4) + 0;
        if (rock.getState()){
          c = 0;
        }
        if (paper.getState()){
          c = 1;
        }
        if (scissors.getState()){
          c = 2;
        }
        if (lizard.getState()){
          c = 3;
        }
        if (spock.getState()){
          c = 4;
        }
        game(c, n);
        if (pWin == true && cWin == false){
          txtA.setText("Result: \n" + "Player chose " + pick[c] + "\nComputer chose " + pick[n] + "\nYou win this round");
          plrScore++;
          txtPlrScore.setText(Integer.toString(plrScore));
        }
        else if (pWin == false && cWin == true){
          txtA.setText("Result: \n" + "Player chose " + pick[c] + "\nComputer chose " + pick[n] + "\nYou lose this round");
          cmpScore++;
          txtCmpScore.setText(Integer.toString(cmpScore));
        }
        else{
          txtA.setText("Result: \n" + "Player chose " + pick[c] + "\nComputer chose " + pick[n] + "\nDRAW");
        }
        
        if (plrScore == 5){
          dia.setLayout(new FlowLayout());
          dia.add(res);
          dia.add(rest);
          dia.add(bttnExit);
          dia.setTitle("Player wins");
          dia.setSize(250, 250);
          dia.setVisible(true);
        }
        else if (cmpScore == 5){
          dia.setLayout(new FlowLayout());
          dia.add(res);
          dia.add(rest);
          dia.add(bttnExit);
          dia.setTitle("Computer Wins");
          dia.setSize(250, 250);
          dia.setVisible(true);
        }
      }
    });
    
    add(lblChoice);
    add(rock);
    add(paper);
    add(scissors);
    add(lizard);
    add(spock);
    add(txtA);
    add(bttnGame);
    add(lblPlrScore);
    add(txtPlrScore);
    add(lblCmpScore);
    add(txtCmpScore);
    add(bttnExit);
    
    setTitle("Blin Simulator 2016");
    setSize(500, 400);
    setVisible(true);
  }
  
  public void restart(){
    pWin = false;
    cWin = false;
    plrScore = 0;
    cmpScore = 0;
    txtPlrScore.setText(Integer.toString(plrScore));
    txtCmpScore.setText(Integer.toString(cmpScore));
  }
  
  public void game(int c, int n){
    if (c == 0){
          if (n == 2 || n == 3){
            this.pWin = true;
            this.cWin = false;
          }
          else if (n == 1 || n == 4){
            this.pWin = false;
            this.cWin = true;
          }
          else{
            this.pWin = false;
            this.cWin = false;
          }
        }
     if (c == 1){
          if (n == 0 || n == 4){
            this.pWin = true;
            this.cWin = false;
          }
          else if (n == 2 || n == 3){
            this.pWin = false;
            this.cWin = true;
          }
          else{
            this.pWin = false;
            this.cWin = false;
          }
        }
     if (c == 2){
          if (n == 1 || n == 3){
            this.pWin = true;
            this.cWin = false;
          }
          else if (n == 0 || n == 4){
            this.pWin = false;
            this.cWin = true;
          }
          else{
            this.pWin = false;
            this.cWin = false;
          }
        }
     if (c == 3){
          if (n == 1 || n == 4){
            this.pWin = true;
            this.cWin = false;
          }
          else if (n == 0 || n == 2){
            this.pWin = false;
            this.cWin = true;
          }
          else{
            this.pWin = false;
            this.cWin = false;
          }
        }
     if (c == 4){
          if (n == 0 || n == 2){
            this.pWin = true;
            this.cWin = false;
          }
          else if (n == 1 || n == 3){
            this.pWin = false;
            this.cWin = true;
          }
          else{
            this.pWin = false;
            this.cWin = false;
          }
        }
  }
  
  public static void main(String[] args){
    new RockPaper();
  }
}

//Rock beats scissor, lizard 1
//paper beats spock, rock 2
//scissors beats paper, lizard 3
//lizard beats spock, paper 4
//spock beats rock, scissor 5