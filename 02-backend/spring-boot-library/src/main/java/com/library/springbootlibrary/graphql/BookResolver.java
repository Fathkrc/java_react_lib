//package com.library.springbootlibrary.graphql;
//
//import com.library.springbootlibrary.entity.Book;
//import com.library.springbootlibrary.repository.BookRepository;
//import graphql.kickstart.tools.GraphQLQueryResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class BookResolver implements GraphQLQueryResolver {
//    private final BookRepository bookRepository;
//
//    public BookResolver(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//    public List<Book> getBooks() {
//        return bookRepository.findAll();
//    }
//
//    public Book getBookById(Long id) {
//        return bookRepository.findById(id).orElse(null);
//    }
//}
