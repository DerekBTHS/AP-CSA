public class Main {
    public static void main(String[] args) {
        String str;
        int x;

        Sign sign1 = new Sign("ABC222DE", 3);
        x = sign1.numberOfLines();
        System.out.println(x);
        str = sign1.getLines();
        System.out.println(str);

        Sign sign2 = new Sign("ABCD", 10);
        x = sign2.numberOfLines();
        System.out.println(x);
        str = sign2.getLines();
        System.out.println(str);

        Sign sign3 = new Sign("ABCDEF", 6);
        x = sign3.numberOfLines();
        System.out.println(x);
        str = sign3.getLines();
        System.out.println(str);

        Sign sign4 = new Sign("", 4);
        x = sign4.numberOfLines();
        System.out.println(x);
        str = sign4.getLines();
        System.out.println(str);

        Sign sign5 = new Sign("AB_CD_EF", 2);
        x = sign5.numberOfLines();
        System.out.println(x);
        str = sign5.getLines();
        System.out.println(str);
    }
}
