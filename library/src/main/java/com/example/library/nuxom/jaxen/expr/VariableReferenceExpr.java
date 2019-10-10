package com.example.library.nuxom.jaxen.expr;

public interface VariableReferenceExpr extends Expr {
    String getPrefix();

    String getVariableName();
}
