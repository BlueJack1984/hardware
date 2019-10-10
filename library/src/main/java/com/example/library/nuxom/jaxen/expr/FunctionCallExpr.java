package com.example.library.nuxom.jaxen.expr;

import java.util.List;

public interface FunctionCallExpr extends Expr {
    String getPrefix();

    String getFunctionName();

    void addParameter(Expr var1);

    List getParameters();
}
