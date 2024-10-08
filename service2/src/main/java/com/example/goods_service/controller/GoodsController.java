package com.example.goods_service.controller;

import com.example.goods_service.entities.Goods;
import com.example.goods_service.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(goodsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        if (goodsService.getById(id) != null)
            return new ResponseEntity<>(goodsService.getById(id), HttpStatus.OK);
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);

    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody Goods goods) {
        return new ResponseEntity<>(goodsService.createGoods(goods), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Goods goods) {
        if (goodsService.updateGoods(id, goods) != null)
            return new ResponseEntity<>(goodsService.updateGoods(id, goods), HttpStatus.OK);
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (goodsService.deleteGoods(id))

            return new ResponseEntity<>(goodsService.deleteGoods(id), HttpStatus.OK);

        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
