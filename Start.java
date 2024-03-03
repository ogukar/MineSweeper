package MineSweeper;

import java.util.Random;

public class Start {
    Random random = new Random();

    private int length=10,width=10;

    int[][] map = new int[length][width];
    int[][] userMap = new int[length][width];
    private int mineNumber;

    public int getMineNumber() {
        return mineNumber;
    }

    public void gameMap(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width ; j++) {
                map[i][j]=0;
            }
        }
        mineNumber = (width*length)/6;
        int i = 0;
        while (i< mineNumber){
            int mineVertical = random.nextInt(length-1);
            int mineHorizontal = random.nextInt(width-1);
            if(map[mineVertical][mineHorizontal] != -1){
                map[mineVertical][mineHorizontal] = -1;
                i++;
            }
        }
        for (int l = 0; l < length; l++) {
            for (int j = 0; j < width; j++) {
                userMap[l][j] = 0;
            }
        }
    }
    public boolean gameBoard(int a, int b){

        if (map[a][b]==-1) {
            System.out.println("you loose");
            return false;
        }else {
            if(a>0 && (map[a-1][b]==-1) ){
                userMap[a][b] +=1;
            }else if(a!=length && (map[a+1][b]==-1)){
                userMap[a][b] +=1;
            }else if(b!=0 && (map[a][b-1]==-1)){
                userMap[a][b] +=1;
            }else if(b!=width && (map[a][b+1]==-1)){
                userMap[a][b] +=1;
            }else if(a!=0 && b!=0 && (map[a-1][b-1]==-1)){
                userMap[a][b] +=1;
            }else if(b!=width && a!=0 && (map[a-1][b+1]==-1)){
                userMap[a][b] +=1;
            }else if(b!=0 && a!=length && (map[a+1][b-1]==-1)){
                userMap[a][b] +=1;
            }else if(b!=width && a!=length && (map[a+1][b+1]==-1)){
                userMap[a][b] +=1;
            }else if(map[a][b]==0){
                userMap[a][b] =9;
            }
            for (int i = 0; i < length ; i++) {
                for (int j = 0; j < width ; j++) {
                    System.out.print(userMap[i][j] + " ");
                }
                System.out.println();
            }
            int mapArea =0;
            for (int i = 0; i < length ; i++) {
                for (int j = 0; j < width ; j++) {
                    if (userMap[i][j]!=0){
                        mapArea++;
                        if (mapArea==(width*length)-mineNumber){
                            System.out.println("you won");
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }
    public void xRay(){
        for (int i = 0; i < length; i++) {         // map xray
            for (int j = 0; j < width; j++) {
                if (map[i][j] != -1) {
                    System.out.print(" " + map[i][j]);
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }
}
