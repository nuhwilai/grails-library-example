package box

import grails.gorm.transactions.Transactional

@Transactional
class FixtureService {

    def createTestData() {
        
        def cate1 = new BookCategory([
            title: "Social",
            code: "ss1",
            description: "for study social media",
            borrwingDays: 10,
            findRatePerDay: 20
        ]).save()

        def cate2 = new BookCategory([
            title: "Sci",
            code: "sc1",
            description: "for study scient",
            borrwingDays: 5,
            findRatePerDay: 30
        ]).save()

        def author1 = new Author([
            titleTH: "เจเจ",
            titleEng: "JJ",
            age: 100
        ]).save()

        def author2 = new Author([
            titleTH: "ท่อ",
            titleEng: "Tor",
            age: 30
        ]).save()

        def book1 = new Book([
            titleTH: "ทดสอบ1",
            titleEng: "test1",
            author: "นายปูน",
            price: 3000,
            since: "2018-01-20",
            isRead: true,
            category: cate1
        ]).save()

        def bookAuthor1 = new BookAuthor([
            author: author1,
            book: book1
        ]).save()



        // book1.addToAuthors(bookAuthor1)
        // author1.addToBooks(bookAuthor1)
    
        def book2 = new Book([
            titleTH: "ทดสอบ2",
            titleEng: "test2",
            author: "นายท่อ",
            price: 5000,
            since: "2019-01-20",
            isRead: false,
            category: cate2
        ]).save()

        new BookAuthor([
            author: author2,
            book: book2
        ]).save()

        def book3 = new Book([
            titleTH: "ทดสอบ3",
            titleEng: "Test3",
            author: "นายปูน",
            price: 500,
            since: "2018-02-20",
            isRead: false,
            category: cate1
        ]).save()

        new BookAuthor([
            author: author1,
            book: book3
        ]).save()

        new BookAuthor([
            author: author2,
            book: book3
        ]).save()

        new Book([
            titleTH: "ทดสอบ4",
            titleEng: "test4",
            author: "นายธฤต",
            price: 3000,
            since: "2019-02-20",
            isRead: true,
            category: cate2
        ]).save()

        new Book([
            titleTH: "กระจอก",
            titleEng: "kak",
            author: "นายเจเจ",
            price: 100,
            since: "2018-02-20",
            isRead: true,
            category: cate1
        ]).save()
    }
}
