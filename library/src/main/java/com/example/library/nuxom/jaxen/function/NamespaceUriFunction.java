package com.example.library.nuxom.jaxen.function;


import nu.xom.jaxen.Context;
import nu.xom.jaxen.Function;
import nu.xom.jaxen.FunctionCallException;
import nu.xom.jaxen.Navigator;

import java.util.List;

public class NamespaceUriFunction implements Function {
    public NamespaceUriFunction() {
    }

    public Object call(Context var1, List var2) throws FunctionCallException {
        if (var2.size() == 0) {
            return evaluate(var1.getNodeSet(), var1.getNavigator());
        } else if (var2.size() == 1) {
            return evaluate(var2, var1.getNavigator());
        } else {
            throw new FunctionCallException("namespace-uri() requires zero or one argument.");
        }
    }

    public static String evaluate(List var0, Navigator var1) throws FunctionCallException {
        if (!var0.isEmpty()) {
            Object var2 = var0.get(0);
            if (var2 instanceof List) {
                return evaluate((List)var2, var1);
            } else if (var1.isElement(var2)) {
                return var1.getElementNamespaceUri(var2);
            } else if (var1.isAttribute(var2)) {
                String var3 = var1.getAttributeNamespaceUri(var2);
                return var3 == null ? "" : var3;
            } else if (var1.isProcessingInstruction(var2)) {
                return "";
            } else if (var1.isNamespace(var2)) {
                return "";
            } else if (var1.isDocument(var2)) {
                return "";
            } else if (var1.isComment(var2)) {
                return "";
            } else if (var1.isText(var2)) {
                return "";
            } else {
                throw new FunctionCallException("The argument to the namespace-uri function must be a node-set");
            }
        } else {
            return "";
        }
    }
}
