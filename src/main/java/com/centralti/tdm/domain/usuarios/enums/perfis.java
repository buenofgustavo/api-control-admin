package com.centralti.tdm.domain.usuarios.enums;

public enum perfis {

    ADMIN       ("0", "ROLE_ADMIN"),
    USUARIO     ("1", "ROLE_USUARIO"),
    DP          ("2", "ROLE_DP"),
    TI          ("3", "ROLE_TI");

    private String codigo;
    private String descricao;

    private perfis(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static perfis toEnum(String cod) {
        if(cod == null) {
            return null;
        }

        for (perfis x: perfis.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil Inválido");
    }

}
