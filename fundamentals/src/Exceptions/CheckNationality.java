package Exceptions;

import java.util.Objects;

public class CheckNationality {
    public static void check(String country) throws NationalityException {

        if(!Objects.equals(country, "Rwanda"))
            throw new NationalityException("You are not a Rwandan");
        else{
            System.out.println("You are a rwandan");
        }
    }

    public static void main(String[] ags){
        try {
            check("Rwanda");
        }catch (NationalityException e){
            System.out.println(e.toString());
        }finally {
            System.out.println("Thanks for applying");
        }
    }
}
