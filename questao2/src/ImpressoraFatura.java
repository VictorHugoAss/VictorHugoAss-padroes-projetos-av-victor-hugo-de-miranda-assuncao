public class ImpressoraFatura {
    public void imprimir(Fatura fatura) {
        System.out.println("\nFATURA DO COMPRADOR\n" + fatura.getDescricao());
        System.out.printf("Total a pagar: R$ %.2f%n", fatura.getTotal());
    }
}
