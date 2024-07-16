package net.weg.wdm.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Usuario {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false)
    private String senha;
    private Boolean habilitado; //Já vem com valor inicial false
//    @OneToMany
//    @JoinColumn(name = "id_solicitante", nullable = false)
//    private List<SolicitacaoReserva> reservas;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;
    @OneToMany(mappedBy = "usuario")
    @Column(nullable = false)
    private List<GrupoDispositivo> gruposDispositibos;
}
