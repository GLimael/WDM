package net.weg.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long numero;
    @ManyToOne
    @Column(nullable = false)
    private TipoDispositivo tipo;
    @Column(nullable = false, length = 20)
    private String marca;
    @Column(nullable = false, length = 50)
    private String modelo;
    @OneToMany(mappedBy = "dispositivo")
    private List<DispositivoReservado> reservasDoDispositivo;
    private String descricao;
    @OneToMany(mappedBy = "dispositivo")
    private List<Manutencao> manutencoes;
    private Boolean habilitado = true;
}
