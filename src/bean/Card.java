package bean;

/**
 * 桥牌对象
 * */
public class Card implements Comparable<Card>{

    public Type getType() {
        return type;
    }

    /**扑克牌的花色*/
    private final Type type;
    /**扑克牌上的数字*/
    private final int count;

    public Card(Type type,int count){
        this.type = type;
        this.count = count;
    }

    private String getCount(){
        switch (count){
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return ""+count;
        }
    }

    @Override
    public String toString() {
        return ""+type+getCount();
    }

    @Override
    public int compareTo(Card o) {
        if(o.type != this.type){
            return this.type.ordinal() - o.type.ordinal();  //以枚举中的定义顺序作为花色的大小
        }
        return this.count - o.count;  //花色相同，以数字比较大小（不严格按桥牌规则，单纯的使用数字的大小）
    }

    public enum Type{
        H("红桃"),
        S("黑桃"), //
        D("方块"), //
        C("梅花");  //
        private String name;
        Type(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
