package br.com.example.app.desafios;

public class Bar {

    public static final String UMA_CERVEJA = "hansa";
    public static final String UMA_CIDRA = "grans";
    public static final String UMA_CIDRA_PECULIAR = "strongbow";
    public static final String GIN_TONICA = "gt";
    public static final String BACARDI_ESPECIAL = "bacardi_special";

    public int calculaCusto(String bebida, boolean assinante, int quantidade) {

        int preco;

        if (quantidade > 2 && (bebida == GIN_TONICA || bebida == BACARDI_ESPECIAL))
            throw new RuntimeException("O número de bebidas ultrapassou o limite, máx: 2.");

        if (bebida.equals(UMA_CERVEJA))
            preco = 74;
        else if (bebida.equals(UMA_CIDRA))
            preco = 103;
        else if (bebida.equals(UMA_CIDRA_PECULIAR))
            preco = 110;
        else if (bebida.equals(GIN_TONICA))
            preco = ingrediente6() + ingrediente5() + ingrediente4();
        else if (bebida.equals(BACARDI_ESPECIAL))
            preco = ingrediente6() / 2 + ingrediente1() + ingrediente2() + ingrediente3();
        else
            throw new RuntimeException("Essa bebida não existe!");

        if (assinante && (bebida == UMA_CIDRA || bebida == UMA_CERVEJA || bebida == UMA_CIDRA_PECULIAR))
            preco -= preco / 10;

        return preco * quantidade;
    }

    // uma dose de rum
    private int ingrediente1() {
        return 65;
    }

    // uma dose de licor de romã
    private int ingrediente2() {
        return 10;
    }

    // uma dose de suco de limão
    private int ingrediente3() {
        return 10;
    }

    // uma dose de licor verde
    private int ingrediente4() {
        return 10;
    }

    // uma dose de água tônica
    private int ingrediente5() {
        return 20;
    }

    // uma dose de gin
    private int ingrediente6() {
        return 85;
    }

    public static void main(String[] args) {
        System.out.println(new Bar().calculaCusto(UMA_CERVEJA, true, 2));
    }
}
