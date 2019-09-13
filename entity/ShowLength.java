package  com.okta.springbootvue.entity;

import lombok.*;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@EqualsAndHashCode
@Table(name="ShowLength")
public class ShowLength {
    @Id
    @SequenceGenerator(name="ShowLength_SEQ",sequenceName="ShowLength_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ShowLength_SEQ")
    @Column(name="ShowLength_ID",unique = true, nullable = true)
    private @NonNull Long id;
    private @NonNull String Length;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Show> Show;

	
}
