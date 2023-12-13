package com.example.corazondelatorback.Controller;

import com.example.corazondelatorback.Model.Borrow;
import com.example.corazondelatorback.Services.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//aqui le das lo que viene antes del endpoint @RequestMapping ("api/admin")
//onda si esta en la url api/admin/mi-endpoint hace algo
public class BorrowController {
    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService){
        this.borrowService = borrowService;
    }

    @GetMapping(value = "/getborrow")
    public List<Borrow> getAllBorrows(){
        return borrowService.BorrowList();
    }

    @PostMapping(value = "/addborrow")
    public String addBorrow(@RequestBody Borrow borrow){
        return borrowService.BorrowBook(borrow);
    }

    @PostMapping("/finishBorrow/{id}")
    public String finishBorrowBook(@PathVariable long id) {
        return borrowService.finishBorrowBook(id);
    }
    @PostMapping("/updateBorrow/{id}")
    public String updateBorrow(@PathVariable long id, @RequestBody Borrow updatedBorrow) {
        return borrowService.updateBorrow(id, updatedBorrow);
    }
    @DeleteMapping("/deleteBorrow/{id}")
    public String deleteBorrow(@PathVariable Long id) {
        return borrowService.deleteBorrow(id);
    }

}
