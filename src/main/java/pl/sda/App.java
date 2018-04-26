package pl.sda;

public class App {
    public static void main(String[] args) {
        final ValidationResult result = new ValidationResult();

        StringBuilder sb = new StringBuilder();
        sb.append("4539177671895702");

        ValidationResult validationResult = new ValidationResult();
        System.out.println(validationResult.isCardNumberCorrect(sb));
        System.out.println(validationResult.cardIssuer(sb));
    }
}
