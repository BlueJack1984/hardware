package com.example.library.nuxom.jaxen.expr;

public interface PathExpr extends Expr {
    Expr getFilterExpr();

    void setFilterExpr(Expr var1);

    LocationPath getLocationPath();
}