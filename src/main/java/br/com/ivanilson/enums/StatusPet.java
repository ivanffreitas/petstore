package br.com.ivanilson.enums;

public enum StatusPet {

    DISPONIVEL(0,"DISPONIVEL"), INDISPONIVEL(1,"INDISPONIVEL");

    private Integer codigo;
    private String descricao;

    private StatusPet(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusPet toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(StatusPet x : StatusPet.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Status inválido");
    }

}
