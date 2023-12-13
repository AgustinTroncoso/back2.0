package com.example.corazondelatorback.Services;

import com.example.corazondelatorback.Model.Borrow;
import com.example.corazondelatorback.Repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowService {
private final BorrowRepository borrowRepository;

@Autowired
    public BorrowService(BorrowRepository borrowRepository){
    this.borrowRepository = borrowRepository;
}
// Metodos

    public String BorrowBook(Borrow borrow) {
        try {
            // Asegúrate de que estás utilizando los valores correctos del objeto Borrow

            borrowRepository.save(borrow);
            // Aquí puedes realizar las operaciones necesarias con los datos
            // (por ejemplo, almacenar en la base de datos)

            return "Borrow registrado exitosamente";
        } catch (Exception e) {
            // Manejo de errores, puedes loggear o lanzar una excepción según tus necesidades
            return "Error al registrar el Borrow";
        }
    }
  /*  public String BorrowBook(@RequestBody Borrow borrow){
        borrowRepository.save(borrow);
        return "borrow agregada";

    }*/
    public String finishBorrowBook(long id) {
        // Obtener la instancia de Borrow por id
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la solicitud de préstamo con id: " + id));

        // Actualizar el estado a "devuelto"
        borrow.setState("devuelto");

        // Guardar los cambios en la base de datos
        borrowRepository.save(borrow);

        return "Préstamo marcado como devuelto";
    }
    public String deleteBorrow(Long borrowId) {
        borrowRepository.deleteById(borrowId);
        return "borrow eliminado";
    }
    public String updateBorrow(long id, Borrow updatedBorrow) {
        Borrow existingBorrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la solicitud de préstamo con id: " + id));

        // Actualiza los campos necesarios
        existingBorrow.setCustomerToBorrow(updatedBorrow.getCustomerToBorrow());
        existingBorrow.setRutCustomerToBorrow(updatedBorrow.getRutCustomerToBorrow());
        existingBorrow.setBorrowedBook(updatedBorrow.getBorrowedBook());
        existingBorrow.setBorrowDate(updatedBorrow.getBorrowDate());
        existingBorrow.setReturnDate(updatedBorrow.getReturnDate());
        existingBorrow.setAuthorizedBy(updatedBorrow.getAuthorizedBy());
        existingBorrow.setPassReturnDate(updatedBorrow.getPassReturnDate());
        existingBorrow.setState(updatedBorrow.getState());

        // ... actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        borrowRepository.save(existingBorrow);

        return "Borrow actualizada";
    }

    public List<Borrow> BorrowList(){
        return borrowRepository.findAll();
    }



}
