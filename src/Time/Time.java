import java.io.PrintStream;
import java.util.Scanner;

public class Time{

    public Time(int h, int m, String id){
        this.h=h;
        this.m=m;
        this.id=id;
    }

    public String getId(){
        return id;
    }

    public int getH(){
        return h;
    }

    public int getM(){
        return m;
    }

    public void setId(String id){
        this.id=id;
    }

    public void setH(int h){
        this.h=h;
    }

    public void setM(int m){
        this.m=m;
    }

    public void print(PrintStream ps){
        ps.println(h+" "+m+" "+id);
    }

    public static Time read(Scanner sc){
        int h, m;
        String id;
        if(sc.hasNext()){
            h=sc.nextInt();
            if(sc.hasNext()){
                m=sc.nextInt();
                if(sc.hasNext()){
                    id=sc.next();
                    return new Time(h, m, id);
                }
            }
        }
        return null;
    }

    public int toMinute(){
        if(id.equals("pm"))
            h+=12;
        return h*60+m;
    }

    public boolean isAfter(Time t){
        return this.toMinute()<t.toMinute();
    }

    public boolean isBefore(Time t){
        return !this.isAfter(t);
    }

    public void shift(int m){
        int totm=this.toMinute() + m%(24*60);
        this.m=totm%60;
        this.h=(totm/60)%24;
        if(this.h>12){
            this.id="pm";
            this.h-=12;
        }else
            this.id="am";
    }

    public void shift(int h, int m){
        int totm=this.toMinute() + (m+h*60)%(24*60);
        this.m=totm%60;
        this.h=(totm/60)%24;
        if(this.h>12){
            this.id="pm";
            this.h-=12;
        }else
            this.id="am";
    }


    private String id;
    private int h;
    private int m;
}
