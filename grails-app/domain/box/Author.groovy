package box

class Author {

    String titleTH
    String titleEng
    int age

    static hasMany = [books: BookAuthor]

    static constraints = {
    }
}
