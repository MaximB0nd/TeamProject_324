package allclasses.andreeva;

public class Password {
    private String password;

    // конструктор с паролем
    public Password(String password) {
        this.password = password;
    }

    // проверка надежности пароля
    public boolean isPowerful() {
        return checkLength() &&
                checkCharacterTypes() &&
                checkKeyboardSequences();
    }

    // метод проверки длины
    private boolean checkLength() {
        return this.password.length() > 12;
    }

    // метод проверки на содержание разных типов символов
    private boolean checkCharacterTypes() {
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (int i = 0; i < this.password.length(); i++) {
            char c = this.password.charAt(i);

            if (c >= 'a' && c <= 'z') hasLower = true;
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            if (c >= '0' && c <= '9') hasDigit = true;
            if (!Character.isLetterOrDigit(c)) hasSymbol = true;
        }

        return hasLower && hasUpper && hasDigit && hasSymbol;
    }

    // метод проверки на запрещенные последовательности
    private boolean checkKeyboardSequences() {
        String[] keyboardSequences = {
                "123", "234", "345", "456", "567", "678", "789",
                "qwe", "wer", "ert", "rty", "tyu", "yui", "uio", "iop",
                "asd", "sdf", "dfg", "fgh", "ghj", "hjk", "jkl",
                "zxc", "xcv", "cvb", "vbn", "bnm"
        };

        String passwordLower = this.password.toLowerCase();

        for (String seq : keyboardSequences) {
            if (passwordLower.contains(seq)) {
                return false;
            }
        }

        return true;
    }
}
