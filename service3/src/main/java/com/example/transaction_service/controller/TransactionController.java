package com.example.transaction_service.controller;

import com.example.transaction_service.dto.GoodsDTO;
import com.example.transaction_service.dto.TransactionDetailsDTO;
import com.example.transaction_service.dto.UserDTO;
import com.example.transaction_service.entities.Transaction;
import com.example.transaction_service.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(transactionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        if (transactionService.getById(id) != null)
            return new ResponseEntity<>(transactionService.getById(id), HttpStatus.OK);
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);


    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.updateTransaction(id, transaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if(!transactionService.deleteTransaction(id))
        return new ResponseEntity<>(transactionService.deleteTransaction(id), HttpStatus.OK);

        return new ResponseEntity<>("Not Found!", HttpStatus.NOT_FOUND);

    }

        @GetMapping("/{id}/details")
    public ResponseEntity<TransactionDetailsDTO> getTransactionDetails(@PathVariable Long id) {
        Transaction transaction = transactionService.findById(id);
        if (transaction == null) {
            return ResponseEntity.notFound().build();
        }

        UserDTO sellerDTO = transactionService.getUserById(transaction.getSellerId());

        UserDTO buyerDTO = transactionService.getUserById(transaction.getBuyerId());
        GoodsDTO goodsDTO = transactionService.getGoodsById(transaction.getGoodsId());

        TransactionDetailsDTO transactionDetails = new TransactionDetailsDTO();
        transactionDetails.setTransactionId(transaction.getId());
        transactionDetails.setSeller(sellerDTO);
        transactionDetails.setBuyer(buyerDTO);
        transactionDetails.setGoods(goodsDTO);
        transactionDetails.setQuantity(transaction.getQuantity());
        transactionDetails.setTotalPrice(transaction.getTotalPrice());

        return ResponseEntity.ok(transactionDetails);
    }


}
