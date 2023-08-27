package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
       super(name, balance, 5000);
       this.tradeLicenseId = tradeLicenseId;
       if(balance < 5000)
       {
           throw new Exception("InsufficientBalance");
       }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
         if(!isNumberValid(tradeLicenseId))
         {
             String rearrangedId = arrangeString(tradeLiceneseId);
             if(rearrangedId == "")
             {
                 throw new Exception("Valid Licence can not be generated");
             }
             else {
                 this.tradeLiceneseId = rearrangedId;
             }
         }
    }

    public String arranged(String S)
    {
        int N = S.length();

        int count[] = new int[26];
        for(int i = 0; i<26; i++)
        {
            count[i] = 0;
        }

        for(char ch : S.toCharArray())
        {
            count[(int)ch - (int)'A']++;
        }

        // calculated the frequency of each of the char

        char ch_max = getCountChar(count);
        int maxCount = count[(int)ch_max - (int)'A'];

        if(N%2 == 0)
        {
            if(maxCount > (N/2)+1)
            {
                return "";
            }
        }
        else {
            if(maxCount > (N/2 + 2))
            {
                return "";
            }

        }

        // this is possible now

        char ans[] = new char[N];
        //fill mot frequent
        for(int index = 0; index <N; index = index + 2)
        {
            if(count[ch_max] > 0)
            {
                ans[index] = ch_max;
                count[ch_max]--;
            }
            else {
                break;
            }
        }

        // fill all other remaining character
        for(int i =0; i<26; i++)
        {
            char ch = (char)('A'+i);

            while(count[ch] > 0)
            {
                if(index >= N)
                {
                    index = 1;
                }
                ans[index] = index +2;
                count[ch]--;
            }
        }

        String res = "";

        for(int i = 0; i<N; i++)
        {
            res += ' ';
        }

        int ind = 0;
        while(maxCount > 0)
        {
            res = res.
        }

    }

    public boolean isNumberValid(String licenseId)
    {
        for(int i = 0; i< licenseId.length()-1; i++)
        {
            if(licenseId.charAt(i) == licenseId.charAt(i+1))
            {
                return false;
            }
        }
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
