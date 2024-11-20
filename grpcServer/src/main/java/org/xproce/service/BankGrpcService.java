package org.xproce.service;

import io.grpc.stub.StreamObserver;
import org.xproce.stubs.Bank;
import org.xproce.stubs.BankServiceGrpc;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void convert(Bank.ConvertCurrencyRequest request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        String currencyForm = request.getCurrencyFrom();
        String to = request.getCurrencyTo();
        double amount = request.getAmount();
        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyForm)
                .setCurrencyTo(to)
                .setAmount(amount)
                .setResult(amount * 12.14)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
