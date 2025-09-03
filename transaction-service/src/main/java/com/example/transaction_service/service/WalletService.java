package com.example.transaction_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final StringRedisTemplate redisTemplate;
    private final Map<Long, CompletableFuture<BigDecimal>> pendingWallets = new ConcurrentHashMap<>();


    public BigDecimal getBalance(Long walletId) {
        String value = redisTemplate.opsForValue().get("walletId:" + walletId);
        if(value != null) return new BigDecimal(value);
        CompletableFuture<BigDecimal> future = new CompletableFuture<>();
        pendingWallets.put(walletId, future);
        return null;
    }

    public void completePendingWallet(Long walletId, BigDecimal balance) {
        String key = "walletId:" + walletId;
        redisTemplate.opsForValue().set("walletId:" + walletId, balance.toString());
        CompletableFuture<BigDecimal> future = pendingWallets.remove(walletId);
        if(future != null){
            future.complete(balance);
        }
    }

}
