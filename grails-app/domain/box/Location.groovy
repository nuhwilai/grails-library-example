package box

class Location {
    String title
    String code
    String address
    static hasMany = [books: Book]
    
    static constraints = {
    }

    static mapping = {
        address type: "text"
    }
}
