public class King extends ConcretePiece {

    private String type = "♔";

    public King(Player player, String type,int index){
        super(player,type,index);
    }


    public String getType (){
        return this.type;
    }

    @Override
    public int getEatnums (){
        return 0;
    }

    @Override
    public String getName (){
        return "K7";
    }



}
