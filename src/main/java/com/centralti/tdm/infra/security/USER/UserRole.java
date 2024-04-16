package com.centralti.tdm.infra.security.USER;

public enum UserRole {
    ADMIN("ROLE_ADMIN", "Administrador"),
    USUARIO("ROLE_USUARIO", "Usuário"),
    DP("ROLE_DP", "DP"),
    TI("ROLE_TI", "T.I");

    private String codigo;
    private String descricao;

    private UserRole(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static UserRole toEnum(String cod) {
        if(cod == null) {
            return null;
        }

        for (UserRole x: UserRole.values()) {
            if(cod.equals(x.getCodigo())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil Inválido: " + cod);
    }
}