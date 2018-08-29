package test;

public class Feibonaqie {
    public static int fei(int k){
        if (k>=0&&k<=1){
            return k;
        }
        int p=0,q=1,f=0;
        for (int i=2;i<=k;i++){
            f=p+q;
            p=q;
            q=f;
        }
        return f;
    }
    public static int jump(int k){
        if (k<=2)
            return k;
        int p=1,q=2;
        int r=1;
        for (int i=2;i<=k;i++){
            r=p+q;
            p=q;
            q=r;
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println(jump(6));
    }
}
