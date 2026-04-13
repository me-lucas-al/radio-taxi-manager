package entity.dataType;

public class Cpf {
    private String number;

    public Cpf(String input) {
        String cleanNumber = input.replaceAll("[^0-9]", "");

        if (cleanNumber.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }

        this.number = cleanNumber;
    }

    public String getFormatted() {
        return String.format("%s.%s.%s-%s",
                number.substring(0, 3),
                number.substring(3, 6),
                number.substring(6, 9),
                number.substring(9));
    }

    @Override
    public String toString() {
        return getFormatted();
    }
}