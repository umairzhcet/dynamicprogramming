package com.umair.string;

public class RobotBoundedCircle {

    public static void main(String[] args) {

        RobotBoundedCircle main=new RobotBoundedCircle();
        System.out.println(main.isRobotBounded("GGLLGG"));
    }
    public boolean isRobotBounded(String instructions) {

        int dir=0;
        int x=0;
        int y=0;

        for(char step:instructions.toCharArray()){
            if(step=='R')
                dir=(dir+1)%4;

            else if(step=='L')
                dir=(dir-1+4)%4;

            else{

                if(dir==0)
                    y++;
                if(dir==1)
                    x++;
                if(dir==2)
                    y--;
                if(dir==3)
                    x--;

            }

        }

        if((x==0 && y==0) || dir!=0)
            return true;

        return false;
    }
}
