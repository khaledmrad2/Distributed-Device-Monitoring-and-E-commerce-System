package com.example.transaction_service.services;

import com.example.transaction_service.dto.GoodsDTO;
import com.example.transaction_service.dto.UserDTO;
import com.example.transaction_service.entities.Transaction;
import com.example.transaction_service.repositories.TransactionRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallbackGetUser")
    public UserDTO getUserById(Long id) {
        return restTemplate.getForObject("http://user-service/userService/api/users/" + id, UserDTO.class);
    }

    public UserDTO fallbackGetUser(Long id) {
        return new UserDTO(id, "Unknown User", "unknown@example.com");
    }

    @HystrixCommand(fallbackMethod = "fallbackGetGoods")
    public GoodsDTO getGoodsById(Long id) {
        return restTemplate.getForObject("http://goods-service/goodsService/api/goods/" + id, GoodsDTO.class);
    }

    public GoodsDTO fallbackGetGoods(Long id) {
        return new GoodsDTO(id, "Unknown Goods", "Description not available", 0.0, LocalDate.now(), 0);
    }

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public Transaction getById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.orElse(null);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isPresent()) {
            Transaction existingTransaction = optionalTransaction.get();
            transaction.setCreatedAt(existingTransaction.getCreatedAt());
            transaction.setId(id);
            return transactionRepository.save(transaction);
        }
        return null;
    }


    public boolean deleteTransaction(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Transaction findById(Long id) {
        Optional<Transaction> transactionOptional = transactionRepository.findById(id);
        return transactionOptional.orElse(null);
    }



}
