package allclasses.larin;

public class Book {
    private String _name;
    private boolean _isAvailable;

    public Book(String name, boolean isAvailable) {
        this._name = name;
        this._isAvailable = isAvailable;
    }

    // Взять книгу
    public boolean borrowBook() {
        if (_isAvailable) {
            _isAvailable = false;
            System.out.println("Книга '" + this._name + "' успешно взята!");
            return true;
        }
        else {
            System.out.println("Книга '" + this._name + "' уже занята!");
            return false;
        }
    }

    // Вернуть книгу
    public boolean returnBook() {
        if (!_isAvailable) {
            _isAvailable = true;
            System.out.println("Книга '" + this._name + "' успешно возвращена!");
            return true;
        }
        else {
            System.out.println("Книга '" + this._name + "' уже доступна!");
            return false;
        }
    }
}
