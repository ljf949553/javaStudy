public class Main {
    public static void main(String[] args) {
        String l1 = "1.2.3";
        String l2 = "1.2.4";
        int i = Main.compareVersion(l1, l2);
        System.out.println(i);
    }
    public static int compareVersion (String v1, String v2) {
        // write code here
        v1 = v1.trim();
        v2 = v2.trim();
        String[] i1 = v1.split("\\.");
        String[] i2 = v2.split("\\.");
        for (int i = 0; i < i1.length - 1; i++) {
            if (i1[i] == i2[i]) {
                continue;
            }
            else if (Integer.valueOf(i1[i]) > Integer.valueOf(i2[i])) {
                return 1;
            } else return -1;
        }
        return -2;
    }
}
