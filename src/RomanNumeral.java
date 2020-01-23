/*
* Roman numeral class to convert and store decimal equivalences
*/
public class RomanNumeral
{
    private String roman;
    private int result;

    //Constructor creating the roman number
    public RomanNumeral(String RN)
    {
        //initialize
        // ...start a running total, convert to upper, set the instance variable
        int total = 0;
        RN = RN.toUpperCase();
        this.roman = RN;

        // ...start an index
        int i = 0;
        //process entire RN
        while (i < RN.length())
        {
            //get letter
            char letter = RN.charAt(i);
            //get letter value
            int value = getValue(letter);

            //if it's the final character...
            if (i == RN.length() -1)
            {
                //we don't need to look at the next char for context, just add the value
                total += value;
            }
            else
            {
                //get the next context letter
                char nextLetter = RN.charAt(i + 1);
                //...and it's value
                int nextValue = getValue(nextLetter);
                //if the RN is ascending in value...
                if (value < nextValue)
                {
                    //we have to subtract
                    total += (nextValue - value);
                    //we have processed two values this round
                    // so must increase the index by 1 (first is taken care of on move to next letter)
                    i++;
                }
                //either descending or duplicate values...
                else
                {
                    //so we just add the current
                    total += value;
                }
            }
            //move to next letter
            i++;
        } //end while
        //set the instance variable
        this.result = total;
    }

    //Return decimal value of RN else -1 if no match found
    private int getValue(char letter) {
        switch (letter)
        {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }

    public String toString()
    {
        return "The decimal value of " + roman + " is " + result;
    }
}
