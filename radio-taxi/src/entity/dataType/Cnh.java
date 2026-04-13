package entity.dataType;

import java.time.LocalDate;

public class Cnh {
    private String number;
    private String category;
    private LocalDate expirationDate;

    public Cnh(String number, String category, LocalDate expirationDate) {
        if (number == null || number.length() < 9) {
            throw new IllegalArgumentException("Número de CNH inválido.");
        }

        this.number = number;
        this.category = category.toUpperCase();
        this.expirationDate = expirationDate;
    }

    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Nº %s | Cat: %s | Val: %s", number, category, expirationDate);
    }
}