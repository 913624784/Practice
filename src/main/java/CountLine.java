import java.io.*;

public class CountLine {
    static int s=0;
    private static int func(File file) throws IOException {
        File[] fs = file.listFiles();
        int count = 0;
        for (File f : fs) {
            if (f.isDirectory())
                func(f);
            if (f.isFile()) {
                FileInputStream fis = new FileInputStream(f);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                while ((br.readLine()) != null) {
                    count++;
                }
                s+=count;
                System.out.println(f.getParent() + "," + count);
            }
        }
        return s;
    }
    private static int func1(File file) throws IOException {
        return func(file);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Countline:"+func1(new File(args[0])));
    }
}
