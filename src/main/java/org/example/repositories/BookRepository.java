package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.configuration.DataBaseConnection;
import org.example.entities.Book;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookRepository implements BookRepo, AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = DataBaseConnection.creatEntityManagerFactory();
    private final SessionFactory sessionFactory = DataBaseConnection.creatSessionFactory();
    private  final EntityManager entityManager=entityManagerFactory.createEntityManager();

    @Override
    public String saveBook(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved";
    }

    @Override
    public void saveAllBooks(List<Book> books) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        for (int i = 0; i < books.size(); i++) {
//            entityManager.persist(books.get(i));
//        }
        books.forEach(entityManager::persist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> resultList = entityManager.createQuery("""
                select b from Book b 
                """, Book.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(resultList);
    }

    @Override
    public Book findById(Long bookId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        entityManager.createQuery("""
         select b from Book b where b.id=?1 or b.name= :januzak 
         """, Book.class).setParameter(1, bookId).
                getSingleResult();//getResulList()
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public Book update(Long id, Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book1 = entityManager.find(Book.class, id);
        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
        sessionFactory.close();
    }

    @Override
    public void deleteBookName(Long bookId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, bookId);
        entityManager.remove(book);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Successfully deleted");
    }

    @Override
    public void clearBookTable() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> deleteFromBookB = entityManager.createQuery("select b from Book b ",
                Book.class).getResultList();
        for (int i = 0; i < deleteFromBookB.size(); i++) {
            entityManager.remove(deleteFromBookB.get(i));
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Successfully deleted book table");
    }

    @Override
    public void dropTable() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("drop table books").executeUpdate();
            entityManager.getTransaction().commit();
        }catch (Exception e){
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
            }
            e.fillInStackTrace();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public void upDateBook2(Long id, Book book) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        Book book2 = entityManager1.createQuery("select b from  Book b where id=:d",Book.class).setParameter("d", id).getSingleResult();
//        book2.setId(book.getId());
        book2.setName(book.getName());
        book2.setAuthor(book.getAuthor());
        book2.setPrice(book.getPrice());
        entityManager1.getTransaction().commit();
        entityManager1.close();
        System.out.println(book2);
    }

    @Override
    public Book findById2(Long id) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        Book singleResult = entityManager1.createQuery("select b  from Book b where id=?1",Book.class).
                setParameter(1,id).getSingleResult();
        Book book=new Book();
        book.setId(singleResult.getId());
        book.setName(singleResult.getName());
        book.setAuthor(singleResult.getAuthor());
        book.setPrice(singleResult.getPrice());
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return book;
    }

    @Override
    public String deleteBookName2(String name) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        entityManager1.createNativeQuery("delete from books where name=? ").
        setParameter(1,name).executeUpdate();
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return "Successfully deleted";
    }

    @Override
    public String deleteBookByNameAndAuthor3(String name, String author) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        entityManager1.createQuery("select b from  Book b where name= ")
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return null;
    }
}



























