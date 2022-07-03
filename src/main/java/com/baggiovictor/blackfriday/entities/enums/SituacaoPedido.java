package com.baggiovictor.blackfriday.entities.enums;

public enum SituacaoPedido {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int code;

    private SituacaoPedido(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static SituacaoPedido valueOf(int code) {
        for (SituacaoPedido value: SituacaoPedido.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Situacao do pedido inválido");
    }
}
