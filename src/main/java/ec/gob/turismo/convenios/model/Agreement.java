package ec.gob.turismo.convenios.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "agreements")
public class Agreement {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.UUID)
    //@UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String number;

    private Integer internalNumber;

    @Column(length = 255, nullable = false)
    private String name;

    private LocalDateTime subscribedAt;

    private LocalDateTime startedAt;

    private Boolean isFinishDate;

    private LocalDateTime endedAt;

    @Column(length = 255)
    private String endedReason;

    private Integer yearTerm;
    private Integer monthTerm;
    private Integer dayTerm;

    @Column(length = 255)
    private String objective;

    private boolean isFinancing;

    private boolean isAddendum;

    @ManyToOne
    @JoinColumn(name = "origin_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_ORIGIN_AGREEMENT"))
    private Catalogue origin;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CATALOGUE_TYPE_AGREEMENT"))
    private Catalogue type;

    @ManyToOne
    @JoinColumn(name = "special_type_id", foreignKey = @ForeignKey(name = "FK_CATALOGUE_SPECIAL_TYPE_AGREEMENT"))
    private Catalogue specialType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true, foreignKey = @ForeignKey(name = "FK_USER_AGREEMENT"))
    private User user;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Administrator> administrators;

    @Transient
    private Administrator administrator;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgreementState> agreementStates;

    @Transient
    private AgreementState agreementState;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InternalInstitution> internalInstitutions;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExternalInstitution> externalInstitutions;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Obligation> obligations;

    @OneToMany(mappedBy = "agreement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Financing> financings;



}
