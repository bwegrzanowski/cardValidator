package pl.sda;

public class ValidationResult {
    private String issuer = "UNKNOWN";
    private boolean verificationPassed = false;


    public boolean isCardNumberCorrect(StringBuilder cardNumber) {
        int cardNumberLength = cardNumber.length();
        int sumOfEvenNumbersStartingFromLastDigit = 0;
        int sumOfOddNumbersStartingFromLastDigit = 0;
        for (int i = 1; i <= cardNumberLength; i++) {
            int tmpParsedDigit = cardNumber.lastIndexOf(String.valueOf(cardNumber));
            if (i % 2 == 0) {
                int evenNumberDoubled = 2 * (tmpParsedDigit);
                if (evenNumberDoubled > 9) {
                    int tmp = evenNumberDoubled % 10;
                    evenNumberDoubled /= 10;
                    evenNumberDoubled += tmp;
                }
                sumOfEvenNumbersStartingFromLastDigit += evenNumberDoubled;
            }
            sumOfOddNumbersStartingFromLastDigit += tmpParsedDigit;
        }
        return ((sumOfEvenNumbersStartingFromLastDigit + sumOfOddNumbersStartingFromLastDigit % 10) == 0) ? true : false ;

    }

    public Issuers cardIssuer(StringBuilder cardNumber) {
        int cardNumberLength = cardNumber.length();
        StringBuilder issuerNumber = cardNumber;
        issuerNumber = issuerNumber.delete(2, cardNumber.length());
        int issuerFirstDigits = Integer.valueOf(String.valueOf(issuerNumber));
        if ((issuerFirstDigits >= 40 && issuerFirstDigits <= 49) && cardNumberLength == 16) {
            return Issuers.Visa;
        }
        if ((issuerFirstDigits >= 51 && issuerFirstDigits <= 55) && cardNumberLength == 16) {
            return Issuers.MasterCard;
        }
        if ((issuerFirstDigits == 34 || issuerFirstDigits == 37) && cardNumberLength == 15) {
            return Issuers.American_Express;
        }
        return Issuers.NO_REGISTERED_ISSUERS_FOR_ENTERED_NUMBER;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public boolean isVerificationPassed() {
        return verificationPassed;
    }

    public void setVerificationPassed(boolean verificationPassed) {
        this.verificationPassed = verificationPassed;
    }
}
