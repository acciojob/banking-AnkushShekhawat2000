package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }
        validateLicenseId();
    }

    public void validateLicenseId() throws Exception {
        if (!isNumberValid(tradeLicenseId)) {
            String rearrangedId = arrangeString(tradeLicenseId);
            if (rearrangedId.equals("")) {
                throw new Exception("Valid License can not be generated");
            } else {
                this.tradeLicenseId = rearrangedId;
            }
        }
    }

    private String arrangeString(String S) {
        int N = S.length();
        int count[] = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }

        for (char ch : S.toCharArray()) {
            count[(int) ch - (int) 'A']++;
        }

        char ch_max = getCountChar(count);
        int maxCount = count[(int) ch_max - (int) 'A'];

        if (N % 2 == 0) {
            if (maxCount > (N / 2) + 1) {
                return "";
            }
        } else {
            if (maxCount > (N / 2 + 2)) {
                return "";
            }
        }

        char ans[] = new char[N];
        int index = 0;

        // Fill most frequent characters
        for (int i = 0; i < N; i = i + 2) {
            if (count[ch_max - 'A'] > 0) {
                ans[i] = ch_max;
                count[ch_max - 'A']--;
            } else {
                break;
            }
        }

        // Fill all other remaining characters
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);

            while (count[ch - 'A'] > 0) {
                if (index >= N) {
                    index = 1;
                }
                ans[index] = ch;
                count[ch - 'A']--;
                index += 2;
            }
        }

        return new String(ans);
    }

    private char getCountChar(int[] count) {
        int maxCount = 0;
        char ch_max = 'A';
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                ch_max = (char) ('A' + i);
            }
        }
        return ch_max;
    }

    public boolean isNumberValid(String licenseId) {
        for (int i = 0; i < licenseId.length() - 1; i++) {
            if (licenseId.charAt(i) == licenseId.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
