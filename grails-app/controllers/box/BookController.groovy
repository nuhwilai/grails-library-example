package box


import grails.rest.*
import grails.converters.*
import grails.gorm.transactions.Transactional

class BookController {
	static responseFormats = ['json']
	
    def index() { 
        def result = [valid: false]
        
        def books = Book.list()
        def totalCount = Book.count()
        
        result.data = books
        result.totalCount = totalCount
        result.valid = true

        render(result as JSON)
    }

    def show(Long id){
        def result = [valid: false]
        def book = Book.get(id)

        result.valid = true
        result.data = book
        
        render(result as JSON)
    }

    def save(Book book){
        def result = [valid: false]
        book.save(failOnError: true)
        result.data = book
        result.valid = true
        render(result as JSON)
    }

    @Transactional
    def update(Book book){
        def result = [valid: false]
        book.save(failOnError: true)

        result.data = book
        result.valid = true

        render(result as JSON)
    }

    @Transactional
    def delete(Long id){
        def result = [valid: false]
        try {
            def book = Book.get(id)
            if(!book){
                throw new Exception("not found book id: ${id}")
            }
            book.delete()
            result.valid = true

        }catch(error){
            result.reason = error.message
        }
        render(result as JSON)
    }


}
