package com.example.library.nuxom.jaxen.expr;


public interface BinaryExpr extends Expr {
    Expr getLHS();

    Expr getRHS();

    String getOperator();
}
