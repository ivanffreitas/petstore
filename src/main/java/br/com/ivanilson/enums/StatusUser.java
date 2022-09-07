package br.com.ivanilson.enums;

public enum StatusUser {
    ATIVO(0,"ATIVO"), INATIVO(1,"INATIVO");

    private Integer codigo;
    private String descricao;

    private StatusUser(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusUser toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(StatusUser x : StatusUser.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido");
    }
}
