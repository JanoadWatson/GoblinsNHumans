package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> grid = new ArrayList<>();
    private static ArrayList<Human> Humans=new ArrayList<>();
    private static ArrayList<Goblin> Goblins =new ArrayList<>();
    public static HashMap<Integer,Integer> boardPositions = new HashMap<>();
    public static String playerIs ="";
    public static String computerIs="";
    public static String computerType="";
    public static String playerType = "";
   public static Human humanChosen ;
    public static Goblin goblinChosen;
    public static int huLastMapVal = 134;
    public static int gobLastMapVal =1;
    public static boolean isGameOver=false;
    ;

    public static void main(String[] args) {
        Warrior Warrior = new Warrior();
        Wizard Wizard = new Wizard();
        Valkyrie Valkyrie = new Valkyrie();
        Goblin GreenGoblin = new GreenGoblin();
        Goblin HobGoblin = new HobGoblin();
        Goblin GoblinQueen = new GoblinQueen();

        FillInitial();
        PositionOnBoard();

        LoadCharacters(Warrior,Wizard,Valkyrie,GreenGoblin,GoblinQueen,HobGoblin);
     Start(Warrior,Wizard,Valkyrie,GreenGoblin,GoblinQueen,HobGoblin);
    }


    public static void Start(Human Warrior,Human Wizard, Human Valkyrie,Goblin GreenGoblin,Goblin GoblinQueen,Goblin HobGoblin){
        String pickSide="";


        Scanner makeChoice = new Scanner(System.in);
        Scanner chooseCharacter = new Scanner(System.in);
        Scanner chooseName = new Scanner(System.in);
        String nameChosen ="";
        String characterChosen = "";

        System.out.println("Welcome to Humans vs Goblins");
        System.out.println("Choose your side ");
        while(!pickSide.toUpperCase().equals("H") && !pickSide.toUpperCase().equals("G")) {
        System.out.println("Choose H for Human or G for Goblin");
         pickSide = makeChoice.nextLine();
            System.out.println();

            if (pickSide.toUpperCase().equals("H") ) {
                playerIs="Human";
                computerIs="Goblin";
                System.out.println("Choose your Human");

                PrintHumans();
                System.out.println("Enter your type of Human");
                characterChosen = chooseCharacter.nextLine();
            } else if(pickSide.toUpperCase().equals("G") ){
                playerIs="Goblin";
                computerIs="Human";
                System.out.println("Choose your Goblin");
                PrintGoblins();
                System.out.println("Enter your type of Goblin");
                characterChosen = chooseCharacter.nextLine();
            }  else{
                System.out.println("Try again please  ");

            }

        }
        if (pickSide.toUpperCase().equals("H")) {
            while (!characterChosen.toLowerCase().equals("warrior") && !characterChosen.toLowerCase().equals("wizard") && !characterChosen.toLowerCase().equals("valkyrie")) {
                System.out.println("Check your spelling and try again");
                System.out.println("Enter your type of Human");
                characterChosen = chooseCharacter.nextLine();
                System.out.println();
            }
        }else{

            while (!characterChosen.toLowerCase().equals("green goblin") && !characterChosen.toLowerCase().equals("hobgoblin") && !characterChosen.toLowerCase().equals("queen goblin")) {
                System.out.println("Check your spelling and try again");
                System.out.println("Enter your type of Goblin");
                characterChosen = chooseCharacter.nextLine();
                System.out.println();
            }
        }

                System.out.println();
            if (pickSide.toUpperCase().equals("H")) {
                if (characterChosen.toLowerCase().equals("warrior")) {
                    humanChosen=Warrior;
                    System.out.println("You have Chosen A Warrior Type");
                    System.out.println("Enter a name for your Warrior");
                    nameChosen = chooseName.nextLine();
                    Warrior.setName(nameChosen);


                } else if (characterChosen.toLowerCase().equals("wizard")) {
                    humanChosen=Wizard;
                    System.out.println("You have Chosen A Wizard Type");
                    System.out.println("Enter a name for your Wizard");
                    nameChosen = chooseName.nextLine();
                    Wizard.setName(nameChosen);
                } else  {
                    humanChosen=Valkyrie;
                    System.out.println("You have Chosen A Valkyrie Type");
                    System.out.println("Enter a name for your Valkyrie");
                    nameChosen = chooseName.nextLine();
                    Valkyrie.setName(nameChosen);
                }
            }else
            {
                if (characterChosen.toLowerCase().equals("green goblin")) {
                  goblinChosen=GreenGoblin;
                    System.out.println("You have Chosen A Green Goblin Type");
                    System.out.println("Enter a name for your Goblin");
                    nameChosen = chooseName.nextLine();
                    GreenGoblin.setName(nameChosen);


                } else if (characterChosen.toLowerCase().equals("hobgoblin")) {
                    goblinChosen=HobGoblin;
                    System.out.println("You have Chosen A Hobgoblin Type");
                    System.out.println("Enter a name for your Goblin");
                    nameChosen = chooseName.nextLine();
                    HobGoblin.setName(nameChosen);
                } else  {
                    goblinChosen=GoblinQueen;
                    System.out.println("You have Chosen A Queen Goblin Type");
                    System.out.println("Enter a name for your Goblin");
                    nameChosen = chooseName.nextLine();
                    GoblinQueen.setName(nameChosen);
                }
            }


            playerType=characterChosen;


            ComputerCharacter(computerIs,nameChosen, GreenGoblin,GoblinQueen,HobGoblin,Warrior,Wizard,Valkyrie);
            TheGame();
    }


    public static void FillInitial() {
        for (int i = 0; i<8; i++) {
            grid.add("|");
            grid.add(" ");
            grid.add("|");
            grid.add(" ");
            grid.add("|");
            grid.add(" ");
            grid.add("|");
            grid.add(" ");
            grid.add("|");
            grid.add(" ");
            grid.add("|");
            grid.add(" ");
            grid.add("|");
            grid.add(" ");
            grid.add("|");
            grid.add(" ");
            grid.add("|");

        }

    }


    public static void Board(){


//        print board by looping through arrayList grid
        for (int i = 0; i < grid.size(); i++){
            if(i == 17||i ==34 ||i==51||i==68||i==85||i==102||i==119){
                System.out.println();
                System.out.println("-----------------");
                System.out.print(grid.get(i));
            }else {
                System.out.print(grid.get(i));
            }
        }
        System.out.println();
    }

    public static void PositionOnBoard(){

        boardPositions.put(1,1);
        boardPositions.put(3,2);
        boardPositions.put(5,3);
        boardPositions.put(7,4);
        boardPositions.put(9,5);
        boardPositions.put(11,6);
        boardPositions.put(13,7);
        boardPositions.put(15,8);
        boardPositions.put(18,9);
        boardPositions.put(20,10);
        boardPositions.put(22,11);
        boardPositions.put(24,12);
        boardPositions.put(26,13);
        boardPositions.put(28,14);
        boardPositions.put(30,15);
        boardPositions.put(32,16);
        boardPositions.put(35,17);
        boardPositions.put(37,18);
        boardPositions.put(39,19);
        boardPositions.put(41,20);
        boardPositions.put(43,21);
        boardPositions.put(45,22);
        boardPositions.put(47,23);
        boardPositions.put(49,24);
        boardPositions.put(52,25);
        boardPositions.put(54,26);
        boardPositions.put(56,27);
        boardPositions.put(58,28);
        boardPositions.put(60,29);
        boardPositions.put(62,30);
        boardPositions.put(64,31);
        boardPositions.put(66,32);
        boardPositions.put(69,33);
        boardPositions.put(71,34);
        boardPositions.put(73,35);
        boardPositions.put(75,36);
        boardPositions.put(77,37);
        boardPositions.put(79,38);
        boardPositions.put(81,39);
        boardPositions.put(83,40);
        boardPositions.put(86,41);
        boardPositions.put(88,42);
        boardPositions.put(90,43);
        boardPositions.put(92,44);
        boardPositions.put(94,45);
        boardPositions.put(96,46);
        boardPositions.put(98,47);
        boardPositions.put(100,48);
        boardPositions.put(103,49);
        boardPositions.put(105,50);
        boardPositions.put(107,51);
        boardPositions.put(109,52);
        boardPositions.put(111,53);
        boardPositions.put(113,54);
        boardPositions.put(115,55);
        boardPositions.put(117,56);
        boardPositions.put(120,57);
        boardPositions.put(122,58);
        boardPositions.put(124,59);
        boardPositions.put(126,60);
        boardPositions.put(128,61);
        boardPositions.put(130,62);
        boardPositions.put(132,63);
        boardPositions.put(134,64);



    }

    public static void LoadCharacters(Human Warrior,Human Wizard, Human Valkyrie,Goblin GreenGoblin, Goblin GoblinQueen,Goblin HobGoblin){

        Humans.add(Warrior);
        Humans.add(Valkyrie);
        Humans.add(Wizard);



        Goblins.add(GreenGoblin);
        Goblins.add(HobGoblin);
        Goblins.add(GoblinQueen);



    }

    public static void PrintHumans(){

       for(int i=0; i<Humans.size();i++){
           System.out.println();
           System.out.println(Humans.get(i).getArchetype());
           System.out.println(Humans.get(i).getPic());
           System.out.println("Health = "+ Humans.get(i).getHealth());
           System.out.println("Strength = " + Humans.get(i).getStrength());
           System.out.println("Weapon = "+Humans.get(i).getWeapon());
           System.out.println();
       }
    }

    public static void PrintGoblins(){
        for(int i=0; i<3;i++){
            System.out.println();
            System.out.println(Goblins.get(i).getArchetype());
            System.out.println(Goblins.get(i).getPic());
            System.out.println("Color = "+Goblins.get(i).getColor());
            System.out.println("Health = "+Goblins.get(i).getHealth());
            System.out.println("Strength = " +Goblins.get(i).getStrength());
            System.out.println("Weapon = " +Goblins.get(i).getWeapon());
            System.out.println();
        }
    }


    public static void ComputerCharacter(String computerIs,String nameChosen,Goblin GreenGoblin,Goblin GoblinQueen,Goblin HobGoblin,Human Warrior,Human Wizard, Human Valkyrie){
        int  computerPick= (int) (Math.random()*(4-1))+1;
        if(computerIs.equals("Human")){
            if(computerPick==1){ computerType = "Warrior";
                humanChosen=Warrior;
            }
            else if(computerPick==2){ computerType = "Wizard";
            humanChosen=Wizard;}
            else{ computerType = "Valkyrie";
            humanChosen=Valkyrie;}
        }else{

            if(computerPick==1) {
                computerType = "Green Goblin";
            goblinChosen=GreenGoblin;
            }
            else if(computerPick==2){ computerType = "HobGoblin";
            goblinChosen=HobGoblin;}
            else{ computerType = "Queen Goblin";
            goblinChosen=GoblinQueen;}
        }
        System.out.println();
        System.out.println(String.format("Hello %s I am the %s named Computer I will destroy you!",nameChosen,computerType));

        if (computerIs.equals("Human")){
            humanChosen.setName("Computer");
        }else{
            goblinChosen.setName("Computer");
        }

    }


    public static void Instruction(){
        System.out.println("Instructions");
        System.out.println();
        System.out.println("The Rules to the Game are simple ");
        System.out.println("If you are the Human seek and destroy the Goblin as he randomly moves across the land");

        System.out.println("This is a battle to the death so when you meet you will fight till the death");
        System.out.println();
        System.out.println();
        System.out.println("If you are the Goblin seek and destroy the human as he randomly moves across the land");

        System.out.println("This is a battle to the death so when you meet you will fight till the death");
        System.out.println();
        System.out.println("Movement");
        System.out.println(" You will type R to roll the dice, then you will choose N,S,E or W for the direction you wish to go in.");
        System.out.println("You can only go in the direction that allows you to move the number of spaces that is chosen by the dice");
        System.out.println("for example if you roll a 5 but want to go east but there are only 3 spaces to the east then you cannot move east");
    }


    public static void TheGame(){
        grid.set(1,goblinChosen.getPic());
        grid.set(134,humanChosen.getPic());
         int lastMapVal;
        Board();
        System.out.println();
        int rollDice= 0;
        String direction="";
        Scanner diceRoll = new Scanner(System.in);
        Scanner choseDirection= new Scanner(System.in);
        String roll="";
        Instruction();
        while(isGameOver==false) {
            if (playerIs.equals("Human")) {
                lastMapVal = huLastMapVal;
                System.out.println("The " + humanChosen.archetype + " " + humanChosen.getName() + "goes ");
            } else {
                lastMapVal = gobLastMapVal;
                System.out.println("The " + goblinChosen.archetype + " " + goblinChosen.getName() + "goes ");
            }
            roll="";
            while (!roll.toUpperCase().equals("R")) {
                System.out.println("Enter R to roll the Dice");
                roll = diceRoll.nextLine();
            }
            int dice = (int) (Math.random() * (5 - 1)) + 1;
            rollDice = dice;
            System.out.println("You rolled a " + rollDice);

            direction="";
            while(!direction.toUpperCase().equals("N")&&!direction.toUpperCase().equals("S") && !direction.toUpperCase().equals("E")&&!direction.toUpperCase().equals("W")) {
                System.out.println("Choose a Direction enter N for north, S for south, E for east or W for west");
                direction = choseDirection.nextLine();
            }

            String player = "H";
            AddPosition(direction, lastMapVal, rollDice, player,playerIs);
            if(isGameOver==false) {
                if (computerIs.equals("Human")) {
                    lastMapVal = huLastMapVal;
                    System.out.println("The " + humanChosen.archetype + " " + humanChosen.getName() + "goes next");
                } else {
                    lastMapVal = gobLastMapVal;
                    System.out.println("The " + goblinChosen.archetype + " " + goblinChosen.getName() + "goes next");
                }
                dice = (int) (Math.random() * (5 - 1)) + 1;
                rollDice = dice;
                System.out.println("You rolled a" + rollDice);

                System.out.println("Choose a Direction enter N for north, S for south, E for east or W for west");

                direction = ComputerDirection();
                player = "C";
                AddPosition(direction, lastMapVal, rollDice, player, computerIs);
            }
        }
    }

    public static void AddPosition(String direction, int lastMapVal,int steps,String player,String playerIs){

        Scanner alternateDirection = new Scanner(System.in);
        String newDirection = "";
        boolean isOnBoard = false;
        int newMapVal;
        while(isOnBoard==false) {
            if (direction.toUpperCase().equals("S")) {
                newMapVal = (17 * steps) + lastMapVal;

                if (grid.size()>newMapVal &&newMapVal>0 && !grid.get(newMapVal).equals("|")){
                    if(fightCheck(newMapVal)==true) {
                        grid.set(newMapVal,playerIs.equals("Goblin")?goblinChosen.getPic():humanChosen.getPic());
                        grid.set(lastMapVal," ");
                    lastMapVal = newMapVal;
                    }else{
                        BattleTilDeath();
                    }
                    isOnBoard = true;
                } else {

                    if(player.equals("C")) {
                        newDirection=ComputerDirection();
                        direction = newDirection;

                    }else{
                        System.out.println("You can't go in that Direction ");
                        direction="";
                        while(!direction.toUpperCase().equals("N")&&!direction.toUpperCase().equals("S") &&!direction.toUpperCase().equals("E")&&!direction.toUpperCase().equals("W")) {
                            System.out.println("Choose a new direction");
                            newDirection = alternateDirection.nextLine();
                            direction = newDirection;
                        }
                    }

                }

            } else if (direction.toUpperCase().equals("N")) {

                newMapVal = lastMapVal-(17 * steps) ;

                if (grid.size()>newMapVal &&newMapVal>0 && !grid.get(newMapVal).equals("|")) {
                    if(fightCheck(newMapVal)==true) {

                        grid.set(newMapVal,playerIs.equals("Goblin")?goblinChosen.getPic():humanChosen.getPic());
                        grid.set(lastMapVal," ");
                    lastMapVal = newMapVal;
                    }else{
                    BattleTilDeath();
                        }
                    isOnBoard = true;
                } else {
                    if(player.equals("C")) {
                        newDirection=ComputerDirection();
                        direction = newDirection;

                    }else{
                        System.out.println("You can't go in that Direction ");
                        direction="";
                        while(!direction.toUpperCase().equals("N")&&!direction.toUpperCase().equals("S") &&!direction.toUpperCase().equals("E")&&!direction.toUpperCase().equals("W")) {
                            System.out.println("Choose a new direction");
                            newDirection = alternateDirection.nextLine();
                            direction = newDirection;
                        }

                    }
                }

            } else if (direction.toUpperCase().equals("E")) {
                newMapVal = lastMapVal + (2*steps);
                if (grid.size()>newMapVal &&newMapVal>0 && !grid.get(newMapVal).equals("|")){
                    if(fightCheck(newMapVal)==true) {
                        grid.set(newMapVal,playerIs.equals("Goblin")?goblinChosen.getPic():humanChosen.getPic());
                        grid.set(lastMapVal," ");
                        lastMapVal = newMapVal;
                    }else{
                        BattleTilDeath();
                    }

                    isOnBoard = true;
                }
                else {
                    if(player.equals("C")) {
                        newDirection=ComputerDirection();
                        direction = newDirection;

                    }else{
                        System.out.println("You can't go in that Direction ");
                        direction="";
                        while(!direction.toUpperCase().equals("N")&&!direction.toUpperCase().equals("S") &&!direction.toUpperCase().equals("E")&&!direction.toUpperCase().equals("W")) {
                            System.out.println("Choose a new direction");
                            newDirection = alternateDirection.nextLine();
                            direction = newDirection;
                        }

                    };
                }
            } else if (direction.toUpperCase().equals("W")) {
                newMapVal = lastMapVal - (2*steps);

                if (grid.size()>newMapVal &&newMapVal>0 && !grid.get(newMapVal).equals("|")){
                    if(fightCheck(newMapVal)==true) {
                        grid.set(newMapVal,playerIs.equals("Goblin")?goblinChosen.getPic():humanChosen.getPic());
                        grid.set(lastMapVal," ");

                    lastMapVal = newMapVal;

                    }else{
                        BattleTilDeath();
                    }
                    isOnBoard = true;
                } else {
                    if(player.equals("C")) {
                        newDirection=ComputerDirection();
                        direction = newDirection;
                    }else{
                        System.out.println("You can't go in that Direction ");
                        direction="";
                        while(!direction.toUpperCase().equals("N")&&!direction.toUpperCase().equals("S") &&!direction.toUpperCase().equals("E")&&!direction.toUpperCase().equals("W")) {
                            System.out.println("Choose a new direction");
                            newDirection = alternateDirection.nextLine();
                            direction = newDirection;
                        }

                    }
                }
            }
        }

        if (playerIs.equals("Human")){
            huLastMapVal=lastMapVal;
        }else {
            gobLastMapVal = lastMapVal;
        }
               if( isGameOver==false) {
                   Board();
               }else{
                   System.out.println(humanChosen);
                   System.out.println(goblinChosen);
               }
    }

    public static boolean fightCheck(int chkBoardPosition){
        if (grid.get(chkBoardPosition).equals(" ")){
            return true;
        }
        else {
            return false;
        }

    }
    public static void BattleTilDeath(){
        while(humanChosen.getHealth()>0 && goblinChosen.getHealth()>0){
            int humanAttack = (int) (Math.random()*(15-10))+1;
            int goblinAttack=(int) (Math.random()*(15-10))+1;

            System.out.println("Human Attacks with " +humanAttack+ " Damage");
            goblinChosen.setHealth(goblinChosen.getHealth()-humanAttack);
            System.out.println("The "+ goblinChosen.getArchetype()+" "+ goblinChosen.getName()+ " Health is now " +goblinChosen.getHealth());
            System.out.println();
            System.out.println();
            System.out.println("Goblin Attacks with " +goblinAttack+ " Damage");
           humanChosen.setHealth(humanChosen.getHealth()-goblinAttack);
            System.out.println("The "+ humanChosen.getArchetype() +" "+humanChosen.getName() + " Health is now " +humanChosen.getHealth());
        }
        if(humanChosen.getHealth()>0 ){
            System.out.println("The "+ humanChosen.getArchetype()+" " +humanChosen.getName() +" Wins!");
        }else{
            System.out.println("The "+ goblinChosen.getArchetype()+" "+ goblinChosen.getName()+ " Wins!");
        }
        System.out.println();
        isGameOver=true;
    }

    public static String ComputerDirection(){
        String compDirection="";
        int choice =(int) (Math.random() *(5-1))+1;
        if(choice==1){
            compDirection = "N";
        }
        else if (choice==2){
            compDirection = "S";
        }else if(choice == 3){
            compDirection = "E";
        }
        else{
            compDirection= "W";
        }

        return compDirection;
    }
}

