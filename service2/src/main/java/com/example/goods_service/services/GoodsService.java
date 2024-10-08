package com.example.goods_service.services;

import com.example.goods_service.entities.Goods;
import com.example.goods_service.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public List<Goods> getAll() {
        return goodsRepository.findAll();
    }

    public Goods getById(Long id) {
        Optional<Goods> goods = goodsRepository.findById(id);
        return goods.orElse(null);
    }

    public Goods createGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    public Goods updateGoods(Long id, Goods goods) {
        if (goodsRepository.existsById(id)) {
            goods.setId(id);
            return goodsRepository.save(goods);
        }
        return null;
    }

    public boolean deleteGoods(Long id) {
        if (goodsRepository.existsById(id)) {
            goodsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
