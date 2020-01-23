public class Main {

    public static void main(String[] args)
    {
        //current year in roman numerals
        String roman = "MMXX";

        //instantiate the roman numeral object
        RomanNumeral RN = new RomanNumeral(roman);

        //print formatted result to console w/ implicit toString call
        System.out.print(RN);
    }

}
