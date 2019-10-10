package com.example.library.nuxom.jaxen.expr;

import java.util.List;

public interface LocationPath extends Expr {
    void addStep(Step var1);

    List getSteps();

    boolean isAbsolute();
}
