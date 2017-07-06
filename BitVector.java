public class BitVector {

    private static int hi = 100;
    private static int BITSPERWORD = 32;
    private static int SHIFT = 5;
    private static int MASK = 0x1F;
    
   //In this array x[0] ~ [0, 31], x[1] ~ [32, 63], x[2] ~ [64, 95] and so on, in each element of array, the integers are represented  
   //as the order of magnitude of 2.
    
    static int[] x = new int[1 + 100 / BITSPERWORD];
    static int shift = 5;
    static int maskl = 0x1F;

    void setB(int i) {
        x[i >> shift] |= 1 << (i & maskl);
    }

    void cls(int i) {
        x[i >> shift] &= ~(1 << (i & maskl));
    }

    boolean test(int i) {
        return (x[i >> shift] & (1 << (i & maskl))) != 0;
    }

    public static void main(String[] args) {
        for (int i : x) {
            System.out.println("num_i = " + i + ", ");
        }

        Searching13Bit s = new Searching13Bit();
        int num[] = new int[100];
        for (int i = 0; i < 100; i++)
            num[i] = i;

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                continue;
            s.setB(num[i]);
        }
        
        for (int i = 0; i < 100; i++) {
            if (s.test(num[i])) 
                System.out.print(num[i] + " is set; ");
            else 
                System.out.print(num[i] + " is NOT set; ");
            
        }
        System.out.println();
    }
}
