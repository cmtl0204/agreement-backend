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
    private UUID id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer internalNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime subscribedAt;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    @Column(nullable = false)
    private Boolean isFinishDate;

    private LocalDateTime endedAt;

    private String endedReason;

    @Column(nullable = false)
    private Integer yearTerm;

    @Column(nullable = false)
    private Integer monthTerm;

    @Column(nullable = false)
    private Integer dayTerm;

    @Column(nullable = false)
    private String objective;

    @Column(nullable = false)
    private Boolean isFinancing;

    //@Column(nullable = false)
    private Boolean isAddendum;

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

    public Administrator getAdministrator() {
        if (administrators != null) {
            return administrators.stream().filter(Administrator::isEnable).findFirst().orElse(null);
        }else {
            return new Administrator();
        }

    }

    public void setAdministrator(Administrator administrator) {
        if (administrators != null) {
            this.administrator = administrators.stream().filter(Administrator::isEnable).findFirst().orElse(null);
        }
   }

    public AgreementState getAgreementState() {
        if (agreementStates != null) {
            return agreementStates.stream().filter(AgreementState::isEnable).findFirst().orElse(null);
        }else {
            return new AgreementState();
        }

    }

    public void setAgreementState(AgreementState agreementState) {
        if (agreementStates != null) {
            this.agreementState = agreementStates.stream().filter(AgreementState::isEnable).findFirst().orElse(null);
        }
    }
}
