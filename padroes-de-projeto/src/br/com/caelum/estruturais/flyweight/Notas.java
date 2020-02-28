package br.com.caelum.estruturais.flyweight;

class Do implements Nota {

    @Override
    public String simbolo() {
        return "C";
    }
}

class Re implements Nota {

    @Override
    public String simbolo() {
        return "D";
    }
}

class Mi implements Nota {

    @Override
    public String simbolo() {
        return "E";
    }
}

class Fa implements Nota {

    @Override
    public String simbolo() {
        return "F";
    }
}

class Sol implements Nota {

    @Override
    public String simbolo() {
        return "G";
    }
}

class La implements Nota {

    @Override
    public String simbolo() {
        return "A";
    }
}

class Si implements Nota {

    @Override
    public String simbolo() {
        return "B";
    }
}