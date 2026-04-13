package entity.dataType;

public class Phone {
    private String number;

    public Phone(String inputNumber) {
        String cleanNumber = inputNumber.replaceAll("[^0-9]", "");

        if (!isValid(cleanNumber)) {
            throw new IllegalArgumentException("Invalid phone number. Must contain 10 or 11 digits.");
        }

        this.number = cleanNumber;
    }

    private boolean isValid(String number) {
        return number != null && (number.length() == 10 || number.length() == 11);
    }

    public String getFormattedNumber() {
        if (number.length() == 11) {
            return String.format("(%s) %s-%s",
                    number.substring(0, 2),
                    number.substring(2, 7),
                    number.substring(7));
        } else {
            return String.format("(%s) %s-%s",
                    number.substring(0, 2),
                    number.substring(2, 6),
                    number.substring(6));
        }
    }
}