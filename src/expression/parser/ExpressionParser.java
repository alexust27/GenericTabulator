package expression.parser;

import expression.*;

public class ExpressionParser<T> implements Parser<T> {
    private int i;
    private T num;
    private String str;
    private char v;
    private Operations<T> op;

    private enum List {number, var, add, sub, mul, div, bracket1, bracket2, abs, sqrt, mod}

    private List id;

    public ExpressionParser(Operations op) {
        this.op = op;
    }

    public TripleExpression<T> parse(String str) throws Exception {
        this.str = str;
        int bb = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bb++;
            } else if (str.charAt(i) == ')') {
                bb--;
            }
            if (bb < 0) {
                throw new ParsingException("unexpected ) at position: " + i);
            }
        }
        if (bb != 0) {
            throw new ParsingException("expected ) at end");
        }
        i = 0;
        return addsub();
    }

    private TripleExpression<T> addsub() throws Exception {
        TripleExpression<T> left = mulDiv();
        while (true) {
            switch (id) {
                case sub:
                    left = new Subtract<>(left, mulDiv(), op);
                    break;

                case add:
                    left = new Add<>(left, mulDiv(), op);
                    break;

                default:

                    return left;
            }
        }
    }

    private TripleExpression<T> mulDiv() throws Exception {
        TripleExpression<T> left = calc();
        while (true) {
            switch (id) {
                case mul:
                    left = new Multiply<>(left, calc(), op);
                    break;

                case div:
                    left = new Divide<>(left, calc(), op);
                    break;

                case mod:
                    left = new Mod<>(left, calc(), op);
                default:
                    return left;
            }
        }
    }

    private TripleExpression<T> calc() throws Exception {
        getNext();
        TripleExpression<T> rez;
        switch (id) {
            case number:
                rez = new Const<>(num);
                getNext();
                break;

            case var:
                rez = new Variable<>(Character.toString(v));
                getNext();
                break;

            case sub:
                rez = new Negate<>(calc(), op);
                break;

            case abs:
                rez = new Abs<>(calc(), op);
                break;

            case sqrt:
                rez = new Square<>(calc(), op);
                break;

            case bracket1:
                rez = addsub();
                getNext();
                break;

            default:
                rez = null;
                throw new ParsingException("unrecognizable symbol at position: " + i);
        }
        return rez;
    }

    private void getNext() throws Exception {
        deleteWhitespace();
        char ch = next();
        if (Character.isDigit(ch)) {
            StringBuilder str_num = new StringBuilder();
            while (Character.isDigit(ch)) {
                str_num.append(ch);
                ch = next();
            }
            i--;
            try {
                num = op.parse(str_num.toString());
            } catch (NumberFormatException e) {
                throw new OverflowException();
            }
            id = List.number;
        } else {
            switch (ch) {
                case '+':
                    id = List.add;
                    break;
                case '-':
                    if (str.length() >= i + 10 && str.substring(i, i + 10).equals("2147483648")) {
                        num = op.parse(str.substring(i - 1, i + 10));
                        i += 10;
                        id = List.number;
                    } else {
                        id = List.sub;
                    }
                    break;
                case '*':
                    id = List.mul;
                    break;
                case '/':
                    id = List.div;
                    break;
                case '(':
                    id = List.bracket1;
                    break;
                case ')':
                    id = List.bracket2;
                    break;

                default:
                    if (ch == 'x' || ch == 'y' || ch == 'z') {
                        id = List.var;
                        v = ch;
                    } else if (str.length() >= i + 2 && str.substring(i - 1, i + 2).equals("abs")) {
                        i += 2;
                        id = List.abs;
                        boolean t = Character.isWhitespace(str.charAt(i));
                        if (t) deleteWhitespace();
                        if (!t && str.charAt(i) != '(' && !Character.isDigit(str.charAt(i)) && str.charAt(i) != '-')
                            throw new ParsingException("unexpected char: \"" + str.charAt(i) + "\" at index: " + (i - 1));
                    } else if (str.length() >= i + 2 && str.substring(i - 1, i + 2).equals("mod")) {
                        i += 2;
                        id = List.mod;
                        boolean t = Character.isWhitespace(str.charAt(i));
                        if (t) deleteWhitespace();
                        if (!t && str.charAt(i) != '(' && !Character.isDigit(str.charAt(i)) && str.charAt(i) != '-')
                            throw new ParsingException("unexpected char: \"" + str.charAt(i) + "\" at index: " + (i - 1));
                    } else if (str.length() >= i + 5 && str.substring(i - 1, i + 5).equals("square")) {
                        i += 5;
                        id = List.sqrt;
                    } else if (!Character.isWhitespace(ch)) {
                        throw new ParsingException("unexpected char: \"" + ch + "\" at index: " + (i - 1));
                    }
            }
        }
        deleteWhitespace();
    }

    private char next() {
        if (i < str.length()) {
            char c = str.charAt(i);
            i++;
            return c;
        } else {
            return '#';
        }
    }

    private void deleteWhitespace() {
        while (Character.isWhitespace(next())) {}
        i--;
    }
}