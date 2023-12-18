package rca.rw.enums;

public class EnumUsage {
    Enum day;
    public EnumUsage(Enum day){
        this.day = day;
    }
    public void infoDay(){
        switch (day){
            case MONDAY:
                System.out.println("mondays are bad days");
                break;
            case FRIDAY:
                System.out.println("fridays are better");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("weekends are better");
                break;
            default:
                System.out.println("mid weeks are so ugly");
        }
    }
    public static void main(String[] args) {
        EnumUsage day1 = new EnumUsage(Enum.FRIDAY);
        day1.infoDay();
    }
}

