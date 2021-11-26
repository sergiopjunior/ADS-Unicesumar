package com.atv1_prog1;

class SemSolucaoRealException extends Exception {

    public SemSolucaoRealException(String errorMessage) {
        super (String.format("A equação %s não possui solução real.", errorMessage));
    }
}
