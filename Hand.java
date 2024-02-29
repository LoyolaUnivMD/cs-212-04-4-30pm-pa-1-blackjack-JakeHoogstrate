import java.util.ArrayList;
public class Hand {

    private ArrayList<String> hand = new ArrayList<>();
    //arraylist for hands


    public void add(String card) {
        //adds a card to a hand
        hand.add(card);
    }

    public void showHand(boolean facedown){
        //shows a hand
        // if facedown is true the second card will be shown as "XX"

        for (int q = 0; q < hand.size(); q++) {
            if (facedown&&q==1){
                System.out.print("XX ");
            }
            else{
            System.out.print(hand.get(q)+" ");
        }
    }}

    public int getValue() {
        //gets current value of a hand

        int value =0;
        //value tracks total value of hand

        boolean hasAce =false;
        //hasAce is for changing ace values between 1 and 11

        for (int l = 0; l < hand.size(); l++) {
            //for loop iterates through hand
            String h = hand.get(l);
            char g = h.charAt(0);
            String p = ""+g;
            //previous 3 lines are to grab the first character of a card (the number) and turn it into a string

            if (p.equals("2")){
                value+=2;
            }
            else if (p.equals("3")){
                value+=3;
            }
            else if (p.equals("4")){
                value+=4;
            }
            else if (p.equals("5")){
                value+=5;
            }
            else if (p.equals("6")){
                value+=6;
            }
            else if (p.equals("7")){
                value+=7;
            }
            else if (p.equals("8")){
                value+=8;
            }
            else if (p.equals("9")){
                value+=9;
            }
            else if (p.equals("T")||p.equals("J")||p.equals("Q")||p.equals("K")){
                value+=10;
            }
            else if (p.equals("A")){
                value+=11;
                hasAce=true;
            }
        }
        if (value>21&&hasAce){
            value-=10;
            //changes ace value to 1 if the player would otherwise bust
        }
        return value;
        //returns value
    }


}