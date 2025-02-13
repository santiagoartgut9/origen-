package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Library responsible for manage the loans and the users.
 */
public class Library {

    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;

    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }

    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        try{
            for (Book b : books.keySet()) {
                if (b.equals(book)) {
                    books.put(b, books.get(b) + 1);
                    return true;
                }
            }
            books.put(book, 1);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        //validate that the book is available and exist
        for (Book b : books.keySet()) {
            if (b.getIsbn().equals(isbn) && books.get(b) > 0) {
                //validate that the user exist
                for (User u : users) {
                    if (u.getId().equals(userId)) {
                        //validate that the user does not have a loan for the same book
                        for (Loan l : loans) {
                            if (l.getUser().equals(u) && l.getBook().equals(b) && l.getStatus().equals(LoanStatus.ACTIVE)) {
                                return null;
                            }
                        }
                        books.put(b, books.get(b) - 1);
                        Loan loan = createLoan(u, b);
                        return loan;
                    }
                }
            }
        }
        return null;
    }

    private Loan createLoan(User u, Book b) {
        Loan loan = new Loan();
        loan.setBook(b);
        loan.setUser(u);
        loan.setLoanDate(LocalDate.now());
        loan.setStatus(LoanStatus.ACTIVE);
        loans.add(loan);
        return loan;

    }

    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        //validate that the loan exist
        for (Loan l : loans) {
            if (l.equals(loan)) {
                books.put(l.getBook(), books.get(l.getBook()) + 1);
                l.setStatus(LoanStatus.RETURNED);
                l.setReturnDate(LocalDate.now());
                return l;
            }
        }
        return null;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public Map<Book, Integer> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public Loan getLoan(User user, Book book) {
        for (Loan l : loans) {
            if (l.getUser().equals(user) && l.getBook().equals(book)) {
                return l;
            }
        }
        return null;
    }
}